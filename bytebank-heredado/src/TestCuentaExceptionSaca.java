
public class TestCuentaExceptionSaca {

	public static void main(String[] args) {
		Cuenta cuenta = new CuentaAhorro(123, 456);
		cuenta.depositar(200);
		try {
			cuenta.saca(210);
			cuenta.saca(3);
		} catch (SaldoInsuficienteException e) {
			e.printStackTrace();
		}
		
	}

}
