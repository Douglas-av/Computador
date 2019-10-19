package VideoAula;
import java.util.LinkedList;
import java.util.Queue;

public class Fila<T> extends EstruturaEstatica<T> {

	private int primeiro;
	private int quantidade;
	
	
	public Fila() {
		super();
	}
	
	public Fila(int capacidade) {
		super(capacidade);
	}
	
	
	
	
	public void enfileira(int t[]) {
		
	}
	
	public void aumentaCapacidade() {
		
	}
	
	public boolean estaVazia() {
		return false;
	}
	
	public void espiar() {
		
	}
	
	public void desenfileirar() {
		
	}
	
	public int tamanho() {
		return quantidade -1;
	}
	
	public String toString() {
		return "";
	}
	
	
	public static void main(String[] args) {
		Queue<String> fifo = new LinkedList<String>();
		
		fifo.add("Valor1");
		fifo.add("Valor2");
		fifo.add("Valor3");
		fifo.add("Valor4");
		fifo.add("Valor5");

		System.out.println(fifo.remove("Valor2"));
		System.out.println("Fila :" + fifo);
				
		String removido = fifo.remove();
		System.out.println("Removido da fila: " + removido + "| Nova fila: " + fifo);
		
		System.out.println("A fila esta vazia? " + fifo.isEmpty());
		
		String verifica = "Valor4";
		if(fifo.contains(verifica)) {
			System.out.println("A String " + verifica + " esta na fila.");
		}
		else {
			System.out.println("A String " + verifica + " não esta na fila");
		}
		
		System.out.println("O primeiro valor na fila é : " + fifo.element());
		
		System.out.println("O primeiro valor na fila é : " + fifo.peek());
		
		System.out.println("O tamanho da fila é : " + fifo.size());
		
		fifo.forEach(item -> System.out.println(item));
		
		
	}
}
