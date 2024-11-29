package hotel;

import base_datos.ClienteDB;
import base_datos.personalDB;
import hotel_transilvania_persona.Cliente;
import hotel_transilvania_persona.Personal;
import hotel_transilvania_persona.gestionar_personal;
import hotel_transilvania_persona.persona;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		conexion con = new conexion();
		con.conectar();
		
		/*//esta parte de aqui se completara en el futuro no olvidaar 
		Cliente cli = new  Cliente("Oscar","ariscain", 8441405, 67318110,"osacjp@gmail.com");
		Cliente cli2 = new Cliente("Jhon", "Panozo", 123132, 89422205, "Panozo@gmail.com");
		
		cli.crear_cliente();
		cli2.crear_cliente();
	
		ClienteDB cliDB = new ClienteDB();
		
		cliDB.agregarPersona(cli);
		cliDB.agregarPersona(cli2);
		*/
		Personal p = new Personal("Oscar","robles", 2310, 76446, "Manager", 25005);
		Personal p2= new Personal("Belinda", "Mena", 312313, 25350,"Cajera 1", 4500);
		Personal p3 = new Personal("Daniel", "Soldado", 45354, 123130,"Mesero",2000);
		
		p.llenado_personal();
		p2.llenado_personal();
		p3.llenado_personal();
		
		
		personalDB pDB = new personalDB();
		/*
		pDB.agregarPersona(p);
		pDB.agregarPersona(p2);
		pDB.agregarPersona(p3);
	*/
		System.out.println("--------------------");
		
		gestionar_personal mi_gestion_personal = new gestionar_personal();
		mi_gestion_personal.agregar_personal(p);
		mi_gestion_personal.agregar_personal(p2);
		mi_gestion_personal.agregar_personal(p3);
		
		
		System.out.println("-------------------2-");
		
		mi_gestion_personal.mostrar_personal();
		
		
		//pDB.buscarPersonaPorCi(p); ignorar esta parte
		System.out.println("-------------------------------");
		//pDB.obtenerDatosPorCI(2310);
		System.out.println("-------------------------------");
		//pDB.buscarPersonalPorCI(23610);
		System.out.println("-------------------------------");
		//pDB.eliminarPersonal(23610);
		System.out.println("_-------------------");
		//pDB.eliminarPersonalDuplicados();
	}

}
