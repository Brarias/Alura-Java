
public class EjercicioFactorial {
	public static void main(String[] args) {
		/* Todos los factoriales de 1 al 10 
		 *ejemplo = El factorial de 4! = 1 x 2 x 3 x 4 = 24
		 * */
		
		int factorial = 1;
		for(int i = 1; i <= 10; i++) {
			factorial *= i;
			System.out.println("El factorial de " + i + " = " + factorial);
		}
		
	}
}
