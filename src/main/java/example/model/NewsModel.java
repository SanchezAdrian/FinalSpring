package example.model;



import org.springframework.lang.NonNull;

public class NewsModel {
	
	@NonNull
	private String nombre;
	
	@NonNull
	private int id;
	
	public NewsModel() {}

	public NewsModel( String nombre, int id) {
		super();
		this.nombre = nombre;
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int edad) {
		this.id = edad;
	}
	
	
}
