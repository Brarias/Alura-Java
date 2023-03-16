
public class TestControlBonificacion {
	
	public static void main(String[] args) {
		Funcionario diego = new Contador();
		diego.setSalario(2000);
		
		Gerente jimena = new Gerente();
		jimena.setSalario(10000);
		
		ControlBonificacion controlBonificacion = new ControlBonificacion();
		
		controlBonificacion.registrarSalario(diego);
		controlBonificacion.registrarSalario(jimena);
		
		Contador alexis = new Contador();
		alexis.setSalario(5000);
		
		controlBonificacion.registrarSalario(alexis);
		
		
		
		
		
	}

}
