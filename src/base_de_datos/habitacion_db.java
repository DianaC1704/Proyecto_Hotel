package base_de_datos;

import java.sql.*;


import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import hotel_transilvania.habitacion;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import hotel_transilvania.habitacion;
import base_de_datos.cliente_db;

public class habitacion_db {
	
	private Connection conexion;
	private habitacion Habitacion;
	
	
	public habitacion_db() {
		try {
			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_hotel", "root", "");
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	
    public List<habitacion> obtenerHabitacionesDisp() {
    	List<habitacion> habitaciones = new ArrayList<>();
        String sql = "SELECT id_habitacion, num_habitacion, disponibilidad, tarifa_noche, tipo_hab FROM habitacion WHERE disponibilidad = true";
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String num_habitacion = rs.getString("num_habitacion");
                boolean disp = rs.getBoolean("disponibilidad");
                double tarifa = rs.getDouble("tarifa_noche");
                String tipo = rs.getString("tipo_hab");
                habitacion Habitacion = new habitacion(num_habitacion,disp, tarifa,tipo);
                habitaciones.add(Habitacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return habitaciones;
    }
    
    public int obtenerID(String num_habitacion) {
    	int ID = 0;
    	String sql = "SELECT id_habitacion FROM habitacion WHERE num_habitacion = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        	stmt.setString(1, num_habitacion);
        	ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ID = rs.getInt("id_habitacion");  // Obtener el ID de la habitación
            } else {
                System.out.println("No se encontró habitación con número: " + num_habitacion);
            }
               } catch (SQLException e) {
                   e.printStackTrace();
               }
        return ID;
    }
    
    public List<habitacion> obtenerHabitacionesCliente(String ci){
    	
		cliente_db cliente_db = new cliente_db();
		int ID = cliente_db.obtenerID(ci);
		//System.out.println(ID);
    	
    	List<habitacion> habitaciones = new ArrayList<>();
    	String sql = "SELECT h.tipo_hab, h.num_habitacion, h.tarifa_noche "
    			+ "FROM cliente c, reserva r, reserva_habitacion rh, habitacion h "
    			+ "WHERE c.id_cliente = r.id_cliente AND r.id_reserva = rh.id_reserva AND rh.id_habitacion = h.id_habitacion AND c.id_cliente = ?";
    	
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, ID); 
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                habitacion hab = new habitacion();
                hab.settipo(rs.getString("tipo_hab"));
                hab.setNum_habitacion(rs.getString("num_habitacion"));
                hab.setTarifa_noche(rs.getDouble("tarifa_noche"));
                habitaciones.add(hab);
                System.out.println(hab.getNum_habitacion());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return habitaciones;
    }
    
    
    
 /*   public double obtenerTarifa(String num_habitacion) {
    	double tarifa = 0;
    	 String sql = "SELECT id_habitacion, num_habitacion, tarifa  FROM habitacion WHERE num_habitacion = ?";
         try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
             parametro.setString(1, num_habitacion);
             ResultSet rs = parametro.executeQuery();
             if (rs.next()) {
                tarifa = rs.getDouble("tarifa");
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return tarifa;
    }
    
  */  
	
    

}
