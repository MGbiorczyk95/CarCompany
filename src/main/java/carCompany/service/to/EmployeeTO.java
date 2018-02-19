package carCompany.service.to;

import java.sql.Date;

public class EmployeeTO {

	public EmployeeTO() {

	}

	private long pesel;
	private String firstName;
	private String secondName;
	private Date dateOfBirth;
	private Date dateOfEmployment;

	public long getPesel() {
		return pesel;
	}

	public void setPesel(long pesel) {
		this.pesel = pesel;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfEmployment() {
		return dateOfEmployment;
	}

	public void setDateOfEmployment(Date dateOfEmployment) {
		this.dateOfEmployment = dateOfEmployment;
	}

	public EmployeeTO(long pesel, String firstName, String secondName, Date dateOfBirth, Date dateOfEmployment) {
		super();
		this.pesel = pesel;
		this.firstName = firstName;
		this.secondName = secondName;
		this.dateOfBirth = dateOfBirth;
		this.dateOfEmployment = dateOfEmployment;
	}

}
