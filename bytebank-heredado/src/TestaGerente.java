
public class TestaGerente {
	
	public static void main(String[] args) {
		Gerente gerente = new Gerente();
		gerente.setSalario(5000);
		
		//Funcionario gerente = new Funcionario();
		gerente.setSalario(8000);
		gerente.setTipo(1);
		gerente.setNombre("Braian");
		gerente.setClave("AluraCursosOnline");
		
		System.out.println(gerente.getBonificacion());
		System.out.println(gerente.iniciarSesion(gerente.getClave()));
		
		//System.out.println(gerente.getBonificacion());
	}

}