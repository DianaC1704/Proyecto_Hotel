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
        String sql = "SELECT id_habitacion, num_habitacion, disponibilidad, tarifa_noche FROM habitacion WHERE disponibilidad = true";
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String num_habitacion = rs.getString("num_habitacion");
                boolean disp = rs.getBoolean("disponibilidad");
                double tarifa = rs.getDouble("tarifa_noche");
                habitacion Habitacion = new habitacion(num_habitacion,disp, tarifa);
                habitaciones.add(Habitacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
