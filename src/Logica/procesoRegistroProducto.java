package Logica;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Clases.ListaProductos;
import Clases.Productos;

public class procesoRegistroProducto {
	
	private static Productos p;
	private static Productos[] lista = ListaProductos.getListaProducto();
	
	
	
	public static boolean agregarProducto(String nombreProducto, String nombreUsuario, String categoria, int precio, String descripcion,int id,String fecha) {
		
		p = new Productos(nombreUsuario, nombreProducto, categoria, precio, descripcion,id,fecha);
		ListaProductos.agregarProducto(p);
		
		return false;
	}
	
	public static void guardarTxtProducto() throws IOException {
		
		File arch = new File("productos.txt");
		String ruta = arch.getAbsolutePath();
		FileWriter nuevoArch = new FileWriter(ruta);
		
		int lineatotal = ListaProductos.getCantProducto();
		int ultimaLinea = 0;
        ultimaLinea = ListaProductos.getCantProducto() - 1;
		
		
		
		for (int i = 0 ; i < lineatotal; i++) {
			
			if (ultimaLinea == i){
				nuevoArch.write(lista[i].getNomUsuario() + "," + lista[i].getNomProducto() + ","+ lista[i].getCategoria()+ "," 
							  + lista[i].getPrecio()  + "," + lista[i].getDescripcion() + "," + lista[i].getId() + "," + lista[i].getFecha());
            }else{
            	nuevoArch.write(lista[i].getNomUsuario() + "," + lista[i].getNomProducto() + ","+ lista[i].getCategoria()+ "," 
						      + lista[i].getPrecio()  + "," + lista[i].getDescripcion()+ "," + lista[i].getId() + "," + lista[i].getFecha() + "\n");
            }
		}
		nuevoArch.close();
	}

}
