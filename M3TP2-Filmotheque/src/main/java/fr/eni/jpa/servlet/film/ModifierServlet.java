package fr.eni.jpa.servlet.film;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jpa.bean.Film;
import fr.eni.jpa.bean.Style;
import fr.eni.jpa.service.GestionFilm;
import fr.eni.jpa.service.GestionStyle;

/**
 * Servlet implementation class AjouterServlet
 */
@WebServlet("/editer")
public class ModifierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionStyle gs = new GestionStyle();
		request.setAttribute("listeStyles", gs.listeStyles());
		GestionFilm gf = new GestionFilm();
		Film f = gf.trouverFilm(Integer.parseInt(request.getParameter("index").substring(1)));
		request.setAttribute("film", f);
		
		request.getRequestDispatcher("/WEB-INF/editerFilm.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			GestionStyle gs = new GestionStyle();
			Style s = gs.trouverStyle(Integer.parseInt(request.getParameter("style")));
			
			GestionFilm gf = new GestionFilm();
			int index = Integer.parseInt(request.getParameter("id"));
			Film f = gf.trouverFilm(index);
			f.setTitre(request.getParameter("titre"));
			f.setAnnee(Integer.parseInt(request.getParameter("annee")));
			f.setStyle(s);		
			f.setDuree(request.getParameter("duree"));
			f.setVu(Boolean.parseBoolean(request.getParameter("vu")));
			f.setSynopsis(request.getParameter("synopsis"));
			gf.modifierFilm(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("lister");
	}

}
