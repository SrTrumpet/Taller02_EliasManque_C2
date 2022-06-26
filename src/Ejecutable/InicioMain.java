package Ejecutable;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import Clases.ListaProductos;
import Clases.ListaUsuarios;
import Clases.Productos;
import Clases.Usuario;
import Interfaces.InicioSesion;

public class InicioMain {
	
	private static ListaProductos listaProductos;
	private static ListaUsuarios listaUsuarios;
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		
		listaUsuarios = new ListaUsuarios(1000);
		listaProductos = new ListaProductos(1000);
		
		agregarListaUsuario(listaUsuarios);
		agregarListaProducto(listaProductos);
		
		InicioSesion ventanaLogin = new InicioSesion();
		ventanaLogin.setVisible(true);
		
		
	}
	
	public static void agregarListaUsuario(ListaUsuarios lista) throws IOException  {
		
		File arch = new File("usuarios.txt");
		
		if (!arch.exists()) {
			arch.createNewFile();
		}
		
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
	
	@SuppressWarnings("static-access")
	public static void agregarListaProducto(ListaProductos lista) throws IOException  {
		
		File arch = new File("productos.txt");
		
		if (!arch.exists()) {
			arch.createNewFile();
		}
		Scanner leer = new Scanner(arch);
		
		while (leer.hasNextLine()) {
			String linea = leer.nextLine();
			String[] datos = linea.split(",");
			
			String usuario = datos[0];
			String producto = datos[1];
			String categoria = datos[2];
			int precio = Integer.parseInt(datos[3]);
			String descripcion = datos[4];
			int id = Integer.parseInt(datos[5]);
			String fecha = datos[6];
			
			Productos p = new Productos(usuario, producto, categoria, precio, descripcion,id,fecha);
			lista.agregarProducto(p);
			
		}
		leer.close();
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	public static ListaProductos getListaProductos() {
		return listaProductos;
	}
	public static void setListaProductos(ListaProductos listaProductos) {
		InicioMain.listaProductos = listaProductos;
	}

	public static ListaUsuarios getListaUsuarios() {
		return listaUsuarios;
	}

	public static void setListaUsuarios(ListaUsuarios listaUsuarios) {
		InicioMain.listaUsuarios = listaUsuarios;
	}

}
