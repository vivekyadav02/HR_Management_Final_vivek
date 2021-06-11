package org.nagarro.hrmanager.dao;

import org.nagarro.hrmanager.model.EmployeeModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends CrudRepository<EmployeeModel, Integer> {

	
}
