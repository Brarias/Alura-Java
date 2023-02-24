
public class Cuenta {
	double saldo;
	int agencia;
	int numero;
	Cliente titular = new Cliente();
	

	public void depositar(double saldo) {
		this.saldo += saldo;
	}

	public boolean retirar(double saldo) {
		boolean retorno = false;
		if (this.saldo >= saldo) {
			this.saldo -= saldo;
			retorno = true;
		}

		return retorno;
	}

	public boolean transferir(double monto, Cuenta destino) {
		boolean retorno = false;
		if (this.saldo >= monto) {
			this.saldo -= monto;
			destino.depositar(monto);
			retorno = true;
		}
		return retorno;
	}

}
