package hotel_transilvania_persona;

import java.util.*;
import java.util.List;

public class gestionar_personal{
	private List<Personal> lista_personal;

	public gestionar_personal() { 
		lista_personal = new ArrayList<>(); 
	}
	// agrega personal a la coleccion 
	
	public gestionar_personal(Personal personal) {
		this();
		agregar_personal(personal); 
	}
	public void agregar_personal(Personal personal) {
		lista_personal.add(personal);
	}
	
	//retona la lista del personal
	public List<Personal> getlisList(){
		return lista_personal;
	}
	
	
	public void mostrar_personal(){
		//List<Personal>lista_personal =mi_gestion_personal.getlisList();
		for(Personal personal : lista_personal ) {
			System.out.println("Nombre: "+personal.getNombre());
			System.out.println("Apellido: "+personal.getApellido());
			System.out.println("ci: "+personal.getCi());
			System.out.println("Celular: "+personal.getCi());
			System.out.println("Puesto: "+personal.getPuesto());
			System.out.println("Salario: "+personal.getSueldo_min());
		}
	}
}
