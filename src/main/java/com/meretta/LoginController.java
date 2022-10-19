package com.meretta;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class LoginController {

	public static boolean validate(UsuarioDto usuarioDto) {
		Boolean resultado = false;
		UsuarioDao usuarioDao = new UsuarioDao();
		List<Usuario> obtenerUsuarios = usuarioDao.obtenerUsuarios();
		for (Usuario usuario : obtenerUsuarios) {
			if (usuario.getEmail().equalsIgnoreCase(usuarioDto.getEmail())) {
				if (usuario.getPass().equalsIgnoreCase(usuarioDto.getPass())) {
					resultado = true;
				}
			}
		}
		return resultado;
	}
	
	public static String md5(String password) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(password.getBytes());
		byte[] digest = md.digest();
		return digest.toString();
	}

}
