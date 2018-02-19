package carCompany.dataAcess.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeEntity implements Serializable {

	private static final long serialVersionUID = -2590219530360537793L;

	@Id
	@Column(name = "PESEL", nullable = false)
	private long pesel;

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "SECONDNAME")
	private String secondName;

	@Column(name = "DATEOFBIRTH")
	private Date dateOfBirth;

	@Column(name = "DATEOFEMPLOYMENT")
	private Date dateOfEmployment;

	@OneToMany(targetEntity = AssignmentEntity.class, mappedBy = "employee", cascade = CascadeType.ALL)
	private Set<AssignmentEntity> assignments = new HashSet<AssignmentEntity>();

	@OneToMany(targetEntity = PrivateCarEntity.class, mappedBy = "employee", cascade = CascadeType.ALL)
	private Set<PrivateCarEntity> cars = new HashSet<PrivateCarEntity>();

	////// hibernate ////
	public EmployeeEntity() {

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

	public long getPesel() {
		return pesel;
	}

	public void setPesel(long pesel) {
		this.pesel = pesel;
	}

	public Date getDateOfEmployment() {
		return dateOfEmployment;
	}

	public void setDateOfEmployment(Date dateOfEmployment) {
		this.dateOfEmployment = dateOfEmployment;
	}

}
