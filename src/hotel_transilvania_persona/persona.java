package hotel_transilvania_persona;

public class persona {
	
	public String nombre;
	public String apellido;
	public int ci;
	public int num_celular;
	
	public persona(String nombre, String apellido, int ci, int num_celular) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.ci = ci;
		this.num_celular = num_celular;
	}
	public persona(String nombre, int ci) {
		super();
		this.nombre = nombre;
		this.ci = ci;
	}
	public persona() {
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getCi() {
		return ci;
	}
	public void setCi(int ci) {
		this.ci = ci;
	}
	public int getNum_celular() {
		return num_celular;
	}
	public void setNum_celular(int num_celular) {
		this.num_celular = num_celular;
	}
	
	public void lista_persona() {
		System.out.println("Nomre: "+getNombre());
		System.out.println("Apellido: "+getApellido());
		System.out.println("CI: "+getCi());
		System.out.println("Numero celular: "+getNum_celular());
	}
	
}
