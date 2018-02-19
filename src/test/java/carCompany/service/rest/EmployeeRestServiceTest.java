package carCompany.service.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
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

import carCompany.dataAcess.entities.EmployeeEntity;
import carCompany.service.EmployeeService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmployeeRestServiceTest {

	@Autowired
	private EmployeeService employeeService;

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
	public void shouldReadEmployeeByPesel() throws Exception {

		// given:
		long pesel = 68042503389L;
		EmployeeEntity employee = employeeService.getEmploye(pesel);

		// when
		ResultActions response = this.mockMvc.perform(get("/rest/employee/find/" + pesel));

		// then
		response.andExpect(status().isOk())//
				.andExpect(jsonPath(".pesel").value((long) employee.getPesel()));
	}

	@Test
	@Transactional
	public void shouldReadEmployeeByFirstName() throws Exception {

		// given:
		String firstName = "Adam";
		List<EmployeeEntity> employees = employeeService.getByFirstName(firstName);

		// when
		ResultActions response = this.mockMvc.perform(get("/rest/employee/find/byFirstName/" + firstName));

		// then
		response.andExpect(status().isOk())//
				.andExpect(jsonPath(".firstName").value((String) employees.get(0).getFirstName()));
	}

	@Test
	@Transactional
	public void shouldReadEmployeeBySecondName() throws Exception {

		// given:
		String secondName = "Tomaszewski";
		List<EmployeeEntity> employees = employeeService.getBySecondName(secondName);

		// when
		ResultActions response = this.mockMvc.perform(get("/rest/employee/find/bySecondName/" + secondName));

		// then
		response.andExpect(status().isOk())//
				.andExpect(jsonPath(".secondName").value((String) employees.get(0).getSecondName()));
	}

	@Test
	@Transactional
	public void shouldReadEmployeeByDateOfBirth() throws Exception {

		// given:
		@SuppressWarnings("deprecation")
		Date dateOfBirth = new Date(92, 10, 8);
		List<EmployeeEntity> employees = employeeService.getByDateOfBirth(dateOfBirth);

		// when
		ResultActions response = this.mockMvc.perform(get("/rest/employee/find/byDateOfBirth/" + dateOfBirth));

		// then
		response.andExpect(status().isOk())//
				.andExpect(jsonPath(".dateOfBirth").value((String) employees.get(0).getDateOfBirth().toString()));
	}

	@Test
	@Transactional
	public void shouldReadEmployeeByStartOfEmployment() throws Exception {

		// given:
		@SuppressWarnings("deprecation")
		Date startOfEmployment = new Date(101, 3, 5);
		List<EmployeeEntity> employees = employeeService.getByDateOfEmployment(startOfEmployment);

		// when
		ResultActions response = this.mockMvc
				.perform(get("/rest/employee/find/byDateOfEmployment/" + startOfEmployment));

		// then
		response.andExpect(status().isOk())//
				.andExpect(jsonPath(".dateOfEmployment")
						.value((String) employees.get(0).getDateOfEmployment().toString()));
	}

	@Test
	@Transactional
	public void shouldReadAllEmployees() throws Exception {

		// given:
		List<EmployeeEntity> employees = employeeService.getAll();

		// when
		ResultActions response = this.mockMvc.perform(get("/rest/employee/getAll/"));

		// then
		response.andExpect(status().isOk())//
				.andExpect(jsonPath("[0].pesel").value((long) employees.get(0).getPesel()))
				.andExpect(jsonPath("[1].pesel").value((long) employees.get(1).getPesel()))
				.andExpect(jsonPath("[2].pesel").value((long) employees.get(2).getPesel()))
				.andExpect(jsonPath("[3].pesel").value((long) employees.get(3).getPesel()))
				.andExpect(jsonPath("[4].pesel").value((long) employees.get(4).getPesel()));
	}
}
