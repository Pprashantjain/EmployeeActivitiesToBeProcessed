package org.tricks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tricks.dao.EmployeeRepo;
import org.tricks.model.EmployeeDetails;

@Service("applicationService")
public class ApplicationService {

	@Autowired
	EmployeeRepo employeeRepo;

	public void saveFile(EmployeeDetails employeeDetails) {
		employeeRepo.save(employeeDetails);
	}

	public long findByActivityName(String name) {
		return employeeRepo.countByName(name);
	}

	public Iterable<EmployeeDetails> getRecords() {

		Iterable<EmployeeDetails> details = employeeRepo.findAll();

		return details;
	}

	public List<EmployeeDetails> findByEmployeeId(int id) {
		return employeeRepo.findByEmployeeId(id);
	}

	public List<String> findEmployeeId() {
		return employeeRepo.findEmployeeId();
	}
}
