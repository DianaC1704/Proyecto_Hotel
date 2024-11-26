package hotel_transilvania;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class checks {
	
	private LocalDateTime fechaHora;
	
	
	
	public checks() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public checks(LocalDateTime fechaHora) {
		super();
		this.fechaHora = fechaHora;
	}
	
	public LocalDateTime getfechaHora() {
		return fechaHora;
	}
	public void setfechaHora(LocalDateTime hora) {
		this.fechaHora = hora;
	}

	
	public String entregarFecha() {
		
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHoraCheck = ahora.format(formato); //convierte objeto ahora a una cadena usando el formato definido
        
        return fechaHoraCheck;
		
	}

	
	
}
