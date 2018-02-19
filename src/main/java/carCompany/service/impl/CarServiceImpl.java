package carCompany.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import carCompany.constans.BrandEnum;
import carCompany.constans.TypeOfPropertyEnum;
import carCompany.dao.CarDao;
import carCompany.dataAcess.entities.CarEntity;
import carCompany.service.CarService;
import carCompany.service.exception.UnknownObjectRequestException;

@Service
@Transactional(readOnly = true)
public class CarServiceImpl implements CarService {

	@Autowired
	private CarDao carDao;

	public CarEntity getCar(long id) throws UnknownObjectRequestException {
		return carDao.getOne(id);
	}

	public List<CarEntity> getByBrand(BrandEnum brand) {
		return carDao.getByBrand(brand);
	}

	public List<CarEntity> getByCapacity(int capacity) {
		return carDao.getByCapacity(capacity);
	}

	public List<CarEntity> getByMileage(int mileage) {
		return carDao.getByMileage(mileage);
	}

	public List<CarEntity> getByTypeOfProperty(TypeOfPropertyEnum typeOfProperty) {
		return carDao.getByTypeOfProperty(typeOfProperty);
	}

	public void deleteCar(long id) {
		carDao.delete(id);
	}

	public CarEntity addCar(CarEntity carEntity) {
		return carDao.save(carEntity);
	}

	public CarEntity updateCar(CarEntity carEntity) {
		return carDao.update(carEntity);
	}

	public List<CarEntity> getAll() {
		return carDao.findAll();
	}

}
