package hotel_transilvania;

import java.util.List;

import javax.swing.JComboBox;

import base_de_datos.habitacion_db;

public class habitacion {
	
	private String num_habitacion;
	private boolean disponibilidad;
	private String tipo;
	private int piso;
	private habitacion_db habitacion_db;
	private double tarifa_noche;
	
	public habitacion(String num_habitacion, boolean disponibilidad, String tipo, int piso) {
		super();
		this.num_habitacion = num_habitacion;
		this.disponibilidad = disponibilidad;
		this.tipo = tipo;
		this.piso = piso;
		this.habitacion_db = new habitacion_db(); 
	}
	
	public habitacion(String num_habitacion, boolean disponibilidad, double tarifa_noche, String tipo) {
		super();
		this.num_habitacion = num_habitacion;
		this.disponibilidad = disponibilidad;
		this.tarifa_noche = tarifa_noche;
		this.tipo = tipo;
	}
	
	public habitacion() {
		super();
		this.habitacion_db = new habitacion_db();
	}
	public String getNum_habitacion() {
		return num_habitacion;
	}
	public void setNum_habitacion(String num_habitacion) {
		this.num_habitacion = num_habitacion;
	}
	public boolean isDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public String gettipo() {
		return tipo;
	}
	public void settipo(String tipo) {
		this.tipo = tipo;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	
	public double getTarifa_noche() {
		return tarifa_noche;
	}

	public void setTarifa_noche(double tarifa_noche) {
		this.tarifa_noche = tarifa_noche;
	}

	public String toString() {
		
		return "Habitacion "+ this.getNum_habitacion()+" ("+this.gettipo()+")";
	}
	
    public JComboBox<habitacion> desplegarHabitacionesDisp(JComboBox<habitacion> cbxHabitacionesDisp) {
    	
    	cbxHabitacionesDisp.removeAllItems();
    	List<habitacion> habitacionesDisp = habitacion_db.obtenerHabitacionesDisp();
    	
    	for (habitacion habitacion : habitacionesDisp) {
    		cbxHabitacionesDisp.addItem(habitacion);
    	}
    	
    	System.out.println(cbxHabitacionesDisp);
    	return cbxHabitacionesDisp;
    	
    }
    
    public double calcularPrecioNoches(List<habitacion> habitaciones, int noches) {
    	
    	double sum_tarifas = 0;
    	
    	for(habitacion hab : habitaciones) {
    		double tar = hab.getTarifa_noche();
    		sum_tarifas += tar;
    		
    	}
    	
    	double total = sum_tarifas * noches;
    	return total;
    	
    }
    
    
	
	
}
