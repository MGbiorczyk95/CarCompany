package carCompany.dao.impl;

import java.sql.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import carCompany.dao.EmployeeDao;
import carCompany.dataAcess.entities.EmployeeEntity;

@Repository
public class EmployeeDaoImpl extends AbstractDao<EmployeeEntity, Long> implements EmployeeDao {

	EmployeeDaoImpl() {

	}

	public List<EmployeeEntity> getByFirstName(String firstName) {
		TypedQuery<EmployeeEntity> query = entityManager.createQuery(
				"select employee from EmployeeEntity employee where employee.firstName = :firstName",
				EmployeeEntity.class);

		query.setParameter("firstName", firstName);

		return query.getResultList();
	}

	public List<EmployeeEntity> getBySecondName(String secondName) {
		TypedQuery<EmployeeEntity> query = entityManager.createQuery(
				"select employee from EmployeeEntity employee where employee.secondName = :secondName",
				EmployeeEntity.class);

		query.setParameter("secondName", secondName);

		return query.getResultList();
	}

	public List<EmployeeEntity> getByDateOfBirth(Date dateOfBirth) {
		TypedQuery<EmployeeEntity> query = entityManager.createQuery(
				"select employee from EmployeeEntity employee where employee.dateOfBirth = :dateOfBirth",
				EmployeeEntity.class);

		query.setParameter("dateOfBirth", dateOfBirth);

		return query.getResultList();
	}

	public List<EmployeeEntity> getByDateOfEmployment(Date dateOfEmployment) {
		TypedQuery<EmployeeEntity> query = entityManager.createQuery(
				"select employee from EmployeeEntity employee where employee.dateOfEmployment = :dateOfEmployment",
				EmployeeEntity.class);

		query.setParameter("dateOfEmployment", dateOfEmployment);

		return query.getResultList();
	}

}
