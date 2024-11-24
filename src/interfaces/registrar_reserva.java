package interfaces;

import java.awt.EventQueue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import base_de_datos.cliente_db;
import base_de_datos.habitacion_db;
import hotel_transilvania.checks;
import hotel_transilvania.habitacion;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;

public class registrar_reserva extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtbNumNoches;
	private JTextField txtbNombreReserva;
	private JTextField txtbTotalReserva;
	private JTextField txtbCheckin;
	private JTextField txtbCheckout;
	private JTextField txtbCI;
	private JLabel lblMensajeCI;
	private JButton btnAgregarCliente;
	
	private cliente_db cliente_db;
	private habitacion habitacion;
	private checks checks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrar_reserva frame = new registrar_reserva();
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
	public registrar_reserva() {
		
		cliente_db = new cliente_db();
		habitacion = new habitacion();
		checks = new checks();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRAR RESERVA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("KG Sorry Not Sorry Chub", Font.PLAIN, 20));
		lblNewLabel.setBounds(203, 11, 157, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(39, 111, 87, 25);
		contentPane.add(lblNewLabel_1);
		
		btnAgregarCliente = new JButton("Agregar Cliente");
		btnAgregarCliente.setEnabled(false);
		btnAgregarCliente.setBounds(326, 114, 115, 23);
		contentPane.add(btnAgregarCliente);
		
		JLabel lblNewLabel_2 = new JLabel("Habitacion");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(39, 147, 103, 25);
		contentPane.add(lblNewLabel_2);
		
		JComboBox<habitacion> cbxHabitacionReserva = new JComboBox<>();
		cbxHabitacionReserva.setBounds(182, 149, 115, 22);
		contentPane.add(cbxHabitacionReserva);
		
		habitacion.desplegarHabitacionesDisp(cbxHabitacionReserva);
		habitacion habitacionEscogida = (habitacion) cbxHabitacionReserva.getSelectedItem();//habitacion escogida
		
		JLabel lblNewLabel_2_1 = new JLabel("Numero de Noches");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(39, 184, 142, 25);
		contentPane.add(lblNewLabel_2_1);
		
		txtbNumNoches = new JTextField();
		txtbNumNoches.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String noches = txtbNumNoches.getText();
				int numNoches = Integer.parseInt(noches);
				System.out.println(habitacionEscogida.getTarifa_noche());
				double total = habitacion.calcularPrecioNoches(habitacionEscogida.getTarifa_noche(), numNoches);
				String totalTotal = String.valueOf(total);
				txtbTotalReserva.setText(totalTotal+" Bs");
			}
		});
		txtbNumNoches.setBounds(182, 183, 112, 20);
		contentPane.add(txtbNumNoches);
		txtbNumNoches.setColumns(10);
		
		txtbTotalReserva = new JTextField();
		txtbTotalReserva.setBounds(182, 242, 112, 20);
		contentPane.add(txtbTotalReserva);
		txtbTotalReserva.setColumns(10);
		
		
		txtbNombreReserva = new JTextField();
		txtbNombreReserva.setColumns(10);
		txtbNombreReserva.setBounds(182, 115, 112, 20);
		contentPane.add(txtbNombreReserva);
		
		JLabel lblNewLabel_3 = new JLabel("Total");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(39, 243, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		
		JLabel lblNewLabel_1_1 = new JLabel("CI");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(39, 75, 87, 25);
		contentPane.add(lblNewLabel_1_1);
		
		lblMensajeCI = new JLabel("");
		lblMensajeCI.setForeground(new Color(128, 0, 0));
		lblMensajeCI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMensajeCI.setBounds(326, 75, 115, 14);
		contentPane.add(lblMensajeCI);

		
		txtbCI = new JTextField();
		txtbCI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCliente();
			}
		});
		txtbCI.setColumns(10);
		txtbCI.setBounds(182, 79, 112, 20);
		contentPane.add(txtbCI);
		
		JButton btnCheckin = new JButton("Check-in");
		btnCheckin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String fecha = checks.entregarFecha();
				txtbCheckin.setText(fecha);
				btnCheckin.setEnabled(false);
			}
		});
		btnCheckin.setBounds(39, 293, 89, 23);
		contentPane.add(btnCheckin);
		
		JButton btnCheckout = new JButton("Check-out");
		btnCheckout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String fecha = checks.entregarFecha();
				txtbCheckout.setText(fecha);
				btnCheckout.setEnabled(false);
			}
		});
		btnCheckout.setBounds(39, 320, 89, 23);
		contentPane.add(btnCheckout);
		
		txtbCheckin = new JTextField();
		txtbCheckin.setBounds(182, 294, 142, 20);
		contentPane.add(txtbCheckin);
		txtbCheckin.setColumns(10);
		
		txtbCheckout = new JTextField();
		txtbCheckout.setColumns(10);
		txtbCheckout.setBounds(182, 321, 142, 20);
		contentPane.add(txtbCheckout);
		
		JButton btnGuardarReserva = new JButton("Guardar Reserva");
		btnGuardarReserva.setBounds(376, 395, 131, 23);
		contentPane.add(btnGuardarReserva);
		
	}
	
	public void buscarCliente() {
		String ci = txtbCI.getText().trim();
		
		if (ci.isEmpty()) {
		lblMensajeCI.setText("Ingrese un CI válido");
		}
		
		String nombre = cliente_db.obtenerNombreConCI(ci);
		
		if (nombre!="") {
			txtbNombreReserva.setText(nombre);
			lblMensajeCI.setText("");
			btnAgregarCliente.setEnabled(false);
			
		} else {
			
			btnAgregarCliente.setEnabled(true);
			txtbNombreReserva.setText("");
			lblMensajeCI.setText("CI no registrado");
	
		}
	}
}
