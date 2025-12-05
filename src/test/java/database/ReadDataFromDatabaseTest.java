package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabaseTest {
	
	@Test
	public void readingDataFromDatabase() throws SQLException {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm","root@%","root");
		
		Statement stat = conn.createStatement();
		
		ResultSet resultset = stat.executeQuery("select * from project");
		while(resultset.next()) {
		
		 resultset.getString(2);
		System.out.println( resultset.getString(1)+"\t" +resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4)+"\t"+resultset.getString(5)+"\t"+resultset.getInt(6));

		}
		
		
		
		conn.close();
	}

}
