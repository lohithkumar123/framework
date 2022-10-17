package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Sample4 {

	public static void main(String[] args) throws SQLException 
	{
		Driver driverref= new Driver();
		DriverManager.registerDriver(driverref);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_yantra", "root", "root");
		Statement stat = con.createStatement();
		String query = "insert into Student(first_name,last_name,address)values('ram','pp','india')";
		String query1="delete from student where id='5'";
		int result = stat.executeUpdate(query);
		int result1=stat.executeUpdate(query1);
		
		if(result==1&&result1==1)
		{
			System.out.println("user is created");
		}
		else
		{
			System.out.println("user is not created");
		}
		con.close();
	}

}
