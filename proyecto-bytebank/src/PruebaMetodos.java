
public class PruebaMetodos {
	
	public static void main(String[] args) {
		
		Cuenta cuentaPrueba = new Cuenta();
		cuentaPrueba.saldo = 300;
		
		cuentaPrueba.depositar(1000);
		System.out.println(cuentaPrueba.saldo);
		
		cuentaPrueba.retirar(500);
		
		System.out.println(cuentaPrueba.saldo);
		
		Cuenta cuentaSecundaria = new Cuenta();
		
		boolean puedeTransferir = cuentaPrueba.transferir(600, cuentaSecundaria);
		
		if(puedeTransferir) {
			System.out.println("Transferencia Exitosa!!!");
		}else {
			System.out.println("No se pudo realizar la transferencia");
		}
		
		System.out.println(cuentaPrueba.saldo);
		System.out.println(cuentaSecundaria.saldo);
	}
}
