
public class TestReferencia2 {
	public static void main(String[] args) {
		
		Cuenta primeraCuenta = new Cuenta();
		primeraCuenta.setSaldo(200); 
		
		Cuenta segundaCuenta = primeraCuenta;
		System.out.println(segundaCuenta);
		System.out.println(primeraCuenta);
		segundaCuenta.setSaldo(500);
		
		System.out.println("saldo de primera cuenta: " + primeraCuenta.getSaldo());
		System.out.println("saldo de segunda cuenta: " + segundaCuenta.getSaldo());
		
		if(primeraCuenta == segundaCuenta) {
			System.out.println("Son el mismo objeto");
		}
		
	}
}
