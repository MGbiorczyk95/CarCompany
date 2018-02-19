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

import carCompany.dataAcess.entities.AssignmentEntity;
import carCompany.service.AssignmentService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AssignmentRestServiceTest {

	@Autowired
	private AssignmentService assignmentService;

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
	public void shouldReadAssignmentById() throws Exception {
		// given:
		long id = 6;
		AssignmentEntity assignment = assignmentService.getAssignment(id);

		// when
		ResultActions response = this.mockMvc.perform(get("/rest/assignment/find/" + id));

		// then
		response.andExpect(status().isOk())//
				.andExpect(jsonPath(".id").value((int) assignment.getId()));

	}

	@Test
	@Transactional
	public void shouldReadAssignmentByEmployeesPesel() throws Exception {
		// given:
		long pesel = 72020500216L;
		List<AssignmentEntity> assignments = assignmentService.getByEmployeesPesel(pesel);

		// when
		ResultActions response = this.mockMvc.perform(get("/rest/assignment/find/byPesel/" + pesel));

		// then
		response.andExpect(status().isOk())//
				.andExpect(jsonPath("[0].pesel").value((long) assignments.get(0).getEmployee().getPesel()))
				.andExpect(jsonPath("[1].pesel").value((long) assignments.get(1).getEmployee().getPesel()));

	}

	@Test
	@Transactional
	public void shouldReadAssignmentByCarId() throws Exception {
		// given:
		long carId = 1;
		List<AssignmentEntity> assignments = assignmentService.getByCarId(carId);

		// when
		ResultActions response = this.mockMvc.perform(get("/rest/assignment/find/byCarId/" + carId));

		// then
		response.andExpect(status().isOk())//
				.andExpect(jsonPath(".carId").value((int) assignments.get(0).getCar().getId()));

	}

	@Test
	@Transactional
	public void shouldReadAssignmentByDateOfAssignment() throws Exception {
		// given:
		@SuppressWarnings("deprecation")
		Date dateOfAssignment = new Date(100, 2, 3);
		List<AssignmentEntity> assignments = assignmentService.getByStartOfAssignment(dateOfAssignment);

		// when
		ResultActions response = this.mockMvc
				.perform(get("/rest/assignment/find/byStartOfAssignment/" + dateOfAssignment));

		// then
		response.andExpect(status().isOk())//
				.andExpect(jsonPath(".dateOfAssignment")
						.value((String) assignments.get(0).getStartOfAssignment().toString()));

	}

	@Test
	@Transactional
	public void shouldReadAllAssignments() throws Exception {
		// given:
		List<AssignmentEntity> assignments = assignmentService.getAll();

		// when
		ResultActions response = this.mockMvc.perform(get("/rest/assignment/getAll/"));

		// then
		response.andExpect(status().isOk())//
				.andExpect(jsonPath("[0].id").value((int) assignments.get(0).getId()))
				.andExpect(jsonPath("[1].id").value((int) assignments.get(1).getId()))
				.andExpect(jsonPath("[2].id").value((int) assignments.get(2).getId()))
				.andExpect(jsonPath("[3].id").value((int) assignments.get(3).getId()))
				.andExpect(jsonPath("[4].id").value((int) assignments.get(4).getId()))
				.andExpect(jsonPath("[5].id").value((int) assignments.get(5).getId()))
				.andExpect(jsonPath("[6].id").value((int) assignments.get(6).getId()));

	}

}
