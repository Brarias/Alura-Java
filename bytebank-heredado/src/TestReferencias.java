
public class TestReferencias {

	public static void main(String[] args) {
		
		/*El elemento m�s gen�rico puede ser 
		 adaptado al elemento m�s espec�fico*/
		
		Funcionario funcionario = new Gerente();
		funcionario.setNombre("Diego");
		
		Gerente gerente = new Gerente();
		gerente.setNombre("Jimena");
		
		funcionario.setSalario(2000);
		gerente.setSalario(10000);
	     
		
	
	}

}
