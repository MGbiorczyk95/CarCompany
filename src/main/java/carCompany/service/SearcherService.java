package carCompany.service;

import java.util.List;

import carCompany.dataAcess.entities.CarEntity;
import carCompany.dataAcess.entities.EmployeeEntity;

public interface SearcherService {

	List<EmployeeEntity> searchEmployeesUsedCar(long carId);

	List<CarEntity> searchCarsUsedInCompanyByMoreThanNumberOfDrivers(int numberOfDrivers);
}
