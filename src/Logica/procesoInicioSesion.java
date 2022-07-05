package Logica;

import java.util.ArrayList;

import Clases.Productos;
import Clases.Usuario;
import Ejecutable.InicioMain;

public class procesoInicioSesion {
	
	protected static ArrayList<Productos> listaProduc = InicioMain.getListaProduc();
	protected static ArrayList<Usuario> listauser = InicioMain.getListauser();
	
	
	
	
	public static Usuario buscarUsuario(String user) {
		int i = -1;
		boolean encontrado = false;
		
		for(Usuario valor : listauser ) {
			i++;
			if (valor.getUsuario().equals(user)) {
				encontrado = true;
				break;
			}
			
		}
		if (encontrado) {
			return listauser.get(i);
		}else {
			return null;
		}
		
		
		
	}
	
	

}
