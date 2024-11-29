package interfaces;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import base_datos.personalDB;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class menu_principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private personalDB pDB;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu_principal frame = new menu_principal();
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
	public menu_principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HOTEL TRANSILVANIA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("KG Sorry Not Sorry Chub", Font.PLAIN, 23));
		lblNewLabel.setBounds(116, 23, 183, 28);
		contentPane.add(lblNewLabel);
		//inicializar personalDB
		pDB = new personalDB();
		
		
		JButton btnRegistrarCliente = new JButton("");
		btnRegistrarCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				registrar_cliente registrar_cliente = new registrar_cliente();
				registrar_cliente.setVisible(true);
			}
		});
		btnRegistrarCliente.setIcon(new ImageIcon(menu_principal.class.getResource("/imagenes/add.png")));
		btnRegistrarCliente.setBounds(54, 78, 38, 34);
		contentPane.add(btnRegistrarCliente);
		
		JLabel lblNewLabel_1 = new JLabel("Registrar nuevo cliente");
		lblNewLabel_1.setFont(new Font("KG Sorry Not Sorry", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(102, 78, 183, 34);
		contentPane.add(lblNewLabel_1);
		
		JButton btnVerPersonal = new JButton("");
		btnVerPersonal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Mostrar_Datos mostrar_datos = new Mostrar_Datos();
				//estos dos para crear la base de datos y agregar persoanl
				mostrar_datos.setDB(pDB);
				mostrar_datos.llenan_tabla();
				mostrar_datos.setVisible(true);
			}
		});
		btnVerPersonal.setFont(new Font("KG Sorry Not Sorry", Font.PLAIN, 15));
		btnVerPersonal.setIcon(new ImageIcon(menu_principal.class.getResource("/imagenes/personas.png")));
		btnVerPersonal.setBounds(54, 123, 38, 34);
		contentPane.add(btnVerPersonal);
		
		JButton btnRegistrarReserva = new JButton("");
		btnRegistrarReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				registrar_reserva registrar_reserva = new registrar_reserva();
				registrar_reserva.setVisible(true);
			}
		});
		btnRegistrarReserva.setIcon(new ImageIcon(menu_principal.class.getResource("/imagenes/calendarPlus.png")));
		btnRegistrarReserva.setFont(new Font("KG Sorry Not Sorry", Font.PLAIN, 15));
		btnRegistrarReserva.setBounds(54, 168, 38, 34);
		contentPane.add(btnRegistrarReserva);
		
		JButton btnFactura = new JButton("");
		btnFactura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Factura factura = new Factura();
				factura.setVisible(true);
			}
		});
		btnFactura.setIcon(new ImageIcon(menu_principal.class.getResource("/imagenes/receipt.png")));
		btnFactura.setFont(new Font("KG Sorry Not Sorry", Font.PLAIN, 15));
		btnFactura.setBounds(54, 213, 38, 34);
		contentPane.add(btnFactura);
		
		JLabel lblNewLabel_1_1 = new JLabel("Buscar Personal");
		lblNewLabel_1_1.setFont(new Font("KG Sorry Not Sorry", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(102, 123, 183, 34);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Registrar Reserva");
		lblNewLabel_1_1_1.setFont(new Font("KG Sorry Not Sorry", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(102, 168, 183, 34);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Factura");
		lblNewLabel_1_1_2.setFont(new Font("KG Sorry Not Sorry", Font.PLAIN, 18));
		lblNewLabel_1_1_2.setBounds(102, 213, 183, 34);
		contentPane.add(lblNewLabel_1_1_2);
	}
}
