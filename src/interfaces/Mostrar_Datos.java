package interfaces;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import hotel_transilvania_persona.Personal;
import hotel_transilvania_persona.gestionar_personal;

import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import java.awt.Color;

public class Mostrar_Datos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbltitulo;
	private JScrollPane scrollPane;
	private JTable tabla_personal;
	private DefaultTableModel tableModel;
	private JTable table;
	
	 gestionar_personal mi_gestion_personal;
	 
	private DefaultTableModel model;
	
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
		setBounds(100, 100, 598, 343);
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
		lbltitulo.setBounds(21, 0, 541, 45);
		contentPane.add(lbltitulo);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(19, 95, 541, 382);
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
