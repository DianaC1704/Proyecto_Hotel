package base_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hotel_transilvania_persona.Cliente;

public class ClienteDB {
	private Connection conexion;

	public ClienteDB() {
		try {
			this.conexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_hotel", "root", ""); 
		}catch (Exception e ) {
			e.printStackTrace();
		}
	}
	
	//Creación de una nueva propiedad
	public void agregarPersona(Cliente cli) {
		String sql ="INSERT INTO cliente(nombre,apellido,ci,num_celular,correo) VALUES(?,?,?,?,?)";
		try(PreparedStatement parametro = conexion.prepareStatement(sql)){
			parametro.setString(1, cli.getNombre());
			parametro.setString(2, cli.getApellido());
			parametro.setInt(3, cli.getCi());
			parametro.setInt(4, cli.getNum_celular());
			parametro.setString(5, cli.getCorreo());
			
			parametro.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Edición de propiedad 
			public void editarPersona(Cliente cli, int id) { 
				String sql = "UPDATE persona SET  nombre = ?,apellido = ?, ci = ?, Num_celular = ?, Correo = ? WHERE id = ?";
				try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
					parametro.setString(1, cli.getNombre()); 
					parametro.setString(2, cli.getApellido()); 
					parametro.setInt(3, cli.getCi()); 
					parametro.setInt(4, cli.getNum_celular());
					parametro.executeUpdate();
					
					
				} catch (SQLException e) { 
					e.printStackTrace();
				}
			}
			
    // Eliminar una propiedad
	    public void eliminarCliente(int id) {
		        String sql = "DELETE FROM persona WHERE id = ?";
		        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
		            parametro.setInt(1, id);
		            parametro.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		    
		    
		    // Obtener lista de propiedades
		    public Cliente obtenerlista(int id) {
		        String sql = "SELECT * FROM cliente WHERE id = ?";
		        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
		            parametro.setInt(1, id);
		            ResultSet rs = parametro.executeQuery();
		            if (rs.next()) {
		                return new Cliente(
		                		rs.getString("nombre"),
		                		rs.getString("apellido"),
		                		rs.getInt("ci"),
		                		rs.getInt("num_celular")
		                		);
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return null;
		    }

	
}
