package org.nagarro.hrmanager;

import org.nagarro.hrmanager.dao.EmployeeRepo;
import org.nagarro.hrmanager.model.EmployeeModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HrManagerApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(HrManagerApplication.class, args);
		
		EmployeeRepo empRepo =context.getBean(EmployeeRepo.class);
		EmployeeModel emp= new EmployeeModel(1,"Vivek kumar",
				"Gurgao","vivekkumar08@nagarro.com","31/05/2021");
		
		EmployeeModel emp1= empRepo.save(emp);
		System.out.println(emp1);
		
		
	}

}
