package slabs.tech.avti;

import slabs.tech.avti.vehicle.Driver;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Simulator for Autonomous Vehicle Tech Infrasture (AVTI)");
		
		long driverId = 1;
		String driverName = "DriverName";
		
		Driver driver = new Driver(driverId, driverName);
		
		System.out.println(driver);
		

	}

}
