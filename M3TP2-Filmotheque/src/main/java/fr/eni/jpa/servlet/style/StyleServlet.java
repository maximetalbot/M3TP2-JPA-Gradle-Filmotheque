package fr.eni.jpa.servlet.style;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jpa.bean.Style;
import fr.eni.jpa.service.GestionStyle;

/**
 * Servlet implementation class StyleServlet
 */
@WebServlet(urlPatterns = {"/ajouterStyle", "/listerStyle", "/modifStyle", "/supprimerStyle"})
public class StyleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println(path);
		if(path.equals("/supprimerStyle")) {
			supprimer(request);
		}
		lister(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println(path);
		
		if(path.equals("/ajouterStyle")) {
			ajouter(request);
		}else {
			//modifier
			modifier(request);
		}
		
		lister(request, response);
	}
	
	private void lister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionStyle gs = new GestionStyle();
		List<Style> listeS = gs.listeStyles();
		request.setAttribute("listeS", listeS);
		request.setAttribute("style",new Style());
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/listeStyles.jsp");
		rd.forward(request, response);
	}
	
	private void ajouter(HttpServletRequest request) {
		String libelle = request.getParameter("libelle");
		Style s = new Style(libelle);
		GestionStyle gs = new GestionStyle();
		try {
			gs.ajoutStyle(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void modifier(HttpServletRequest request) {
		String libelle = request.getParameter("libelle");
		GestionStyle gs = new GestionStyle();
		Style s =gs.trouverStyle(Integer.parseInt(request.getParameter("id")));
		s.setLibelle(libelle);
		try {
			gs.modifierStyle(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void supprimer(HttpServletRequest request) {
		GestionStyle gs = new GestionStyle();
		try {
			gs.supprimerStyle(Integer.parseInt(request.getParameter("index")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}