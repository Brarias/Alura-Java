
public class EjemploCiclos2 {
	public static void main(String[] args) {

		/* Sumar todos los numeros del 1 al 10 */

		int contador = 0;
		int acumulador = 0;

		while (contador < 10) {
			contador++;

			acumulador += contador;

		}
		System.out.println(acumulador);
	}
}
