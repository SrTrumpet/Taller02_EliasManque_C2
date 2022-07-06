package Ejecutable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Clases.Productos;
import Clases.Usuario;
import Interfaces.InicioSesion;

public class InicioMain {
	
	private static ArrayList<Productos> listaProduc;
	private static ArrayList<Usuario> listauser;
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		
		listauser = new ArrayList<>();
		listaProduc = new ArrayList<>();
		
		agregarListaUsuario(listauser);
		agregarListaProducto(listaProduc);
		
		InicioSesion ventanaLogin = new InicioSesion();
		ventanaLogin.setVisible(true);
		
		
	}
	
	public static void agregarListaUsuario(ArrayList<Usuario> lista) throws IOException  {
		
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
			lista.add(u);
			
		}
		leer.close();
		
	}
	

	public static void agregarListaProducto(ArrayList<Productos> lista) throws IOException  {
		
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
			lista.add(p);
			
		}
		leer.close();
	}

	
	
	
	
	public static ArrayList<Productos> getListaProduc() {
		return listaProduc;
	}

	public static void setListaProduc(ArrayList<Productos> listaProduc) {
		InicioMain.listaProduc = listaProduc;
	}

	public static ArrayList<Usuario> getListauser() {
		return listauser;
	}

	public static void setListauser(ArrayList<Usuario> listauser) {
		InicioMain.listauser = listauser;
	}



	
	
	
	
	
	
	
	
	


	

}
