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
	private DefaultTableModel tableModel;
	private JTable table;
	
	private gestionar_personal mi_gestion_personal;
	private personalDB pDB;
	private DefaultTableModel model;
	private JButton btnBuscar_personal;
	private JLabel lbltitulo_2;
	private JTextField txtBuscar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mostrar_Datos frame = new Mostrar_Datos();
					frame.setVisible(true);
					
					// Inicializar gestionar_personal y cargar datos
					gestionar_personal gestionPersonal = new gestionar_personal();
					Personal personal1 = new Personal("Oscar", "Robles", 2310, 76446, "Manager", 25005.0); 
					Personal personal2 = new Personal("Belinda", "Mena", 312313, 25350, "Cajera 1", 2500.0);
					gestionPersonal.agregar_personal(personal1);
					gestionPersonal.agregar_personal(personal2);
					frame.setProcesos(gestionPersonal); 
					frame.llenar_tabla();
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
		setBounds(100, 100, 554, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbltitulo = new JLabel("LISTA DEL PERSONAL");
		lbltitulo.setBackground(new Color(0, 0, 0));
		lbltitulo.setForeground(new Color(255, 255, 255));
		lbltitulo.setOpaque(true);
		lbltitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitulo.setFont(new Font("Ink Free", Font.PLAIN, 31));
		lbltitulo.setBounds(0, 0, 541, 45);
		contentPane.add(lbltitulo);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 110, 541, 382);
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
					int ci =Integer.parseInt(entrada);   //se transforma el  texto a int para verificar el ci dentro de la base
					Personal personal = pDB.obtenerDatosPorCI(ci);
					
	
						if(personal != null) {
							JOptionPane.showMessageDialog(null, "Personal encontrado:\n"
						          + "Nombre: "+ personal.getNombre()+"\n"
						          + "Apellido: "+ personal.getApellido()+"\n"
						          + "Num celular: "+ personal.getNum_celular()+"\n"
						          + "Puesto: "+personal.getPuesto()+"\n"
						          + "Sueldo minimo: "+personal.getSueldo_min()+"Resultado",JOptionPane.INFORMATION_MESSAGE);
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
		btnBuscar_personal.setBounds(413, 68, 85, 21);
		contentPane.add(btnBuscar_personal);
		
		lbltitulo_2 = new JLabel("Ingrese el ci del personal al que busca:");
		lbltitulo_2.setBounds(10, 68, 208, 21);
		contentPane.add(lbltitulo_2);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(227, 69, 149, 21);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		//inicializar el personalDB
		pDB = new personalDB();

	}
	//llama a la clase gesion de personal, del extrae la lista
    public void setProcesos(gestionar_personal mi_gestion_personal) {
		this.mi_gestion_personal = mi_gestion_personal;
	}
    
    
	public void llenar_tabla() {
		if(mi_gestion_personal == null) {
			System.err.println("Error: mi_gestion_personal no ha sido inicializado.");
			return;
		}
		List<Personal> lista_personal = mi_gestion_personal.getlisList();
		
		for(Personal personal: lista_personal) {
			Object[] fila = new Object[6];
			fila[0]=personal.getNombre();
			fila[1] = personal.getApellido();
			fila[2] = personal.getCi();
			fila[3] = personal.getNum_celular();
			fila[4]=personal.getPuesto();
			fila[5]=personal.getSueldo_min();
			
			model.addRow(fila);
		}
	}

	
}
