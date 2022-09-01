package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class EmployeeService 
{

	@Autowired
	 private EmployeeRepository repo;
	
	public List<Employee> listAll()
	{
		return repo.findAll();
	}
	
	public void save(Employee employee)
	{
		repo.save(employee);
	}
	
	public Employee get(Integer id)
	{
		/*
		 * java.util.Optional<Employee> employee = repo.findById(id);
		 * if(employee.isPresent()) { return employee.get();
		 * 
		 * } return null;
		 */
		return repo.findById(id).get();
	}
	
	public void delete(Integer id)
	{
		repo.deleteById(id);
		
	}
	
}
