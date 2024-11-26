package interfaces;

import java.awt.EventQueue;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import base_de_datos.cliente_db;
import base_de_datos.habitacion_db;
import base_de_datos.reserva_db;
import hotel_transilvania.checks;
import hotel_transilvania.habitacion;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
	private habitacion_db habitacion_db;
	private checks checks;
	private JList<habitacion> listHabitaciones;
	private DefaultListModel<habitacion> model;
	private List<habitacion> seleccionadas;
	private JSpinner dateSpinner;
	private reserva_db reserva_db;


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
		habitacion_db = new habitacion_db();
		checks = new checks();
		List<habitacion> seleccionadas = new ArrayList<>();
		reserva_db = new reserva_db();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 615, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRAR RESERVA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("KG Sorry Not Sorry Chub", Font.PLAIN, 20));
		lblNewLabel.setBounds(223, 11, 157, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cliente");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(39, 111, 87, 25);
		contentPane.add(lblNewLabel_1);
		
		btnAgregarCliente = new JButton("Registrar Cliente");
		btnAgregarCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				registrar_cliente registrarCliente = new registrar_cliente();
				registrarCliente.setVisible(true);
			}
		});
		btnAgregarCliente.setEnabled(false);
		btnAgregarCliente.setBounds(347, 114, 142, 23);
		contentPane.add(btnAgregarCliente);
		
		JLabel lblNewLabel_2 = new JLabel("Eleccion habitacion(es):");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(347, 148, 177, 25);
		contentPane.add(lblNewLabel_2);
		

		
		JLabel lblNewLabel_2_1 = new JLabel("Numero de Noches");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(39, 268, 142, 25);
		contentPane.add(lblNewLabel_2_1);
		
		
		txtbNombreReserva = new JTextField();
		txtbNombreReserva.setColumns(10);
		txtbNombreReserva.setBounds(182, 115, 134, 20);
		contentPane.add(txtbNombreReserva);
		
		JLabel lblNewLabel_3 = new JLabel("Total");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(39, 304, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		
		JLabel lblNewLabel_1_1 = new JLabel("CI");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(39, 75, 87, 25);
		contentPane.add(lblNewLabel_1_1);
		
		lblMensajeCI = new JLabel("");
		lblMensajeCI.setHorizontalAlignment(SwingConstants.LEFT);
		lblMensajeCI.setForeground(new Color(128, 0, 0));
		lblMensajeCI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMensajeCI.setBounds(347, 75, 211, 28);
		contentPane.add(lblMensajeCI);

		
		txtbCI = new JTextField();
		txtbCI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCliente();
			}
		});
		
		txtbCI.setColumns(10);
		txtbCI.setBounds(182, 79, 134, 20);
		contentPane.add(txtbCI);
		
		
		JLabel lblNewLabel_2_2 = new JLabel("Fecha de Inicio");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(39, 174, 103, 25);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Fecha de Fin");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1.setBounds(39, 207, 103, 25);
		contentPane.add(lblNewLabel_2_2_1);
		
		
		List<habitacion> habitaciones = habitacion_db.obtenerHabitacionesDisp();
		model = new DefaultListModel<>();
		for(habitacion habitacion : habitaciones) {
			model.addElement(habitacion);
		}
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(347, 174, 211, 139); 
		contentPane.add(scrollPane);
		
		listHabitaciones = new JList<>(model);
		scrollPane.setViewportView(listHabitaciones);
		listHabitaciones.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);  // Permitir selección múltiple
		listHabitaciones.setVisibleRowCount(10);
		
        listHabitaciones.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { //comprobacion si ya termino el ajuste de la seleccion
                	
                    List<habitacion> seleccionadasTemp = listHabitaciones.getSelectedValuesList();
                    
                    for (habitacion hab : seleccionadasTemp) {
                        if (!seleccionadas.contains(hab)) {
                            seleccionadas.add(hab);  // Agrega solo si no está ya en la lista de habitaciones seleccionadas
                            ((DefaultListModel<habitacion>)listHabitaciones.getModel()).removeElement(hab);//eliminar de la lista que se muestra al usuario
                        }
                        //System.out.println("Habitaciones seleccionadas: "+seleccionadas);
                    }
                }
            }
        });
    
        
		SpinnerNumberModel diaModel = new SpinnerNumberModel(31, 1, 31, 1); 
		JSpinner spDiaInicio = new JSpinner(diaModel);
		spDiaInicio.setBounds(182, 178, 39, 20);
		contentPane.add(spDiaInicio);
		
		SpinnerNumberModel mesModel = new SpinnerNumberModel(12, 1, 12, 1); 
		JSpinner spMesInicio = new JSpinner(mesModel);
		spMesInicio.setBounds(228, 178, 39, 20);
		contentPane.add(spMesInicio);
		
		SpinnerNumberModel yearModel = new SpinnerNumberModel(24, 1, 99, 1); 
		JSpinner spYearInicio = new JSpinner(yearModel);
		spYearInicio.setBounds(277, 178, 39, 20);
		contentPane.add(spYearInicio);
		
		JLabel lblNewLabel_4 = new JLabel("Dia");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(182, 153, 26, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Mes");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4_1.setBounds(229, 154, 26, 14);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Año");
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4_2.setBounds(279, 154, 26, 14);
		contentPane.add(lblNewLabel_4_2);
		
		SpinnerNumberModel diaModel2 = new SpinnerNumberModel(31, 1, 31, 1); 
		JSpinner spDiaFin = new JSpinner(diaModel2);
		spDiaFin.setBounds(182, 211, 39, 20);
		contentPane.add(spDiaFin);
		
		SpinnerNumberModel yearModel2 = new SpinnerNumberModel(24, 1, 99, 1); 
		JSpinner spYearFin = new JSpinner(yearModel2);
		spYearFin.setBounds(277, 211, 39, 20);
		contentPane.add(spYearFin);
		
		SpinnerNumberModel mesModel2 = new SpinnerNumberModel(12, 1, 12, 1);
		JSpinner spMesFin = new JSpinner(mesModel2);
		spMesFin.setBounds(228, 211, 39, 20);
		contentPane.add(spMesFin);
		
		JButton btnLimpiarSeleccion = new JButton("Limpiar Seleccion");
		btnLimpiarSeleccion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listHabitaciones.clearSelection();
				model.clear();
				List<habitacion> habitaciones = habitacion_db.obtenerHabitacionesDisp();
				for(habitacion habitacion : habitaciones) {
					model.addElement(habitacion);
				}
				seleccionadas.clear();
				
				
			}
		});
		btnLimpiarSeleccion.setBounds(347, 325, 126, 23);
		contentPane.add(btnLimpiarSeleccion);
		
		txtbNumNoches = new JTextField();
		txtbNumNoches.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String noches = txtbNumNoches.getText();
				int numNoches = Integer.parseInt(noches);
				
				double total = habitacion.calcularPrecioNoches(seleccionadas, numNoches);
				String totalTotal = String.valueOf(total);
				txtbTotalReserva.setText(totalTotal+" Bs");
			}
		});
		txtbNumNoches.setBounds(182, 272, 56, 20);
		contentPane.add(txtbNumNoches);
		txtbNumNoches.setColumns(10);
		
		txtbTotalReserva = new JTextField();
		txtbTotalReserva.setBounds(182, 303, 56, 20);
		contentPane.add(txtbTotalReserva);
		txtbTotalReserva.setColumns(10);
		
		JButton btnGuardarReserva = new JButton("Guardar");
		btnGuardarReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String diaIn = spDiaInicio.getValue()+"";
				String mesIn = spMesInicio.getValue()+"";
				String yearIn = spMesInicio.getValue()+"";
				String diaFin = spDiaFin.getValue()+"";
				String mesFin = spMesFin.getValue()+"";
				String yearFin = spYearFin.getValue()+"";
				String fechaIn = diaIn+"-"+mesIn+"-"+"20"+yearIn;
				String fechaFin = diaFin+"-"+mesFin+"-"+"20"+yearFin;
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDate fechaI = LocalDate.parse(fechaIn,formatter);
				LocalDate fechaF = LocalDate.parse(fechaFin,formatter);
				int n = Integer.parseInt(txtbNumNoches.getText().trim());
				reserva_db.registrarReserva(txtbCI.getText().trim(), fechaI, fechaF, n, seleccionadas);
				//JOptionPane.showMessageDialog(null, "Reserva registrada con exito", "Registro de reserva", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		});
		btnGuardarReserva.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuardarReserva.setBounds(474, 374, 115, 25);
		contentPane.add(btnGuardarReserva);
	}
	
	
	
	public void buscarCliente() {
		String ci = txtbCI.getText().trim();
		
		if (ci.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Ingrese un CI válido", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		
		String apellido = cliente_db.obtenerApellidoConCI(ci);
		
		if (apellido!="") {
			txtbNombreReserva.setText(apellido);
			lblMensajeCI.setText("");
			btnAgregarCliente.setEnabled(false);
			
		} else {
			
			btnAgregarCliente.setEnabled(true);
			txtbNombreReserva.setText("");
			lblMensajeCI.setText("CI no registrado");
			//JOptionPane.showMessageDialog(null, "CI no registrado", "!", JOptionPane.INFORMATION_MESSAGE);
	
		}
	}
}
