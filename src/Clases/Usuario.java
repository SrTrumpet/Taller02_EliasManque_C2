package Clases;

public class Usuario {
	
	private String usuario;
	private String password;
	private String fullName;
	private String correo;
	private String contacto;
	
	
	public Usuario(String usuario, String password, String fullName, String correo, String contacto) {
		this.password = password;
		this.usuario = usuario;
		this.fullName = fullName;
		this.correo = correo;
		this.contacto = contacto;
	}

	
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getContacto() {
		return contacto;
	}
	
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

}
