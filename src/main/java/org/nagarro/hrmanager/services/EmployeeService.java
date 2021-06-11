package org.nagarro.hrmanager.services;

import java.util.List;

import org.nagarro.hrmanager.dao.EmployeeRepo;
import org.nagarro.hrmanager.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;
	
	public List<EmployeeModel> getAllEmployee(){
		List<EmployeeModel> list=null;
		try {
		list = (List<EmployeeModel>)this.empRepo.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public EmployeeModel addEmployee(EmployeeModel emp) {
		EmployeeModel result =empRepo.save(emp);
		return result;
	}
	
	public void updateEmployee(EmployeeModel emp, int empId) {
		try {
		emp.setEmpId(empId);
		empRepo.save(emp);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
