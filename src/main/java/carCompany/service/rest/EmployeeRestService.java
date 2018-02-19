package carCompany.service.rest;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import carCompany.service.EmployeeService;
import carCompany.service.exception.UnknownObjectRequestException;
import carCompany.service.mapper.EmployeeMapper;
import carCompany.service.to.EmployeeTO;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/rest/employee")
public class EmployeeRestService {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping(value = "/find/{pesel}", method = RequestMethod.GET)
	@ResponseBody
	public EmployeeTO readEmployee(@PathVariable long pesel) throws UnknownObjectRequestException {

		return EmployeeMapper.map(employeeService.getEmploye(pesel));
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeTO> getAllEmployees() throws UnknownObjectRequestException {

		return EmployeeMapper.map2TOs(employeeService.getAll());
	}

	@RequestMapping(value = "/find/byFirstName/{firstName}", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeTO> readEmployeesByFirstName(@PathVariable String firstName)
			throws UnknownObjectRequestException {

		return EmployeeMapper.map2TOs(employeeService.getByFirstName(firstName));
	}

	@RequestMapping(value = "/find/bySecondName/{secondName}", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeTO> readEmployeesBySecondName(@PathVariable String secondName)
			throws UnknownObjectRequestException {

		return EmployeeMapper.map2TOs(employeeService.getBySecondName(secondName));
	}

	@RequestMapping(value = "/find/byDateOfBirth/{dateOfBirth}", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeTO> readEmployeesByDateOfBirth(@PathVariable Date dateOfBirth)
			throws UnknownObjectRequestException {

		return EmployeeMapper.map2TOs(employeeService.getByDateOfBirth(dateOfBirth));
	}

	@RequestMapping(value = "/find/byDateOfEmployment/{dateOfEmployment}", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeTO> readEmployeesByDateOfEmployment(@PathVariable Date dateOfEmployment)
			throws UnknownObjectRequestException {

		return EmployeeMapper.map2TOs(employeeService.getByDateOfEmployment(dateOfEmployment));
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public EmployeeTO createEmployee(@RequestBody EmployeeTO employeeTo) {
		return EmployeeMapper.map(employeeService.addEmployee(EmployeeMapper.map(employeeTo)));

	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@ResponseBody
	public EmployeeTO updateEmployee(@RequestBody EmployeeTO employeeTo) {
		return EmployeeMapper.map(employeeService.updateEmployee(EmployeeMapper.map(employeeTo)));

	}

	@RequestMapping(value = "/delete/{pesel}", method = RequestMethod.POST)
	@ResponseBody
	public void deleteEmployee(@PathVariable Long pesel) {
		employeeService.deleteEmployee(pesel);
	}

}
