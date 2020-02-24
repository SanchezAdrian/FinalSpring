package example.model;

import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

public class LlevarModel {
	
	@NonNull
	private int id;
	
	@NonNull
	private CiclistaModel dorsal;
	
	@NonNull
	private EtapaModel netapa;
	
	@NonNull
	@Size(min=3,max=3)
	private MaillotModel codigo;
	
	
	public LlevarModel() {}


	public LlevarModel(int id, CiclistaModel dorsal, EtapaModel netapa, @Size(min = 3, max = 3) MaillotModel codigo) {
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


	public CiclistaModel getDorsal() {
		return dorsal;
	}


	public void setDorsal(CiclistaModel dorsal) {
		this.dorsal = dorsal;
	}


	public EtapaModel getNetapa() {
		return netapa;
	}


	public void setNetapa(EtapaModel netapa) {
		this.netapa = netapa;
	}


	public MaillotModel getCodigo() {
		return codigo;
	}


	public void setCodigo(MaillotModel codigo) {
		this.codigo = codigo;
	}
	
	
	
	



}
