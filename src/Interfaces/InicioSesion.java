package Interfaces;

import java.util.*;
import java.io.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.ListaProductos;
import Clases.ListaUsuarios;
import Clases.Usuario;
import Dialogos.DRegistro;
import Dialogos.DfalloInicioSesion;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InicioSesion extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField passwordField;
	
	protected static ListaUsuarios listaUser;
	protected static ListaProductos listaProducto;
	private static String usuarioInicio;

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		listaUser = new ListaUsuarios(100);
		listaProducto = new ListaProductos(100);
		agregarListaUsuario(listaUser);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesion frame = new InicioSesion();
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
	public InicioSesion() {
		setTitle("VentasCoquimbo - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(98, 53, 223, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(98, 158, 223, 44);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("No tienes una cuenta?");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(66, 266, 195, 25);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicioSesion();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(98, 324, 223, 41);
		contentPane.add(btnNewButton);
		
		user = new JTextField();
		user.setBounds(98, 96, 223, 35);
		contentPane.add(user);
		user.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(98, 203, 223, 35);
		contentPane.add(passwordField);
		
		JButton btnNewButton_1 = new JButton("Registrate");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DRegistro ventanaRegistro = new DRegistro();
				ventanaRegistro.setVisible(rootPaneCheckingEnabled);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(194, 269, 112, 25);
		contentPane.add(btnNewButton_1);
	}
	
	
	private void inicioSesion() {
		String usuario = user.getText();
		String password = passwordField.getText();
		
		String nombreUsuarios = listaUser.buscarPersonaString(usuario);
		String passwordConfirmar = listaUser.buscarContraseña(usuario);
		if (usuario.equals(null)) {
			DfalloInicioSesion ventanaError = new DfalloInicioSesion();
			ventanaError.setVisible(rootPaneCheckingEnabled);
		}
		else if (nombreUsuarios.equals(usuario)) {
			if(password.equals(passwordConfirmar)) {
				usuarioInicio = usuario;
				FrameVentas ventanaPrincipal = new FrameVentas();
				ventanaPrincipal.setVisible(true);
				dispose();
			}else {
				DfalloInicioSesion ventanaError = new DfalloInicioSesion();
				ventanaError.setVisible(rootPaneCheckingEnabled);
			}
		}else {
			DfalloInicioSesion ventanaError = new DfalloInicioSesion();
			ventanaError.setVisible(rootPaneCheckingEnabled);
		}
		
		/**
		
		procesoInicioSesion procesos = new procesoInicioSesion();
		
		String usuario = user.getText();
		System.out.println("EEEEE"+ usuario);
		String password = passwordField.getText();
		System.out.println("EEEEE"+ password);
		
		
		boolean valor = procesos.inicioSesion(usuario, password);
		if (valor == false) {
			DfalloInicioSesion ventanaError = new DfalloInicioSesion();
			ventanaError.setVisible(rootPaneCheckingEnabled);
		}else if (valor == true){
			FrameVentas inicioPrograme = new FrameVentas();
			inicioPrograme.setVisible(true);
		}*/
	}
	
	public static void agregarListaUsuario(ListaUsuarios lista) throws IOException  {
			
			File arch = new File("usuarios.txt");
			Scanner leer = new Scanner(arch);
			
			while (leer.hasNextLine()) {
				String linea = leer.nextLine();
				String[] datos = linea.split(",");
				
				String usuario = datos[0];
				String password = datos[1];
				String fullName = datos[2];
				String correo = datos[3];
				String contacto = datos[4];
				
				Usuario u = new Usuario(usuario, password, fullName, correo, contacto);
				lista.agregarUsuario(u);
				
			}
			leer.close();
			
		}
		
	
	public static ListaUsuarios getLista() {
		return listaUser;
	}
	
	public static String getUsuarioInicio() {
		return usuarioInicio;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
