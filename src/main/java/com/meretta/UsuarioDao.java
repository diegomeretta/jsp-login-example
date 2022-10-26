package com.meretta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

	public List<Usuario> obtenerUsuarios(){
		List<Usuario> lista = new ArrayList<Usuario>();
		Connection connection = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mariadb://localhost:3308/datos?user=root&password=pass");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setEmail(rs.getString("email"));
				usuario.setPass(rs.getString("contrasenia"));
				lista.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public Usuario obtenerUsuario(String email){
		Usuario usuario = null;
		Connection connection = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mariadb://localhost:3308/datos?user=root&password=pass");
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM usuario WHERE email = ? ");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setEmail(rs.getString("email"));
				usuario.setPass(rs.getString("contrasenia"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return usuario;
	}
}
