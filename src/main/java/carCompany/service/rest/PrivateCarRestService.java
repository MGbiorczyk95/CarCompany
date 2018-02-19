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
import carCompany.service.PrivateCarService;
import carCompany.service.exception.UnknownObjectRequestException;
import carCompany.service.mapper.PrivateCarMapper;
import carCompany.service.to.PrivateCarTO;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/rest/privatecar")
public class PrivateCarRestService {

	private PrivateCarService privateCarService;

	@Autowired
	public PrivateCarRestService(PrivateCarService privateCarService) {
		this.privateCarService = privateCarService;
	}

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	@ResponseBody
	public PrivateCarTO readPrivateCar(@PathVariable long id) throws UnknownObjectRequestException {

		return PrivateCarMapper.map(privateCarService.getPrivateCar(id));
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	public List<PrivateCarTO> getAllPrivateCars() throws UnknownObjectRequestException {

		return PrivateCarMapper.map2TOs(privateCarService.getAll());
	}

	@RequestMapping(value = "/find/byBrand/{brand}", method = RequestMethod.GET)
	@ResponseBody
	public List<PrivateCarTO> readPrivateCarsByBrand(@PathVariable BrandEnum brand)
			throws UnknownObjectRequestException {

		return PrivateCarMapper.map2TOs(privateCarService.getByBrand(brand));
	}

	@RequestMapping(value = "/find/byCapacity/{capacity}", method = RequestMethod.GET)
	@ResponseBody
	public List<PrivateCarTO> readPrivateCarsByCapacity(@PathVariable int capacity)
			throws UnknownObjectRequestException {

		return PrivateCarMapper.map2TOs(privateCarService.getByCapacity(capacity));
	}

	@RequestMapping(value = "/find/byMileage/{mileage}", method = RequestMethod.GET)
	@ResponseBody
	public List<PrivateCarTO> readPrivateCarsByMileage(@PathVariable int mileage) throws UnknownObjectRequestException {

		return PrivateCarMapper.map2TOs(privateCarService.getByMileage(mileage));
	}

	@RequestMapping(value = "/find/byOwner/{pesel}", method = RequestMethod.GET)
	@ResponseBody
	public List<PrivateCarTO> readPrivateCarsByOwner(@PathVariable long pesel) throws UnknownObjectRequestException {

		return PrivateCarMapper.map2TOs(privateCarService.getByEmployeesPesel(pesel));
	}

	@RequestMapping(value = "/create", method = RequestMethod.PUT)
	@ResponseBody
	public PrivateCarTO createPrivateCar(@RequestBody PrivateCarTO privateCarTo) {
		return PrivateCarMapper.map(privateCarService.addPrivateCar(PrivateCarMapper.map(privateCarTo)));

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public PrivateCarTO updatePrivateCar(@RequestBody PrivateCarTO privateCarTo) {
		return PrivateCarMapper.map(privateCarService.updatePrivateCar(PrivateCarMapper.map(privateCarTo)));

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public void deleteEmployee(@PathVariable Long id) {
		privateCarService.deletePrivateCar(id);
	}

}
