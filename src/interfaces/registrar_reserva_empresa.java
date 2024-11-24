package interfaces;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JTextField;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

public class registrar_reserva_empresa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblfondo = new JLabel("");
	private JLabel lblregiostrar_reserva_empresa;
	private JTextField textField;
	private JMenuItem mntmNewMenuItem;
	private JLabel lblnombre_empresa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrar_reserva_empresa frame = new registrar_reserva_empresa();
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
	public registrar_reserva_empresa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblnombre_empresa = new JLabel("Nombre empresa(cliente):");
		lblnombre_empresa.setBounds(35, 72, 169, 23);
		contentPane.add(lblnombre_empresa);
		
		mntmNewMenuItem = new JMenuItem("lol");
		mntmNewMenuItem.setBounds(210, 150, 348, 35);
		contentPane.add(mntmNewMenuItem);
		
		
		lblregiostrar_reserva_empresa = new JLabel("REGISTRAR RESERVA");
		lblregiostrar_reserva_empresa.setVerticalAlignment(SwingConstants.TOP);
		lblregiostrar_reserva_empresa.setBackground(new Color(0, 0, 0));
		lblregiostrar_reserva_empresa.setFont(new Font("Times New Roman",Font.PLAIN,28));
		lblregiostrar_reserva_empresa.setBounds(202, 10, 348, 35);
		contentPane.add(lblregiostrar_reserva_empresa);
		lblfondo.setIcon(new ImageIcon(registrar_reserva_empresa.class.getResource("/imagenes/fondo_2.jpg")));
		lblfondo.setBounds(0, 10, 728, 556);
		contentPane.add(lblfondo);
		
		textField = new JTextField();
		textField.setBounds(266, 66, 385, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
	}
}
