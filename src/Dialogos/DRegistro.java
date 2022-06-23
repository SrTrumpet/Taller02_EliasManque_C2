package Dialogos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class DRegistro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
		setBounds(100, 100, 504, 401);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField = new JTextField();
			textField.setBounds(36, 56, 204, 25);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Nombre Usuario");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel.setBounds(36, 22, 204, 24);
			contentPanel.add(lblNewLabel);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(249, 56, 196, 25);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(36, 140, 204, 25);
			contentPanel.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			textField_3 = new JTextField();
			textField_3.setBounds(249, 140, 204, 25);
			contentPanel.add(textField_3);
			textField_3.setColumns(10);
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
			textField_4 = new JTextField();
			textField_4.setBounds(36, 223, 204, 25);
			contentPanel.add(textField_4);
			textField_4.setColumns(10);
		}
		{
			textField_5 = new JTextField();
			textField_5.setBounds(249, 223, 204, 25);
			contentPanel.add(textField_5);
			textField_5.setColumns(10);
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
			JButton btnNewButton = new JButton("Registrarse");
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewButton.setBounds(135, 286, 204, 40);
			contentPanel.add(btnNewButton);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

}
