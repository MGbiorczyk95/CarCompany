package carCompany.dao;

import java.util.List;

import carCompany.constans.BrandEnum;
import carCompany.constans.TypeOfPropertyEnum;
import carCompany.dataAcess.entities.CarEntity;

public interface CarDao extends Dao<CarEntity, Long> {

	List<CarEntity> getByBrand(BrandEnum brand);

	List<CarEntity> getByCapacity(int capacity);

	List<CarEntity> getByMileage(int mileage);

	List<CarEntity> getByTypeOfProperty(TypeOfPropertyEnum typeOfProperty);

}
