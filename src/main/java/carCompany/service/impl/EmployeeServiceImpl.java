package carCompany.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import carCompany.dao.EmployeeDao;
import carCompany.dataAcess.entities.EmployeeEntity;
import carCompany.service.EmployeeService;
import carCompany.service.exception.UnknownObjectRequestException;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public EmployeeEntity getEmploye(long pesel) throws UnknownObjectRequestException {
		return employeeDao.findOne(pesel);
	}

	public List<EmployeeEntity> getByFirstName(String firstName) {
		return employeeDao.getByFirstName(firstName);
	}

	public List<EmployeeEntity> getBySecondName(String secondName) {
		return employeeDao.getBySecondName(secondName);
	}

	public List<EmployeeEntity> getByDateOfBirth(Date dateOfBirth) {
		return employeeDao.getByDateOfBirth(dateOfBirth);
	}

	public List<EmployeeEntity> getByDateOfEmployment(Date dateOfEmployment) {
		return employeeDao.getByDateOfEmployment(dateOfEmployment);
	}

	public void deleteEmployee(long pesel) {
		employeeDao.delete(pesel);
	}

	public EmployeeEntity addEmployee(EmployeeEntity employeeEntity) {
		return employeeDao.save(employeeEntity);
	}

	public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
		return employeeDao.save(employeeEntity);
	}

	public List<EmployeeEntity> getAll() {
		return employeeDao.findAll();
	}

}
