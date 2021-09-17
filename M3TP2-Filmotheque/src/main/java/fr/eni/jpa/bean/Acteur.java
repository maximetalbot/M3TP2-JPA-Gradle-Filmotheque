package fr.eni.jpa.bean;
import javax.persistence.*;

@Entity
@Table(name = "ACTEURS")
public class Acteur extends Personne {

	// Constructors
	public Acteur() {
	}
	
	public Acteur(String nom, String prenom) {
		super(nom, prenom);
	}
	
	public Acteur(int id, String nom, String prenom) {
		super(id, nom, prenom);
	}	
}
