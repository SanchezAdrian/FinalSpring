package example.model;

import java.util.List;

import org.springframework.lang.NonNull;

public class EquipoModel {
	
	@NonNull
	private String nomeq;
	
	@NonNull
	private String director;
	
	private String logo;
	
	public EquipoModel() {}

	private List<CiclistaModel> ciclistas;

	public EquipoModel(String nomeq, String director, String logo, List<CiclistaModel> ciclistas) {
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

	public List<CiclistaModel> getCiclistas() {
		return ciclistas;
	}

	public void setCiclistas(List<CiclistaModel> ciclistas) {
		this.ciclistas = ciclistas;
	}
	
	
	
	
	

}
