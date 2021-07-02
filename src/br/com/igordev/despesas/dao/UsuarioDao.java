package br.com.igordev.despesas.dao;

import br.com.igordev.despesas.modelo.Usuario;

public interface UsuarioDao {

	boolean existeUsuario(Usuario usuario);
	
}
