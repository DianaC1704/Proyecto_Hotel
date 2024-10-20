package hotel_transilvania_persona;

public class Personal extends persona {
	
	public String puesto;
	public double salario_min;
<<<<<<< HEAD
	public int num_social;
=======
>>>>>>> 18b69412b810b907359bf55b5acadf5ca6fc226a
	
	public Personal(String nombre, String apellido, int ci, int num_celular, String puesto, double salario_min,
			int num_social) {
		super(nombre, apellido, ci, num_celular);
		this.puesto = puesto;
		this.salario_min = salario_min;
		this.ci=ci;
	}
	public Personal(String nombre, String apellido, int ci, int num_celular) {
		super(nombre, apellido, ci, num_celular);
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public double getSalario_min() {
		return salario_min;
	}
	public void setSalario_min(double salario_min) {
		this.salario_min = salario_min;
	}
	
	
	public String num_soc(int ci, String puesto) {
		String n;
		String ci_st = String.valueOf(ci); //se transforma de int a string
		String ap_st = puesto.substring(puesto.length()-3); // se obtine los ultimos 3 caracteres
		n= ci_st+ap_st;
		return n;
	}
	
	public void llenado_personal() {
		System.out.println("Nombre: "+getNombre());
		System.out.println("Apellido: "+getApellido());
		System.out.println("CI: "+getCi());
		System.out.println("Numero social: "+num_soc(ci, puesto));
		System.out.println("Sueldo min: "+getSalario_min());
		
	}
}
