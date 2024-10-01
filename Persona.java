
public class Persona {
	private String nombre;
	protected int ci;
	private int num_celular;
	
	public Persona(String nombre, int ci, int num_celular) {
		super();
		this.nombre = nombre;
		this.ci = ci;
		this.num_celular = num_celular;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
}
