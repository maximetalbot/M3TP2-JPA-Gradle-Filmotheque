package fr.eni.jpa.dao;

import java.util.List;

import fr.eni.jpa.bean.Style;

public interface StyleDAO extends IDAO<Style> {
	public Style findById(int id);
	public List<Style> findAll();
 }
