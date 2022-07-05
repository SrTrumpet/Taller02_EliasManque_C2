package Logica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Clases.ListaUsuarios;
import Clases.Productos;
import Clases.Usuario;
import Ejecutable.InicioMain;
	

public class procesoRegistro {
	
	protected static ArrayList<Productos> listaProduc = InicioMain.getListaProduc();
	protected static ArrayList<Usuario> listauser = InicioMain.getListauser();
	
	public boolean ResgistroUsuario(String usuario, String fullName, String correo, String contacto, String pass, String passConfirm,File archUsuario) throws IOException {
		
		if(!pass.equals(passConfirm)) {
			return false;
		}else {
			String ruta = archUsuario.getAbsolutePath();
	        FileWriter arch = new FileWriter(ruta);
			
			return true;
		}		
	}
	
	
	public static boolean personaExiste(String user) {
		
		boolean existe = false;
		
		for(Usuario valor : listauser) {
			if(valor.getUsuario().equals(user)) {
				existe = true;
			}
		}
		
		return existe;
		
		
	}
	
	public static void saveTxt(ArrayList<Usuario> lista) throws IOException {
		
		
		File arch = new File("usuarios.txt");
		String ruta = arch.getAbsolutePath();
		FileWriter nuevoArch = new FileWriter(ruta);
		
		int ultimaLinea = 0;
        ultimaLinea = lista.size() - 1;
		
		
		
		for (int i = 0 ; i < lista.size(); i++) {
			
			Usuario u = lista.get(i);
			
			if (ultimaLinea == i){
				nuevoArch.write(u.getUsuario() + "," + u.getPassword() + ","+ u.getFullName()+ "," 
							  + u.getCorreo()  + "," + u.getContacto());
            }else{
            	nuevoArch.write(u.getUsuario() + "," + u.getPassword() + ","+ u.getFullName()+ "," 
						      + u.getCorreo()  + "," + u.getContacto()+"\n");
            }
		}
		nuevoArch.close();
		
		
		
	}


}