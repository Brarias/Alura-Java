
public class Conexion implements AutoCloseable {
	
	public Conexion() {
		System.out.println("Abriendo Conexion");
		
	}
	
	public void leerDatos() {
		System.out.println("Recibienco datos");
		throw new IllegalStateException();
		
	}
	
	public void cerrar() {
		System.out.println("Cerrando Conexion");
	}

	@Override
	public void close() throws Exception {
		cerrar();
		
	}

}
