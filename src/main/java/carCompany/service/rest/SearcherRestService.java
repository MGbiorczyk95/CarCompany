package carCompany.service.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import carCompany.service.SearcherService;
import carCompany.service.mapper.CarMapper;
import carCompany.service.mapper.EmployeeMapper;
import carCompany.service.to.CarTO;
import carCompany.service.to.EmployeeTO;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/rest/search")
public class SearcherRestService {

	private SearcherService searcherService;

	@Autowired
	public SearcherRestService(SearcherService searcherService) {
		this.searcherService = searcherService;
	}

	@RequestMapping(value = "/employeesUsedCar/{carId}", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeTO> searchEmployeesUsedCar(@PathVariable long carId) {

		return EmployeeMapper.map2TOs(searcherService.searchEmployeesUsedCar(carId));
	}

	@RequestMapping(value = "/carsUsedInCompanyByNumberOfDrivers/{numberOfDrivers}", method = RequestMethod.GET)
	@ResponseBody
	public List<CarTO> searchCarsUsedInCompanyByNumberOfDrivers(@PathVariable int numberOfDrivers) {

		return CarMapper.map2TOs(searcherService.searchCarsUsedInCompanyByMoreThanNumberOfDrivers(numberOfDrivers));
	}
}
