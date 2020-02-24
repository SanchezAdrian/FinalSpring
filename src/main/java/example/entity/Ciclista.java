package example.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "ciclista")
public class Ciclista {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="dorsal")
	private int dorsal;
	
	@Column(name="nombre", length=50 )
	private String nombre;
	
	@Column(name="foto")
	private String foto;
	
	@Column(name="edad")
	private int edad;
	
	@ManyToOne
	@JoinColumn(name="nomeq")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Equipo nomeq;
	
	@OneToMany(mappedBy="dorsal", cascade=CascadeType.REMOVE)
	private List<Etapa> etapas;
	
	@OneToMany(mappedBy="dorsal", cascade=CascadeType.REMOVE)
	private List<Puerto> puertos;
	
	@OneToMany(mappedBy="dorsal", cascade=CascadeType.REMOVE)
	private List<Llevar> llevars;
	

	
	public Ciclista(int dorsal, String nombre, String foto, int edad, Equipo nomeq, List<Etapa> etapas,
			List<Puerto> puertos, List<Llevar> llevars) {
		super();
		this.dorsal = dorsal;
		this.nombre = nombre;
		this.foto = foto;
		this.edad = edad;
		this.nomeq = nomeq;
		this.etapas = etapas;
		this.puertos = puertos;
		this.llevars = llevars;
	}

	public Ciclista() {
		
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Equipo getNomeq() {
		return nomeq;
	}

	public void setNomeq(Equipo nomeq) {
		this.nomeq = nomeq;
	}

	public List<Etapa> getEtapas() {
		return etapas;
	}

	public void setEtapas(List<Etapa> etapas) {
		this.etapas = etapas;
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
