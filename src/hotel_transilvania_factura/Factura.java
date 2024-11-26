package hotel_transilvania_factura;

import hotel_transilvania.checks;

import java.time.LocalDateTime;

public class Factura {
	
	private String NIT;
	private double total;
	private checks checks;
	private LocalDateTime fecha;
	
	
	public Factura() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getNIT() {
		return NIT;
	}
	public void setNIT(String nIT) {
		this.NIT = nIT;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	
	
}
