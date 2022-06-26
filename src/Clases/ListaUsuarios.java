package Clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ListaUsuarios {
	
	private static Usuario user[];
	private int max;
	private static int cantUsuarios;
	
	public ListaUsuarios(int max) {
		this.max = max;
		user = new Usuario[max];
		cantUsuarios = 0;
	}
	
	public ListaUsuarios() {
		
	}

	
	
	
	
	public boolean agregarUsuario(Usuario usuario) {
		if (cantUsuarios < max) {
			user[cantUsuarios] = usuario;
			cantUsuarios++;
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
	public static Usuario buscarPersona(String nombre){
		int i;
		for(i = 0; i < cantUsuarios; i++){
			if (user[i].getUsuario().equals(nombre)){
				break;
			}
		}
		
		if (i == cantUsuarios){
			return null;
		}
		else{
			return user[i];
		}
	}
	
	
	
	public static boolean personaExiste(String busqueda) {
		
		int i;
		for( i = 0 ; i< cantUsuarios; i++) {
			if (user[i].getUsuario().equals(busqueda)) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	public String buscarPersonaString(String nombre) {
		int i;
		for (i = 0; i < cantUsuarios; i++) {
			if (user[i].getUsuario().equals(nombre)){
				break;
			}
		}if (i == cantUsuarios){
			return "12x+´{342das";
		}
		else{
			return user[i].getUsuario();
		}
	}
	
	
	
	
	
	public String buscarContraseña(String nombre) {
		int i;
		for (i = 0; i < cantUsuarios; i++) {
			if (user[i].getUsuario().equals(nombre)){
				break;
			}
		}if (i == cantUsuarios){
			return "12x+´{342da";
		}
		else{
			return user[i].getPassword();
		}
	}
	
	
	
	
	
	
	public static void saveTxt(ListaUsuarios lista) throws IOException {
		
		
		File arch = new File("usuarios.txt");
		String ruta = arch.getAbsolutePath();
		FileWriter nuevoArch = new FileWriter(ruta);
		
		int ultimaLinea = 0;
        ultimaLinea = cantUsuarios - 1;
		
		
		
		for (int i = 0 ; i < cantUsuarios; i++) {
			
			if (ultimaLinea == i){
				nuevoArch.write(user[i].getUsuario() + "," + user[i].getPassword() + ","+ user[i].getFullName()+ "," 
							  + user[i].getCorreo()  + "," + user[i].getContacto());
            }else{
            	nuevoArch.write(user[i].getUsuario() + "," + user[i].getPassword() + ","+ user[i].getFullName()+ "," 
						      + user[i].getCorreo()  + "," + user[i].getContacto()+"\n");
            }
		}
		nuevoArch.close();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
