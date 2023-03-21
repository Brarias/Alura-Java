
public class Flujo {
	public static void main(String[] args) {
		System.out.println("Inicio de main");
		metodo1();
		System.out.println("Fin de main");
	}
		private static void metodo1() {
			System.out.println("Inicio de metodo1");
			try {
				metodo2();
			}catch(MiException me) {
				me.printStackTrace();
			}
			
			System.out.println("Fin de metodo1");	
	}
		
		private static void metodo2() {
			System.out.println("Inicio de metodo2");
			throw new MiException("Mi excepcion fue lanzada");
			
			
		}

}
