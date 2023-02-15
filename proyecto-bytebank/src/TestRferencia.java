
public class TestRferencia {
	public static void main(String[] args) {
		
		Cuenta primeraCuenta = new Cuenta();
		primeraCuenta.saldo = 200;
		
		Cuenta segundaCuenta = primeraCuenta;
		System.out.println(segundaCuenta);
		System.out.println(primeraCuenta);
		segundaCuenta.saldo = 500;
		
		System.out.println("saldo de primera cuenta: " + primeraCuenta.saldo);
		System.out.println("saldo de segunda cuenta: " + segundaCuenta.saldo);
		
		if(primeraCuenta == segundaCuenta) {
			System.out.println("Son el mismo objeto");
		}
		
	}
}
