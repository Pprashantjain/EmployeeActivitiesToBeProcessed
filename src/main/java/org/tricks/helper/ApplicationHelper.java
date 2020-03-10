package org.tricks.helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.tricks.model.Employee;
import org.tricks.model.EmployeeActivities;
import org.tricks.model.EmployeeActivitiesCount;
import org.tricks.model.EmployeeDetails;
import org.tricks.model.TodaysActivity;
import org.tricks.service.ApplicationService;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service("applicationHelper")
@PropertySource(value = { "classpath:employeeActivity.properties" })
public class ApplicationHelper {

	@Autowired
	ApplicationService applicationService;

	@Autowired
	Environment env;

	public void readJsonFiles(String path) {
		ObjectMapper objectMapper = new ObjectMapper();
		EmployeeDetails details = null;
		try {
			Employee employee = objectMapper.readValue(new File(path), Employee.class);
			for (EmployeeActivities activities : employee.getActivities()) {
				if (validateActivity(activities.getName())) {
					details = new EmployeeDetails(employee.getEmployee_id(), activities.getName(),
							activities.getTime() + "", activities.getDuration() + "");
					applicationService.saveFile(details);
				}
			}
		} catch (IOException e) {
			System.out.println("Error : " + e.getMessage());
		}

	}

	public boolean validateActivity(String name) {

		List<String> activities = Arrays.asList(env.getRequiredProperty("employee.activities").split(","));

		if (activities.contains(name.toLowerCase())) {
//			System.out.println("activity contains: " + name);
			return true;
		} else {
//			System.out.println("activity not contains: " + name);
			return false;

		}
	}

	public void getPath() {

		String dataDirectory = new ClassPathResource(env.getRequiredProperty("employee.filePath")).getPath();
		File file = new File(dataDirectory);
		File files[] = file.listFiles();
//		System.out.println("path" + file.getAbsolutePath());
		try {
			for (File obj : files) {
				readJsonFiles(obj.getAbsolutePath());
//				System.out.println("exist :" + obj.getAbsolutePath());
			}
		} catch (Exception e) {
			System.out.println("Error is getting files: " + e.getMessage());
		}

	}

	public List<TodaysActivity> getActivityCount() {

		List<TodaysActivity> activityFinalList = new ArrayList<TodaysActivity>();
		List<String> activities = Arrays.asList(env.getRequiredProperty("employee.activities").split(","));
		EmployeeActivitiesCount count = null;
		List<EmployeeActivitiesCount> countList = new ArrayList<EmployeeActivitiesCount>();
		for (String name : activities) {
			count = new EmployeeActivitiesCount(name, applicationService.findByActivityName(name) + "");
			countList.add(count);
		}
		Comparator<EmployeeActivitiesCount> byCount = (EmployeeActivitiesCount e1, EmployeeActivitiesCount e2) -> e1
				.getOccurrences().compareTo(e2.getOccurrences());
		Collections.sort(countList, byCount);
		Collections.sort(countList, byCount.reversed());
		/* another list getting */
		Iterable<String> employeeIds = applicationService.findEmployeeId();
		Employee e = null;
		EmployeeActivities acti = null;
		List<EmployeeActivities> actiList = null;
		List<Employee> empList = new ArrayList<Employee>();
		for (String employeeId : employeeIds) {
			actiList = new ArrayList<EmployeeActivities>();
			List<EmployeeDetails> detailsList = applicationService.findByEmployeeId(Integer.parseInt(employeeId));
			for (EmployeeDetails deta : detailsList) {
				acti = new EmployeeActivities(deta.getName(), Long.valueOf(deta.getTime()));
				actiList.add(acti);
			}
			e = new Employee(Integer.valueOf(employeeId), actiList);
			empList.add(e);
//			System.out.println(employeeId);
		}

		Comparator<EmployeeActivities> sortActivity = (EmployeeActivities a1, EmployeeActivities a2) -> a1.getTime()
				.compareTo(a2.getTime());
		Collections.sort(actiList, sortActivity);

		Comparator<Employee> idWise = (Employee e1, Employee e2) -> e1.getEmployee_id()
				+ "".compareTo(e2.getEmployee_id() + "");
		Collections.sort(empList, idWise);
		Collections.sort(empList, idWise.reversed());

		TodaysActivity todaysActivityObj = new TodaysActivity(countList, empList);
		activityFinalList.add(todaysActivityObj);

		return activityFinalList;
	}
}
