package ru.artezio.shared.services;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import ru.artezio.shared.entity.Department;
import ru.artezio.shared.entity.Employee;

@RemoteServiceRelativePath("testgwt/employeeService")
public interface EmployeeService extends RemoteService {

		
	
	public Employee hire(String name, Department department);
	
	public Employee changeDepartment(Employee emp, Department dep);
	
	public Employee fire(Employee emp);
	
	public List<Employee> findAll();
	
}
