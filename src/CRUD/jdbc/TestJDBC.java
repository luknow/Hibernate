package CRUD.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
	
	//Sprawdzenie polaczenia z baza danych nie wykorzystujac Hibernate'a
	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://remotemysql.com:3306/HjkxAVYM5y";
		String user = "HjkxAVYM5y";
		String password = "ku0zLxnN5I";
		try{
			 Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
