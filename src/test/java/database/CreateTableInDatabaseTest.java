package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class CreateTableInDatabaseTest {
	@Test
	public void creatingTable() throws SQLException {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/zoho_crm","root@%","root");
		
		Statement stat = conn.createStatement();
		
//		stat.executeUpdate("create database zoho_crm");
		
//		int resultset = stat.executeUpdate("create table DAVSTUDENT(student_id int, student_name varchar(100),emailid varchar(75), Total_Marks int)");
//		System.out.println("table created in zoho_crm database");
		int resultset = stat.executeUpdate("insert into DAVSTUDENT values(1210,'Rashmi','rashmi@gmail.com',558)");
//		 stat.executeUpdate("insert into DAVSTUDENT values('1020','Jully',jully@gmail.com','570')");
//		 stat.executeUpdate("insert into DAVSTUDENT values('1021','Subrat',subrat@gmail.com','576')");
		System.out.println(resultset);

}
}
