package hotel_transilvania_persona;

public class Personal extends persona {
	
	public String puesto;
	public double salario;
	
	public Personal(String nombre, String apellido, int ci, int num_celular, String puesto, double salario) {
		super(nombre, apellido, ci, num_celular);
		this.puesto = puesto;
		this.salario = salario;
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
	
	public double getsalario() {
		return salario;
	}

	public void setsalario(double salario) {
		this.salario = salario;
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
		System.out.println("Numero celular: "+getNum_celular());
		System.out.println("Puesto: "+getPuesto());
		System.out.println("Sueldo min: "+getsalario());	
		
	}
}
