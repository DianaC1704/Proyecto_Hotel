package hotel_transilvania_persona;

import hotel_transilvania.Reserva;

public class Cliente extends persona{
	
	public String correo;
<<<<<<< HEAD
	public int num_cliente; //valores de ci y celular
=======
	//public int num_cliente; //valores de ci y celular
>>>>>>> 18b69412b810b907359bf55b5acadf5ca6fc226a
	
	public Cliente(String nombre, String apellido, int ci, int num_celular, String correo, String historial,int num_cliente) {
		super(nombre, apellido, ci, num_celular);
		this.correo = correo;
		
		//this.num_cliente = num_cliente;
	}
	
	public Cliente(String nombre, String apellido, int ci, int num_celular) {
		super(nombre, apellido, ci, num_celular);
	}

	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
/*
	public int getNum_cliente() {
		return num_cliente;
	}
	public void setNum_cliente(int num_cliente) {
		this.num_cliente = num_cliente;
	}
	*/
	class historial_cli extends Reserva{
		String apellido;
		int ci;
		int num_hab;
		
		public historial_cli(int num_habitacion, boolean disponibilidad, int camas, int piso, int numero_reserva,
				int noches, String apellido, int ci, int num_hab) {
			super(num_habitacion, disponibilidad, camas, piso, numero_reserva, noches);
			this.apellido = apellido;
			this.ci = ci;
			this.num_hab= num_hab;
		}
		public void historial_cliente() {
			
			System.out.println("Apellido: "+getApellido());
			System.out.println("CI: "+getCi());
			System.out.println("Numero habitacion: "+getNum_habitacion());
			System.out.println("Dias: "+tiempo_estancia());
		}
	}

}






