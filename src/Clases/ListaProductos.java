package Clases;

public class ListaProductos {
	
	private static Productos listaProducto[];
	private static int max;
	private static int cantProducto;
	
	public ListaProductos(int max) {
		this.max = max;
		listaProducto = new Productos[max];
		cantProducto = 0;
	}

	
	public static boolean agregarProducto(Productos p) {
		int nuevoMax = max;
		if (cantProducto < nuevoMax) {
			listaProducto[cantProducto] = p;
			cantProducto++;
			return true;
		}else {
			return false;
		}
		
	}
	
	
	public static Productos[] getListaProducto() {
		return listaProducto;
	}


	public static int getCantProducto() {
		return cantProducto;
	}


	public static void setCantProducto(int cantProducto) {
		ListaProductos.cantProducto = cantProducto;
	}
	
	
	
	
	
	
	
	

}
