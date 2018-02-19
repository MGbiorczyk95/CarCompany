package carCompany;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import carCompany.service.AssignmentServiceTest;
import carCompany.service.CarServiceTest;
import carCompany.service.EmployeeServiceTest;
import carCompany.service.PrivateCarServiceTest;
import carCompany.service.SearcherServiceTest;
import carCompany.service.rest.AssignmentRestServiceTest;
import carCompany.service.rest.CarRestServiceTest;
import carCompany.service.rest.EmployeeRestServiceTest;
import carCompany.service.rest.PrivateCarRestServiceTest;
import carCompany.service.rest.SearcherRestServiceTest;

@RunWith(Suite.class)
@SuiteClasses({ AssignmentServiceTest.class, CarServiceTest.class, EmployeeServiceTest.class,
		PrivateCarServiceTest.class, SearcherServiceTest.class, AssignmentRestServiceTest.class,
		CarRestServiceTest.class, EmployeeRestServiceTest.class, PrivateCarRestServiceTest.class,
		SearcherRestServiceTest.class, })
public class AllTests {

}
