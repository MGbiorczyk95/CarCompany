package carCompany.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import carCompany.dao.AssignmentDao;
import carCompany.dataAcess.entities.AssignmentEntity;
import carCompany.service.AssignmentService;
import carCompany.service.exception.UnknownObjectRequestException;

@Service
@Transactional(readOnly = true)
public class AssignmentServiceImpl implements AssignmentService {

	@Autowired
	private AssignmentDao assignmentDao;

	public AssignmentEntity getAssignment(long id) throws UnknownObjectRequestException {
		return assignmentDao.findOne(id);
	}

	public List<AssignmentEntity> getByStartOfAssignment(Date startOfAssignment) {
		return assignmentDao.getByStartOfAssignment(startOfAssignment);
	}

	public List<AssignmentEntity> getByEmployeesPesel(long pesel) {
		return assignmentDao.getByEmployeesPesel(pesel);
	}

	public List<AssignmentEntity> getByCarId(long carId) {
		return assignmentDao.getByCarId(carId);
	}

	public void deleteAssignment(long id) {
		assignmentDao.delete(id);
	}

	public AssignmentEntity addAssignment(AssignmentEntity assignmentEntity) {
		return assignmentDao.save(assignmentEntity);
	}

	public AssignmentEntity updateAssignment(AssignmentEntity assignmentEntity) {
		return assignmentDao.save(assignmentEntity);
	}

	public List<AssignmentEntity> getAll() {
		return assignmentDao.findAll();
	}

}
