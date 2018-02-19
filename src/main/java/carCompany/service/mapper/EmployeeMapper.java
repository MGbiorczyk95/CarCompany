package carCompany.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import carCompany.dataAcess.entities.EmployeeEntity;
import carCompany.service.to.EmployeeTO;

public class EmployeeMapper {

	public static EmployeeTO map(EmployeeEntity employeeEntity) {
		if (employeeEntity != null) {
			EmployeeTO employeeTO = new EmployeeTO(employeeEntity.getPesel(), employeeEntity.getFirstName(),
					employeeEntity.getSecondName(), employeeEntity.getDateOfBirth(),
					employeeEntity.getDateOfEmployment());

			return employeeTO;
		}
		return null;
	}

	public static EmployeeEntity map(EmployeeTO employeeTO) {
		if (employeeTO != null) {
			EmployeeEntity employeeEntity = new EmployeeEntity();
			employeeEntity.setPesel(employeeTO.getPesel());
			employeeEntity.setFirstName(employeeTO.getFirstName());
			employeeEntity.setSecondName(employeeTO.getSecondName());
			employeeEntity.setDateOfBirth(employeeTO.getDateOfBirth());
			employeeEntity.setDateOfEmployment(employeeTO.getDateOfEmployment());
			return employeeEntity;
		}
		return null;

	}

	public static EmployeeEntity update(EmployeeEntity employeeEntity, EmployeeTO employeeTO) {
		if (employeeEntity != null && employeeTO != null) {

		}
		return employeeEntity;
	}

	public static List<EmployeeTO> map2TOs(List<EmployeeEntity> employeeEntities) {
		return employeeEntities.stream().map(EmployeeMapper::map).collect(Collectors.toList());
	}

	public static List<EmployeeEntity> map2Entities(List<EmployeeTO> employeeTOs) {
		return employeeTOs.stream().map(EmployeeMapper::map).collect(Collectors.toList());
	}
}
