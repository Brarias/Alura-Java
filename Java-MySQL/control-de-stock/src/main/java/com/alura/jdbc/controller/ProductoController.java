package com.alura.jdbc.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alura.jdbc.factory.ConnectionFactory;

public class ProductoController {

	public void modificar(String nombre, String descripcion, Integer cantidad, Integer id) throws SQLException {
		Connection con = new ConnectionFactory().recuperaConexion();
		PreparedStatement statement = con.prepareStatement(
				"UPDATE PRODUCTO SET " + " NOMBRE =?" + ", DESCRIPCION =?" + ", CANTIDAD =?" + " WHERE ID =?");

		statement.setString(1, nombre);
		statement.setString(2, descripcion);
		statement.setInt(3, cantidad);
		statement.setInt(4, id);

		statement.execute();

		con.close();
	}

	public int eliminar(Integer id) throws SQLException {
		Connection con = new ConnectionFactory().recuperaConexion();
		PreparedStatement statement = con.prepareStatement("DELETE FROM PRODUCTO WHERE ID =?");
		statement.setInt(1, Integer.valueOf(id));

		statement.execute();

		return statement.getUpdateCount();
	}

	public List<Map<String, String>> listar() throws SQLException {
		Connection con = new ConnectionFactory().recuperaConexion();

		PreparedStatement statement = con.prepareStatement("SELECT ID, NOMBRE, DESCRIPCION, CANTIDAD FROM PRODUCTO");

		statement.execute();

		ResultSet resulSet = statement.getResultSet();

		List<Map<String, String>> resultado = new ArrayList<>();

		while (resulSet.next()) {

			Map<String, String> fila = new HashMap<>();
			fila.put("ID", String.valueOf(resulSet.getInt("ID")));
			fila.put("NOMBRE", resulSet.getString("NOMBRE"));
			fila.put("DESCRIPCION", resulSet.getString("DESCRIPCION"));
			fila.put("CANTIDAD", String.valueOf(resulSet.getInt("CANTIDAD")));

			resultado.add(fila);
		}

		con.close();

		return resultado;
	}

	public void guardar(Map<String, String> producto) throws SQLException {
		String nombre = producto.get("NOMBRE");
		String descripcion = producto.get("DESCRIPCION");
		Integer cantidad = Integer.valueOf(producto.get("CANTIDAD"));
		Integer maximoCantidad = 50;

		Connection con = new ConnectionFactory().recuperaConexion();
		con.setAutoCommit(false);
		PreparedStatement statement = con.prepareStatement(
				"INSERT INTO PRODUCTO(nombre, descripcion, cantidad)" + "VALUES(?, ?, ?)",
				Statement.RETURN_GENERATED_KEYS);

		do {
			int cantidadParaGuardar = Math.min(cantidad, maximoCantidad);

			ejecutaRegistro(nombre, descripcion, cantidadParaGuardar, statement);

			cantidad -= maximoCantidad;
		} while (cantidad > 0);
	}

	private void ejecutaRegistro(String nombre, String descripcion, Integer cantidad, PreparedStatement statement)
			throws SQLException {
		
		statement.setString(1, nombre);
		statement.setString(2, descripcion);
		statement.setInt(3, cantidad);

		statement.execute();

		ResultSet resultSet = statement.getGeneratedKeys();

		while (resultSet.next()) {
			System.out.println(String.format("Fue insertado el producto de ID: %d", resultSet.getInt(1)));

		}
	}

}
