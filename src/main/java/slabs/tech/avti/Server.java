package slabs.tech.avti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import slabs.tech.avti.vehicle.Autonomy;
import slabs.tech.avti.vehicle.Battery;
import slabs.tech.avti.vehicle.Driver;
import slabs.tech.avti.vehicle.Vehicle;

public class Server {


	private final String url = "jdbc:postgresql://localhost/avti";
	private final String user = "postgres";
	private final String password = "postgres";
	
	public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
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
		
		Server server = new Server();
		server.connect();
		
		
		
	}

}
