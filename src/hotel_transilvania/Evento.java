package hotel_transilvania;

public class Evento {
	private String titulo;
	private String descripcion;
	private String nom_organizador;
	private int cant_personas;
	private boolean prioridad;
	
	public Evento() {
		super();
	}
	public Evento(String titulo, String descripcion, String nom_organizador, int cant_personas, boolean prioridad) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.nom_organizador = nom_organizador;
		this.cant_personas = cant_personas;
		this.prioridad = prioridad;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNom_organizador() {
		return nom_organizador;
	}
	public void setNom_organizador(String nom_organizador) {
		this.nom_organizador = nom_organizador;
	}
	public int getCant_personas() {
		return cant_personas;
	}
	public void setCant_personas(int cant_personas) {
		this.cant_personas = cant_personas;
	}
	public boolean isPrioridad() {
		return prioridad;
	}
	public void setPrioridad(boolean prioridad) {
		this.prioridad = prioridad;
	}
	
}
