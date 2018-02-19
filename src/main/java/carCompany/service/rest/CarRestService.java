package carCompany.service.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import carCompany.constans.BrandEnum;
import carCompany.constans.TypeOfPropertyEnum;
import carCompany.service.CarService;
import carCompany.service.exception.UnknownObjectRequestException;
import carCompany.service.mapper.CarMapper;
import carCompany.service.to.CarTO;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/rest/car")
public class CarRestService {

	private CarService carService;

	@Autowired
	public CarRestService(CarService carService) {
		this.carService = carService;
	}

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	@ResponseBody
	public CarTO readCar(@PathVariable long id) throws UnknownObjectRequestException {

		return CarMapper.map(carService.getCar(id));
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	public List<CarTO> getAllCars() throws UnknownObjectRequestException {

		return CarMapper.map2TOs(carService.getAll());
	}

	@RequestMapping(value = "/find/byBrand/{brand}", method = RequestMethod.GET)
	@ResponseBody
	public List<CarTO> readCarsByBrand(@PathVariable BrandEnum brand) throws UnknownObjectRequestException {

		return CarMapper.map2TOs(carService.getByBrand(brand));
	}

	@RequestMapping(value = "/find/byCapacity/{capacity}", method = RequestMethod.GET)
	@ResponseBody
	public List<CarTO> readCarsByCapacity(@PathVariable int capacity) throws UnknownObjectRequestException {

		return CarMapper.map2TOs(carService.getByCapacity(capacity));
	}

	@RequestMapping(value = "/find/byMileage/{mileage}", method = RequestMethod.GET)
	@ResponseBody
	public List<CarTO> readCarsByMileage(@PathVariable int mileage) throws UnknownObjectRequestException {

		return CarMapper.map2TOs(carService.getByMileage(mileage));
	}

	@RequestMapping(value = "/find/byTypeOfProperty/{typeOfProperty}", method = RequestMethod.GET)
	@ResponseBody
	public List<CarTO> readCarsByMileage(@PathVariable TypeOfPropertyEnum typeOfProperty)
			throws UnknownObjectRequestException {

		return CarMapper.map2TOs(carService.getByTypeOfProperty(typeOfProperty));
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public CarTO createCar(@RequestBody CarTO carTo) {
		return CarMapper.map(carService.addCar(CarMapper.map(carTo)));

	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@ResponseBody
	public CarTO updateCar(@RequestBody CarTO carTo) {
		return CarMapper.map(carService.updateCar(CarMapper.map(carTo)));

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public void deleteEmployee(@PathVariable Long id) {
		carService.deleteCar(id);
	}
}
