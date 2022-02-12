package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		getConnection();
		post();
		get();
		

	}
	
	
	
	public static void post() throws Exception
	{
		try
		{
			final String v1="VARANAMAYIRAM";
			final String v2="SURYA";
			final String v3="THAMANNA";
			final String v4="2002";
			final String v5="SHAJI KAILAS";
			Connection con=getConnection();
			PreparedStatement posted=con.prepareStatement("INSERT INTO movies(m_name,m_actor,m_actress,m_release,m_director)VALUES('"+v1+"','"+v2+"','"+v3+"','"+v4+"','"+v5+"')");
			posted.executeUpdate();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			System.out.println("Insert completed");
		}
	}
	
	
	public static ArrayList<String> get() throws Exception {
		try {
			Connection con=getConnection();
			PreparedStatement statement=con.prepareStatement("SELECT * FROM movies");
			
			ResultSet result=statement.executeQuery();
			
			ArrayList<String> array=new ArrayList<>();
			while(result.next()) {
				System.out.println(result.getString("m_name"));
				System.out.println(" ");
				System.out.println(result.getString("m_actor"));
				System.out.println(" ");
				System.out.println(result.getString("m_actress"));
				System.out.println(" ");
				System.out.println(result.getString("m_release"));
				System.out.println(" ");
				System.out.println(result.getString("m_director"));
				
				array.add(result.getString("m_director"));
			}
			System.out.println("All records have been selected");
			return array;
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public static Connection getConnection() throws Exception{
		
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/muledb";
			String username="root";
			String password="Vishnu@99";
			Class.forName(driver);
			
			Connection conn=DriverManager.getConnection(url,username,password);
			System.out.println("Connected");
			return conn;
		} catch(Exception e) {
			
			System.out.println(e);
		}
		
		
		return null;
	
	}
}
