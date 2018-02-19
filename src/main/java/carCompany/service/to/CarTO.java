package carCompany.service.to;

import carCompany.constans.BrandEnum;
import carCompany.constans.TypeOfPropertyEnum;

public class CarTO {

	public CarTO() {

	}

	private long id;
	private BrandEnum brand;
	private int capacity;
	private int mileage;
	private TypeOfPropertyEnum typeOfProperty;

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

	public CarTO(long id, BrandEnum brand, int capacity, int mileage, TypeOfPropertyEnum typeOfProperty) {
		super();
		this.id = id;
		this.brand = brand;
		this.capacity = capacity;
		this.mileage = mileage;
		this.typeOfProperty = typeOfProperty;
	}

}
