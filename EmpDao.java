package servletcurdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Connection con;
		//Class.forName("com.mysql.cj.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");

		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dmart","root","root");
		if(con != null)
		{
			System.out.println("Connection created");
		}
		else
		{
			System.out.println("Connection not created");
		}
		return con;
	}
	
	public static int save(Emp e)
	{

		int st=0;
		try
		{
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("insert into employee1234(name,password,email,country) values(?,?,?,?)");
		ps.setInt(1, e.getId());
		ps.setString(2, e.getName());
		ps.setString(2, e.getPassword());
		ps.setString(3, e.getEmail());
		ps.setString(4, e.getCountry());
		st = ps.executeUpdate();
		con.close();
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		return st;
	}


	public static List<Emp> getAllEmployee()
	{
		List<Emp> list = new ArrayList<>();
		try
		{
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from employee1234");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				list.add(new Emp(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			}
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public static Emp getEmployee(int id)
	{
		Emp e=null;
		try
		{
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from employee123 where id = ?");
			System.out.println("hello");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while(rs.next())
			{
			e = new Emp(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
			con.close();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return e;
	}
	public static int update(Emp e)
	{
		int st=0;
		try
		{
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("update employee1234 set name=?,password=?,email=?,country=? where id=?");
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getCountry());
			ps.setInt(5, e.getId());
			st = ps.executeUpdate();
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		return st;
	}
	public static int delete(int id)
	{
		int st = 0;
		try
		{
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("delete from employee1234 where id =?");
			ps.setInt(1, id);

			st = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return st;
	}
}
