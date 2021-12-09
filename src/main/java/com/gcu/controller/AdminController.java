package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.EmployeeModel;

@Controller
public class AdminController {
	@GetMapping("/display")
	public String display(Model model) {
		
		
		
		model.addAttribute("title", " ");
	
		return "AdminControllerPage";
	}
	
	
	
	}
