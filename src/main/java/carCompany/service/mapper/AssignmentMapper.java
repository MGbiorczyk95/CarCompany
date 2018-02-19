package carCompany.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import carCompany.dataAcess.entities.AssignmentEntity;
import carCompany.service.to.AssignmentTO;

public class AssignmentMapper {

	public static AssignmentTO map(AssignmentEntity assignmentEntity) {
		if (assignmentEntity != null) {
			AssignmentTO assignmentTO = new AssignmentTO(assignmentEntity.getId(),
					assignmentEntity.getStartOfAssignment(), assignmentEntity.getEmployee().getPesel(),
					assignmentEntity.getCar().getId());

			return assignmentTO;
		}
		return null;
	}

	public static AssignmentEntity map(AssignmentTO assignmentTO) {
		if (assignmentTO != null) {
			AssignmentEntity assignmentEntity = new AssignmentEntity();
			assignmentEntity.setId(assignmentTO.getId());
			assignmentEntity.setStartOfAssignment(assignmentTO.getDateOfAssignment());
			return assignmentEntity;
		}
		return null;

	}

	public static AssignmentEntity update(AssignmentEntity assignmentEntity, AssignmentTO assignmentTO) {
		if (assignmentEntity != null && assignmentTO != null) {

		}
		return assignmentEntity;
	}

	public static List<AssignmentTO> map2TOs(List<AssignmentEntity> assignmentEntities) {
		return assignmentEntities.stream().map(AssignmentMapper::map).collect(Collectors.toList());
	}

	public static List<AssignmentEntity> map2Entities(List<AssignmentTO> assignmentTOs) {
		return assignmentTOs.stream().map(AssignmentMapper::map).collect(Collectors.toList());
	}
}
