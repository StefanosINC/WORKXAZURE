package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.context.annotation.SessionScope;

import com.gcu.business.EmployeeService;
import com.gcu.business.EmployeeServiceInterface;

@Configuration
public class SpringConfig {
	
//	// This Spring Bean will handle register and login logic
  @Bean  (name="EmployeeService", initMethod="init", destroyMethod="destroy")
  @SessionScope
  @Primary
		public EmployeeServiceInterface doCredentialsService() 
{
	        return new EmployeeService();
	}
	
}
