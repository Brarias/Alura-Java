package com.alura.jdbc.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection recuperaConexion() throws SQLException {
		  Connection con = DriverManager.getConnection(
	                "jdbc:mysql://localhost/control_de_stock?useTimeZone=true&serverTimeZone=UTC",
	                "root",
	                "1234");
		  return con;
	}
	
}
