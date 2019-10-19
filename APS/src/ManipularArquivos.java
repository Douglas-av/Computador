import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ManipularArquivos {
	
	public void novoArquivo() {
		try {
			String nomeArq = JOptionPane.showInputDialog("Informe o nome do arquivo: ");
			if(nomeArq == null) {return;}
			String tipoArq = JOptionPane.showInputDialog("Informe o tipo de arquivo, Ex: 'txt', 'csv'...");
			if(tipoArq == null) {return;}
			FileWriter arq = new FileWriter("C:\\Users\\Dougras\\Desktop\\Nova pasta\\" + nomeArq + "." + tipoArq);
			PrintWriter gravarArq = new PrintWriter(arq);

			String entrada = JOptionPane.showInputDialog("Aperte ENTER para sair", null);
			while (entrada != null && !entrada.isEmpty()) {
				System.out.println(entrada + " foi adicionado ao arquivo");
				gravarArq.print(entrada + "\n");
				entrada = JOptionPane.showInputDialog("Aperte ENTER para sair", null);

			}

			arq.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public Queue<String> abrirArquivo() {
		JFileChooser fileChooser = new JFileChooser();
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
	
	
	
	public static void main(String[] args) {
		ManipularArquivos mnaq = new ManipularArquivos();
		//mnaq.abrirArquivo();
		mnaq.novoArquivo();
	}

}
