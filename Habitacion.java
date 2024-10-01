
public class Habitacion {
	
	private boolean disponibilidad;
	private int num_camas;
	private int piso;
	private int num_hab;
	public Habitacion(boolean disponibilidad, int num_camas, int piso, int num_hab) {
		super();
		this.disponibilidad = disponibilidad;
		this.num_camas = num_camas;
		this.piso = piso;
		this.num_hab = num_hab;
	}
	public boolean isDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public int getNum_camas() {
		return num_camas;
	}
	public void setNum_camas(int num_camas) {
		this.num_camas = num_camas;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	public int getNum_hab() {
		return num_hab;
	}
	public void setNum_hab(int num_hab) {
		this.num_hab = num_hab;
	}
	
	

}
