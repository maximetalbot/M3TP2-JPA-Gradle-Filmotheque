package fr.eni.jpa.dao;

import java.util.List;

import fr.eni.jpa.bean.Style;

public class StyleDAOImpl extends DAOImpl<Style> implements StyleDAO {
	@Override
	public Style findById(int id) {
		return DAOUtil.getEntityManager().find(Style.class, id);
	}

	@Override
	public List<Style> findAll() {
		String req = "select Object(s) from Style s";
		return DAOUtil.getEntityManager().createQuery(req, Style.class).getResultList();
	}

}