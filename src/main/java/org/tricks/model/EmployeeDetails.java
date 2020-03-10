package org.tricks.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class EmployeeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMP_SEQ")
	@SequenceGenerator(sequenceName = "employe_seq", allocationSize = 1, name = "EMP_SEQ")
	private int srNo;
	private int employeeId;
	private String name;
	private String time;
	private String duration;

	public EmployeeDetails() {

	}

	public EmployeeDetails(int employeeId, String name, String time, String duration) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.time = time;
		this.duration = duration;
	}

	public int getSrNo() {
		return srNo;
	}

	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

}
