
public class PruebaMetodos {
	
	public static void main(String[] args) {
		
		Cuenta cuentaPrueba = new Cuenta();
		cuentaPrueba.setSaldo(300);
		
		cuentaPrueba.depositar(1000);
		System.out.println(cuentaPrueba.getSaldo());
		
		cuentaPrueba.retirar(500);
		
		System.out.println(cuentaPrueba.getSaldo());
		
		Cuenta cuentaSecundaria = new Cuenta();
		
		boolean puedeTransferir = cuentaPrueba.transferir(600, cuentaSecundaria);
		
		if(puedeTransferir) {
			System.out.println("Transferencia Exitosa!!!");
		}else {
			System.out.println("No se pudo realizar la transferencia");
		}
		
		System.out.println(cuentaPrueba.getSaldo());
		System.out.println(cuentaSecundaria.getSaldo());
	}
}
