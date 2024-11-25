package hotel_transilvania;

import java.time.LocalDate;

import hotel_transilvania_persona.Cliente;
import java.time.DateTimeException;

public class Reserva extends Cliente{
	
	private LocalDate fecha_inicio;
	private LocalDate fecha_fin;
	private int noches;
	private boolean estado;
	private Cliente cliente;
	

	
	public Reserva() {
		super();
	
	}
	public Reserva(String nombre, int ci) {
		super(nombre, ci);
	
	}
	public Reserva(String nombre, String apellido, int ci, int num_celular, String correo) {
		super(nombre, apellido, ci, num_celular, correo);
	
	}
	public LocalDate getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(LocalDate fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public LocalDate getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(LocalDate fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public int getNoches() {
		return noches;
	}
	public void setNoches(int noches) {
		this.noches = noches;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public boolean validarFecha(int dia, int mes, int year) {
		
		try {
			LocalDate fecha = LocalDate.of(year, mes, dia);
			return true;
			
		} catch(DateTimeException ex) {
			return false;
		}
		
	}
	
	
	
}
