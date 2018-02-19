package carCompany.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import carCompany.constans.BrandEnum;
import carCompany.dao.PrivateCarDao;
import carCompany.dataAcess.entities.PrivateCarEntity;

@Repository
public class PrivateCarDaoImpl extends AbstractDao<PrivateCarEntity, Long> implements PrivateCarDao {

	PrivateCarDaoImpl() {

	}

	public List<PrivateCarEntity> getByBrand(BrandEnum brand) {
		TypedQuery<PrivateCarEntity> query = entityManager.createQuery(
				"select privatecar from PrivateCarEntity privatecar where privatecar.brand = :brand",
				PrivateCarEntity.class);

		query.setParameter("brand", brand);

		return query.getResultList();
	}

	public List<PrivateCarEntity> getByCapacity(int capacity) {
		TypedQuery<PrivateCarEntity> query = entityManager.createQuery(
				"select privatecar from PrivateCarEntity privatecar where privatecar.capacity = :capacity",
				PrivateCarEntity.class);

		query.setParameter("capacity", capacity);

		return query.getResultList();
	}

	public List<PrivateCarEntity> getByMileage(int mileage) {
		TypedQuery<PrivateCarEntity> query = entityManager.createQuery(
				"select privatecar from PrivateCarEntity privatecar where privatecar.mileage = :mileage",
				PrivateCarEntity.class);

		query.setParameter("mileage", mileage);

		return query.getResultList();
	}

	public List<PrivateCarEntity> getByEmployeesPesel(long pesel) {
		TypedQuery<PrivateCarEntity> query = entityManager.createQuery(
				"select privatecar from PrivateCarEntity privatecar where privatecar.employee.pesel = :pesel",
				PrivateCarEntity.class);

		query.setParameter("pesel", pesel);

		return query.getResultList();
	}

}
