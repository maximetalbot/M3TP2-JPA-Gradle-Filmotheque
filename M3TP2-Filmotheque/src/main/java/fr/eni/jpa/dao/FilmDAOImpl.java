package fr.eni.jpa.dao;

import java.util.List;

import fr.eni.jpa.bean.Film;

public class FilmDAOImpl extends DAOImpl<Film> implements FilmDAO {

	@Override
	public Film findById(int id) {
		return DAOUtil.getEntityManager().find(Film.class, id);
	}

	@Override
	public List<Film> findAll() {
		String req = "select Object(f) from Film f";
		return DAOUtil.getEntityManager().createQuery(req, Film.class).getResultList();
	}

}
