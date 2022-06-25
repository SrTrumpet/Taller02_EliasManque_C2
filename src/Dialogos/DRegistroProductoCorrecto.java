package Dialogos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

public class DRegistroProductoCorrecto extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DRegistroProductoCorrecto dialog = new DRegistroProductoCorrecto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DRegistroProductoCorrecto() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(DRegistroProductoCorrecto.class.getResource("/Imagenes/correcto.png")));
		lblNewLabel_1.setBounds(167, 50, 96, 96);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblProductoSubido = new JLabel("Producto publicado");
		lblProductoSubido.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductoSubido.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProductoSubido.setBounds(23, 138, 388, 68);
		contentPanel.add(lblProductoSubido);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
