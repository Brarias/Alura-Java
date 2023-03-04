// extiende de... Herenciaz
public class Gerente extends Funcionario {

	private String clave;

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public String getClave() {
		return this.clave;
	}

	public boolean iniciarSesion(String clave) {
		return clave == "AluraCursosOnline";
	}
	
	// sobreescritura de método
	public double getBonificacion() {
		return super.getSalario() + super.getBonificacion();
	}
}
