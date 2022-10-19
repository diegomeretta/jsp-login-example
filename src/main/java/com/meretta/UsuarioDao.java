package com.meretta;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

	public List<Usuario> obtenerUsuarios(){
		List<Usuario> lista = new ArrayList<Usuario>();
		Usuario usuario1 = new Usuario();
		usuario1.setEmail("diego@gmail.com");
		usuario1.setPass("diego");
		lista.add(usuario1);
		Usuario usuario2 = new Usuario();
		usuario2.setEmail("diego2@gmail.com");
		usuario2.setPass("diego2");
		lista.add(usuario2);
		return lista;
	}
	
}
