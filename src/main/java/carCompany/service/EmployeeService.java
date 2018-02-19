package carCompany.service;

import java.sql.Date;
import java.util.List;

import carCompany.dataAcess.entities.EmployeeEntity;
import carCompany.service.exception.UnknownObjectRequestException;

public interface EmployeeService {

	EmployeeEntity getEmploye(long pesel) throws UnknownObjectRequestException;

	List<EmployeeEntity> getByFirstName(String firstName);

	List<EmployeeEntity> getBySecondName(String secondName);

	List<EmployeeEntity> getByDateOfBirth(Date dateOfBirth);

	List<EmployeeEntity> getByDateOfEmployment(Date dateOfEmployment);

	void deleteEmployee(long pesel);

	EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);

	EmployeeEntity addEmployee(EmployeeEntity employeeEntity);

	List<EmployeeEntity> getAll();
}
