package fr.eni.jpa.dao;

import java.util.List;

import fr.eni.jpa.bean.Film;

public interface FilmDAO extends IDAO<Film> {
	public Film findById(int id);

	public List<Film> findAll();

}
