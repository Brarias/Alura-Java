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

	public int modificar(String nombre, String descripcion, Integer cantidad, Integer id) throws SQLException {
		final Connection con = new ConnectionFactory().recuperaConexion();

		try (con) {
			final PreparedStatement statement = con.prepareStatement(
					"UPDATE PRODUCTO SET " + " NOMBRE =?" + ", DESCRIPCION =?" + ", CANTIDAD =?" + " WHERE ID =?");
			try (statement) {

				statement.setString(1, nombre);
				statement.setString(2, descripcion);
				statement.setInt(3, cantidad);
				statement.setInt(4, id);

				statement.execute();

				int updateCount = statement.getUpdateCount();

				return updateCount;
			}
		}
	}

	public int eliminar(Integer id) throws SQLException {
		final Connection con = new ConnectionFactory().recuperaConexion();

		try (con) {
			final PreparedStatement statement = con.prepareStatement("DELETE FROM PRODUCTO WHERE ID =?");

			try (statement) {
				statement.setInt(1, Integer.valueOf(id));

				statement.execute();

				return statement.getUpdateCount();
			}
		}
	}

	public List<Map<String, String>> listar() throws SQLException {
		final Connection con = new ConnectionFactory().recuperaConexion();

		try (con) {
			final PreparedStatement statement = con
					.prepareStatement("SELECT ID, NOMBRE, DESCRIPCION, CANTIDAD FROM PRODUCTO");

			try (statement) {
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
				return resultado;
			}

		}
	}

	public void guardar(Map<String, String> producto) throws SQLException {
		String nombre = producto.get("NOMBRE");
		String descripcion = producto.get("DESCRIPCION");
		Integer cantidad = Integer.valueOf(producto.get("CANTIDAD"));
		Integer maximoCantidad = 50;

		final Connection con = new ConnectionFactory().recuperaConexion();

		try (con) {
			con.setAutoCommit(false);
			final PreparedStatement statement = con.prepareStatement(
					"INSERT INTO PRODUCTO(nombre, descripcion, cantidad)" + "VALUES(?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			try (statement) {

				do {
					int cantidadParaGuardar = Math.min(cantidad, maximoCantidad);

					ejecutaRegistro(nombre, descripcion, cantidadParaGuardar, statement);

					cantidad -= maximoCantidad;
				} while (cantidad > 0);

				con.commit();

			} catch (Exception e) {
				con.rollback();

			}

		}
	}

	private void ejecutaRegistro(String nombre, String descripcion, Integer cantidad, PreparedStatement statement)
			throws SQLException {

		if (cantidad < 50) {
			throw new RuntimeException("Ocurrio un error");
		}

		statement.setString(1, nombre);
		statement.setString(2, descripcion);
		statement.setInt(3, cantidad);

		statement.execute();

		final ResultSet resultSet = statement.getGeneratedKeys();

		try (resultSet) {
			while (resultSet.next()) {
				System.out.println(String.format("Fue insertado el producto de ID: %d", resultSet.getInt(1)));

			}
		}
	}

}
