package base_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hotel_transilvania_persona.Personal;

public class personalDB {
	private Connection conexion;

	public personalDB() {
		try {
			this.conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_transil", "root", "");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//Creación de una nueva propiedad
		public void agregarPersona(Personal p) {
			String sql ="INSERT INTO personal(nombre,apellido,ci,num_celular,puesto,sueldo_min) VALUES(?,?,?,?,?,?)";
			try(PreparedStatement parametro = conexion.prepareStatement(sql)){
				parametro.setString(1, p.getNombre());
				parametro.setString(2, p.getApellido());
				parametro.setInt(3, p.getCi());
				parametro.setInt(4, p.getNum_celular());
				parametro.setString(5, p.getPuesto());
				parametro.setDouble(6, p.getSueldo_min());
				
				System.out.println("Nombre: " + p.getNombre());
				System.out.println("Apellido: " + p.getApellido()); 
				System.out.println("CI: " + p.getCi());
				System.out.println("Num celular: "+p.getNum_celular());
				System.out.println("Puesto: " + p.getPuesto());
				System.out.println("Sueldo mínimo: " + p.getSueldo_min()); 
				
			
				parametro.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	/*
	 * public boolean verificarCI(int ci) {
    String sql = "SELECT COUNT(*) FROM cliente WHERE ci = ?";
    try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
        parametro.setInt(1, ci);
        ResultSet rs = parametro.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
    }
*/
	public Personal obtenerDatosPorCI(int ci) { 
		String sql = "SELECT * FROM personal WHERE ci = ?"; 
		try (PreparedStatement parametro = conexion.prepareStatement(sql)){ 
			parametro.setInt(1, ci); 
			ResultSet rs = parametro.executeQuery(); 
			if (rs.next()) { 
				String nombre = rs.getString("nombre"); 
				String apellido = rs.getString("apellido"); 
				int numCelular = rs.getInt("num_celular");
				String puesto = rs.getString("puesto"); 
				double sueldoMin = rs.getDouble("sueldo_min"); 
				return new Personal(nombre, apellido, ci, numCelular, puesto, sueldoMin); 
				}
			} catch (SQLException e) { 
				e.printStackTrace(); 
				}
		       return null; 
		       }
	public void buscarPersonalPorCI(int ci) { 
		Personal personal = obtenerDatosPorCI(ci); 
		if (personal != null) { System.out.println("Personal encontrado:");
		System.out.println("Nombre: " + personal.getNombre());
		System.out.println("Apellido: " + personal.getApellido()); 
		System.out.println("Num celular: " + personal.getNum_celular());
		System.out.println("Puesto: " + personal.getPuesto()); 
		System.out.println("Sueldo mínimo: " + personal.getSueldo_min());
		} else { 
			System.out.println("No se encontró personal con el CI: " + ci);
			} 
		}
	//se obtiene la lista de ci del personal para su posterior eliminacion
	public List<Integer> obtenerCiDuplicados() {
	    List<Integer> ciDuplicados = new ArrayList<>();
	    String sql = "SELECT ci FROM personal WHERE ci IN (SELECT ci FROM personal GROUP BY ci HAVING COUNT(ci) > 1)";
	    try (PreparedStatement parametro = conexion.prepareStatement(sql);
	         ResultSet rs = parametro.executeQuery()) {
	        while (rs.next()) {
	            ciDuplicados.add(rs.getInt("ci"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ciDuplicados;
	}
	
	// Eliminar un personal(clasve para elimincar al personla que esta duplicado)
	public void eliminarPersonal(int ci) { 
		String sql = "DELETE FROM personal WHERE ci = ?";
		try (PreparedStatement parametro = conexion.prepareStatement(sql)) { 
			parametro.setInt(1, ci); 
			parametro.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace(); 
				} 
		}
	//eliminar a personal duplicado usando list con el eliminarPersonal--- posible no cambio
	
	public void eliminarPersonalDuplicados() {
	    List<Integer> idsDuplicados = obtenerCiDuplicados();
	    for (int ci : idsDuplicados) {
	        eliminarPersonal(ci);
	        System.out.println("Eliminado personal con ID: " + ci);
	    }
	}


}
