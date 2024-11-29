package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JOptionPane;
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
				Mostrar_Datos ms_datos = new Mostrar_Datos();
				ms_datos.setDB(pDB);
				ms_datos.llenan_tabla();
				ms_datos.setVisible(true);
			}
		});
		btnAyuda.setIcon(new ImageIcon(menu_.class.getResource("/imagenes/question.png")));
		btnAyuda.setBounds(577, 448, 32, 32);
		contentPane.add(btnAyuda);
		
		//boton que se va eliminar duplicados
		JButton btnEliminarDuplicados = new JButton("Eliminar Duplicados");
		btnEliminarDuplicados.addMouseListener(new MouseAdapter() {
			@Override public void mouseClicked(MouseEvent e) {
				pDB.eliminarPersonalDuplicados(); 
				JOptionPane.showMessageDialog(null, "Los registros duplicados han sido eliminados.");
				} 
			}); 
		btnEliminarDuplicados.setBounds(200, 500, 200, 30);
		contentPane.add(btnEliminarDuplicados);
		
		
		
		inicializarDatos();
     }
	private void inicializarDatos() {
		pDB  = new personalDB();
	}
}
