package Outros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ManipularArquivos extends JFrame {

	private static final long serialVersionUID = 1L;
	protected JScrollPane scrollPane;
	protected JTable tabela;
	private JPanel contentPane;

	public ManipularArquivos() {
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

	public void novoArquivo() {
		File pasta = null;
		try {
			pasta = new File(ManipularArquivos.class.getResource("../").toURI());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		String dir = pasta.getAbsolutePath();
		
		try {
			String nomeArq = JOptionPane.showInputDialog("Informe o nome do arquivo: ");
			if (nomeArq == null) {
				return;
			}
			String tipoArq = JOptionPane.showInputDialog("Informe o tipo de arquivo, Ex: 'txt', 'csv'...");
			if (tipoArq == null) {
				return;
			}
			FileWriter arq = new FileWriter(dir + "/" + nomeArq + "." + tipoArq);
			PrintWriter gravarArq = new PrintWriter(arq);

			String entrada = JOptionPane.showInputDialog("Aperte ENTER para sair", null);
			while (entrada != null && !entrada.isEmpty()) {
				System.out.println(entrada + " foi adicionado ao arquivo");
				gravarArq.print(entrada + "\n");
				entrada = JOptionPane.showInputDialog("Aperte ENTER para sair", null);

			}
			JOptionPane.showMessageDialog(null, "O arquvi foi salvo em: " + dir, null, 1);
			arq.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public Queue<String> abrirArquivo() {
		JFileChooser fileChooser = null;
		try {
			fileChooser = new JFileChooser(ManipularArquivos.class.getResource("../").toURI().getPath());
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
				BufferedReader lerArq = new BufferedReader(arq);
				try {
					conteudo.add(lerArq.readLine());
					while (lerArq.ready()) {
						conteudo.add(lerArq.readLine());
					}
					conteudo.forEach(item -> System.out.println(item));
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

	public void criarGrafico(int quantidade, Queue<Integer> valores, Queue<String> nomes, Queue<String> nuzei) {
		DefaultCategoryDataset barra = new DefaultCategoryDataset();

		for (int i = 0; i < quantidade; i++) {
			barra.addValue(valores.remove(), nomes.remove(), nuzei.remove());
		}

		JFreeChart grafico = ChartFactory.createBarChart3D("Grafico de idades por sexo", "Nomes", "Idade", barra,
				PlotOrientation.VERTICAL, true, true, false);

		ChartPanel painel = new ChartPanel(grafico);
		painel.setLocation(38, 69);
		painel.setBounds(305, 0, 360, 200);
		getContentPane().add(painel);
		painel.setLayout(null);
		painel.setVisible(true);
	}

	public void atualizaTabela(Queue<String> conteudo) {
		this.setVisible(true);
		String[] separadas;
		String[] cabecalho;
		cabecalho = conteudo.remove().split(";");
		ArrayList<String> lista = new ArrayList<String>();
		lista.addAll(conteudo);
		separadas = lista.toString().split(",");
		tabela = new JTable();
		// Definir o cabeçalho da tabela.
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
		modelo.setColumnIdentifiers(cabecalho);

		for (int i = 0; i < separadas.length; i++) {
			String[] valor = separadas[i].toString().split(";");
			modelo.addRow(valor);
		}

		scrollPane.setViewportView(tabela);
		getContentPane().add(scrollPane);
	}

	public static void main(String[] args) {
		ManipularArquivos mnaq = new ManipularArquivos();
//		Queue<String> s = mnaq.abrirArquivo();
//
//		mnaq.atualizaTabela(s);
	
		mnaq.abrirArquivo();
	}

}
