
public class Cuenta {
	private double saldo;
	private int agencia;
	private int numero;
	private Cliente titular = new Cliente();
	

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
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public int getAgencia() {
		return agencia;
	}
	
	public void setAgencia(int agencia) {
		if(agencia > 0) {
		this.agencia = agencia;
		}else {
			System.out.println("No esta permitido numeros negativos");
		}
	}
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	public Cliente getTitular() {
		return titular;
	}
	

}
