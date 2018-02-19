package carCompany.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import carCompany.dao.AssignmentDao;
import carCompany.dao.CarDao;
import carCompany.dataAcess.entities.AssignmentEntity;
import carCompany.dataAcess.entities.CarEntity;
import carCompany.dataAcess.entities.EmployeeEntity;
import carCompany.service.SearcherService;

@Service
@Transactional(readOnly = true)
public class SearcherServiceImpl implements SearcherService {

	@Autowired
	private AssignmentDao assignmentDao;
	@Autowired
	private CarDao carDao;

	@Override
	public List<EmployeeEntity> searchEmployeesUsedCar(long carId) {

		List<EmployeeEntity> employeesUsedCar = new ArrayList<EmployeeEntity>();

		List<AssignmentEntity> assignments = assignmentDao.getByCarId(carId);

		for (AssignmentEntity assignment : assignments) {

			if (!employeesUsedCar.contains(assignment.getEmployee()))
				employeesUsedCar.add(assignment.getEmployee());
		}

		return employeesUsedCar;
	}

	@Override
	public List<CarEntity> searchCarsUsedInCompanyByMoreThanNumberOfDrivers(int numberOfDrivers) {

		List<CarEntity> carsToReturn = carDao.findAll();

		Map<CarEntity, Integer> carsInCompany = new HashMap<CarEntity, Integer>();

		List<AssignmentEntity> assignments = assignmentDao.findAll();

		for (AssignmentEntity assignment : assignments) {

			if (!carsInCompany.containsKey(assignment.getCar())) {
				carsInCompany.put(assignment.getCar(), 1);
			} else {
				carsInCompany.put(assignment.getCar(), carsInCompany.get(assignment.getCar()) + 1);
			}
		}
		for (CarEntity car : carsToReturn) {
			if (carsInCompany.get(car) == numberOfDrivers) {

			} else {
				carsToReturn.remove(car);
			}
		}
		return carsToReturn;
	}
}
