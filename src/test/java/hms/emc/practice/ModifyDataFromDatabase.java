package hms.emc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ModifyDataFromDatabase 
{

	public static void main(String[] args) throws SQLException 
	{
		//step1--create instance for Driver--> register driver to jdbc
		Driver dbDriver = new Driver();
		DriverManager.registerDriver(dbDriver);

		Connection connection = null;
		try {
			//step2--get connection-->dburl, un, pwd
			jdbc:mysql://localhost:3306/sdet46
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet46", "root", "root");
			//step3--create statement
			Statement statement = connection.createStatement();
			//step4--execute query
			int result = statement.executeUpdate("insert into employee values (1003, 'Raam', 25000, 362581479, 'Tumkur'); ");
			//step5--iterate data and verify or fetch
			if(result==1)
			{
				System.out.println("Data is added successfully");
			}
			
		}
		finally
		{
			//step6--close connection
			connection.close();
			System.out.println("connection closed");
		}
	}
}

