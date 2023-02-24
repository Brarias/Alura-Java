
public class TestReferencia {

	
	public static void main(String[] args) {
		
		Cliente diego = new Cliente();
		diego.nombre = "Diego";
		diego.documento = "45674325";
		diego.telefono = "1130897621";
		
		Cuenta cuentaDeDiego = new Cuenta();
		cuentaDeDiego.agencia = 1;
		cuentaDeDiego.titular = diego;
		
		
		System.out.println(cuentaDeDiego.titular.documento);
		System.out.println(cuentaDeDiego.titular);
		
		
	}
}
