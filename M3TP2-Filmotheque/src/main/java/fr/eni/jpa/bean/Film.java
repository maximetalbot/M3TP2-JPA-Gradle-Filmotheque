package fr.eni.jpa.bean;
import java.io.Serializable;
import java.sql.Time;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "FILMS")
public class Film implements Serializable {

	// Colonnes de base
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "TITRE", nullable = false)
	private String titre;
	@Column(name = "ANNEE", nullable = false)
	private int annee;
	@Column(name = "DUREE", nullable = false)
	private String duree;
	@Column(name = "VU", nullable = false)
	private boolean vu;
	@Column(name = "SYNOPSIS", nullable = true)
	private String synopsis;
	
	// Associations
	@ManyToOne(cascade=CascadeType.ALL)
	private Style style;
	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST }, orphanRemoval=true)
	private Realisateur real;
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST }, orphanRemoval=true)
	private List<Acteur> acteurs;
	
	// Constructors
	public Film() {
	}

	public Film(String titre, int annee, Style style, Realisateur real, String duree, List<Acteur> acteurs,
			String synopsis, boolean vu) {
		super();
		this.titre = titre;
		this.annee = annee;
		this.style = style;
		this.real = real;
		this.duree = duree;
		this.acteurs = acteurs;
		this.synopsis = synopsis;
		this.vu = vu;
	}

	public Film(int id, String titre, int annee, Style style, Realisateur real, String duree, List<Acteur> acteurs,
			String synopsis, boolean vu) {
		super();
		this.id = id;
		this.titre = titre;
		this.annee = annee;
		this.style = style;
		this.real = real;
		this.duree = duree;
		this.acteurs = acteurs;
		this.synopsis = synopsis;
		this.vu = vu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public boolean isVu() {
		return vu;
	}

	public void setVu(boolean vu) {
		this.vu = vu;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public Realisateur getReal() {
		return real;
	}

	public void setReal(Realisateur real) {
		this.real = real;
	}

	public List<Acteur> getActeurs() {
		return acteurs;
	}

	public void setActeurs(List<Acteur> acteurs) {
		this.acteurs = acteurs;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", titre=" + titre + ", annee=" + annee + ", duree=" + duree + ", vu=" + vu
				+ ", synopsis=" + synopsis + ", style=" + style + ", realisateur=" + real + ", acteurs="
				+ acteurs + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
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
		Film other = (Film) obj;
		if (id != other.id)
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}
}
