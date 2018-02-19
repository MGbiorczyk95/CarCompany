package carCompany.dao;

import java.sql.Date;
import java.util.List;

import carCompany.dataAcess.entities.EmployeeEntity;

public interface EmployeeDao extends Dao<EmployeeEntity, Long> {

	List<EmployeeEntity> getByFirstName(String firstName);

	List<EmployeeEntity> getBySecondName(String secondName);

	List<EmployeeEntity> getByDateOfBirth(Date dateOfBirth);

	List<EmployeeEntity> getByDateOfEmployment(Date dateOfEmployment);

}
