package carCompany.dao;

import java.sql.Date;
import java.util.List;

import carCompany.dataAcess.entities.AssignmentEntity;

public interface AssignmentDao extends Dao<AssignmentEntity, Long> {

	List<AssignmentEntity> getByStartOfAssignment(Date startOfAssignment);

	List<AssignmentEntity> getByEmployeesPesel(long pesel);

	List<AssignmentEntity> getByCarId(long carId);

}
