package Outros;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import SomenteTelas.SubTela1;

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
		setBounds(100, 100, 774, 604);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(desktopPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(desktopPane,
				Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE));
		contentPane.setLayout(gl_contentPane);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 300, 200);

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
				SubTela1 subTela = new SubTela1();
				desktopPane.add(subTela);
				conteudo = abrirArquivo();
				Component componente = atualizaTabela(conteudo);
				subTela.getContentPane().add(componente);
				subTela.setVisible(true);

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

				SubTela1 subTela = new SubTela1();
				desktopPane.add(subTela);
				Component grafico = criarGrafico(valores.size(), valores, nomes, nuzei);
				subTela.getContentPane().add(grafico);
				subTela.setVisible(true);

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

	}
}
