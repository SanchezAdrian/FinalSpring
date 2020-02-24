package example.model;


import java.util.List;

import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

public class MaillotModel {
	
	@NonNull
	@Size(min=3,max=3)
	private String codigo;
	
	@NonNull
	private String tipo;
	
	@NonNull
	private String color;
	
	@NonNull
	private int premio;
	
	private List<LlevarModel> llevars;

	public MaillotModel() {}

	public MaillotModel(@Size(min = 3, max = 3) String codigo, String tipo, String color, int premio,
			List<LlevarModel> llevars) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.color = color;
		this.premio = premio;
		this.llevars = llevars;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPremio() {
		return premio;
	}

	public void setPremio(int premio) {
		this.premio = premio;
	}

	public List<LlevarModel> getLlevars() {
		return llevars;
	}

	public void setLlevars(List<LlevarModel> llevars) {
		this.llevars = llevars;
	}
	
	


	

}
