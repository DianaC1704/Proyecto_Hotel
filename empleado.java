
public class empleado extends Persona {
	private String puesto;
	private double salario;
	
	public empleado(String nombre, int ci, int num_celular, String puesto, double salario) {
		super(nombre, ci, num_celular);
		this.puesto = puesto;
		this.salario = salario;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	

}
