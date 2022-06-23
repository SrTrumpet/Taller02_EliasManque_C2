package Clases;

public class ListaUsuarios {
	
	private Usuario user[];
	private int max;
	private int cantUsuarios;
	
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
	
	public Usuario buscarPersona(String nombre){
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
	public String buscarPersonaString(String nombre) {
		int i;
		for (i = 0; i < cantUsuarios; i++) {
			if (user[i].getUsuario().equals(nombre)){
				System.out.println(user[i].getUsuario());
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
				System.out.println(user[i].getUsuario());
				break;
			}
		}if (i == cantUsuarios){
			return "12x+´{342da";
		}
		else{
			return user[i].getPassword();
		}
	}
	


}
