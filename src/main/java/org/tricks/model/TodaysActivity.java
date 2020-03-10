package org.tricks.model;

import java.util.List;

public class TodaysActivity {

	private List<EmployeeActivitiesCount> all_employees_last_7_days_statistics;
	private List<Employee> todays_activities;

	public TodaysActivity() {

	}

	public TodaysActivity(List<EmployeeActivitiesCount> all_employees_last_7_days_statistics,
			List<Employee> todays_activities) {
		super();
		this.all_employees_last_7_days_statistics = all_employees_last_7_days_statistics;
		this.todays_activities = todays_activities;
	}

	public List<EmployeeActivitiesCount> getAll_employees_last_7_days_statistics() {
		return all_employees_last_7_days_statistics;
	}

	public void setAll_employees_last_7_days_statistics(
			List<EmployeeActivitiesCount> all_employees_last_7_days_statistics) {
		this.all_employees_last_7_days_statistics = all_employees_last_7_days_statistics;
	}

	public List<Employee> getTodays_activities() {
		return todays_activities;
	}

	public void setTodays_activities(List<Employee> todays_activities) {
		this.todays_activities = todays_activities;
	}

}
