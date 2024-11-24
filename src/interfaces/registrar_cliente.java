package interfaces;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import base_de_datos.cliente_db;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

import hotel_transilvania_persona.Cliente;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class registrar_cliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtbNombreRegistro;
	private JTextField txtbApellidoRegistro;
	private JTextField txtbCIRegistro;
	private JTextField txtbCorreoRegistro;
	private JTextField txtbNumCelRegistro;
	private Cliente cliente;
	private cliente_db cliente_db;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrar_cliente frame = new registrar_cliente();
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
	public registrar_cliente() {
		
		cliente = new Cliente();
		cliente_db = new cliente_db();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 443, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRAR CLIENTE");
		lblNewLabel.setFont(new Font("KG Sorry Not Sorry Chub", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(118, 11, 177, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(47, 71, 77, 17);
		contentPane.add(lblNewLabel_1);
		
		txtbNombreRegistro = new JTextField();
		txtbNombreRegistro.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				cliente.setNombre(txtbNombreRegistro.getText().trim());
			}
		});
		
		txtbNombreRegistro.setBounds(201, 68, 127, 20);
		contentPane.add(txtbNombreRegistro);
		txtbNombreRegistro.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellido");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(47, 94, 77, 17);
		contentPane.add(lblNewLabel_1_1);
		
		txtbApellidoRegistro = new JTextField();
		txtbApellidoRegistro.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				cliente.setApellido(txtbApellidoRegistro.getText().trim());
			}
		});
		txtbApellidoRegistro.setColumns(10);
		txtbApellidoRegistro.setBounds(201, 94, 127, 20);
		contentPane.add(txtbApellidoRegistro);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("CI");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(47, 119, 77, 17);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtbCIRegistro = new JTextField();
		txtbCIRegistro.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				cliente.setCi(Integer.parseInt(txtbCIRegistro.getText().trim()));
			}
		});
		txtbCIRegistro.setBounds(201, 119, 127, 20);
		contentPane.add(txtbCIRegistro);
		txtbCIRegistro.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Correo");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(47, 143, 77, 17);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		txtbCorreoRegistro = new JTextField();
		txtbCorreoRegistro.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				cliente.setCorreo(txtbCorreoRegistro.getText().trim());
			}
		});
		txtbCorreoRegistro.setColumns(10);
		txtbCorreoRegistro.setBounds(201, 143, 127, 20);
		contentPane.add(txtbCorreoRegistro);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Numero de Celular");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1.setBounds(47, 166, 117, 17);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		txtbNumCelRegistro = new JTextField();
		txtbNumCelRegistro.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				cliente.setNum_celular(Integer.parseInt(txtbNumCelRegistro.getText()));
			}
		});
		txtbNumCelRegistro.setColumns(10);
		txtbNumCelRegistro.setBounds(201, 166, 127, 20);
		contentPane.add(txtbNumCelRegistro);
		
		JButton btnGuardarCliente = new JButton("Guardar");
		btnGuardarCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean guardadoExitoso = cliente_db.agregarCliente(cliente);
				btnGuardarCliente.setEnabled(false);
				if (guardadoExitoso) {
					
		            JOptionPane.showMessageDialog(registrar_cliente.this, 
		                    "Cliente guardado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				} else {
		            JOptionPane.showMessageDialog(registrar_cliente.this, 
		                    "Hubo un error al guardar, intentelo de nuevo", "Error", JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		btnGuardarCliente.setBounds(306, 237, 89, 23);
		contentPane.add(btnGuardarCliente);
		
		
	}

}
