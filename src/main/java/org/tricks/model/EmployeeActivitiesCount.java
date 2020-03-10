package org.tricks.model;

public class EmployeeActivitiesCount {

	private String activity_name;
	private String occurrences;

	public EmployeeActivitiesCount() {

	}

	public EmployeeActivitiesCount(String activity_name, String occurrences) {
		super();
		this.activity_name = activity_name;
		this.occurrences = occurrences;
	}

	public String getActivity_name() {
		return activity_name;
	}

	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
	}

	public String getOccurrences() {
		return occurrences;
	}

	public void setOccurrences(String occurrences) {
		this.occurrences = occurrences;
	}

}
