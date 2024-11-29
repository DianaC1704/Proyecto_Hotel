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
			//inicializamos la lista de personal predefininda 
			List<Personal> lisPrefi = new ArrayList<>();
			lisPrefi.add(new Personal("Oscar","Ariscain",2312323,764564,"Manager",2500.0));
			lisPrefi.add(new Personal("Belinda", "Mena", 312313, 25350, "Cajera 1", 2500.0));
			lisPrefi.add(new Personal("Juan", "Perez", 456789, 12345, "Recepcionista", 1800.0)); 
			lisPrefi.add(new Personal("Ana", "Gomez", 789123, 98765, "Limpieza", 1500.0)); 
			lisPrefi.add(new Personal("Carlos", "Lopez", 325775, 65463, "Cajera 2", 2800.0)); 
			lisPrefi.add(new Personal("Marco", "Oropesa", 343254, 31231, "Cajera 3", 2710.0)); 
			lisPrefi.add(new Personal("Julia", "Lopez", 398954, 54321, "Cajero 4", 1500.0));
			lisPrefi.add(new Personal("Canela", "Quispe", 778454, 54321, "Limpieza 1", 3000.0)); 
			lisPrefi.add(new Personal("Caroline", "Rodrigos", 326544, 54321, "Limpieza 2", 2650.0)); 
			lisPrefi.add(new Personal("Amir", "Mamani", 378944, 54321, "Seguridad 1", 2545.0));
			lisPrefi.add(new Personal("Ramona", "Veruzca", 976774, 3137671, "Contador 1", 2700.0));
			lisPrefi.add(new Personal("Ardor", "Lorena", 4568684, 6757621, "Contador 2", 2245.0));
			lisPrefi.add(new Personal("Amir", "Mamani", 989944, 54321, "Seguridad 2", 2545.0));
			lisPrefi.add(new Personal("Pablo", "Zuro", 376874, 54321, "Asociado", 2545.0));
			lisPrefi.add(new Personal("Julia", "Velasquez", 378944, 54321, "Colaborador", 2545.0));
			lisPrefi.add(new Personal("Enrique", "Loreno", 8785944, 576571, "Seguridad 3", 2545.0));
			
			
			
			//agregar la lista de personal a la base de datos
			for(Personal p : lisPrefi) {
				agregarPersonal(p);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//Creación de una nueva propiedad
		public void agregarPersonal(Personal p) {
			String sql ="INSERT INTO personal(nombre,apellido,ci,num_celular,puesto,salario) VALUES(?,?,?,?,?,?)";
			try(PreparedStatement parametro = conexion.prepareStatement(sql)){
				parametro.setString(1, p.getNombre());
				parametro.setString(2, p.getApellido());
				parametro.setInt(3, p.getCi());
				parametro.setInt(4, p.getNum_celular());
				parametro.setString(5, p.getPuesto());
				parametro.setDouble(6, p.getsalario());
				parametro.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	
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
				double salario = rs.getDouble("salario"); 
				return new Personal(nombre, apellido, ci, numCelular, puesto, salario); 
				}
			} catch (SQLException e) { 
				e.printStackTrace(); 
				}
		       return null; 
		       }
	
	// buscar a personal usando el ci de este 
	public void buscarPersonalPorCI(int ci) { 
		Personal personal = obtenerDatosPorCI(ci); 
		if (personal != null) { System.out.println("Personal encontrado:");
		System.out.println("Nombre: " + personal.getNombre());
		System.out.println("Apellido: " + personal.getApellido()); 
		System.out.println("Num celular: " + personal.getNum_celular());
		System.out.println("Puesto: " + personal.getPuesto()); 
		System.out.println("Sueldo mínimo: " + personal.getsalario());
		} else { 
			System.out.println("No se encontró personal con el CI: " + ci);
			} 
		}
	//metodo para obtener todos los registros del personal
	public List<Personal> getAllPersonal (){
		List<Personal> listaPersonal= new ArrayList<>();
		String sql = "SELECT * FROM personal";
		try (PreparedStatement parametro = conexion.prepareStatement(sql);
				ResultSet rs= parametro.executeQuery()){
			while(rs.next()) {
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				int ci = rs.getInt("ci");
				int numCelular = rs.getInt("num_celular");
				String puesto = rs.getString("puesto");
				double salario = rs.getDouble("salario");
				Personal personal = new Personal(nombre, apellido, ci, numCelular,puesto, salario);
				listaPersonal.add(personal);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaPersonal;
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
