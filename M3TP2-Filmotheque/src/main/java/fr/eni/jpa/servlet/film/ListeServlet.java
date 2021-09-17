package fr.eni.jpa.servlet.film;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jpa.bean.Film;
import fr.eni.jpa.service.GestionFilm;

/**
 * Servlet implementation class AjouterServlet
 */
@WebServlet(urlPatterns = { "/lister", "/supprimer", "/afficher" })
public class ListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println(path);

		switch (path) {
		case "/supprimer":
			supprimer(request);
		case "/lister" : 
			listerFilms(request, response);
			break;
		default:
			//afficher
			afficherFilm(request, response);
			break;
		}
	}

	private void supprimer(HttpServletRequest request) {
		try {
			GestionFilm gs = new GestionFilm();
			gs.supprimerFilm(Integer.parseInt(request.getParameter("index").substring(1)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void listerFilms(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionFilm gf = new GestionFilm();
		List<Film> l = gf.listeFilms();
		if (l == null) {
			l = new ArrayList<Film>();
		}
		request.setAttribute("listeF", l);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/listeFilms.jsp");
		rd.forward(request, response);
	}
	
	private void afficherFilm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("index"));
			GestionFilm gf = new GestionFilm();
			Film f = gf.trouverFilm(id);
			request.setAttribute("film", f);
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/afficherFilm.jsp");
		rd.forward(request, response);
	}
	
}
