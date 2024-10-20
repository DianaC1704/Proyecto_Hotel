package hotel_transilvania;

public class habitacion {
	private int num_habitacion;
	private boolean disponibilidad;
	private int camas;
	private int piso;
	public habitacion(int num_habitacion, boolean disponibilidad, int camas, int piso) {
		super();
		this.num_habitacion = num_habitacion;
		this.disponibilidad = disponibilidad;
		this.camas = camas;
		this.piso = piso;
	}
	public habitacion() {
		super();
	}
	public int getNum_habitacion() {
		return num_habitacion;
	}
	public void setNum_habitacion(int num_habitacion) {
		this.num_habitacion = num_habitacion;
	}
	public boolean isDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public int getCamas() {
		return camas;
	}
	public void setCamas(int camas) {
		this.camas = camas;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	
	
}
