package Logica;

import Clases.ListaUsuarios;

public class procesoInicioSesion {
	
	private ListaUsuarios lista;
	
	public boolean inicioSesion(String nombre, String password) {
		
		System.out.println("Dentro "+ nombre +" "+ password);
		System.out.println();
		String nombreUsuario = lista.buscarPersonaString(nombre);
		System.out.println(nombreUsuario);
		
		if (nombreUsuario == null) {
			System.out.println("LLEEE1");
			return false;
		}
		else if (nombreUsuario.equals(nombre)) {
			System.out.println("LLEEE2");
			return true;
		}else {
			System.out.println("LLEEE3");
			return false;
		}
	}

}
