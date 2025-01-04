package com.ducpq.demo.thymeleaf.controller;

import com.ducpq.demo.thymeleaf.entity.Employee;
import com.ducpq.demo.thymeleaf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
		
		return "employees/list-employees";
	}
	
	// add mapping for "add"
	@GetMapping("/add")
	public String getAddPage(Model model) {
		
		Employee employee = new Employee();
		
		// add to the spring models
		model.addAttribute("employee", employee);
		
		return "employees/form-employees";
	}
	
	// add mapping for "update"
	@PostMapping("/update")
	public String getUpdatePage(@RequestParam("employeeId") Integer employeeId, Model model) {
		
		Employee employee = employeeService.findById(employeeId).data();
		
		// add to the spring models
		model.addAttribute("employee", employee);
		
		return "employees/form-employees";
	}
	
	// add mapping for "save"
	@PostMapping("/save")
	public String save(@ModelAttribute Employee employee) {
		
		// save employee
		if (employee.getId() == null) {
			employeeService.save(employee);
		} else {
			employeeService.update(employee);
		}
		
		return "redirect:/employees/list?sort=lastName";
	}
	
	// add mapping for "delete"
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer employeeId, @ModelAttribute Employee employee) {
		
		// delete employee
		employeeService.deleteById(employeeId);
		
		return "redirect:/employees/list?sort=lastName";
	}
	
	
}
