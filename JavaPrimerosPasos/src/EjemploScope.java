
public class EjemploScope {

	public static void main(String[] args) {

		int edad = 11;
		int cantidadPersonas = 2;

		boolean esPareja;
		/*
		 * boolean puedeEntrar = edad >= 18 && esPareja;
		 * 
		 * System.out.println("El valor de la condicion es: " + esPareja);
		 */
		
		if (cantidadPersonas > 1) {
			esPareja = true;
		}else {
			esPareja = false;
		}
		
		boolean puedeEntrar = edad >= 18 && esPareja;
		
	}
}
