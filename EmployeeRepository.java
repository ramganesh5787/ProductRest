package net.codejava;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository  extends JpaRepository<Employee,Integer>

{

	@Query(value = "Select * from employee where emp_id = :id  and is_active = 1 and is_deleted = 0 ",nativeQuery = true)
	Employee findbyId(@Param("id") int id);
}
