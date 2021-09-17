package fr.eni.jpa.bean;

import javax.persistence.*;

@Entity
@Table(name = "PERSONNES")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Personne {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	@Column(name="NOM", nullable=false,length=50)
	private String nom;
	@Column(name="PRENOM", nullable=false,length=50)
	private String prenom;

	public Personne() {
	}

	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public Personne(int id, String nom, String prenom) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	// toString
	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	// Equals et Hashcode sont utilisés par les services pour des validations entre objets
	// particulièrement par java quand on utilise Set&Map. Préconisé.
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
