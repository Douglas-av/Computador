package VideoAula;

public class Testes {

	public static void main(String[] args) {
	
		Pilha<String> pilha = new Pilha<String>();

		pilha.adiciona("Douglas");
		pilha.adiciona("Douglas");
		pilha.adiciona("Douglas");
		pilha.adiciona("Douglas");
		System.out.println(pilha.estaVazia());
		System.out.println(pilha.tamanho());
		System.out.println(pilha.toString());
		
	}

}
