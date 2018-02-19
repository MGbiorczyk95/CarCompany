package carCompany.service.to;

import carCompany.constans.BrandEnum;

public class PrivateCarTO {

	public PrivateCarTO() {

	}

	private long id;
	private BrandEnum brand;
	private int capacity;
	private int mileage;
	private long pesel;

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

	public long getPesel() {
		return pesel;
	}

	public void setPesel(long pesel) {
		this.pesel = pesel;
	}

	public PrivateCarTO(long id, BrandEnum brand, int capacity, int mileage, long pesel) {
		super();
		this.id = id;
		this.brand = brand;
		this.capacity = capacity;
		this.mileage = mileage;
		this.pesel = pesel;
	}

}
