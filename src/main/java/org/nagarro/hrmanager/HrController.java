package org.nagarro.hrmanager;

import java.util.List;
import java.util.Optional;

import org.nagarro.hrmanager.model.EmployeeModel;
import org.nagarro.hrmanager.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HrController {

	@Autowired
	private EmployeeService empService;

	@RequestMapping("/")
	public String home() {
		/*
		 * EmployeeModel emp= new EmployeeModel(1,"Vivek kumar",
		 * "Gurgao","vivekkumar08@nagarro.com","31/05/2021");
		 */
		return "HIIIII";
	}
	

	@GetMapping("/getemployees")
	public ResponseEntity<List<EmployeeModel>> getEmployess() {
		List<EmployeeModel> list=this.empService.getAllEmployee();
		if(list.size()<= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

	@PostMapping("/postemployees")
	public  ResponseEntity<EmployeeModel> addEmployee(@RequestBody EmployeeModel emp) {
		EmployeeModel em= null;
		try {
		em = this.empService.addEmployee(emp);
		return  ResponseEntity.of(Optional.of(em));
		}catch(Exception e) {
			e.printStackTrace();
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/putemployees/{empId}")
	public  ResponseEntity<EmployeeModel> updateEmployee(@RequestBody EmployeeModel emp, @PathVariable("empId") int empId) {
		try {
		this.empService.updateEmployee(emp, empId);
		return  ResponseEntity.ok().body(emp);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
