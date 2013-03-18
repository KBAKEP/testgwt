package ru.artezio.server.service.jpa;

import java.util.List;

import javax.annotation.PostConstruct; 
import javax.annotation.PreDestroy; 

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.artezio.shared.entity.Department;
import ru.artezio.shared.entity.Employee;
import ru.artezio.shared.services.DepartmentService;


@Service("departmentService")
@Repository
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	private Log log = LogFactory.getLog(DepartmentServiceImpl.class);

	@PersistenceContext
	private EntityManager em;

	@PostConstruct 
	public void init() throws Exception { 
	} 
	  
	@PreDestroy 
	public void destroy() { 
	} 
	
	
	public Department create(String name) {
		
		/*
		Department dep = findByName(name);	
		if (dep == null) { 
			log.info("Inserting new department");
			dep = new Department(name);
			em.persist(dep);
		} else {                       // Update Employee
			em.merge(dep);
			log.info("Updating existing department");
		}
		log.info("Department saved with id: " + dep.getId());
		em.flush();
		*/
		
		Department dep = new Department(name);
		em.persist(dep);
		em.flush();
		return dep;
	}

	public List<Department> findAll() {
		String queryString = "SELECT d FROM Department d ";
		Query query = em.createQuery(queryString, Department.class);

		return query.getResultList();
	}
	
	public Department findById(Long id) {
		Department dep = (Department) em.find(Department.class, id);
		return dep;
	}
	
	public Department findByName(String name) {

		String queryString = "select distinct d from Department d where d.name = :name";
		
		TypedQuery<Department> query = em.createQuery(queryString, Department.class);
		query.setParameter("name", name);
		return query.getSingleResult();
	}

	public Employee hire(Department dep, Employee emp) {
		
		dep.addEmployee(emp);
		em.persist(dep);
		em.flush();		
		return emp;
	}
	
	public List<Department> employeeList(Department dep) {
		String queryString = "SELECT e FROM Employee e "
				+ " left join fetch e.department d where d.name = :departmentName";
		
		Query query = em.createQuery(queryString, Department.class);
		query.setParameter("departmentName", dep.getName());
		return query.getResultList();
	}

}
