import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.data.category.DefaultCategoryDataset;

public class ManipularArquivo extends JFrame {
	protected String path = ManipularArquivo.class.getResource("").getPath().toString();
	private static final long serialVersionUID = 1L;
	protected JScrollPane scrollPane;
	protected JTable tabela;
	private JPanel contentPane;
	private String nomeArq = "";
	private static String header="";
	private String tipoArq;
	private static String caminhoCompleto="";

	public String getTipoArq() {
		return tipoArq;
	}

	public String getHeader() {
		return header;
	}

	public ManipularArquivo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setVisible(true);
		contentPane.setLayout(null);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 300, 200);
	}

	public String selecionarDiretorio() {
		File caminho = new File("");
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("Escolha onde quer salvar o arquivo");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		//
		// disable the "All files" option.
		//
		chooser.setAcceptAllFileFilterUsed(false);
		//
		if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {
			caminho = chooser.getSelectedFile();
		} else {
			System.out.println("Nada selecionado ");
		}
		return caminho.toString();
	}

	public static void salvarArquivo(int escolha, String caminho, String tipoArq) throws IOException {
		String nomeArq="";
		if (escolha == 1) {
			nomeArq = "entradaOceanos";
			header = "id;ultimo dado;ano ultimo dado; dado atual; ano dado atual";
		} else if (escolha == 2) {
			nomeArq = "entradaCalotas";
			header = "id;estado;ultimo dado;dado atual;ano dado atual";
		} else {
			nomeArq = "entradaAnimais";
			header = "id;nome;nome cientifico;status;habitat;estado";
		}
		caminhoCompleto = caminho+"\\"+nomeArq+"."+tipoArq;
//		File arquivo = new File(caminhoCompleto);
//		OutputStream out = new FileOutputStream(arquivo);
//		out.
//		out.close();
		FileWriter arq = new FileWriter(caminhoCompleto);
//		System.out.println(caminhoCompleto);
		PrintWriter gravarArq = new PrintWriter(arq);
		System.out.println(header);
		gravarArq.print(header);	
		arq.close();
	}

	public void addDados(int escolha, Queue conteudo) {
		// try {
		//			pasta = new File(ManipularArquivo.class.getResource("../").toURI());
		//		} catch (URISyntaxException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		//		String dir = pasta.getAbsolutePath();
		//		String caminho = selecionarDiretorio();
		//		try {


		//			String nomeArq = JOptionPane.showInputDialog("Informe o nome do arquivo: ");
		//			if (nomeArq == null) {
		//				return;
		//			}
		//			this.tipoArq = JOptionPane.showInputDialog("Informe o tipo de arquivo: 'txt' ou 'csv'");
		//			if ( (tipoArq == null) || (!tipoArq.equals("txt")) && (!tipoArq.equals("csv")) ) {
		//				System.out.println("Alguma coisa");
		//				return;
		//			}
//		FileWriter arq = null;
//		try {
////			arq = new FileWriter(caminhoCompleto);
//			System.out.println(caminhoCompleto);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		PrintWriter gravarArq = new PrintWriter(arq);
		PrintStream fileStream = null;
		try {
			fileStream = new PrintStream(new FileOutputStream(caminhoCompleto, true));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (Object item : conteudo) {
			fileStream.println(item);
		}
//		try {
////			arq.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if (escolha == 1) {
//			this.nomeArq = "entradaOceanos";
//		} else if (escolha == 2) {
//			this.nomeArq = "entradaCalotas";
//		} else {
//			this.nomeArq = "entradaAnimais";
//		}
		//			String entrada = JOptionPane.showInputDialog("Insira os valores", null);
		//			while (entrada != null && !entrada.isEmpty()) {
		//				System.out.println(id + ";" + entrada + " foi adicionado ao arquivo");
		
		//				entrada = JOptionPane.showInputDialog("Insira os valores", null);
		
		//			}
		//			JOptionPane.showMessageDialog(null, "O arquivo foi salvo em: " + caminho, null, 1);
		//			arq.close();
		//		} catch (IOException e1) {
		//			// TODO Auto-generated catch block
		//			e1.printStackTrace();
		//		}
	}

	public void conteudoArquivo(Queue<String> conteudo) {
		//		if (conteudo.peek()==null) {
		//			JOptionPane.showMessageDialog(null,"O arquivo selecionado esta vazio","Aviso",JOptionPane.INFORMATION_MESSAGE); 
		//		}
		//		else {
		//			conteudo.forEach(item -> System.out.println(item));
		//			Object[] opcoes= { "Fila", "Pilha"};
		//			int escolha = JOptionPane.showOptionDialog(null,
		//					"O arquivo selecionado possui os seguintes valores:\n\r"+conteudo+"\n\rDeseja mexer nessa lista como fila ou pilhha?",
		//					"Leitura",
		//					JOptionPane.YES_NO_OPTION,
		//					JOptionPane.QUESTION_MESSAGE,
		//					null,     //do not use a custom Icon
		//					opcoes,  //the titles of buttons
		//					opcoes[0]); //default button title
		////			System.out.println(escolha);
		//			if (escolha==JOptionPane.YES_OPTION) {
		//				adicionar(conteudo);
		//			}else if(escolha==JOptionPane.NO_OPTION){
		//				deletar(conteudo);
		//			}else {
		//				dispose();
		//			}
		//		}
	}

	public void adicionar(Queue<String> conteudo) {
		Scanner fileScanner;
		conteudo.add("10");
		fileScanner = new Scanner(path);
		fileScanner.nextLine();
		atualizarArquivo(conteudo);
		fileScanner.close();
	}

	public void deletar(Queue<String> conteudo) {
		Scanner fileScanner;
		conteudo.remove();
		fileScanner = new Scanner(path);
		fileScanner.nextLine();
		atualizarArquivo(conteudo);
		fileScanner.close();
	}

	public void atualizarArquivo(Queue<String> conteudo) {
		System.out.println(conteudo);
		File fnew = new File(path);
		FileWriter f2;

		try {
			f2 = new FileWriter(fnew, false);
			for (String s : conteudo) {
				if (s == "") {

				} else {
					f2.write(s + "\n");
				}
			}
			f2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Queue<String> abrirArquivo() {
		JFileChooser fileChooser = new JFileChooser();
		try {
			fileChooser = new JFileChooser(ManipularArquivo.class.getResource("").toURI().getPath().toString());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Queue<String> conteudo = new LinkedList<String>();

		fileChooser.setDialogTitle("Buscar arquivo.");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo", "txt", "csv", "xml");
		fileChooser.setFileFilter(filter);
		int retorno = fileChooser.showOpenDialog(null);
		if (retorno == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try {
				FileReader arq = new FileReader(file.getPath());
				path = file.getPath();
				BufferedReader lerArq = new BufferedReader(arq);
				try {
					conteudo.add(lerArq.readLine());
					while (lerArq.ready()) {
						conteudo.add(lerArq.readLine());
					}
					if (conteudo.peek() == null) {
						JOptionPane.showMessageDialog(null, "O arquivo selecionado esta vazio", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
					}

					//					conteudoArquivo(conteudo);
					//					conteudo.forEach(item -> System.out.println(item));
					arq.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return conteudo;
	}

	//	public Component criarGrafico(int quantidade, Queue<Integer> valores, Queue<String> nomes, Queue<String> nuzei) {
	//		DefaultCategoryDataset barra = new DefaultCategoryDataset();
	//
	//		for (int i = 0; i < quantidade; i++) {
	//			barra.addValue(valores.remove(), nomes.remove(), nuzei.remove());
	//		}
	//
	//		JFreeChart grafico = ChartFactory.createBarChart3D("Grafico de idades por sexo", "Nomes", "Idade", barra,
	//				PlotOrientation.VERTICAL, true, true, false);
	//
	//		ChartPanel painel = new ChartPanel(grafico);
	//		painel.setLocation(38, 69);
	//		painel.setBounds(0, 0, 200, 200);
	//		getContentPane().add(painel);
	//		painel.setLayout(null);
	//		painel.setVisible(true);
	//		return painel;
	//	}

	public Component atualizaTabela(Queue<String> conteudo) {
		this.setVisible(true);
		String[] separadas;
		String[] cabecalho;
		cabecalho = conteudo.remove().split(";");
		ArrayList<String> lista = new ArrayList<String>();
		lista.addAll(conteudo);
		separadas = lista.toString().split(",");
		tabela = new JTable();
		// Definir o cabe�alho da tabela.
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
		modelo.setColumnIdentifiers(cabecalho);
		for (int i = 0; i < separadas.length; i++) {
			String[] valor = separadas[i].toString().split(";");
			modelo.addRow(valor);
		}

		scrollPane.setViewportView(tabela);
		return scrollPane;
	}

	public static void main(String[] args) {
		ManipularArquivo mnaq = new ManipularArquivo();
		//		Queue<String> s = mnaq.abrirArquivo();
		//
		//		mnaq.atualizaTabela(s);

		mnaq.abrirArquivo();
	}

}
