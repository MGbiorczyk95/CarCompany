package carCompany.dao.impl;

import java.sql.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import carCompany.dao.AssignmentDao;
import carCompany.dataAcess.entities.AssignmentEntity;

@Repository
public class AssignmentDaoImpl extends AbstractDao<AssignmentEntity, Long> implements AssignmentDao {

	AssignmentDaoImpl() {

	}

	public List<AssignmentEntity> getByStartOfAssignment(Date startOfAssignment) {
		TypedQuery<AssignmentEntity> query = entityManager.createQuery(
				"select assignment from AssignmentEntity assignment where assignment.startOfAssignment = :startOfAssignment",
				AssignmentEntity.class);

		query.setParameter("startOfAssignment", startOfAssignment);

		return query.getResultList();
	}

	public List<AssignmentEntity> getByEmployeesPesel(long pesel) {
		TypedQuery<AssignmentEntity> query = entityManager.createQuery(
				"select assignment from AssignmentEntity assignment where assignment.employee.pesel = :pesel",
				AssignmentEntity.class);

		query.setParameter("pesel", pesel);

		return query.getResultList();
	}

	public List<AssignmentEntity> getByCarId(long carId) {
		TypedQuery<AssignmentEntity> query = entityManager.createQuery(
				"select assignment from AssignmentEntity assignment where assignment.car.id = :carId",
				AssignmentEntity.class);

		query.setParameter("carId", carId);

		return query.getResultList();
	}

}
