package carCompany.dataAcess.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import carCompany.constans.BrandEnum;
import carCompany.constans.TypeOfPropertyEnum;

@Entity
@Table(name = "car")
public class CarEntity implements Serializable {
	private static final long serialVersionUID = -2590219530360537793L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	@Column(name = "BRAND", nullable = false)
	private BrandEnum brand;

	@Column(name = "CAPACITY", nullable = false)
	private int capacity;

	@Column(name = "MILEAGE", nullable = false)
	private int mileage;

	@Column(name = "TYPEOFPROPERTY", nullable = false)
	private TypeOfPropertyEnum typeOfProperty;

	@OneToMany(targetEntity = AssignmentEntity.class, mappedBy = "car", cascade = CascadeType.ALL)
	private Set<AssignmentEntity> assignments = new HashSet<AssignmentEntity>();

	public CarEntity() {
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

	public TypeOfPropertyEnum getTypeOfProperty() {
		return typeOfProperty;
	}

	public void setTypeOfProperty(TypeOfPropertyEnum typeOfProperty) {
		this.typeOfProperty = typeOfProperty;
	}

}
