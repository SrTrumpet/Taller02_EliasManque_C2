package Clases;


public class Productos {
	
	private String nomUsuario;
	private String nomProducto;
	private String categoria;
	private int precio;
	private String descripcion;
	private int id;
	private String fecha;
	//private Image imgProducto;
	//private String rutaImg;
	
	
	public Productos(String nomUsuario, String nomProducto, String categoria, int precio, String descripcion,int id,String fecha) {
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.nomUsuario = nomUsuario;
		this.nomProducto = nomProducto;
		this.precio = precio;
		this.id = id;
		this.fecha = fecha;
	}
	
	
	
	
	
	
	



	public String getNomUsuario() {
		return nomUsuario;
	}
	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}
	public String getNomProducto() {
		return nomProducto;
	}
	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
	
	
	

}
