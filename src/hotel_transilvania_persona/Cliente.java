package hotel_transilvania_persona;


public class Cliente extends persona{
	
	public String correo;
	
	public Cliente() {
		
	}
	
	
	public Cliente(String nombre, String apellido, int ci, int num_celular, String correo, String historial,int num_cliente) {
		super(nombre, apellido, ci, num_celular);
		this.correo = correo;
		
		//this.num_cliente = num_cliente;
	}
	
	public Cliente(String nombre, String apellido, int ci, int num_celular, String correo) {
		super(nombre, apellido, ci, num_celular);
		this.correo = correo;
	}
	
	public Cliente(String nombre, int ci) {
		super(nombre, ci);
	}

	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	

	
	

}






