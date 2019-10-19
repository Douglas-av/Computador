package VideoAula;

public class EstruturaEstatica<T> {

	protected T[] elementos;
	protected int tamanho;

	public EstruturaEstatica(int capacidade) {
		this.elementos = (T[]) new Object[capacidade];
		this.tamanho = 0;
	}

	public EstruturaEstatica() {
		this(10);
	}

	public boolean estaVazia() {
		if (this.tamanho == 0) {
			return true;
		}
		return false;
	}

	protected boolean adiciona(T elemento) {
		this.aumentaCapacidade();
		if (this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		}
		return false;
	}

	protected void remove() {

	}

	public int tamanho() {
		return this.tamanho;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[");

		for (int i = 0; i < this.tamanho-1; i++) {
			s.append(this.elementos[i]);
			s.append(",");
		}
		if (this.tamanho > 0) {
			s.append(this.elementos[this.tamanho - 1]);
		}

		s.append("]");

		return s.toString();
	}

	private void aumentaCapacidade() {
		if (this.tamanho == this.elementos.length) {
			T[] elementosNovos = (T[]) new Object[this.elementos.length * 2];
			for (int i = 0; i < this.elementos.length; i++) {
				elementosNovos[i] = this.elementos[i];
			}
			this.elementos = elementosNovos;
		}
	}

}
