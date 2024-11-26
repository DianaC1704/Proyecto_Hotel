package interfaces;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import base_de_datos.habitacion_db;
import hotel_transilvania.habitacion;
import base_de_datos.cliente_db;

public class Factura extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtbCIFactura;
	private JTextField txtbClienteFactura;
	private JTextField txtbFechaFactura;
	private JTextField txtbTotalFactura;
	private JTable table;
	private habitacion_db habitacion_db;
	private cliente_db cliente_db;
	private List<habitacion> habitacionesCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Factura frame = new Factura();
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
	public Factura() {
		this.habitacion_db = new habitacion_db();
		cliente_db = new cliente_db();
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FACTURA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("KG Sorry Not Sorry Chub", Font.PLAIN, 20));
		lblNewLabel.setBounds(216, 11, 96, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CI");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(39, 63, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("SERVICIO");
		model.addColumn("ITEMS");
		model.addColumn("PRECIO");
		
		
		table = new JTable(model);
		table.setBounds(39, 183, 465, 92);
		contentPane.add(table);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(39, 183, 465, 92);
		contentPane.add(scrollPane);
		
		txtbCIFactura = new JTextField();
		txtbCIFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtbClienteFactura.setText("");
				model.setRowCount(0);
				
				String CI = txtbCIFactura.getText();
				
		        boolean clienteExiste = cliente_db.existeCliente(CI);  
		        
		        if (!clienteExiste) {
		            JOptionPane.showMessageDialog(null, "El CI ingresado no se encuentra en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
		            return; 
		        }
				
				String apellido = cliente_db.obtenerApellidoConCI(CI);
				txtbClienteFactura.setText(apellido);
		        LocalDate fechaHoy = LocalDate.now();
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		        String fechaHoyStr = fechaHoy.format(formatter);
				txtbFechaFactura.setText(fechaHoyStr);
				habitacionesCliente = habitacion_db.obtenerHabitacionesCliente(CI);
				if(habitacionesCliente != null && !habitacionesCliente.isEmpty()) {
					for(habitacion hab : habitacionesCliente) {
						model.addRow(new Object[] {
								"RESERVA", "Habitacion "+hab.getNum_habitacion(), hab.getTarifa_noche()
						});
					}
				}
				
				double total=0;
				
				int rowCount = model.getRowCount(); 
				for (int i = 0; i < rowCount; i++) {
				    Object precio = model.getValueAt(i, 2);
				    total += ((Number) precio).doubleValue();
				}
				
				String totalStr = total + " Bs";
				txtbTotalFactura.setText(totalStr);
			}
		});
		txtbCIFactura.setBounds(125, 62, 127, 20);
		contentPane.add(txtbCIFactura);
		txtbCIFactura.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cliente");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(39, 91, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtbClienteFactura = new JTextField();
		txtbClienteFactura.setColumns(10);
		txtbClienteFactura.setBounds(125, 90, 127, 20);
		contentPane.add(txtbClienteFactura);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Fecha");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(39, 116, 46, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtbFechaFactura = new JTextField();
		txtbFechaFactura.setColumns(10);
		txtbFechaFactura.setBounds(125, 115, 127, 20);
		contentPane.add(txtbFechaFactura);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Detalle:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(39, 158, 46, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Total:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(366, 302, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtbTotalFactura = new JTextField();
		txtbTotalFactura.setBounds(418, 301, 86, 20);
		contentPane.add(txtbTotalFactura);
		txtbTotalFactura.setColumns(10);
		
				
		JButton btnGuardarFactura = new JButton("Terminar");
		btnGuardarFactura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnGuardarFactura.setBounds(440, 349, 89, 23);
		contentPane.add(btnGuardarFactura);
		
	}
}
