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

import carCompany.dataAcess.entities.EmployeeEntity;
import carCompany.service.EmployeeService;
import carCompany.service.exception.UnknownObjectRequestException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

	@Autowired
	private EmployeeService employeeService;

	@Test
	@Transactional
	public void shouldGetEmployeeByPesel() throws UnknownObjectRequestException {
		// given
		long pesel = 68042503389L;

		// when
		EmployeeEntity employee = employeeService.getEmploye(pesel);

		// then
		assertTrue(employee != null);
		assertEquals(employee.getPesel(), pesel);

	}

	@Test
	@Transactional
	public void shouldGetEmployeeByFirstName() throws UnknownObjectRequestException {
		// given
		String firstName = "Marcin";

		// when
		List<EmployeeEntity> employees = employeeService.getByFirstName(firstName);

		// then
		assertTrue(employees != null);
		assertEquals(employees.get(0).getFirstName(), firstName);

	}

	@Test
	@Transactional
	public void shouldGetEmployeeBySecondName() throws UnknownObjectRequestException {
		// given
		String secondName = "Stasik";

		// when
		List<EmployeeEntity> employees = employeeService.getBySecondName(secondName);

		// then
		assertTrue(employees != null);
		assertEquals(employees.get(0).getSecondName(), secondName);

	}

	@Test
	@Transactional
	public void shouldGetEmployeeByDateOfBirth() throws UnknownObjectRequestException {
		// given
		@SuppressWarnings("deprecation")
		Date dateOfBirth = new Date(75, 5, 15);

		// when
		List<EmployeeEntity> employees = employeeService.getByDateOfBirth(dateOfBirth);

		// then
		assertTrue(employees != null);
		assertEquals(employees.get(0).getDateOfBirth(), dateOfBirth);

	}

	@Test
	@Transactional
	public void shouldGetEmployeeByDateOfEmployment() throws UnknownObjectRequestException {
		// given
		@SuppressWarnings("deprecation")
		Date dateOfEmployment = new Date(101, 3, 5);

		// when
		List<EmployeeEntity> employees = employeeService.getByDateOfEmployment(dateOfEmployment);

		// then
		assertTrue(employees != null);
		assertEquals(employees.get(0).getDateOfEmployment(), dateOfEmployment);

	}

}
