package slabs.tech.avti;

import slabs.tech.avti.vehicle.Autonomy;
import slabs.tech.avti.vehicle.Battery;
import slabs.tech.avti.vehicle.Driver;
import slabs.tech.avti.vehicle.Vehicle;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Simulator for Autonomous Vehicle Tech Infrasture (AVTI)");
		
		long driverId = 1;
		String driverName = "DriverName";
		
		Driver driver = new Driver(driverId, driverName);
		
		Battery battery = new Battery();
		
		Autonomy autonomy = new Autonomy();
		
		Vehicle vehicle = new Vehicle(driver, battery, autonomy);

		
		System.out.println(vehicle);
	}

}
