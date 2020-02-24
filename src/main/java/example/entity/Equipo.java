package example.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "equipo")

public class Equipo {
	
	@Id
	@Column(name="nomeq")
	private String nomeq;
	
	@Column(name="director")
	private String director;
	
	@Column(name="logo")
	private String logo;
	
	@OneToMany(mappedBy="nomeq", cascade=CascadeType.REMOVE)
	private List<Ciclista> ciclistas;
	
	
public Equipo() {}
	
	

	public Equipo(String nomeq, String director, String logo, List<Ciclista> ciclistas) {
	super();
	this.nomeq = nomeq;
	this.director = director;
	this.logo = logo;
	this.ciclistas = ciclistas;
}



	public String getNomeq() {
		return nomeq;
	}

	public void setNomeq(String nomeq) {
		this.nomeq = nomeq;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public List<Ciclista> getCiclistas() {
		return ciclistas;
	}

	public void setCiclistas(List<Ciclista> ciclistas) {
		this.ciclistas = ciclistas;
	}
	
	
}
