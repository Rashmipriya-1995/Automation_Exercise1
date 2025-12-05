package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class UpdateDataIndatabaseTest {
	@Test
	public void updatingData() throws SQLException {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root@%", "root");
		
		Statement stat = conn.createStatement();
		
		
		int result = stat.executeUpdate("insert into project values('project_1996','Rashmi','06-08-2025','Zoho_CRM_01','Created','102')");
		System.out.println(result);
		conn.close();
	}
	

}
