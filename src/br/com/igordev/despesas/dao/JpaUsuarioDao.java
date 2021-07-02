package br.com.igordev.despesas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.igordev.despesas.modelo.Usuario;

@Repository
public class JpaUsuarioDao implements UsuarioDao {
	
	@PersistenceContext
	EntityManager manager;
	

	@Override
	public boolean existeUsuario(Usuario usuario) {
		String jpql = "select u from usuario u where u.login = :login and u.senha = :senha";
		List<Usuario> usuarios  =  manager.createQuery(jpql, Usuario.class)
				.setParameter("login", usuario.getLogin())
				.setParameter("senha", usuario.getSenha()).getResultList();
		
		return !usuarios.isEmpty();
	}

}
