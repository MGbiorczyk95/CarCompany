package carCompany.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import carCompany.constans.BrandEnum;
import carCompany.constans.TypeOfPropertyEnum;
import carCompany.dataAcess.entities.CarEntity;
import carCompany.service.CarService;
import carCompany.service.exception.UnknownObjectRequestException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CarServiceTest {

	@Autowired
	private CarService carService;

	@Test
	@Transactional
	public void shouldGetCarById() throws UnknownObjectRequestException {

		// given
		long id = 1;

		// when
		CarEntity car = carService.getCar(id);

		// then
		assertTrue(car != null);
		assertEquals(car.getId(), id);
	}

	@Test
	@Transactional
	public void shouldGetCarByBrand() throws UnknownObjectRequestException {

		// given
		BrandEnum brand = BrandEnum.Mercedes;

		// when
		List<CarEntity> cars = carService.getByBrand(brand);

		// then
		assertTrue(cars != null);
		assertEquals(cars.get(0).getBrand(), brand);
	}

	@Test
	@Transactional
	public void shouldGetCarByTypeOfProperty() throws UnknownObjectRequestException {

		// given
		TypeOfPropertyEnum typeOfProperty = TypeOfPropertyEnum.Leasing;
		// when
		List<CarEntity> cars = carService.getByTypeOfProperty(typeOfProperty);

		// then
		assertTrue(cars != null);
		assertEquals(cars.get(0).getTypeOfProperty(), typeOfProperty);
	}

	@Test
	@Transactional
	public void shouldGetCarByCapacity() throws UnknownObjectRequestException {

		// given
		int capacity = 4000;
		// when
		List<CarEntity> cars = carService.getByCapacity(capacity);
		// then
		assertTrue(cars != null);
		assertEquals(cars.get(0).getCapacity(), capacity);
	}

	@Test
	@Transactional
	public void shouldGetCarByMileage() throws UnknownObjectRequestException {

		// given
		int mileage = 330000;
		// when
		List<CarEntity> cars = carService.getByMileage(mileage);
		// then
		assertTrue(cars != null);
		assertEquals(cars.get(0).getMileage(), mileage);
	}
}
