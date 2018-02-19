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

import carCompany.service.AssignmentService;
import carCompany.service.exception.UnknownObjectRequestException;
import carCompany.service.mapper.AssignmentMapper;
import carCompany.service.to.AssignmentTO;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/rest/assignment")
public class AssignmentRestService {

	private AssignmentService assignmentService;

	@Autowired
	public AssignmentRestService(AssignmentService assignmentService) {
		this.assignmentService = assignmentService;
	}

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	@ResponseBody
	public AssignmentTO readAssignment(@PathVariable long id) throws UnknownObjectRequestException {

		return AssignmentMapper.map(assignmentService.getAssignment(id));
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	public List<AssignmentTO> getAllAssignments() throws UnknownObjectRequestException {

		return AssignmentMapper.map2TOs(assignmentService.getAll());
	}

	@RequestMapping(value = "/find/byPesel/{pesel}", method = RequestMethod.GET)
	@ResponseBody
	public List<AssignmentTO> readAssignmentByPesel(@PathVariable long pesel) throws UnknownObjectRequestException {

		return AssignmentMapper.map2TOs(assignmentService.getByEmployeesPesel(pesel));
	}

	@RequestMapping(value = "/find/byCarId/{carId}", method = RequestMethod.GET)
	@ResponseBody
	public List<AssignmentTO> readAssignmentByCarId(@PathVariable long carId) throws UnknownObjectRequestException {

		return AssignmentMapper.map2TOs(assignmentService.getByCarId(carId));
	}

	@RequestMapping(value = "/find/byStartOfAssignment/{startOfAssignment}", method = RequestMethod.GET)
	@ResponseBody
	public List<AssignmentTO> readAssignmentByDateOfAssignment(@PathVariable Date startOfAssignment)
			throws UnknownObjectRequestException {

		return AssignmentMapper.map2TOs(assignmentService.getByStartOfAssignment(startOfAssignment));
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public AssignmentTO createAssignment(@RequestBody AssignmentTO assignmentTo) {
		return AssignmentMapper.map(assignmentService.addAssignment(AssignmentMapper.map(assignmentTo)));

	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@ResponseBody
	public AssignmentTO updateAssignment(@RequestBody AssignmentTO assignmentTo) {
		return AssignmentMapper.map(assignmentService.updateAssignment(AssignmentMapper.map(assignmentTo)));

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public void deleteAssignment(@PathVariable Long id) {
		assignmentService.deleteAssignment(id);
	}

}
