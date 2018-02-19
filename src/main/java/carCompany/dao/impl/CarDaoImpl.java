package carCompany.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import carCompany.constans.BrandEnum;
import carCompany.constans.TypeOfPropertyEnum;
import carCompany.dao.CarDao;
import carCompany.dataAcess.entities.CarEntity;

@Repository
public class CarDaoImpl extends AbstractDao<CarEntity, Long> implements CarDao {

	CarDaoImpl() {

	}

	public List<CarEntity> getByBrand(BrandEnum brand) {
		TypedQuery<CarEntity> query = entityManager
				.createQuery("select car from CarEntity car where car.brand = :brand", CarEntity.class);

		query.setParameter("brand", brand);

		return query.getResultList();
	}

	public List<CarEntity> getByCapacity(int capacity) {
		TypedQuery<CarEntity> query = entityManager
				.createQuery("select car from CarEntity car where car.capacity = :capacity", CarEntity.class);

		query.setParameter("capacity", capacity);

		return query.getResultList();
	}

	public List<CarEntity> getByMileage(int mileage) {
		TypedQuery<CarEntity> query = entityManager
				.createQuery("select car from CarEntity car where car.mileage = :mileage", CarEntity.class);

		query.setParameter("mileage", mileage);

		return query.getResultList();
	}

	public List<CarEntity> getByTypeOfProperty(TypeOfPropertyEnum typeOfProperty) {
		TypedQuery<CarEntity> query = entityManager.createQuery(
				"select car from CarEntity car where car.typeOfProperty = :typeOfProperty", CarEntity.class);

		query.setParameter("typeOfProperty", typeOfProperty);

		return query.getResultList();
	}

}
