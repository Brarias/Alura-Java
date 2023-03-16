
public abstract class Cuenta {
	protected double saldo;
	private int agencia;
	private int numero;
	private Cliente titular = new Cliente();
	
	private static int contadorCuentas = 0;

	
	public Cuenta(int agencia, int numero) {	
		
		this.agencia = agencia;
		this.numero = numero;
		contadorCuentas++;

	}

	public abstract void depositar(double valor);

	public boolean retirar(double saldo) {
		boolean retorno = false;
		if (this.saldo >= saldo) {
			this.saldo -= saldo;
			retorno = true;
		}

		return retorno;
	}
	
	public boolean saca(double valor) {
		boolean retorno = false;
		if(this.saldo >= valor) {
			this.saldo -= valor;
			retorno = true;
		}
		
		return retorno;
		
	}

	public boolean transferir(double valor, Cuenta destino) {
		boolean retorno = false;
		if (this.saldo >= valor) {
			this.saca(valor);
			destino.depositar(valor);
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
		if (agencia > 0) {
			this.agencia = agencia;
		} else {
			System.out.println("No esta permitido numeros negativos");
		}
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public Cliente getTitular() {
		return titular;
	}
	
	public static int getContadorCuentas() {
		return contadorCuentas;
	}

}
