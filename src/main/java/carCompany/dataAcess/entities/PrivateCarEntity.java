package carCompany.dataAcess.entities;

import java.io.Serializable;

import javax.persistence.FetchType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import carCompany.constans.BrandEnum;

@Entity
@Table(name = "privatecar")
public class PrivateCarEntity implements Serializable {

	private static final long serialVersionUID = -2590219530360537793L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	@Column(name = "BRAND")
	private BrandEnum brand;

	@Column(name = "CAPACITY", nullable = false)
	private int capacity;

	@Column(name = "MILEAGE", nullable = false)
	private int mileage;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPLOYEE", nullable = false)
	private EmployeeEntity employee;

	public PrivateCarEntity() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BrandEnum getBrand() {
		return brand;
	}

	public void setBrand(BrandEnum brand) {
		this.brand = brand;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

}
