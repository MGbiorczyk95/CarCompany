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

import carCompany.constans.BrandEnum;
import carCompany.constans.TypeOfPropertyEnum;
import carCompany.dataAcess.entities.CarEntity;
import carCompany.service.CarService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CarRestServiceTest {

	@Autowired
	private CarService carService;

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
	public void shouldReadCarById() throws Exception {

		// given:
		long id = 5;
		CarEntity car = carService.getCar(id);

		// when
		ResultActions response = this.mockMvc.perform(get("/rest/car/find/" + id));

		// then
		response.andExpect(status().isOk())//
				.andExpect(jsonPath(".id").value((int) car.getId()));
	}

	@Test
	@Transactional
	public void shouldReadCarByBrand() throws Exception {

		// given:
		BrandEnum brand = BrandEnum.Daf;
		List<CarEntity> cars = carService.getByBrand(brand);

		// when
		ResultActions response = this.mockMvc.perform(get("/rest/car/find/byBrand/" + brand));

		// then
		response.andExpect(status().isOk())//
				.andExpect(jsonPath("[0].brand").value((String) cars.get(0).getBrand().toString()))
				.andExpect(jsonPath("[1].brand").value((String) cars.get(1).getBrand().toString()));
	}

	@Test
	@Transactional
	public void shouldReadCarByTypeOfProperty() throws Exception {

		// given:
		TypeOfPropertyEnum typeOfProperty = TypeOfPropertyEnum.Leasing;
		List<CarEntity> cars = carService.getByTypeOfProperty(typeOfProperty);

		// when
		ResultActions response = this.mockMvc.perform(get("/rest/car/find/byTypeOfProperty/" + typeOfProperty));

		// then
		response.andExpect(status().isOk())//
				.andExpect(jsonPath("[0].typeOfProperty").value((String) cars.get(0).getTypeOfProperty().toString()))
				.andExpect(jsonPath("[1].typeOfProperty").value((String) cars.get(1).getTypeOfProperty().toString()))
				.andExpect(jsonPath("[2].typeOfProperty").value((String) cars.get(2).getTypeOfProperty().toString()));
	}

	@Test
	@Transactional
	public void shouldReadCarByCapacity() throws Exception {

		// given:
		int capacity = 4500;
		List<CarEntity> cars = carService.getByCapacity(capacity);

		// when
		ResultActions response = this.mockMvc.perform(get("/rest/car/find/byCapacity/" + capacity));

		// then
		response.andExpect(status().isOk())//
				.andExpect(jsonPath(".capacity").value((int) cars.get(0).getCapacity()));
	}

	@Test
	@Transactional
	public void shouldReadCarByMileage() throws Exception {

		// given:
		int mileage = 240000;
		List<CarEntity> cars = carService.getByMileage(mileage);

		// when
		ResultActions response = this.mockMvc.perform(get("/rest/car/find/byMileage/" + mileage));

		// then
		response.andExpect(status().isOk())//
				.andExpect(jsonPath(".mileage").value((int) cars.get(0).getMileage()));
	}

	@Test
	@Transactional
	public void shouldReadAllCars() throws Exception {

		// given:
		List<CarEntity> cars = carService.getAll();

		// when
		ResultActions response = this.mockMvc.perform(get("/rest/car/getAll/"));

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
