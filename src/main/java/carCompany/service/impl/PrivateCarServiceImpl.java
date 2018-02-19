package carCompany.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import carCompany.constans.BrandEnum;
import carCompany.dao.PrivateCarDao;
import carCompany.dataAcess.entities.PrivateCarEntity;
import carCompany.service.PrivateCarService;
import carCompany.service.exception.UnknownObjectRequestException;

@Service
@Transactional(readOnly = true)
public class PrivateCarServiceImpl implements PrivateCarService {

	@Autowired
	private PrivateCarDao privateCarDao;

	public PrivateCarEntity getPrivateCar(long id) throws UnknownObjectRequestException {
		return privateCarDao.findOne(id);
	}

	public List<PrivateCarEntity> getByBrand(BrandEnum brand) {
		return privateCarDao.getByBrand(brand);
	}

	public List<PrivateCarEntity> getByCapacity(int capacity) {
		return privateCarDao.getByCapacity(capacity);
	}

	public List<PrivateCarEntity> getByMileage(int mileage) {
		return privateCarDao.getByMileage(mileage);
	}

	public List<PrivateCarEntity> getByEmployeesPesel(long pesel) {
		return privateCarDao.getByEmployeesPesel(pesel);
	}

	public void deletePrivateCar(long id) {
		privateCarDao.delete(id);
	}

	public PrivateCarEntity addPrivateCar(PrivateCarEntity privateCarEntity) {
		return privateCarDao.save(privateCarEntity);
	}

	public PrivateCarEntity updatePrivateCar(PrivateCarEntity privateCarEntity) {
		return privateCarDao.update(privateCarEntity);
	}

	public List<PrivateCarEntity> getAll() {
		return privateCarDao.findAll();
	}

}
