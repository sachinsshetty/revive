package slabs.tech.avti.vehicle;

import slabs.tech.avti.vehicle.driver.Driver;

public class Vehicle {
	
	private Driver driver;
	private Battery battery;
	private Autonomy autonomy;
	
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public Battery getBattery() {
		return battery;
	}
	public void setBattery(Battery battery) {
		this.battery = battery;
	}
	public Vehicle(Driver driver, Battery battery, Autonomy autonomy) {
		super();
		this.driver = driver;
		this.battery = battery;
		this.autonomy = autonomy;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public Autonomy getAutonomy() {
		return autonomy;
	}
	public void setAutonomy(Autonomy autonomy) {
		this.autonomy = autonomy;
	}

}
