package interfaces;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import base_datos.personalDB;
import hotel_transilvania_persona.Personal;
import hotel_transilvania_persona.gestionar_personal;

import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mostrar_Datos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbltitulo;
	private JScrollPane scrollPane;
	private JTable tabla_personal;
	
	private personalDB pDB;
	private DefaultTableModel model;
	private JButton btnBuscar_personal;
	private JLabel lbltitulo_2;
	private JTextField txtBuscar;
	private JButton btnAgregar_personal;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mostrar_Datos frame = new Mostrar_Datos();
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
	public Mostrar_Datos() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 630, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbltitulo = new JLabel("LISTA DEL PERSONAL");
		lbltitulo.setOpaque(true);
		lbltitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitulo.setFont(new Font("KG Sorry Not Sorry Chub", Font.PLAIN, 31));
		lbltitulo.setBounds(37, 0, 541, 45);
		contentPane.add(lbltitulo);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 132, 596, 382);
		contentPane.add(scrollPane);

		tabla_personal = new JTable();
			
		model = new DefaultTableModel();
		tabla_personal.setModel(model);
		
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Ci");
		model.addColumn("Celular");
		model.addColumn("Puesto");
		model.addColumn("Salario");
				
		scrollPane.setViewportView(tabla_personal);
		
		btnBuscar_personal = new JButton("BUSCAR");
		
		btnBuscar_personal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//pDB.buscarPersonalPorCI(Integer.parseInt(btnBuscar_personal.getText()));
				String entrada = txtBuscar.getText();
			
				try {
					int ci =Integer.parseInt(entrada);
					Personal personal = pDB.obtenerDatosPorCI(ci);
					
						if(personal != null) {
							pDB.buscarPersonalPorCI(ci);
							
							JOptionPane.showMessageDialog(null, "Personal encontrado:\n"
						          + "Nombre: "+ personal.getNombre()+"\n"
						          + "Apellido: "+ personal.getApellido()+"\n"
						          + "Num celular: "+ personal.getNum_celular()+"\n"
						          + "Puesto: "+personal.getPuesto()+"\n"
						          + "salario: "+personal.getsalario()+"Resultado",entrada, JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "No se encontro al personal con el CI: "+ci+" Resultado", entrada, JOptionPane.INFORMATION_MESSAGE);
						}				
				}catch (NumberFormatException ex) {
					// TODO: handle exception
					System.err.print("La entrada no es un numero valido"+entrada);
					JOptionPane.showMessageDialog(null, "Porfavor, introduzca un numero valido. ","ERROR", JOptionPane.ERROR_MESSAGE);
				}
			
			}
		});
		
		btnBuscar_personal.setBounds(402, 101, 102, 21);
		contentPane.add(btnBuscar_personal);
		
		lbltitulo_2 = new JLabel("Ingrese el ci del personal al que busca:");
		lbltitulo_2.setFont(new Font("Tahoma",Font.PLAIN,14) );
		lbltitulo_2.setBounds(100, 55, 246, 30);
		contentPane.add(lbltitulo_2);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(145, 101, 201, 21);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		btnAgregar_personal = new JButton("AGREGAR");
		btnAgregar_personal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				registrar_personal registrar_personal = new registrar_personal();
				registrar_personal.setDB(pDB);
				registrar_personal.setVisible(true);
			}
		});
		btnAgregar_personal.setBounds(402, 55, 102, 21);
		contentPane.add(btnAgregar_personal);

	}
	
	//metodo para establecer la instancia de personalDB
	public void setDB(personalDB pDB){
		this.pDB = pDB;
	}
	
	public void llenan_tabla() {
		if(pDB == null) {
			System.err.println("Error: personlaDB no ha sido inicializado.");
			return;
		}
	
	List<Personal> lista_Personal = pDB.getAllPersonal();
	for(Personal personal : lista_Personal) {
		Object[] fila = new Object[6];
		fila[0] = personal.getNombre();
		fila[1] = personal.getApellido();
		fila[2] = personal.getCi();
		fila[3] = personal.getNum_celular();
		fila[4] = personal.getPuesto();
		fila[5] = personal.getsalario();
		
		model.addRow(fila);
	}
	
   }
}
