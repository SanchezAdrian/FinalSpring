package example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="llevar")

public class Llevar {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="dorsal")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Ciclista dorsal;
	
	@ManyToOne
	@JoinColumn(name="netapa")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Etapa netapa;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codigo")
	@OnDelete(action=OnDeleteAction.NO_ACTION)
	private Maillot codigo;

	public Llevar() {
		
	}

	public Llevar(int id, Ciclista dorsal, Etapa netapa, Maillot codigo) {
		super();
		this.id = id;
		this.dorsal = dorsal;
		this.netapa = netapa;
		this.codigo = codigo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ciclista getDorsal() {
		return dorsal;
	}

	public void setDorsal(Ciclista dorsal) {
		this.dorsal = dorsal;
	}

	public Etapa getNetapa() {
		return netapa;
	}

	public void setNetapa(Etapa netapa) {
		this.netapa = netapa;
	}

	public Maillot getCodigo() {
		return codigo;
	}

	public void setCodigo(Maillot codigo) {
		this.codigo = codigo;
	}
	
}
