package br.com.igordev.despesas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.igordev.despesas.dao.JdbcUsuarioDao;
import br.com.igordev.despesas.dao.UsuarioDao;
import br.com.igordev.despesas.modelo.Usuario;

@Controller
public class LoginController {
	
	
	@Autowired
	@Qualifier("jpaUsuarioDao")
	private UsuarioDao dao;
	
//	@Autowired
//	public LoginController(JdbcUsuarioDao dao) {
//		this.dao = dao;
//	}

	@RequestMapping("loginForm")
	public String loginForm() {
		return "formulario-login";
	}
		
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {
		if (dao.existeUsuario(usuario)) {
			session.setAttribute("usuarioLogado", usuario);
			return "menu"; //WEB-INF/view/menu.jsp
		}
		return "redirect:loginForm";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginForm";
	}	
	
}
