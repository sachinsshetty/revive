package slabs.tech.avti.echarging;

public class CoOrdinate {
	
	public CoOrdinate(double latitudeX, double latitudeY) {
		super();
		this.setLatitudeX(latitudeX);
		this.latitudeY = latitudeY;
	}
	private double latitudeX;
	private double latitudeY;
	public double getLatitudeY() {
		return latitudeY;
	}
	public void setLatitudeY(double latitudeY) {
		this.latitudeY = latitudeY;
	}
	public double getLatitudeX() {
		return latitudeX;
	}
	public void setLatitudeX(double latitudeX) {
		this.latitudeX = latitudeX;
	}

}
