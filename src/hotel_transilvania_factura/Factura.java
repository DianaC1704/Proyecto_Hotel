package hotel_transilvania_factura;

public class Factura extends Pago{
	
	public double impuestos;// posible cambio a metodo
	public int noches;
	public String info_cliente;// posible cambio a metedo usando obj
	public double servicios_subyacentes;
	public boolean metodo_pago;
	
	public Factura(String nombre, String apellido, int ci, int num_celular, double sub_total, String metodo,
			double tarifa_noche, double tarifa_evento, double impuestos, int noches, String cliente,
			double servicios_subyacentes) {
		super(nombre, apellido, ci, num_celular, sub_total, metodo, tarifa_noche, tarifa_evento);
		this.impuestos = impuestos;
		this.noches = noches;
		this.info_cliente = cliente;
		this.servicios_subyacentes = servicios_subyacentes;
	}
	
	public Factura(String nombre, String apellido, int ci, int num_celular, double sub_total, String metodo,
			double tarifa_noche, double tarifa_evento, double impuestos, int noches, String info_cliente,
			double servicios_subyacentes, boolean metodo_pago) {
		super(nombre, apellido, ci, num_celular, sub_total, metodo, tarifa_noche, tarifa_evento);
		this.impuestos = impuestos;
		this.noches = noches;
		this.info_cliente = info_cliente;
		this.servicios_subyacentes = servicios_subyacentes;
		this.metodo_pago = metodo_pago;
	}

	public double getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(double impuestos) {
		this.impuestos = impuestos;
	}

	public int getNoches() {
		return noches;
	}

	public void setNoches(int noches) {
		this.noches = noches;
	}

	public String getInfo_cliente() {
		return info_cliente;
	}

	public void setInfo_cliente(String info_cliente) {
		this.info_cliente = info_cliente;
	}

	public double getServicios_subyacentes() {
		return servicios_subyacentes;
	}

	public void setServicios_subyacentes(double servicios_subyacentes) {
		this.servicios_subyacentes = servicios_subyacentes;
	}
	
	public boolean getMetodo_pago() {
		return metodo_pago;
	}

	public void setMetodo_pago(boolean metodo_pago) {
		this.metodo_pago = metodo_pago;
	}

	static int metodo_pago() {
		// tarjeta o efectivo
		
		return 0;
		
	}
	
	
}
