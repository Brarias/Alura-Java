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

import com.alura.jdbc.dao.ProductoDAO;
import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.modelo.Producto;

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

	public void guardar(Producto producto) throws SQLException {
		ProductoDAO productoDAO = new ProductoDAO(new ConnectionFactory().recuperaConexion());
		
		productoDAO.guardar(producto);
	}

	

}
