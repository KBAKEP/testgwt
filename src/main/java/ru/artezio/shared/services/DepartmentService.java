package ru.artezio.shared.services;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import ru.artezio.shared.entity.Department;
import ru.artezio.shared.entity.Employee;

@RemoteServiceRelativePath("springGwtServices/departmentService")
public interface DepartmentService extends RemoteService {

	public Department create(String name);
	
	public Department findById(Long id);
	
	public List<Department> findAll();

	public List<Department> employeeList(Department dep);
	
	public Department findByName(String name);
	
	public Employee hire(Department dep, Employee emp);
	
}
