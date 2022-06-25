package Dialogos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Interfaces.FrameVentas;
import Interfaces.InicioSesion;
import Logica.procesoRegistroProducto;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Choice;

public class DCrearVenta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nomProducto;
	private JTextField precioProducto;
	private Choice categoria;
	private JTextPane descripcionProducto;
	
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DCrearVenta dialog = new DCrearVenta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DCrearVenta() {
		setTitle("VentasCoquimbo - Publicar Producto");
		setBounds(100, 100, 663, 468);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombre");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel.setBounds(27, 24, 171, 38);
			contentPanel.add(lblNewLabel);
		}
		{
			nomProducto = new JTextField();
			nomProducto.setBounds(27, 60, 171, 26);
			contentPanel.add(nomProducto);
			nomProducto.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Precio");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setBounds(27, 106, 171, 38);
			contentPanel.add(lblNewLabel_1);
		}
		{
			precioProducto = new JTextField();
			precioProducto.setBounds(27, 154, 171, 26);
			contentPanel.add(precioProducto);
			precioProducto.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Descripcion");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_2.setBounds(27, 190, 171, 26);
			contentPanel.add(lblNewLabel_2);
		}
		
		descripcionProducto = new JTextPane();
		descripcionProducto.setText("....");
		descripcionProducto.setBounds(27, 222, 307, 86);
		contentPanel.add(descripcionProducto);
		
		JButton btnNewButton = new JButton("Registrar/Editar Publicacion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombreProducto = nomProducto.getText();
				String nombreUsuario = InicioSesion.getUsuarioInicio();
				String categoriaProducto = categoria.getSelectedItem();
				int precio =  Integer.parseInt(precioProducto.getText());
				String descripcion = descripcionProducto.getText();
				
				
				try {
					if(categoriaProducto.equals("-----")) {
						System.out.println(nombreUsuario);
						System.out.println("Elija una categoria");
					}
					else if(nombreProducto.equals("")) {
						System.out.println("Ingrese un nombre");
					}
					else if (!procesoRegistroProducto.agregarProducto(nombreProducto,nombreUsuario,categoriaProducto,precio,descripcion)) {
						procesoRegistroProducto.guardarTxtProducto();
					}
					
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(25, 353, 267, 35);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Subir Foto");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(344, 353, 267, 35);
		contentPanel.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(DCrearVenta.class.getResource("/Imagenes/icons8_gallery_96px_1.png")));
		lblNewLabel_3.setBounds(344, 106, 258, 229);
		contentPanel.add(lblNewLabel_3);
		{
			categoria = new Choice();
			categoria.setFont(new Font("Dialog", Font.PLAIN, 14));
			categoria.setBounds(204, 60, 171, 40);
			
			categoria.add("-----");
			categoria.add("Juego");
			categoria.add("Cocina u Hogar");
			categoria.add("Electrodomesticos");
			categoria.add("Herramienta");
			categoria.add("Moda");
			categoria.add("Oficina");
			categoria.add("Deporte y Fitness");
			categoria.add("Telefonia");
			categoria.add("Audio o Video");
			categoria.add("Computacion");
			categoria.add("Vehiculo");
			
			
			contentPanel.add(categoria);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Categoria");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_4.setBounds(208, 26, 171, 38);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
