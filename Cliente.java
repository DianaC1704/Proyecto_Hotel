
public class Cliente extends Persona{
	private String correo;
	private String historial;
	
	public Cliente(String nombre, int ci, int num_celular, String correo, String historial) {
		super(nombre, ci, num_celular);
		this.correo = correo;
		this.historial = historial;
	}
	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getHistorial() {
		return historial;
	}
	public void setHistorial(String historial) {
		this.historial = historial;
	}
	
	

}
