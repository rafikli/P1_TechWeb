package mvc.controller;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import mvc.model.*;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class ListaController {
	@RequestMapping("")
  	public String homeController(HttpSession session,Alunos duvida) {		  
	  return "Duvidas";
	 }
	@RequestMapping("/cria")
  	public String criaController(HttpSession session,Alunos duvida) {		  
	  return "Default";
	 }
	@RequestMapping("addDuvida")
	public String addPostController(HttpSession session, String nome, String duvida) throws ClassNotFoundException, SQLException {
  		
		DAO dao;
		
		dao = new DAO();

Alunos aluno = new Alunos();

aluno.setNome(nome);
	aluno.setDuvida(duvida);
	
	dao.adiciona(aluno);
	dao.close();
	return "Duvidas";
}
	@RequestMapping("removeDuvida")
  	public String removeController(HttpSession session,int id) throws ClassNotFoundException, SQLException {		  
		DAO dao;
		
		dao = new DAO();
		dao.remove(id);
		dao.close();
		return "Duvidas";
	 }
	@RequestMapping("editaDuvida")
  	public String editaController(HttpSession session,String nome, String duvida,int id) {		  
		session.setAttribute("nome", nome);
		session.setAttribute("duvida", duvida);
		session.setAttribute("id", id);
		
		return "Atualiza";
	 }
	@RequestMapping("atualizaDuvida")
  	public String atualizaController(HttpSession session,String nome, String duvida,String id) throws ClassNotFoundException, SQLException {		  
		DAO dao;
		
		dao = new DAO();
		Alunos aluno = new Alunos();
		aluno.setId(Integer.valueOf(id));
		aluno.setNome(nome);
		aluno.setDuvida(duvida);		
		dao.altera(aluno);
		return "Duvidas";
	
	}
}

//	    @RequestMapping("/DelPostController")
//	    public String delPostController(HttpSession session, Post post) {
//
//	    	
//	      User user = (User) session.getAttribute("user");
//	      post.setUserId(user.getId());
//	      String orderBy = (String) session.getAttribute("orderBy");
//
//	      DAO dao = new DAO();
//	      dao.delPost(post);
//	      session.setAttribute("posts", dao.getListPosts(user, orderBy));
//
//	      return "main";
//	    }
//
//	    @RequestMapping("/EditPostController")
//	    public String editPostController(HttpSession session, Post post) {
//	    
//	    	
//	      User user = (User) session.getAttribute("user");
//	      post.setUserId(user.getId());
//	      String orderBy = (String) session.getAttribute("orderBy");
//
//	      DAO dao = new DAO();
//	      dao.editPost(post);
//	      session.setAttribute("posts", dao.getListPosts(user, orderBy));
//
//	      return "main";
//	    }
//	
//	
//}
