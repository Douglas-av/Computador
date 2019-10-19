import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Teste extends JFrame {

	private JPanel contentPane;

	public void criarGrafico() {
		DefaultCategoryDataset barra = new DefaultCategoryDataset();
		
		JFreeChart grafico = ChartFactory.createBarChart("Teste", "Teste1", "Test2", barra, PlotOrientation.VERTICAL, true, true, false);
		getContentPane().setLayout(null);
			
		ChartPanel painel = new ChartPanel(grafico);
		painel.setLocation(38, 69);
		painel.setSize(375,369);
		getContentPane().add(painel);
		painel.setLayout(null);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teste frame = new Teste();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Teste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Graico");
		setSize(500, 500);
		setLocationRelativeTo(null);
		criarGrafico();
		
		setVisible(true);
	}

}
