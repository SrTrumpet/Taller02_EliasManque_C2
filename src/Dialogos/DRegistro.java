package Dialogos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.ListaUsuarios;
import Clases.Productos;
import Clases.Usuario;
import Ejecutable.InicioMain;
import Interfaces.InicioSesion;
import Logica.procesoRegistro;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class DRegistro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nomUsuario;
	private JTextField fullName;
	private JTextField correo;
	private JTextField contacto;
	private JTextField password;
	private JTextField passConfirm;
	
	protected static ArrayList<Productos> listaProduc = InicioMain.getListaProduc();
	protected static ArrayList<Usuario> listauser = InicioMain.getListauser();

	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DRegistro dialog = new DRegistro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DRegistro() {
		setTitle("VentasCoquimbo - Registro");
		setBounds(100, 100, 504, 401);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			nomUsuario = new JTextField();
			nomUsuario.setBounds(36, 56, 204, 25);
			contentPanel.add(nomUsuario);
			nomUsuario.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Nombre Usuario");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel.setBounds(36, 22, 204, 24);
			contentPanel.add(lblNewLabel);
		}
		{
			fullName = new JTextField();
			fullName.setBounds(249, 56, 196, 25);
			contentPanel.add(fullName);
			fullName.setColumns(10);
		}
		{
			correo = new JTextField();
			correo.setText("@gmail.com");
			correo.setBounds(36, 140, 204, 25);
			contentPanel.add(correo);
			correo.setColumns(10);
		}
		{
			contacto = new JTextField();
			contacto.setText("+569");
			contacto.setBounds(249, 140, 204, 25);
			contentPanel.add(contacto);
			contacto.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Nombre Completo");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setBounds(250, 22, 204, 24);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblCorreo = new JLabel("Correo");
			lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblCorreo.setBounds(36, 103, 204, 24);
			contentPanel.add(lblCorreo);
		}
		{
			JLabel lblContacto = new JLabel("Contacto");
			lblContacto.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblContacto.setBounds(249, 103, 204, 24);
			contentPanel.add(lblContacto);
		}
		{
			password = new JTextField();
			password.setBounds(36, 223, 204, 25);
			contentPanel.add(password);
			password.setColumns(10);
		}
		{
			passConfirm = new JTextField();
			passConfirm.setBounds(249, 223, 204, 25);
			contentPanel.add(passConfirm);
			passConfirm.setColumns(10);
		}
		{
			JLabel lblContrasea = new JLabel("Contrase\u00F1a");
			lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblContrasea.setBounds(36, 189, 204, 24);
			contentPanel.add(lblContrasea);
		}
		{
			JLabel lblConfirmarcontrasea = new JLabel("Confirmar Contrase\u00F1a");
			lblConfirmarcontrasea.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblConfirmarcontrasea.setBounds(249, 189, 204, 24);
			contentPanel.add(lblConfirmarcontrasea);
		}
		{
			JButton accionRegistro = new JButton("Registrarse");
			accionRegistro.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					
					
					
					String nombreUsuario = nomUsuario.getText();
					String nombreCompelto = fullName.getText();
					String correoUser = correo.getText();
					String contactoUser = contacto.getText();
					String contrasena = password.getText();
					String contrasenaConfirm = passConfirm.getText();
					
					int sumaCorrecta = 0;
					
					if(procesoRegistro.personaExiste(nombreUsuario)) {
						sumaCorrecta++;
						DVentanaErrorRegistroUsuarioExiste ventanaErrorUsuario = new DVentanaErrorRegistroUsuarioExiste();
						ventanaErrorUsuario.setVisible(rootPaneCheckingEnabled);

					}
					else if(nombreUsuario.length() < 4) {
						sumaCorrecta++;
						DRegistroErrorUsuario u = new DRegistroErrorUsuario();
						u.setVisible(rootPaneCheckingEnabled);
					}
					else if(nombreCompelto.length() < 6) {
						sumaCorrecta++;
						DRegistroErrorUsuario u = new DRegistroErrorUsuario();
						u.setVisible(rootPaneCheckingEnabled);
					}
					else if(correoUser.length() < 13) {
						DRegistroErrorCorreo c = new DRegistroErrorCorreo();
						c.setVisible(rootPaneCheckingEnabled);
					}					
					else if(contactoUser.length() != 12) {
						sumaCorrecta++;
						DRegistroErrorContacto ventanaErrorContacto = new DRegistroErrorContacto();
						ventanaErrorContacto.setVisible(rootPaneCheckingEnabled);						
					}					
					else if(procesoRegistro.personaExiste(nombreUsuario)) {
						sumaCorrecta++;
						DVentanaErrorRegistroUsuarioExiste ventanaErrorUsuario = new DVentanaErrorRegistroUsuarioExiste();
						ventanaErrorUsuario.setVisible(rootPaneCheckingEnabled);

					} 
					else if (contrasenaConfirm.length() == 0 || contrasena.length() == 0 ) {
						sumaCorrecta++;
						DVentanaErrorRegistro error = new DVentanaErrorRegistro();
						error.setVisible(rootPaneCheckingEnabled);
											
					}
					else if (!contrasena.equals(contrasenaConfirm)) {
						sumaCorrecta++;
						DVentanaErrorRegistro error = new DVentanaErrorRegistro();
						error.setVisible(rootPaneCheckingEnabled);
					}
					else if (sumaCorrecta == 0){
	
						Usuario u = new Usuario(nombreUsuario, contrasena, nombreCompelto, correoUser, contactoUser);
						listauser.add(u);
						
						try {
							procesoRegistro.saveTxt(listauser);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						
						
						
						DVentanaCorrectoRegistro registrado = new DVentanaCorrectoRegistro();
						registrado.setVisible(true);
						dispose();
						
					}
					
				}
			});
			accionRegistro.setFont(new Font("Tahoma", Font.BOLD, 15));
			accionRegistro.setBounds(135, 286, 204, 40);
			contentPanel.add(accionRegistro);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
	

}
