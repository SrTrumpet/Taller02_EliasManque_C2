package Logica;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


import Clases.Productos;
import Ejecutable.InicioMain;

public class procesoRegistroProducto {
	
	private static Productos p;
	private static ArrayList<Productos> lista = InicioMain.getListaProduc();
	
	
	
	public static boolean agregarProducto(String nombreProducto, String nombreUsuario, String categoria, int precio, String descripcion,int id,String fecha) {
		
		p = new Productos(nombreUsuario, nombreProducto, categoria, precio, descripcion,id,fecha);
		lista.add(p);
		
		return false;
	}
	
	public static void guardarTxtProducto(ArrayList<Productos> lista) throws IOException {
		
		File arch = new File("productos.txt");
		String ruta = arch.getAbsolutePath();
		FileWriter nuevoArch = new FileWriter(ruta);
		
		
		int ultimaLinea = lista.size() - 1;;
        
		
		
		
		for (int i = 0 ; i < lista.size(); i++) {
			
			Productos p = lista.get(i);
			
			if (ultimaLinea == i){
				nuevoArch.write(p.getNomUsuario() + "," + p.getNomProducto() + ","+ p.getCategoria()+ "," 
							  + p.getPrecio()  + "," + p.getDescripcion() + "," + p.getId() + "," + p.getFecha());
            }else{
            	nuevoArch.write(p.getNomUsuario() + "," + p.getNomProducto() + ","+ p.getCategoria()+ "," 
						      + p.getPrecio()  + "," + p.getDescripcion()+ "," + p.getId() + "," + p.getFecha() + "\n");
            }
		}
		nuevoArch.close();
	}

}
