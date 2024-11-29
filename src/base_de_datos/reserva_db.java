package base_de_datos;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import base_de_datos.cliente_db;
import base_de_datos.habitacion_db;
import hotel_transilvania.habitacion;

public class reserva_db {
	
	private Connection conexion;
	private cliente_db cliente_db;
	private habitacion_db habitacion_db;
	
	
	public reserva_db() {
		
		habitacion_db = new habitacion_db();
		try {
			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_transil", "root", "");
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	
	public void registrarReserva(String ci, LocalDate fechaInicio, LocalDate fechaFin, int n_noches, List<habitacion> habitaciones) {
		
		//1. Obtener ID
		cliente_db = new cliente_db();
		int ID = cliente_db.obtenerID(ci);
		
		//2. Crear reserva
		int idReserva = 0;
		String sqlInsertarReserva = "INSERT INTO reserva (id_cliente, fecha_inicio, fecha_fin, noches) VALUES (?, ?, ?, ?)";
		try(PreparedStatement ps1 = conexion.prepareStatement(sqlInsertarReserva,Statement.RETURN_GENERATED_KEYS)){
			conexion.setAutoCommit(false); 
			ps1.setInt(1, ID);
			ps1.setDate(2, java.sql.Date.valueOf(fechaInicio));
			ps1.setDate(3, java.sql.Date.valueOf(fechaFin));
			ps1.setInt(4, n_noches);	
			ps1.executeUpdate();
			
            ResultSet generatedKeys = ps1.getGeneratedKeys();
            if (generatedKeys.next()) {
                idReserva = generatedKeys.getInt(1);
            } else {
                System.out.println("No se pudo obtener el ID de la reserva.");
                conexion.rollback();
                return;
            }
			
		}
		catch (SQLException e) {
            e.printStackTrace();
        }
		
		//3. Insertar habitaciones
		String sqlInsertarHabitaciones = "INSERT INTO reserva_habitacion (id_reserva, id_habitacion) VALUES (?, ?)";
		
		try(PreparedStatement ps2 = conexion.prepareStatement(sqlInsertarHabitaciones)){
			for(habitacion Habitacion : habitaciones) {
				
				int idHabitacion = habitacion_db.obtenerID(Habitacion.getNum_habitacion());
      	        //System.out.println("id_reserva: " + idReserva + " y id_habitacion: " + idHabitacion);
				ps2.setInt(1, idReserva);
				ps2.setInt(2, idHabitacion);
				ps2.executeUpdate();
			}
		
		  conexion.commit();
	      JOptionPane.showMessageDialog(null, "Reserva registrada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	      conexion.setAutoCommit(true);
		}
	      catch (SQLException e) {
	          e.printStackTrace();
	         
	}
	
	}
	
	//metodo en proceso para Factura con EVENTOS y SERVICIOS
	/*public JTable detalleFactura(String ci) {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("SERVICIO");
		modelo.addColumn("ITEM");
		modelo.addColumn("PRECIO");
		
		//1. Obtener cliente ID
		cliente_db = new cliente_db();
		int ID = cliente_db.obtenerID(ci);
		
		//2. Obtener servicios
        String sql = "SELECT , ts.nombre AS nombreServicio, ts.tarifa_hora AS precioServicio FROM cliente, reserva, reserva_habitacion, servicio ";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)){
        	
        }
	}*/
	

}