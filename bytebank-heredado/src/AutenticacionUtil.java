
public class AutenticacionUtil {
	
	private String clave;
	
	public boolean iniciarSesion(String calve) {
		return this.clave == clave;
	}
	
	public void setClave(String clave) {
		this.clave = clave;
	}

}
