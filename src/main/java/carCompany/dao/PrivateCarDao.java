package carCompany.dao;

import java.util.List;

import carCompany.constans.BrandEnum;
import carCompany.dataAcess.entities.PrivateCarEntity;

public interface PrivateCarDao extends Dao<PrivateCarEntity, Long> {

	List<PrivateCarEntity> getByBrand(BrandEnum brand);

	List<PrivateCarEntity> getByCapacity(int capacity);

	List<PrivateCarEntity> getByMileage(int mileage);

	List<PrivateCarEntity> getByEmployeesPesel(long pesel);

}
