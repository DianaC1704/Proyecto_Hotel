package base_de_datos;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hotel_transilvania_persona.Cliente;

public class cliente_db {
	
	private Connection conexion;
	
	public cliente_db() {
		try {
			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_hotel", "root", "");
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	
    public String obtenerApellidoConCI(String CI) {
    	String apellido = "";
        String sql = "SELECT id_cliente, apellido, CI FROM cliente WHERE CI = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setString(1, CI);
            ResultSet rs = parametro.executeQuery();
            if (rs.next()) {
               apellido = rs.getString("apellido");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return apellido;
    }
    
    public int obtenerID(String CI) {
    	int id = 0;
        String sql = "SELECT id_cliente FROM cliente WHERE CI = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setString(1, CI);
            ResultSet rs = parametro.executeQuery();
            if (rs.next()) {
               id = rs.getInt("id_cliente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    
	public boolean agregarCliente(Cliente cliente) {
		String sql="INSERT INTO cliente(correo,nombre,CI,apellido,num_celular) VALUES(?,?,?,?,?)";
		try (PreparedStatement parametro=conexion.prepareStatement(sql)){
			parametro.setString(1, cliente.getCorreo());
			parametro.setString(2, cliente.getNombre());
			parametro.setString(3, cliente.getCi()+"");
			parametro.setString(4, cliente.getApellido());
			parametro.setString(5, cliente.getNum_celular()+"");
			
			int filasInsertadas = parametro.executeUpdate();
			return filasInsertadas>0;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
    
    public void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
