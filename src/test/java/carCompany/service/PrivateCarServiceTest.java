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
import carCompany.dataAcess.entities.PrivateCarEntity;
import carCompany.service.PrivateCarService;
import carCompany.service.exception.UnknownObjectRequestException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PrivateCarServiceTest {

	@Autowired
	private PrivateCarService privateCarService;

	@Test
	@Transactional
	public void shouldGetPrivateCarById() throws UnknownObjectRequestException {

		// given
		long id = 1;

		// when
		PrivateCarEntity privateCar = privateCarService.getPrivateCar(id);

		// then
		assertTrue(privateCar != null);
		assertEquals(privateCar.getId(), id);
	}

	@Test
	@Transactional
	public void shouldGetPrivateCarByBrand() throws UnknownObjectRequestException {

		// given
		BrandEnum brand = BrandEnum.Mercedes;

		// when
		List<PrivateCarEntity> privateCars = privateCarService.getByBrand(brand);

		// then
		assertTrue(privateCars != null);
		assertEquals(privateCars.get(0).getBrand(), brand);

	}

	@Test
	@Transactional
	public void shouldGetPrivateCarByEmployeesPesel() throws UnknownObjectRequestException {

		// given
		long pesel = 68042503389L;
		// when
		List<PrivateCarEntity> privateCars = privateCarService.getByEmployeesPesel(pesel);

		// then
		assertTrue(privateCars != null);
		assertEquals(privateCars.get(0).getEmployee().getPesel(), pesel);
	}

	@Test
	@Transactional
	public void shouldGetPrivateCarByCapacity() throws UnknownObjectRequestException {

		// given
		int capacity = 2500;
		// when
		List<PrivateCarEntity> privateCars = privateCarService.getByCapacity(capacity);
		// then
		assertTrue(privateCars != null);
		assertEquals(privateCars.get(0).getCapacity(), capacity);
	}

	@Test
	@Transactional
	public void shouldGetPrivateCarByMileage() throws UnknownObjectRequestException {

		// given
		int mileage = 330000;
		// when
		List<PrivateCarEntity> privateCars = privateCarService.getByMileage(mileage);
		// then
		assertTrue(privateCars != null);
		assertEquals(privateCars.get(0).getMileage(), mileage);
	}
}
