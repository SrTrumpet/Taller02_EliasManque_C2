package Dialogos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Scrollbar;
import javax.swing.JScrollBar;
import java.awt.List;
import javax.swing.JScrollPane;

public class DInfProducto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DInfProducto dialog = new DInfProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DInfProducto() {
		setTitle("VentasCoquimbo - Info Producto");
		setBounds(100, 100, 801, 437);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\"Nombre Producto\"");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 26, 164, 25);
		contentPanel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(244, 114, 515, 181);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Fecha", "Nombre Usuario"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Comprar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(10, 343, 208, 37);
		contentPanel.add(btnNewButton);
		
		JLabel descripcionDInfo = new JLabel("descrip");
		descripcionDInfo.setBounds(10, 197, 208, 86);
		contentPanel.add(descripcionDInfo);
		
		JLabel label = new JLabel("New label");
		label.setBounds(10, 320, 127, -6);
		contentPanel.add(label);
		
		JLabel precioDInf = new JLabel("precio");
		precioDInf.setBounds(20, 296, 140, 37);
		contentPanel.add(precioDInf);
		
		JLabel nomVendedorDInf = new JLabel("Vendedor");
		nomVendedorDInf.setBounds(246, 68, 157, 25);
		contentPanel.add(nomVendedorDInf);
		
		JLabel lblNewLabel_1 = new JLabel("cantacto");
		lblNewLabel_1.setBounds(474, 68, 115, 25);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("inf Vendedor");
		lblNewLabel_2.setBounds(244, 34, 226, 24);
		contentPanel.add(lblNewLabel_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
