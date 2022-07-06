package Interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Choice;
import java.awt.Panel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Clases.Productos;
import Dialogos.DCrearVenta;
import Dialogos.DInfProducto;
import Dialogos.DMisCompras;
import Dialogos.DMisPublicaciones;
import Ejecutable.InicioMain;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class FrameVentas extends JFrame {

	private JPanel contentPane;
	private JTable listaProducto;
	private static DefaultTableModel miTabla;
	public static ArrayList<Productos> listaP = InicioMain.getListaProduc();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameVentas frame = new FrameVentas();
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
	public FrameVentas() {
		setTitle("VentasCoquimbo - Perfil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ventanaCrearVenta = new JButton("Vender Producto");
		ventanaCrearVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DCrearVenta ventanaVentas = new DCrearVenta();
				ventanaVentas.setVisible(rootPaneCheckingEnabled);
			}
		});
		ventanaCrearVenta.setFont(new Font("Tahoma", Font.BOLD, 15));
		ventanaCrearVenta.setBounds(10, 437, 235, 33);
		contentPane.add(ventanaCrearVenta);
		
		JButton ventanaMisProductos = new JButton("Mis Publicaciones");
		ventanaMisProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DMisPublicaciones ventanaMisPublicaciones = new DMisPublicaciones();
				DMisPublicaciones.llenarTabla();
				ventanaMisPublicaciones.setVisible(rootPaneCheckingEnabled);
			}
		});
		ventanaMisProductos.setFont(new Font("Tahoma", Font.BOLD, 15));
		ventanaMisProductos.setBounds(10, 480, 235, 42);
		contentPane.add(ventanaMisProductos);
		
		JButton ventanaInfoProducto = new JButton("Inf. Producto");
		ventanaInfoProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DInfProducto ventanaProducto = new DInfProducto();
				ventanaProducto.setVisible(rootPaneCheckingEnabled);
			}
		});
		ventanaInfoProducto.setFont(new Font("Tahoma", Font.BOLD, 15));
		ventanaInfoProducto.setBounds(255, 437, 235, 33);
		contentPane.add(ventanaInfoProducto);
		
		JButton ventanaComprasRealizadas = new JButton("Mis Compras");
		ventanaComprasRealizadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DMisCompras ventanaCompras = new DMisCompras();
				ventanaCompras.setVisible(rootPaneCheckingEnabled);
			}
		});
		ventanaComprasRealizadas.setFont(new Font("Tahoma", Font.BOLD, 15));
		ventanaComprasRealizadas.setBounds(255, 480, 235, 42);
		contentPane.add(ventanaComprasRealizadas);
		
		JButton botonFiltrar = new JButton("Filtrar");
		botonFiltrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		botonFiltrar.setBounds(500, 480, 230, 42);
		contentPane.add(botonFiltrar);
		
		Choice catergoriaProducto = new Choice();
		catergoriaProducto.setFont(new Font("Dialog", Font.PLAIN, 18));
		catergoriaProducto.setBounds(496, 437, 234, 83);
		
		catergoriaProducto.add("-----");
		catergoriaProducto.add("Juego");
		catergoriaProducto.add("Cocina u Hogar");
		catergoriaProducto.add("Electrodomesticos");
		catergoriaProducto.add("Herramienta");
		catergoriaProducto.add("Moda");
		catergoriaProducto.add("Oficina");
		catergoriaProducto.add("Deporte y Fitness");
		catergoriaProducto.add("Telefonia");
		catergoriaProducto.add("Audio o Video");
		catergoriaProducto.add("Computacion");
		catergoriaProducto.add("Vehiculo");
		
		contentPane.add(catergoriaProducto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 76, 720, 351);
		contentPane.add(scrollPane);
		
		listaProducto = new JTable();
		
		miTabla = new DefaultTableModel();
		
		listaProducto.setModel(miTabla);
		
		miTabla.addColumn("ID");
		miTabla.addColumn("Nombre");
		miTabla.addColumn("Categoria");
		miTabla.addColumn("Fecha");
		miTabla.addColumn("Visto");
		scrollPane.setViewportView(listaProducto);
		
		
		JLabel lblNewLabel = new JLabel("Bienvenido");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 10, 99, 23);
		contentPane.add(lblNewLabel);
		
		JLabel nomUsuarioSesion = new JLabel("["+ InicioSesion.getUsuarioInicio() +"]");
		nomUsuarioSesion.setFont(new Font("Tahoma", Font.BOLD, 15));
		nomUsuarioSesion.setBounds(102, 10, 388, 23);
		contentPane.add(nomUsuarioSesion);
		
		JLabel lblListaDeProductos = new JLabel("Lista de Productos disponibles");
		lblListaDeProductos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblListaDeProductos.setBounds(10, 43, 297, 23);
		contentPane.add(lblListaDeProductos);
	}
	
	
public static void llenarTabla() {
		
		String nombre = InicioSesion.getUsuarioInicio();
		
		for (Productos valores : listaP) {
			Object[] filas = new Object[5];
			
			filas[0] = valores.getId();
			filas[1] = valores.getNomProducto();
			filas[2] = valores.getCategoria();
			filas[3] = valores.getFecha();
			filas[4] = "No";
			miTabla.addRow(filas);
			
		}
	}
}
