package fr.eni.jpa.dao;

import javax.persistence.*;

public class DAOUtil {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	// Dès le chargement de cette class, ce bloc static sera executé
	static {
		emf = Persistence.createEntityManagerFactory("Mysql_UP");
		em = emf.createEntityManager();
	}
	
	
	public static EntityManager getEntityManager(){
		return em;
	}
	
	public static void close(){
		
		// Si EntityManager (et factory) pas nul et ouvert: à fermer.
		if(em != null && em.isOpen()) {
			em.close();
		}
		
		if(emf != null && emf.isOpen()) {
			emf.close();
		}
	}
}