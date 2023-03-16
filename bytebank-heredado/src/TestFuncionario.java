
public class TestFuncionario {

	public static void main(String[] args) {
		Funcionario diego = new Contador();
		diego.setNombre("Diego");
		diego.setDocumento("44455667");
		diego.setTipo(0);
		diego.setSalario(7000);
		
		System.out.println(diego.getBonificacion());
		System.out.println(diego.getSalario());
	}
}
