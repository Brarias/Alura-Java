
public class TestReferencia {

	
	public static void main(String[] args) {
		
		Cliente diego = new Cliente();
		diego.setNombre("Diego");
		diego.setDocumento("45674325");
		diego.setTelefono("1130897621");
		
		Cuenta cuentaDeDiego = new Cuenta();
		cuentaDeDiego.setAgencia(1); 
		cuentaDeDiego.setTitular(diego);
		
		
		System.out.println(cuentaDeDiego.getTitular().getDocumento());
		System.out.println(cuentaDeDiego.getTitular());
		
		
	}
}
