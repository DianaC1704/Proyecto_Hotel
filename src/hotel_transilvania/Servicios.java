package hotel_transilvania;

public class Servicios {
	
	public String nom_servicio;
	public double precio;
	public String descripcion;
	
	public Servicios(String nom_servicio, double precio, String descripcion) {
		super();
		this.nom_servicio = nom_servicio;
		this.precio = precio;
		this.descripcion = descripcion;
	}
	public String getNom_servicio() {
		return nom_servicio;
	}
	public void setNom_servicio(String nom_servicio) {
		this.nom_servicio = nom_servicio;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
