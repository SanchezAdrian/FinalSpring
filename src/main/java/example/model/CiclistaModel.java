package example.model;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

public class CiclistaModel {
	
	@NonNull
	@Size(min=2,max=8)
	private String nombre;
	
	@NonNull
	@Min(18)
	private int edad;
	
	@NonNull
	private int dorsal;
	
	private String foto;
	
	@NonNull
	private EquipoModel nomeq;
	
	private List<EtapaModel> etapas;
	
	private List<PuertoModel> puertos;
	
	private List <LlevarModel> llevars;
	
	public CiclistaModel(@Size(min = 2, max = 8) String nombre, @Min(18) int edad, int dorsal, String foto, EquipoModel nomeq,List<EtapaModel> etapas, List<PuertoModel> puertos, List<LlevarModel> llevars) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.dorsal = dorsal;
		this.foto = foto;
		this.nomeq = nomeq;
		this.etapas = etapas;
		this.puertos = puertos;
		this.llevars = llevars;
	}

	public CiclistaModel() {}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public EquipoModel getNomeq() {
		return nomeq;
	}

	public void setNomeq(EquipoModel nomeq) {
		this.nomeq = nomeq;
	}

	public List<EtapaModel> getEtapas() {
		return etapas;
	}

	public void setEtapas(List<EtapaModel> etapas) {
		this.etapas = etapas;
	}

	public List<PuertoModel> getPuertos() {
		return puertos;
	}

	public void setPuertos(List<PuertoModel> puertos) {
		this.puertos = puertos;
	}

	public List<LlevarModel> getLlevars() {
		return llevars;
	}

	public void setLlevars(List<LlevarModel> llevars) {
		this.llevars = llevars;
	}


	
	
	
	
	
	
	
}
