package HotelManagementSystem;

import java.sql.*;

public class conn {
	public Connection c;
	public Statement s;

	public conn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL Driver
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "hotel_user", "password");
			s = c.createStatement();
			System.out.println("Connected successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
