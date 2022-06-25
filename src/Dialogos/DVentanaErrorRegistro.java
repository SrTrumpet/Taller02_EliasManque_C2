package Dialogos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class DVentanaErrorRegistro extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			
			DVentanaErrorRegistro dialog = new DVentanaErrorRegistro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DVentanaErrorRegistro() {
		setBounds(100, 100, 435, 239);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel iconoError = new JLabel("");
		iconoError.setIcon(new ImageIcon(DVentanaErrorRegistro.class.getResource("/Imagenes/error.png")));
		iconoError.setBounds(165, 42, 96, 96);
		contentPanel.add(iconoError);
		{
			JLabel lblNewLabel = new JLabel("Error, Contrase\u00F1a no Coincide");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(65, 114, 313, 55);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
