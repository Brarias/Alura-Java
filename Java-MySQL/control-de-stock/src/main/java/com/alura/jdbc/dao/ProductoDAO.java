package com.alura.jdbc.dao;

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
import com.alura.jdbc.modelo.Producto;

public class ProductoDAO {

	final private Connection con;

	public ProductoDAO(Connection con) {
		this.con = con;
	}

	public void guardar(Producto producto) {

		try (con) {
			final PreparedStatement statement = con.prepareStatement(
					"INSERT INTO PRODUCTO(nombre, descripcion, cantidad)" + "VALUES(?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			try (statement) {
				ejecutaRegistro(producto, statement);

			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	private void ejecutaRegistro(Producto producto, PreparedStatement statement) throws SQLException {

		statement.setString(1, producto.getNombre());
		statement.setString(2, producto.getDescripcion());
		statement.setInt(3, producto.getCantidad());

		statement.execute();

		final ResultSet resultSet = statement.getGeneratedKeys();

		try (resultSet) {
			while (resultSet.next()) {
				producto.setId(resultSet.getInt(1));
				System.out.println(String.format("Fue insertado el producto de ID: %s", producto.toString()));

			}
		}
	}

	public List<Producto> listar() {
		List<Producto> resultado = new ArrayList<>();
		final Connection con = new ConnectionFactory().recuperaConexion();

		try (con) {
			final PreparedStatement statement = con
					.prepareStatement("SELECT ID, NOMBRE, DESCRIPCION, CANTIDAD FROM PRODUCTO");

			try (statement) {
				statement.execute();

				ResultSet resulSet = statement.getResultSet();

				try (resulSet) {
					while (resulSet.next()) {

						Producto fila = new Producto(resulSet.getInt("ID"),resulSet.getString("NOMBRE"), 
								resulSet.getString("DESCRIPCION"), resulSet.getInt("CANTIDAD"));
						
						resultado.add(fila);
					}
				}
			}
			return resultado;
		} catch (

		SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
