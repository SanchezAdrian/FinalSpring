package example.model;

import java.util.List;

import org.springframework.lang.NonNull;

public class EtapaModel {
	
	@NonNull
	private int netapa;
	
	@NonNull 
	private int km;
	
	@NonNull
	private String salida;
	
	@NonNull
	private String llegada;
	
	@NonNull 
	private CiclistaModel dorsal;
	
	private List<PuertoModel> puertos;
	
	private List<LlevarModel> llevars;
	
	public EtapaModel() {}

	public EtapaModel(int netapa, int km, String salida, String llegada, CiclistaModel dorsal,
			List<PuertoModel> puertos, List<LlevarModel> llevars) {
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

	public CiclistaModel getDorsal() {
		return dorsal;
	}

	public void setDorsal(CiclistaModel dorsal) {
		this.dorsal = dorsal;
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
 