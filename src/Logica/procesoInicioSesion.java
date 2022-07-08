package Logica;

import java.util.ArrayList;

import Clases.Productos;
import Clases.Usuario;
import Dialogos.DfalloInicioSesion;
import Ejecutable.InicioMain;

public class procesoInicioSesion {
	
	protected static ArrayList<Productos> listaProduc = InicioMain.getListaProduc();
	protected static ArrayList<Usuario> listauser = InicioMain.getListauser();
	
public static boolean inicioSesionI(String usuario, String password) {		
		
		boolean inicio = false;
		
		Usuario u;
		if(buscarUsuarioBoolean(usuario)) {
			u = procesoInicioSesion.buscarUsuario(usuario);
		}else {
			DfalloInicioSesion ventanaError = new DfalloInicioSesion();
			ventanaError.setVisible(true);
			return inicio;
		}
		
			
		String nombreUsuarios = u.getUsuario();		
		String passwordConfirmar = u.getPassword();
		
		
		if (u.equals(null)) {
			DfalloInicioSesion v = new DfalloInicioSesion();
			v.setVisible(true);
			
		}
		else {
			if (usuario.equals(null)) {
				DfalloInicioSesion ventanaError = new DfalloInicioSesion();
				ventanaError.setVisible(true);
				
			}
			else if (nombreUsuarios.equals(usuario)) {
				if(password.equals(passwordConfirmar)) {
					inicio = true;	
				}else {
					DfalloInicioSesion ventanaError = new DfalloInicioSesion();
					ventanaError.setVisible(true);
					
				}
			}else {
				DfalloInicioSesion ventanaError = new DfalloInicioSesion();
				ventanaError.setVisible(true);
				
			}
			
		}
		return inicio;
	}
	
	
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
	
	public static boolean buscarUsuarioBoolean(String user) {
		boolean encontrado = false;
		
		for(Usuario valor : listauser ) {
			if (valor.getUsuario().equals(user)) {
				encontrado = true;
				break;
			}
			
		}
		if (encontrado) {
			return encontrado;
		}else {
			return encontrado;
		}
		
		
		
	}
	
	public static int indiceUsuario(String usuario) {
		int index;
		Usuario u = procesoInicioSesion.buscarUsuario(usuario);
		index = listauser.indexOf(u);
		return index;
	}

}
