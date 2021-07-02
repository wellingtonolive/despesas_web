package br.com.igordev.despesas.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.igordev.despesas.dao.DespesaDao;
import br.com.igordev.despesas.modelo.Despesa;

@Transactional
@Controller
public class DespesasController {
	
	@Autowired
	@Qualifier("jpaDespesaDao") //JpaDespesaDao jpaDespesaDao = new JpaDespesaDao();
	private DespesaDao dao;	
	
	@RequestMapping("novaDespesa")
	public String form() {
		return "despesa/formulario"; // -> WEB-INF/views/despesa/formulario.jsp
	}
	
	@RequestMapping("adicionaDespesa") //action do form -> action="adicionaDespesa"
	public String adiciona(@Valid Despesa despesa, BindingResult result) { //SPRING: despesa = new Despesa()
		//<form><input name="descricao"></form>
		//SPRING: despesa.setDescricao("<texto do text area>");
		
		if (result.hasErrors()) {
			return "despesa/formulario";
		}
		
		//JdbcDespesaDao dao = new JdbcDespesaDao();
		dao.adiciona(despesa);
		return "redirect:listaDespesas";// -> WEB-INF/views/despesa/adicionada.jsp
	}
	
	@RequestMapping("listaDespesas")
	public String lista(Model model) {
		//JdbcDespesaDao dao = new JdbcDespesaDao();
		List<Despesa> despesas = dao.lista();
		model.addAttribute("despesas", despesas);
		return "despesa/lista";
	}	
	
	//1 - removeDespesa
	//2 - listaDespesas
	
	@RequestMapping("removeDespesa")
	public String remove(Despesa despesa) {
		//JdbcDespesaDao dao = new JdbcDespesaDao();
		dao.remove(despesa);
		return "redirect:listaDespesas"; //cliente
	}
	
	@RequestMapping("mostraDespesa")
	public String mostra(Long id, Model model) {
		//JdbcDespesaDao dao = new JdbcDespesaDao();
		model.addAttribute("despesa", dao.buscaPorId(id));
		return "despesa/mostra"; // WEB-INF/views/despesa/mostra.jsp
	}

	@RequestMapping("alteraDespesa")
	public String altera(Despesa despesa) {
		//JdbcDespesaDao dao = new JdbcDespesaDao();
		dao.altera(despesa);
		return "redirect:listaDespesas";
	}	
	
	@RequestMapping("quitarDespesa")
	public String quitarDespesa(Long id, Model model) {
		//JdbcDespesaDao dao = new JdbcDespesaDao();
		dao.quita(id);
		model.addAttribute("despesa", dao.buscaPorId(id));
		return "despesa/quitada"; //linha para se alterada na tabela
	}	
	
}
