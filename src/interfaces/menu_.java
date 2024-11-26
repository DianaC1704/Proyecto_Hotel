package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import base_datos.personalDB;
import hotel_transilvania_persona.Personal;
import hotel_transilvania_persona.gestionar_personal;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
public class menu_ extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblimagen_1 = new JLabel("");
	private JButton btnEmpresa;
	private JButton btnUsuario;
	private JLabel lblTitulol;
	private JLabel lblempresa;
	private JLabel lblusuario;
	private JLabel lblMensaje;
	private JButton btnAyuda;
	
	personalDB pDB;
	
	 gestionar_personal mi_gestion_personal;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu_ frame = new menu_();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public menu_() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Menu de opcoiones");
		setBounds(100, 100, 657, 551);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 61, 238));
		contentPane.setForeground(new Color(18, 0, 55));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblimagen_1.setIcon(new ImageIcon(menu_.class.getResource("/imagenes/menu.jpg")));
		lblimagen_1.setBounds(10, 10, 324, 498);
		contentPane.add(lblimagen_1);
		
		btnEmpresa = new JButton("");
		btnEmpresa.addMouseListener(new MouseAdapter() {
			@Override
			//agregar la clase usuario
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnEmpresa.setIcon(new ImageIcon(menu_.class.getResource("/imagenes/logo_empresario.png")));
		btnEmpresa.setBounds(545, 150, 64, 64);
		contentPane.add(btnEmpresa);
		
		btnUsuario = new JButton("");
		btnUsuario.addMouseListener(new MouseAdapter() {
			@Override
			//agregar la clase usuario
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnUsuario.setIcon(new ImageIcon(menu_.class.getResource("/imagenes/logo_usuario.png")));
		btnUsuario.setBounds(545, 251, 64, 64);
		contentPane.add(btnUsuario);
		
		lblTitulol = new JLabel("BIENVENIDO");
		lblTitulol.setFont(new Font("Verdana", Font.BOLD, 36));
		lblTitulol.setBackground(new Color(238, 240, 239));
		lblTitulol.setForeground(new Color(0, 0, 0));
		lblTitulol.setBounds(344, 35, 290, 51);
		contentPane.add(lblTitulol);
		
		lblempresa = new JLabel("Empresario: ");
		lblempresa.setFont(new Font("Times New Roman",Font.PLAIN,22));
		lblempresa.setBounds(370, 171, 152, 25);
		contentPane.add(lblempresa);
		
		lblusuario = new JLabel("Usuario:");
		lblusuario.setFont(new Font("Times New Roman",Font.PLAIN,22));
		lblusuario.setBounds(374, 269, 148, 30);
		contentPane.add(lblusuario);
		
		lblMensaje = new JLabel("Quieres saber sobre nuestro staff:");
		lblMensaje.setFont(new Font("Times New Roman",Font.PLAIN,16));
		lblMensaje.setBounds(344, 460, 220, 13);
		contentPane.add(lblMensaje);
		
		btnAyuda = new JButton("");
		btnAyuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//inicializamos mi_gestion_personal
				/*
				if(mi_gestion_personal == null) {
					List<Personal> listaPrefija= new ArrayList<>();
					
					mi_gestion_personal = new gestionar_personal();
					mi_gestion_personal.agregar_personal(new Personal("Oscar", "Robles", 2310, 76446, "Manager", 25005.0));
					mi_gestion_personal.agregar_personal(new Personal("Belinda", "Mena", 312313, 25350, "Cajera 1", 2500.0));
				*/
				/*
					listaPrefija.add(new Personal("Oscar", "Robles", 2310, 76446, "Manager", 25005.0)); 
					listaPrefija.add(new Personal("Belinda", "Mena", 312313, 25350, "Cajera 1", 2500.0)); 
					listaPrefija.add(new Personal("Juan", "Perez", 456789, 12345, "Recepcionista", 1800.0));
				}
			*/	
				Mostrar_Datos ms_datos = new Mostrar_Datos();
				ms_datos.setProcesos(mi_gestion_personal);
				ms_datos.llenar_tabla();;
				ms_datos.setVisible(true);
			}
		});
		btnAyuda.setIcon(new ImageIcon(menu_.class.getResource("/imagenes/question.png")));
		btnAyuda.setBounds(577, 448, 32, 32);
		contentPane.add(btnAyuda);
		
		inicializarDatos();
     }
	
		private void inicializarDatos() {
			if(mi_gestion_personal == null) {
				List<Personal> lisPrefi =new ArrayList<>();
				 lisPrefi.add(new Personal("oscar","ariscain",2310 ,76446, "Manager", 25005.0 ));
				 lisPrefi.add(new Personal("Belinda", "Mena", 312313, 25350, "Cajera 1", 2500.0)); 
				 lisPrefi.add(new Personal("Juan", "Perez", 456789, 12345, "Recepcionista", 1800.0)); 
				 lisPrefi.add(new Personal("Ana", "Gomez", 789123, 98765, "Limpieza", 1500.0));
				 lisPrefi.add(new Personal("Carlos", "Lopez", 325775, 65463, "Cajera 2", 2800.0));
				 lisPrefi.add(new Personal("Marco", "Oropesa", 343254, 31231, "Cajera 3", 2710.0));
				 lisPrefi.add(new Personal("Julia", "Lopez", 398954, 54321, "Seguridad", 1500.0));
				 lisPrefi.add(new Personal("Canela", "Quispe", 778454, 54321, "Seguridad", 3000.0));
				 lisPrefi.add(new Personal("Caroline", "Rodrigos", 326544, 54321, "Seguridad", 2650.0));
				 lisPrefi.add(new Personal("Amir", "Mamani", 378944, 54321, "Seguridad", 2545.0));
		
				 mi_gestion_personal = new gestionar_personal();
			for(Personal personal :  lisPrefi ) {
				mi_gestion_personal.agregar_personal(personal);
			}
		}
		
	}
		
		
		public void agregar_list_basedatos() {
			pDB = new personalDB();
			
			Personal p = new Personal("oscar","ariscain",2310 ,76446, "Manager", 25005.0 );
			Personal p2 = new Personal("Belinda", "Mena", 312313, 25350, "Cajera 1", 2500.0);
			Personal p3 = new Personal("Juan", "Perez", 456789, 12345, "Recepcionista", 1800.0);
			Personal p4 = new Personal("Ana", "Gomez", 789123, 98765, "Limpieza", 1500.0);
			Personal p5 = new Personal("Carlos", "Lopez", 325775, 65463, "Cajera 2", 2800.0);
			Personal p6 = new Personal("Marco", "Oropesa", 343254, 31231, "Cajera 3", 2710.0);
			Personal p7= new Personal("Julia", "Lopez", 398954, 54321, "Seguridad", 1500.0);
			Personal p8 = new Personal("Canela", "Quispe", 778454, 54321, "Seguridad", 3000.0);
			Personal p9 = new Personal("Caroline", "Rodrigos", 326544, 54321, "Seguridad", 2650.0);
			Personal p10 = new Personal("Amir", "Mamani", 378944, 54321, "Seguridad", 2545.0);
			
			pDB.agregarPersona(p);
			pDB.agregarPersona(p2);
			pDB.agregarPersona(p3);
			pDB.agregarPersona(p4);
			pDB.agregarPersona(p5);
			pDB.agregarPersona(p6);
			pDB.agregarPersona(p7);
			pDB.agregarPersona(p8);
			pDB.agregarPersona(p9);
			pDB.agregarPersona(p10);
			
		}

}
