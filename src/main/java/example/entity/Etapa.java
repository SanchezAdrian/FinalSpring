package example.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "etapa")

public class Etapa {
	
	@Id
	@Column(name="netapa")
	private int netapa;
	
	@Column(name="km")
	private int km;
	
	@Column(name="salida")
	private String salida;
	
	@Column(name="llegada")
	private String llegada;
	
	@ManyToOne
	@JoinColumn(name="dorsal")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Ciclista dorsal;
	
	@OneToMany(mappedBy="netapa", cascade=CascadeType.REMOVE)
	private List<Puerto> puertos;
	
	@OneToMany(mappedBy="netapa", cascade=CascadeType.REMOVE)
	private List<Llevar> llevars;
	
	public Etapa() {
		
	}

	public Etapa(int netapa, int km, String salida, String llegada, Ciclista dorsal, List<Puerto> puertos,
			List<Llevar> llevars) {
		super();
		this.netapa = netapa;
		this.km = km;
		this.salida = salida;
		this.llegada = llegada;
		this.dorsal = dorsal;
		this.puertos = puertos;
		this.llevars = llevars;
	}

	public int getNetapa() {
		return netapa;
	}

	public void setNetapa(int netapa) {
		this.netapa = netapa;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public String getSalida() {
		return salida;
	}

	public void setSalida(String salida) {
		this.salida = salida;
	}

	public String getLlegada() {
		return llegada;
	}

	public void setLlegada(String llegada) {
		this.llegada = llegada;
	}

	public Ciclista getDorsal() {
		return dorsal;
	}

	public void setDorsal(Ciclista dorsal) {
		this.dorsal = dorsal;
	}

	public List<Puerto> getPuertos() {
		return puertos;
	}

	public void setPuertos(List<Puerto> puertos) {
		this.puertos = puertos;
	}

	public List<Llevar> getLlevars() {
		return llevars;
	}

	public void setLlevars(List<Llevar> llevars) {
		this.llevars = llevars;
	}
	
	
	
	
	

}
