package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;
import com.mysql.jdbc.Driver;

public class SelectQuery 
{
	public static void main(String[] args) throws Throwable 
	{
Connection con=null;
try
{
	Driver driverref=new Driver();
	DriverManager.registerDriver(driverref);
	con= DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
	System.out.println("Connection is done");
	Statement stat = con.createStatement();
	String query = "Select * From Project";
	ResultSet resultset = stat.executeQuery(query);
	while (resultset.next())
	{
		System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4));
	}
}
catch (Exception e)
{
}
finally
{
	con.close();
	System.out.println("*************** END DB CONNECTION *****************");
}
}
}