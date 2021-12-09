package com.gcu.business;



import java.util.List;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.gcu.data.entity.EmployeeEntity;
import com.gcu.model.EmployeeModel;



public interface EmployeeServiceInterface {
	public void init();
	public void destroy();
	public boolean login(EmployeeModel user);
	//UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	public String doLogin(EmployeeModel credentialsModel, BindingResult bindingResult, Model model);
	List<EmployeeModel> findAll();
}
