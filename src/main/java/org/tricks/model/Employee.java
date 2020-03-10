package org.tricks.model;

import java.util.List;

public class Employee {

	private int employee_id;
	private List<EmployeeActivities> activities;

	public Employee() {

	}

	public Employee(int employee_id, List<EmployeeActivities> activities) {
		super();
		this.employee_id = employee_id;
		this.activities = activities;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public List<EmployeeActivities> getActivities() {
		return activities;
	}

	public void setActivities(List<EmployeeActivities> activities) {
		this.activities = activities;
	}

}
