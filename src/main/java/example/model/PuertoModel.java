package example.model;

import org.springframework.lang.NonNull;

public class PuertoModel {
	
	@NonNull
	private String nompuerto;
	
	@NonNull
	private int altura;
	
	@NonNull
	private String categoria;
	
	@NonNull
	private int pendiente;
	
	@NonNull 
	private EtapaModel netapa;
	
	@NonNull
	private CiclistaModel dorsal;
	
	public PuertoModel() {}

	public PuertoModel(String nompuerto, int altura, String categoria, int pendiente, EtapaModel netapa,
			CiclistaModel dorsal) {
		super();
		this.nompuerto = nompuerto;
		this.altura = altura;
		this.categoria = categoria;
		this.pendiente = pendiente;
		this.netapa = netapa;
		this.dorsal = dorsal;
	}

	public String getNompuerto() {
		return nompuerto;
	}

	public void setNompuerto(String nompuerto) {
		this.nompuerto = nompuerto;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getPendiente() {
		return pendiente;
	}

	public void setPendiente(int pendiente) {
		this.pendiente = pendiente;
	}

	public EtapaModel getNetapa() {
		return netapa;
	}

	public void setNetapa(EtapaModel netapa) {
		this.netapa = netapa;
	}

	public CiclistaModel getDorsal() {
		return dorsal;
	}

	public void setDorsal(CiclistaModel dorsal) {
		this.dorsal = dorsal;
	}
	
	

	
}
