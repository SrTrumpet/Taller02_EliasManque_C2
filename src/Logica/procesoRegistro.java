package Logica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class procesoRegistro {
	
	public boolean ResgistroUsuario(String usuario, String fullName, String correo, String contacto, String pass, String passConfirm,File archUsuario) throws IOException {
		
		if(!pass.equals(passConfirm)) {
			return false;
		}else {
			String ruta = archUsuario.getAbsolutePath();
	        FileWriter arch = new FileWriter(ruta);
			
			return true;
		}
		
		
		
		
		
	}


}