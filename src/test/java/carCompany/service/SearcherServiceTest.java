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

import carCompany.dataAcess.entities.CarEntity;
import carCompany.dataAcess.entities.EmployeeEntity;
import carCompany.service.SearcherService;
import carCompany.service.exception.UnknownObjectRequestException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SearcherServiceTest {

	@Autowired
	private SearcherService searcherService;

	@Test
	@Transactional
	public void shouldGetEmployeesUsedCarByCarId() throws UnknownObjectRequestException {

		// given
		long carId = 2;
		String firstName = "Tomasz";

		// when
		List<EmployeeEntity> employees = searcherService.searchEmployeesUsedCar(carId);

		// then
		assertTrue(employees != null);
		assertEquals(employees.get(0).getFirstName(), firstName);
	}

	@Test
	@Transactional
	public void shouldGetCarsUsedInCompanyByMoreThanNumberOfDrivers() throws UnknownObjectRequestException {

		// given
		int numberOfDrivers = 1;

		// then
		List<CarEntity> cars = searcherService.searchCarsUsedInCompanyByMoreThanNumberOfDrivers(numberOfDrivers);

		// then
		assertTrue(cars != null);
		assertEquals(cars.size(), 7);
	}

}
