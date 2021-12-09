package com.gcu.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;


import com.gcu.business.EmployeeServiceInterface;
import com.gcu.model.EmployeeModel;





@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceInterface employeeservice;
	
	
	
	
	
	
	// Login
	@GetMapping("/login")
	public String display(Model model) {
		model.addAttribute("title", "");
		
		
		return "index";
		
		
	}
	

	
	@GetMapping("/ViewEmployees")
	public String displayEmployees(Model model) {
	
		
		// get employee List from the service -> Database
		List<EmployeeModel> employeeList = employeeservice.findAll();
		
		// Set the title attribute (from common)
		model.addAttribute("title", "View Employees");
		
		// add the employee attribute which is in list of employees
		model.addAttribute("employeeList", employeeList);
		
		return "ViewEmployeesForm";
	}
	
	
	
	@GetMapping("/RegForm")
	public String displayReg(Model model) {
		model.addAttribute("title", "New Employee Form");
		
		model.addAttribute("employeeModel", new EmployeeModel());
		
		return "NewEmployeeForm";
	}
	
	// Register Form
	public String doRegister(EmployeeModel employee, BindingResult bindingResult, Model model) {
		
		return null;
	
		}

	
}