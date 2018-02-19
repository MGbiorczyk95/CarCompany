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
import carCompany.dataAcess.entities.PrivateCarEntity;
import carCompany.service.PrivateCarService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PrivateCarRestServiceTest {

	@Autowired
	private PrivateCarService privateCarService;

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
	public void shouldReadPrivateCarById() throws Exception {

		// given:
		long id = 2;
		PrivateCarEntity privateCar = privateCarService.getPrivateCar(id);

		// when
		ResultActions response = this.mockMvc.perform(get("/rest/privatecar/find/" + id));

		// then
		response.andExpect(status().isOk())//
				.andExpect(jsonPath(".id").value((int) privateCar.getId()));
	}

	@Test
	@Transactional
	public void shouldReadPrivateCarByBrand() throws Exception {

		// given:
		BrandEnum brand = BrandEnum.Scania;
		List<PrivateCarEntity> privateCars = privateCarService.getByBrand(brand);

		// when
		ResultActions response = this.mockMvc.perform(get("/rest/privatecar/find/byBrand/" + brand));

		// then
		response.andExpect(status().isOk())//
				.andExpect(jsonPath(".brand").value((String) privateCars.get(0).getBrand().toString()));
	}

	@Test
	@Transactional
	public void shouldReadPrivateCarByEmployeesPesel() throws Exception {

		// given:
		long pesel = 75061504501L;
		List<PrivateCarEntity> cars = privateCarService.getByEmployeesPesel(pesel);

		// when
		ResultActions response = this.mockMvc.perform(get("/rest/privatecar/find/byOwner/" + pesel));

		// then
		response.andExpect(status().isOk())//
				.andExpect(jsonPath(".pesel").value((long) cars.get(0).getEmployee().getPesel()));
	}

	@Test
	@Transactional
	public void shouldReadPrivateCarByCapacity() throws Exception {

		// given:
		int capacity = 6000;
		List<PrivateCarEntity> privateCars = privateCarService.getByCapacity(capacity);

		// when
		ResultActions response = this.mockMvc.perform(get("/rest/privatecar/find/byCapacity/" + capacity));

		// then
		response.andExpect(status().isOk())//
				.andExpect(jsonPath(".capacity").value((int) privateCars.get(0).getCapacity()));
	}

	@Test
	@Transactional
	public void shouldReadPrivateCarByMileage() throws Exception {

		// given:
		int mileage = 240000;
		List<PrivateCarEntity> privateCars = privateCarService.getByMileage(mileage);

		// when
		ResultActions response = this.mockMvc.perform(get("/rest/privatecar/find/byMileage/" + mileage));

		// then
		response.andExpect(status().isOk())//
				.andExpect(jsonPath(".mileage").value((int) privateCars.get(0).getMileage()));
	}

	@Test
	@Transactional
	public void shouldReadAllCars() throws Exception {

		// given:
		List<PrivateCarEntity> privateCars = privateCarService.getAll();

		// when
		ResultActions response = this.mockMvc.perform(get("/rest/privatecar/getAll/"));

		// then
		response.andExpect(status().isOk())//
				.andExpect(jsonPath("[0].id").value((int) privateCars.get(0).getId()))
				.andExpect(jsonPath("[1].id").value((int) privateCars.get(1).getId()));
	}
}
