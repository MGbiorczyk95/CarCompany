package carCompany.service.to;

import java.sql.Date;

public class AssignmentTO {
	public AssignmentTO() {

	}

	private long id;
	private Date dateOfAssignment;
	private long pesel;
	private long carId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateOfAssignment() {
		return dateOfAssignment;
	}

	public void setDateOfAssignment(Date dateOfAssignment) {
		this.dateOfAssignment = dateOfAssignment;
	}

	public long getPesel() {
		return pesel;
	}

	public void setPesel(long pesel) {
		this.pesel = pesel;
	}

	public long getCarId() {
		return carId;
	}

	public void setCarId(long carId) {
		this.carId = carId;
	}

	public AssignmentTO(long id, Date dateOfAssignment, long pesel, long carId) {
		super();
		this.id = id;
		this.dateOfAssignment = dateOfAssignment;
		this.pesel = pesel;
		this.carId = carId;
	}

}
