package slabs.tech.avti.echarging;

import java.util.List;

public class Location {
	public Location(List<Stall> stalls, CoOrdinate coordinate) {
		super();
		this.stalls = stalls;
		this.coordinate = coordinate;
	}

	private List<Stall> stalls;
	private CoOrdinate coordinate;

	public CoOrdinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(CoOrdinate coordinate) {
		this.coordinate = coordinate;
	}

	public List<Stall> getStalls() {
		return stalls;
	}

	public void setStalls(List<Stall> stalls) {
		this.stalls = stalls;
	}

}
