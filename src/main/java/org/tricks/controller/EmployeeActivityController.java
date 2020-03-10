package org.tricks.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.tricks.helper.ApplicationHelper;
import org.tricks.model.TodaysActivity;

@RestController
public class EmployeeActivityController {

	@Autowired
	private ApplicationHelper applicationHelper;

	@GetMapping("/")
	@ResponseBody
	public ModelAndView getStarted(HttpServletRequest request) {

		ModelAndView view = new ModelAndView();
		view.setViewName("home");
		return view;
	}

	@GetMapping("/activitiesCount")
	@ResponseBody
	public List<TodaysActivity> getAllEmployeesActivitiesCount(HttpServletRequest request) {

		List<TodaysActivity> count = new ArrayList<TodaysActivity>();
		count = applicationHelper.getActivityCount();
		return count;
	}
}
