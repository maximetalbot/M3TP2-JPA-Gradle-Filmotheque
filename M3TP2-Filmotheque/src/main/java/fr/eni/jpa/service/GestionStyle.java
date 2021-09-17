package fr.eni.jpa.service;

import java.util.List;

import fr.eni.jpa.bean.Style;
import fr.eni.jpa.dao.StyleDAO;
import fr.eni.jpa.dao.StyleDAOImpl;

public class GestionStyle {
	private StyleDAO dao;
	
	public GestionStyle() {
		dao = new StyleDAOImpl();
	}
	
	public List<Style> listeStyles(){
		return dao.findAll();
	}
	
	public Style trouverStyle(int id) {
		return dao.findById(id);
	}
	
	public void ajoutStyle(Style s) throws Exception{
		//Gestion de vérification du libelle du style
		if(s.getLibelle() != null && !s.getLibelle().trim().isEmpty()) {
			dao.add(s);
		}else {
			throw new Exception("Veuillez vérifier votre libelle");
		}
	}
	
	public void modifierStyle(Style s) throws Exception{
		dao.update(s);
	}
	
	public void supprimerStyle(int id) throws Exception{
		dao.delete(trouverStyle(id));
	}
}
