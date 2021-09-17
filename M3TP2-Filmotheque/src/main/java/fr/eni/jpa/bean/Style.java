package fr.eni.jpa.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "STYLES")
public class Style {

	// Variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="LIBELLE", nullable=false,length=50)
	private String libelle;
	
	public Style() {
	}

	public Style(String libelle) {
		this.libelle = libelle;
	}

	public Style(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Style [id=" + id + ", libelle=" + libelle + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
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
		Style other = (Style) obj;
		if (id != other.id)
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	}
		
}
