package hotel_transilvania_factura;

import hotel_transilvania_persona.persona;

public class Pago extends persona{
	public double sub_total;
	public String metodo;
	public double tarifa_noche;
	public double tarifa_evento;
	public Pago(String nombre, String apellido, int ci, int num_celular, double sub_total, String metodo,
			double tarifa_noche, double tarifa_evento) {
		super(nombre, apellido, ci, num_celular);
		this.sub_total = sub_total;
		this.metodo = metodo;
		this.tarifa_noche = tarifa_noche;
		this.tarifa_evento = tarifa_evento;
	}
	public Pago(String nombre, String apellido, int ci, int num_celular) {
		super(nombre, apellido, ci, num_celular);
	}
	public double getSub_total() {
		return sub_total;
	}
	public void setSub_total(double sub_total) {
		this.sub_total = sub_total;
	}
	public String getMetodo() {
		return metodo;
	}
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	public double getTarifa_noche() {
		return tarifa_noche;
	}
	public void setTarifa_noche(double tarifa_noche) {
		this.tarifa_noche = tarifa_noche;
	}
	public double getTarifa_evento() {
		return tarifa_evento;
	}
	public void setTarifa_evento(double tarifa_evento) {
		this.tarifa_evento = tarifa_evento;
	}
	
}
