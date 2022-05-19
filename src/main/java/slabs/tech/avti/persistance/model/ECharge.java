package slabs.tech.avti.persistance.model;

public class ECharge {

	private long id;
	private Location location;
	private PowerProvider powerProvider;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public PowerProvider getPowerProvider() {
		return powerProvider;
	}

	public void setPowerProvider(PowerProvider powerProvider) {
		this.powerProvider = powerProvider;
	}

}
