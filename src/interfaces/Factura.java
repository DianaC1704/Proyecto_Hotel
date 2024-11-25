package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class Factura extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtbNombreFactura;
	private JTextField txtbNITFactura;
	private JTextField txtbFechaFactura;
	private JTextField txtbTotalFactura;
	private JTable table;

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
		
		JLabel lblNewLabel_1 = new JLabel("Cliente");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(39, 63, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtbNombreFactura = new JTextField();
		txtbNombreFactura.setBounds(125, 62, 127, 20);
		contentPane.add(txtbNombreFactura);
		txtbNombreFactura.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("NIT");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(39, 91, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtbNITFactura = new JTextField();
		txtbNITFactura.setColumns(10);
		txtbNITFactura.setBounds(125, 90, 127, 20);
		contentPane.add(txtbNITFactura);
		
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
		
		table = new JTable();
		table.setBounds(39, 183, 464, 92);
		contentPane.add(table);
		
		JButton btnGuardarFactura = new JButton("Guardar");
		btnGuardarFactura.setBounds(223, 349, 89, 23);
		contentPane.add(btnGuardarFactura);
	}
}
