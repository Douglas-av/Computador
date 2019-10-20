package SomenteTelas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Outros.DB;
import Outros.ManipularArquivos;

import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class TelaInicial1 extends JFrame {

	private JPanel contentPane;
	private TelaInicial1 self;
	private JScrollPane scrollPane;
	private JTable tabela;
	private ManipularArquivos manipularArquivos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial1 frame = new TelaInicial1();
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
	public TelaInicial1() {
		self = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNovo = new JMenu("Novo");
		menuBar.add(mnNovo);
		
		JMenu mnAbrir = new JMenu("Abrir");
		menuBar.add(mnAbrir);
		
		JMenu mnGrafico = new JMenu("Gerar Grafico");
		menuBar.add(mnGrafico);
		
		JMenu mnNewMenu_3 = new JMenu("New menu");
		menuBar.add(mnNewMenu_3);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
}
