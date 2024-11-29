package interfaces;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import base_datos.personalDB;
import hotel_transilvania_persona.Personal;


import javax.swing.JLabel; 
import javax.swing.JOptionPane; 
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton; 

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class registrar_personal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private personalDB pDB;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textCi;
	private JTextField textnum_celular;
	private JTextField textPuesto;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblci;
	private JLabel lblNum_celular;
	private JLabel lblPuesto;
	private JLabel lbltitulo;
	private JLabel lblTitulo;
	private JButton btnAgregar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrar_personal frame = new registrar_personal();
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
	public registrar_personal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbltitulo = new JLabel("REGISTRAR PERSONAL");
		lbltitulo.setOpaque(true);
		lbltitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitulo.setFont(new Font("KG Sorry Not Sorry Chub", Font.PLAIN, 31));
		lbltitulo.setBounds(139, 0, 232, 40);
		contentPane.add(lbltitulo);
		
		textNombre = new JTextField();
		textNombre.setBounds(237, 88, 96, 19);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(237, 128, 96, 19);
		contentPane.add(textApellido);
		
		textCi = new JTextField();
		textCi.setColumns(10);
		textCi.setBounds(237, 171, 96, 19);
		contentPane.add(textCi);
		
		textnum_celular = new JTextField();
		textnum_celular.setColumns(10);
		textnum_celular.setBounds(237, 216, 96, 19);
		contentPane.add(textnum_celular);
		
		textPuesto = new JTextField();
		textPuesto.setColumns(10);
		textPuesto.setBounds(237, 255, 96, 19);
		contentPane.add(textPuesto);
		
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma",Font.PLAIN,14));
		lblNombre.setBounds(50, 91, 71, 13);
		contentPane.add(lblNombre);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma",Font.PLAIN,14));
		lblApellido.setBounds(50, 131, 90, 13);
		contentPane.add(lblApellido);
		
		lblci = new JLabel("CI:");
		lblci.setFont(new Font("Tahoma",Font.PLAIN,14));
		lblci.setBounds(50, 174, 45, 13);
		contentPane.add(lblci);
		
		lblNum_celular = new JLabel("Numero Celular:");
		lblNum_celular.setFont(new Font("Tahoma",Font.PLAIN,14));
		lblNum_celular.setBounds(50, 219, 102, 13);
		contentPane.add(lblNum_celular);
		
		lblPuesto = new JLabel("Puesto:");
		lblPuesto.setFont(new Font("Tahoma",Font.PLAIN,14));
		lblPuesto.setBounds(50, 258, 71, 13);
		contentPane.add(lblPuesto);
		
		lblTitulo = new JLabel("REGISTRAR PERSONAL");
		lblTitulo.setFont(new Font("KG Sorry Not Sorry Chub", Font.PLAIN, 28));
		lblTitulo.setBounds(27, 10, 344, 32);
		contentPane.add(lblTitulo);
		
		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre = textNombre.getText();
				String apellido = textApellido.getText();
				int ci = Integer.parseInt(textCi.getText());
				int num_celular = Integer.parseInt(textnum_celular.getText());
				String puesto = textPuesto.getText();
				double salario = 2000;
				
				Personal nuevoPersonal = new Personal(nombre, apellido, ci, num_celular, puesto, salario);
				pDB.agregarPersonal(nuevoPersonal);
				
				JOptionPane.showMessageDialog(null, "Personal agregado correctamente");
				//dispose();// cerrar la ventana despues de agregar el personal
			}
		});
		btnAgregar.setBounds(232, 304, 111, 32);
		contentPane.add(btnAgregar);
	}
	
	public void setDB(personalDB pDB) {
		this.pDB = pDB;
		this.pDB =pDB;
	}
}
