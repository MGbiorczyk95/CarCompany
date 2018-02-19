package carCompany.service;

import java.util.List;

import carCompany.constans.BrandEnum;
import carCompany.constans.TypeOfPropertyEnum;
import carCompany.dataAcess.entities.CarEntity;
import carCompany.service.exception.UnknownObjectRequestException;

public interface CarService {

	CarEntity getCar(long id) throws UnknownObjectRequestException;

	List<CarEntity> getByBrand(BrandEnum brand);

	List<CarEntity> getByCapacity(int capacity);

	List<CarEntity> getByMileage(int mileage);

	List<CarEntity> getByTypeOfProperty(TypeOfPropertyEnum typeOfProperty);

	void deleteCar(long id);

	CarEntity addCar(CarEntity carEntity);

	CarEntity updateCar(CarEntity carEntity);

	List<CarEntity> getAll();
}
