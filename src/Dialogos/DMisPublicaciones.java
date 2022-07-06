package Dialogos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import Clases.Productos;
import Clases.Usuario;
import Ejecutable.InicioMain;
import Interfaces.InicioSesion;
import Logica.procesoInicioSesion;

import javax.swing.SwingConstants;

public class DMisPublicaciones extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableMisPublicaciones;
	private static DefaultTableModel miTabla;
	private static int totalProductos=0;
	
	private static ArrayList<Productos> listaP = InicioMain.getListaProduc();
	private static ArrayList<Usuario> listaU = InicioMain.getListauser();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DMisPublicaciones dialog = new DMisPublicaciones();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DMisPublicaciones() {
		setTitle("VentasCoquimbo - Mis Publicaciones");
		setBounds(100, 100, 669, 428);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnNewButton = new JButton("Editar Producto");
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewButton.setBounds(10, 297, 251, 33);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton_1 = new JButton("Borrar Producto");
			btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewButton_1.setBounds(394, 297, 251, 33);
			contentPanel.add(btnNewButton_1);
		}
		{
			JLabel lblNewLabel = new JLabel("Cantidad de Ventas: " + totalVentas(totalProductos));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel.setBounds(216, 340, 194, 31);
			contentPanel.add(lblNewLabel);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 97, 635, 178);
			contentPanel.add(scrollPane);
			{
				
				tableMisPublicaciones = new JTable();
				
				miTabla = new DefaultTableModel();
				
				tableMisPublicaciones.setModel(miTabla);
				
				miTabla.addColumn("ID");
				miTabla.addColumn("Nombre");
				miTabla.addColumn("Categoria");
				miTabla.addColumn("Fecha");
				miTabla.addColumn("VedidasS_N");
				
				scrollPane.setViewportView(tableMisPublicaciones);
			}
		}
		{
			
			JLabel nombreCompleto = new JLabel("Nombre: "+ procesoInicioSesion.buscarUsuario(InicioSesion.getUsuarioInicio()).getFullName());
			nombreCompleto.setHorizontalAlignment(SwingConstants.CENTER);
			nombreCompleto.setBounds(394, 10, 251, 25);
			contentPanel.add(nombreCompleto);
		}
		{
			int i = InicioSesion.getIndex();
			System.out.println(i);
			JLabel lblNewLabel_1 = new JLabel("Numero: "+listaU.get(i).getContacto());
			lblNewLabel_1.setBounds(10, 16, 231, 25);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Publicaciones");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(220, 74, 203, 25);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
	
	
	public static void llenarTabla() {
		
		String nombre = InicioSesion.getUsuarioInicio();
		
		for (Productos valores : listaP) {
			Object[] filas = new Object[5];
			if (nombre.equals(valores.getNomUsuario())) {
				filas[0] = valores.getId();
				filas[1] = valores.getNomProducto();
				filas[2] = valores.getCategoria();
				filas[3] = valores.getFecha();
				filas[4] = "No";
				miTabla.addRow(filas);
			}
		}
	}
	
	public int totalVentas(int i) {
		String nombre = InicioSesion.getUsuarioInicio();
		for (Productos valores : listaP) {
			if (nombre.equals(valores.getNomUsuario())) {
				i++;
			}
		}
		return i;
	}

	
	
	
	
	
	
	
	
	
	

}
