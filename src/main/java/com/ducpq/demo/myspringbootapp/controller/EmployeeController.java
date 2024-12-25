package com.ducpq.demo.myspringbootapp.controller;

import com.ducpq.demo.myspringbootapp.entity.Employee;
import com.ducpq.demo.myspringbootapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	private final EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	// add mapping for "list"
	@GetMapping("/list")
	public String getList(
			@PageableDefault(size = 10)
			@SortDefault(sort = "id", direction = Sort.Direction.ASC)
			Pageable pageable, Model model) {
		
		// get the employees from db
		List<Employee> employees = employeeService.findAll(pageable).data().data();
		
		// add to the spring models
		model.addAttribute("employees", employees);
		
		return "list-employees";
	}
	
}
