package Outros;

import java.awt.EventQueue;
import java.awt.Image;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCadastro extends ManipularArquivos {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private Queue<String> conteudo = new LinkedList<String>();

	private static ImageIcon icone_Iceberg = new ImageIcon(
			new ImageIcon(TelaCadastro.class.getResource("/imagens/iceberg2.png")).getImage().getScaledInstance(20, 30,
					Image.SCALE_SMOOTH));
	private static ImageIcon icone_Mar = new ImageIcon(
			new ImageIcon(TelaCadastro.class.getResource("/imagens/Mar-icone.jpg")).getImage().getScaledInstance(20, 30,
					Image.SCALE_SMOOTH));
	private static ImageIcon icone_Urso = new ImageIcon(
			new ImageIcon(TelaCadastro.class.getResource("/imagens/urso-icone.jpg")).getImage().getScaledInstance(20,
					30, Image.SCALE_SMOOTH));

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("File");
		menuBar.add(mnArquivo);

		JMenuItem mnNovo = new JMenuItem("Novo", icone_Iceberg);
		mnNovo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				novoArquivo();
			}
		});
		mnNovo.setSize(40, 60);
		mnArquivo.add(mnNovo);

		JMenuItem mnAberturaArquivo = new JMenuItem("Abrir arquivo", icone_Urso);
		mnAberturaArquivo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				conteudo = abrirArquivo();
				atualizaTabela(conteudo);
			}
		});
		mnArquivo.add(mnAberturaArquivo);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Grafico", icone_Mar);
		mntmNewMenuItem_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Queue<Integer> valores = new LinkedList<Integer>();
				Queue<String> nomes = new LinkedList<String>();
				Queue<String> nuzei = new LinkedList<String>();

				conteudo.forEach(item -> nomes.add((item.toString().split(java.util.regex.Pattern.quote(";"))[0])));
				System.out.println(nomes);
				nomes.forEach(item -> System.out.println(item));

				conteudo.forEach(item -> valores
						.add(Integer.parseInt(item.toString().split(java.util.regex.Pattern.quote(";"))[1])));
				System.out.println(valores);
				valores.forEach(item -> System.out.println(item));

				conteudo.forEach(item -> nuzei.add((item.toString().split(java.util.regex.Pattern.quote(";"))[2])));
				System.out.println(nuzei);
				nuzei.forEach(item -> System.out.println(item));

				criarGrafico(valores.size(), valores, nomes, nuzei);
			}
		});
		mnArquivo.add(mntmNewMenuItem_2);

		JMenuItem mnSair = new JMenuItem("Sair");
		mnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		mnArquivo.add(mnSair);

		JMenu mnNewMenu_1 = new JMenu("Edit");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("New menu item");
		mntmNewMenuItem_4.setIcon(new ImageIcon(new ImageIcon(TelaCadastro.class.getResource("/imagens/Urso-icone.jpg"))
				.getImage().getScaledInstance(30, 30, 1)));
		mnNewMenu_1.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("New menu item");
		mnNewMenu_1.add(mntmNewMenuItem_6);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("New menu item");
		mnNewMenu_1.add(mntmNewMenuItem_5);

		JMenu mnNewMenu_2 = new JMenu("New menu");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("New menu item");
		mnNewMenu_2.add(mntmNewMenuItem_7);

		JMenu mnNewMenu_3 = new JMenu("New menu");
		menuBar.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_8 = new JMenuItem("New menu item");
		mnNewMenu_3.add(mntmNewMenuItem_8);

		JMenu mnNewMenu_4 = new JMenu("New menu");
		menuBar.add(mnNewMenu_4);

		JMenuItem mntmNewMenuItem_9 = new JMenuItem("New menu item");
		mnNewMenu_4.add(mntmNewMenuItem_9);

		JMenu mnNewMenu_5 = new JMenu("New menu");
		menuBar.add(mnNewMenu_5);

		JMenuItem mntmNewMenuItem_10 = new JMenuItem("New menu item");
		mnNewMenu_5.add(mntmNewMenuItem_10);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setVisible(true);
		contentPane.setLayout(null);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 300, 200);

	}
}
