package fr.eni.jpa.bean;

import javax.persistence.*;

@Entity
@Table(name = "REALISATEURS")
public class Realisateur extends Personne {

	// Constructors
	public Realisateur() {
		super();
	}

	public Realisateur(int id, String nom, String prenom) {
		super(id, nom, prenom);
	}

	public Realisateur(String nom, String prenom) {
		super(nom, prenom);
	}
}
