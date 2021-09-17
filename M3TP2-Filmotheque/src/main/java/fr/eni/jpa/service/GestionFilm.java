package fr.eni.jpa.service;

import java.util.List;

import fr.eni.jpa.bean.Film;
import fr.eni.jpa.dao.FilmDAO;
import fr.eni.jpa.dao.FilmDAOImpl;

/**
 * Couche BLL sans vérification ni gestion des exception
 * 
 * -- Peu intéressante -- passe plat
 *
 */
public class GestionFilm {
	private FilmDAO dao;

	public GestionFilm() {
		dao = new FilmDAOImpl();
	}

	public List<Film> listeFilms() {
		return dao.findAll();
	}

	public Film trouverFilm(int id) {
		return dao.findById(id);
	}

	public void ajoutFilm(Film f) throws Exception {
		dao.add(f);
	}

	public void modifierFilm(Film f) throws Exception {
		dao.update(f);
	}

	public void supprimerFilm(int id) throws Exception {
		dao.delete(trouverFilm(id));
	}
}
