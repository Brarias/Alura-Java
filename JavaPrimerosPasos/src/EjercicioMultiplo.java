
public class EjercicioMultiplo {
	public static void main(String[] args) {
		/* Todos los números múltiplos de 3 del 1 al 100 */
		/*
		 * for(int contador = 0; contador <= 100; contador++) { if(contador %3 == 0) {
		 * System.out.println(contador); } }
		 */
		
		for(int contador = 0; contador <= 100; contador += 3) {
			System.out.println(contador);
		}
	}
}
