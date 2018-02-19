package carCompany.service;

import java.util.List;

import carCompany.constans.BrandEnum;
import carCompany.dataAcess.entities.PrivateCarEntity;
import carCompany.service.exception.UnknownObjectRequestException;

public interface PrivateCarService {

	PrivateCarEntity getPrivateCar(long id) throws UnknownObjectRequestException;

	List<PrivateCarEntity> getByBrand(BrandEnum brand);

	List<PrivateCarEntity> getByCapacity(int capacity);

	List<PrivateCarEntity> getByMileage(int mileage);

	List<PrivateCarEntity> getByEmployeesPesel(long pesel);

	void deletePrivateCar(long id);

	PrivateCarEntity addPrivateCar(PrivateCarEntity privateCarEntity);

	PrivateCarEntity updatePrivateCar(PrivateCarEntity privateCarEntity);

	List<PrivateCarEntity> getAll();
}
