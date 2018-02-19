package carCompany.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import carCompany.dataAcess.entities.AssignmentEntity;
import carCompany.service.AssignmentService;
import carCompany.service.exception.UnknownObjectRequestException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AssignmentServiceTest {

	@Autowired
	private AssignmentService assignmentService;

	@Test
	@Transactional
	public void shouldGetAssignmentById() throws UnknownObjectRequestException {

		// given
		long id = 1;
		// when
		AssignmentEntity assignment = assignmentService.getAssignment(id);

		// then
		assertTrue(assignment != null);
		assertEquals(assignment.getId(), id);
	}

	@Test
	@Transactional
	public void shouldGetAssignmentByEmployeesPesel() throws UnknownObjectRequestException {

		// given
		long pesel = 68042503389L;
		// when
		List<AssignmentEntity> assignments = assignmentService.getByEmployeesPesel(pesel);

		// then
		assertTrue(assignments != null);
		assertEquals(assignments.get(0).getEmployee().getPesel(), pesel);
	}

	@Test
	@Transactional
	public void shouldGetAssignmentByCarId() throws UnknownObjectRequestException {

		// given
		long carId = 3;
		// when
		List<AssignmentEntity> assignments = assignmentService.getByCarId(carId);

		// then
		assertTrue(assignments != null);
		assertEquals(assignments.get(0).getCar().getId(), carId);
	}

	@Test
	@Transactional
	public void shouldGetAssignmentByStartOfAssignment() throws UnknownObjectRequestException {

		// given
		@SuppressWarnings("deprecation")
		Date startOfAssignment = new Date(100, 2, 3);
		// when
		List<AssignmentEntity> assignments = assignmentService.getByStartOfAssignment(startOfAssignment);

		// then
		assertTrue(assignments != null);
		assertEquals(assignments.get(0).getStartOfAssignment(), startOfAssignment);
	}
}
