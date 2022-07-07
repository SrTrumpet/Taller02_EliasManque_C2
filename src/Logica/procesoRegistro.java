package Logica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Clases.Productos;
import Clases.Usuario;
import Dialogos.DCorrectoRegistro;
import Dialogos.DErrorRegistro;
import Dialogos.DRegistroErrorContacto;
import Dialogos.DRegistroErrorCorreo;
import Dialogos.DRegistroErrorUsuario;
import Dialogos.DRegistroUsuarioExiste;
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

	
	public static void registroProceso(String nombreUsuario,String nombreCompelto,String correoUser,String contactoUser,String contrasena,String contrasenaConfirm) {
		
		int sumaCorrecta = 0;
		
		if(procesoRegistro.personaExiste(nombreUsuario)) {
			sumaCorrecta++;
			DRegistroUsuarioExiste ventanaErrorUsuario = new DRegistroUsuarioExiste();
			ventanaErrorUsuario.setVisible(true);

		}
		else if(nombreUsuario.length() < 4) {
			sumaCorrecta++;
			DRegistroErrorUsuario u = new DRegistroErrorUsuario();
			u.setVisible(true);
		}
		else if(nombreCompelto.length() < 6) {
			sumaCorrecta++;
			DRegistroErrorUsuario u = new DRegistroErrorUsuario();
			u.setVisible(true);
		}
		else if(correoUser.length() < 13) {
			DRegistroErrorCorreo c = new DRegistroErrorCorreo();
			c.setVisible(true);
		}					
		else if(contactoUser.length() != 12) {
			sumaCorrecta++;
			DRegistroErrorContacto ventanaErrorContacto = new DRegistroErrorContacto();
			ventanaErrorContacto.setVisible(true);						
		}					
		else if(procesoRegistro.personaExiste(nombreUsuario)) {
			sumaCorrecta++;
			DRegistroUsuarioExiste ventanaErrorUsuario = new DRegistroUsuarioExiste();
			ventanaErrorUsuario.setVisible(true);

		} 
		else if (contrasenaConfirm.length() == 0 || contrasena.length() == 0 ) {
			sumaCorrecta++;
			DErrorRegistro error = new DErrorRegistro();
			error.setVisible(true);
								
		}
		else if (!contrasena.equals(contrasenaConfirm)) {
			sumaCorrecta++;
			DErrorRegistro error = new DErrorRegistro();
			error.setVisible(true);
		}
		else if (sumaCorrecta == 0){

			Usuario u = new Usuario(nombreUsuario, contrasena, nombreCompelto, correoUser, contactoUser);
			listauser.add(u);
			
			try {
				procesoRegistro.saveTxt(listauser);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}	
			
			
			
			DCorrectoRegistro registrado = new DCorrectoRegistro();
			registrado.setVisible(true);
			
			
		}
		
		
	}
	
	
	
	

}