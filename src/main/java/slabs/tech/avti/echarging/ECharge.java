package slabs.tech.avti.echarging;

public class ECharge {
	
	public ECharge(Location location, PowerProvider powerProvider) {
		super();
		this.location = location;
		this.powerProvider = powerProvider;
	}

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
