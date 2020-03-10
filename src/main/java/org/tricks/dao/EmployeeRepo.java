package org.tricks.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.tricks.model.EmployeeDetails;
import java.lang.String;
import java.util.List;

public interface EmployeeRepo extends CrudRepository<EmployeeDetails, Integer> {

	int findByName(String name);

	long countByName(String name);

	List<EmployeeDetails> findByEmployeeId(int employeeId);

	@Query("select distinct e.employeeId from EmployeeDetails e order by e.employeeId desc")
	List<String> findEmployeeId();
}
