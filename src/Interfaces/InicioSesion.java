package Interfaces;

import java.util.*;
import java.io.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import Clases.Productos;
import Clases.Usuario;
import Dialogos.DRegistro;

import Ejecutable.InicioMain;
import Logica.procesoInicioSesion;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class InicioSesion extends JFrame{

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField passwordField;
	
	protected static ArrayList<Productos> listaProduc = InicioMain.getListaProduc();
	protected static ArrayList<Usuario> listauser = InicioMain.getListauser();
	private static String usuarioInicio;
	private static int index = 0;

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

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
		
		JButton botonIngresar = new JButton("Ingresar");
		botonIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String usuario = user.getText();
				
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();
				
				if(procesoInicioSesion.inicioSesionI(usuario,password)) {
					usuarioInicio = usuario;
					index = procesoInicioSesion.indiceUsuario(usuario);
					FrameVentas ventanaPrincipal = new FrameVentas();
					FrameVentas.llenarTabla();
					ventanaPrincipal.setVisible(true);
					dispose();
				}
			}
		});
		botonIngresar.setFont(new Font("Tahoma", Font.BOLD, 15));
		botonIngresar.setBounds(98, 324, 223, 41);
		contentPane.add(botonIngresar);
		
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
	
	public static String getUsuarioInicio() {
		return usuarioInicio;
	}

	public static int getIndex() {
		return index;
	}

		
	
}
