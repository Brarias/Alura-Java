
public class Flujo {
	public static void main(String[] args) {
		System.out.println("Inicio de main");
		try {
			metodo1();
		} catch (Exception e ) {
			e.printStackTrace();
		}
		System.out.println("Fin de main");
	}

	private static void metodo1() throws MiException {
		System.out.println("Inicio de metodo1");
		metodo2();
		System.out.println("Fin de metodo1");
	}

	private static void metodo2() throws MiException {
		System.out.println("Inicio de metodo2");
		throw new MiException("Mi excepcion fue lanzada");
	}

}
