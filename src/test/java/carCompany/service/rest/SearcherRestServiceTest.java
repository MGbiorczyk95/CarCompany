package carCompany.service.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import carCompany.dataAcess.entities.CarEntity;
import carCompany.dataAcess.entities.EmployeeEntity;
import carCompany.service.SearcherService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SearcherRestServiceTest {

	@Autowired
	private SearcherService searcherService;

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	@Transactional
	public void shouldReadEmployeesUsedCarByCarId() throws Exception {

		// given
		long carId = 2;
		List<EmployeeEntity> employeesUsedCar = searcherService.searchEmployeesUsedCar(carId);

		// when
		ResultActions response = this.mockMvc.perform(get("/rest/search/employeesUsedCar/" + carId));

		// then
		response.andExpect(status().isOk())//
				.andExpect(jsonPath(".pesel").value((long) employeesUsedCar.get(0).getPesel()));
	}

	@Test
	@Transactional
	public void shouldReadCarsUsedInCompanyByNumberOfDrivers() throws Exception {

		// given
		int numberOfDrivers = 1;
		List<CarEntity> cars = searcherService.searchCarsUsedInCompanyByMoreThanNumberOfDrivers(numberOfDrivers);

		// when
		ResultActions response = this.mockMvc
				.perform(get("/rest/search/carsUsedInCompanyByNumberOfDrivers/" + numberOfDrivers));

		// then
		response.andExpect(status().isOk())//
				.andExpect(jsonPath("[0].id").value((int) cars.get(0).getId()))
				.andExpect(jsonPath("[1].id").value((int) cars.get(1).getId()))
				.andExpect(jsonPath("[2].id").value((int) cars.get(2).getId()))
				.andExpect(jsonPath("[3].id").value((int) cars.get(3).getId()))
				.andExpect(jsonPath("[4].id").value((int) cars.get(4).getId()))
				.andExpect(jsonPath("[5].id").value((int) cars.get(5).getId()))
				.andExpect(jsonPath("[6].id").value((int) cars.get(6).getId()));

	}

}
