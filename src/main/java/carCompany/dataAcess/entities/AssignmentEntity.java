package carCompany.dataAcess.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "assignment")
public class AssignmentEntity implements Serializable {

	private static final long serialVersionUID = -2590219530360537793L;
	@SuppressWarnings("unused")
	private static final int weeksForAssign = 2;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	@Column(name = "STARTOFASSIGNMENT", nullable = false)
	private Date startOfAssignment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPLOYEE", nullable = false)
	private EmployeeEntity employee;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CAR", nullable = false)
	private CarEntity car;

	public AssignmentEntity() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getStartOfAssignment() {
		return startOfAssignment;
	}

	public void setStartOfAssignment(Date startOfAssignment) {
		this.startOfAssignment = startOfAssignment;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

	public CarEntity getCar() {
		return car;
	}

	public void setCar(CarEntity car) {
		this.car = car;
	}

}
