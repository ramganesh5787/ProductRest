package net.codejava;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	public List<Employee> listAll() {
		return repo.findAll();
	}

	public void save(Employee emp) 
	  {
	  
	 try { 
		 if (Objects.nonNull(emp))
		 {
			 emp.setIs_active(1);
			 emp.setIsDeleted(0);
			 emp = repo.save(emp); 
		 } 
		 } 
	 catch (Exception e)
	 { 
		 throw new RuntimeException(e.getMessage()); 
		 } 
	 }
	 
	/*
	 * public Employee get(Integer id) {
	 * 
	 * java.util.Optional<Employee> employee = repo.findById(id);
	 * if(employee.isPresent()) { return employee.get();
	 * 
	 * } return null;
	 * 
	 * return repo.findById(id).get();
	 * 
	 * 
	 * }
	 */

	public Employee get(Integer id) 
	
	{
		try
		{
			
			if (Objects.nonNull(id))
			{
				Optional<Employee> employee = repo.findById(id);
				if(employee.isPresent())
				{
				return employee.get();
			   }
				return null;
			}
		}
		catch (Exception e) 
		{
		    throw new RuntimeException(e.getMessage());
	}
		return null;
	
	}
	/*
	 * public void delete(Integer id) { repo.deleteById(id);
	 * 
	 * }
	 */
	
public String delete(Integer id)
	
	{
		try
		{
			if (Objects.nonNull(id))
			{
				Optional<Employee> employee = repo.findById(id);
				if(employee.isPresent())
				{
				employee.get().setIsDeleted(1);
				employee.get().setIs_active(0);
                repo.save(employee.get());
			  }
			}
		}
		catch (Exception e)
		{
		   throw new RuntimeException(e.getMessage());
	}
		return "Success";
	
	}
}
