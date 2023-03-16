
public class SistemaInterno {
	private String clave = "AluraCursosOnline";
	
	public boolean autenticar(Autenticable gerente) {
		boolean puedeIniciarSesion = gerente.iniciarSesion(clave);
		boolean retorno;
		if(puedeIniciarSesion) {
			System.out.println("Login exitoso");
			retorno = true;
		}else {
			System.out.println("Error en el login");
			retorno = false;
		}
		return retorno;
	}

}
