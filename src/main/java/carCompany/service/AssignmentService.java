package carCompany.service;

import java.sql.Date;
import java.util.List;

import carCompany.dataAcess.entities.AssignmentEntity;
import carCompany.service.exception.UnknownObjectRequestException;

public interface AssignmentService {

	AssignmentEntity getAssignment(long id) throws UnknownObjectRequestException;

	List<AssignmentEntity> getByStartOfAssignment(Date startOfAssignment);

	List<AssignmentEntity> getByEmployeesPesel(long pesel);

	List<AssignmentEntity> getByCarId(long carId);

	void deleteAssignment(long id);

	AssignmentEntity addAssignment(AssignmentEntity assignmentEntity);

	AssignmentEntity updateAssignment(AssignmentEntity assignmentEntity);

	List<AssignmentEntity> getAll();
}
