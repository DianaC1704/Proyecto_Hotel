package hotel_transilvania;

public class Reserva extends habitacion{
	public int numero_reserva;
	public int noches;
	private Object fecha_checkin;
	private Object fecha_chec;
	public Reserva(int num_habitacion, boolean disponibilidad, int camas, int piso, int numero_reserva, int noches) {
		super(num_habitacion, disponibilidad, camas, piso);
		this.numero_reserva = numero_reserva;
		this.noches = noches;
	}
	
	public Reserva(int num_habitacion, boolean disponibilidad, int camas, int piso) {
		super(num_habitacion, disponibilidad, camas, piso);
	}
	public Reserva() {
		
	}
	public int getNumero_reserva() {
		return numero_reserva;
	}
	public void setNumero_reserva(int numero_reserva) {
		this.numero_reserva = numero_reserva;
	}
	public int getNoches() {
		return noches;
	}
	public void setNoches(int noches) {
		this.noches = noches;
	}
	
	// clase interna, registro entrada
	 class check_in{
		public String fecha_checkin; // dd/mm/aa
		public String hora_checkin; //hh/mm/ss
		public check_in(String fecha_checkin, String hora_checkin) {
			super();
			this.fecha_checkin = fecha_checkin;
			this.hora_checkin = hora_checkin;
		}
		public String getFecha_checkin() {
			return fecha_checkin;
		}
		public void setFecha_checkin(String fecha_checkin) {
			this.fecha_checkin = fecha_checkin;
		}
		public String getHora_checkin() {
			return hora_checkin;
		}
		public void setHora_checkin(String hora_checkin) {
			this.hora_checkin = hora_checkin;
		}
		
	}
	// clase interna, registro salida
	class check_out{
		public String fecha_checkout;
		public String hora_checkout;
		public check_out(String fecha_checkout, String hora_checkout) {
			super();
			this.fecha_checkout = fecha_checkout;
			this.hora_checkout = hora_checkout;
		}
		public String getFecha_checkout() {
			return fecha_checkout;
		}
		public void setFecha_checkout(String fecha_checkout) {
			this.fecha_checkout = fecha_checkout;
		}
		public String getHora_checkout() {
			return hora_checkout;
		}
		public void setHora_checkout(String hora_checkout) {
			this.hora_checkout = hora_checkout;
		}
			
	}
	public int tiempo_estancia() { //calculo de estancia dentro del hotel
		int d=0;
		int inicio = Integer.parseInt(((String) this.fecha_checkin).substring(0,2));
		int fin =Integer.parseInt(((String) this.fecha_chec).substring(0,2));
		d = fin -inicio;
		return d;
	}
}
