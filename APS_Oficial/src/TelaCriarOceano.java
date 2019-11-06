import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

public class TelaCriarOceano extends ManipularArquivo{
	private static final long serialVersionUID = 1L;
	private TelaPrincipal telaPrincipal;
	private JTextField txtCaminho;
	private JTextField txtNomeOceano;
	private ButtonGroup bg = new ButtonGroup();
	private JTable tblValores;
	private JTextField textField;
	private JTextField txtDadoAntigo;
	private JTextField txtDadoRecente;
	private JTextField txtDataAntes;
	Queue conteudoFila = new LinkedList();
	Stack conteudoPilha = new Stack();
	private int idAnimal=1;
	private JTextField txtDataRecente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCriarOceano window = new TelaCriarOceano();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCriarOceano() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		new JFrame();
		setBounds(100, 100, 509, 377);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);

		JLabel lblCaminho = new JLabel("Caminho:");
		lblCaminho.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblCaminho.setBounds(21, 11, 56, 23);
		getContentPane().add(lblCaminho);

		txtCaminho = new JTextField();
		txtCaminho.setText("Digite o caminho...");
		txtCaminho.setBounds(87, 11, 141, 23);
		getContentPane().add(txtCaminho);
		txtCaminho.setColumns(10);

		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setFont(new Font("Courier New", Font.PLAIN, 11));
		btnBrowse.setBounds(235, 11, 89, 23);
		getContentPane().add(btnBrowse);

		JLabel lblTipoArquivo = new JLabel("Tipo do Arquivo:\r\n");
		lblTipoArquivo.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblTipoArquivo.setBounds(87, 58, 112, 14);
		getContentPane().add(lblTipoArquivo);

		txtNomeOceano = new JTextField();
		txtNomeOceano.setVisible(false);
		txtNomeOceano.setFont(new Font("Courier New", Font.PLAIN, 11));
		txtNomeOceano.setBounds(113, 152, 86, 20);
		getContentPane().add(txtNomeOceano);
		txtNomeOceano.setColumns(10);

		JButton btnVoltar = new JButton("Voltar\r\n");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSecundaria telaSecundaria = new TelaSecundaria(3);
				dispose();
				telaSecundaria.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Courier New", Font.PLAIN, 11));
		btnVoltar.setBounds(10, 299, 89, 23);
		getContentPane().add(btnVoltar);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setVisible(false);
		btnConfirmar.setFont(new Font("Courier New", Font.PLAIN, 11));
		btnConfirmar.setBounds(107, 299, 99, 23);
		getContentPane().add(btnConfirmar);

		JRadioButton rdbtnPilha = new JRadioButton("Pilha");
		rdbtnPilha.setFont(new Font("Courier New", Font.PLAIN, 11));
		rdbtnPilha.setBounds(142, 91, 64, 23);
		getContentPane().add(rdbtnPilha);

		JRadioButton rdbtnFila = new JRadioButton("Fila");
		rdbtnFila.setFont(new Font("Courier New", Font.PLAIN, 11));
		rdbtnFila.setBounds(220, 91, 56, 23);
		getContentPane().add(rdbtnFila);

		JComboBox cmbTipoArq = new JComboBox();
		cmbTipoArq.setVisible(false);
		cmbTipoArq.setModel(new DefaultComboBoxModel(new String[] {"txt", "csv"}));
		cmbTipoArq.setBounds(209, 54, 98, 20);
		getContentPane().add(cmbTipoArq);

		JLabel lblNomeOceano = new JLabel("Nome Oceano:");
		lblNomeOceano.setVisible(false);
		lblNomeOceano.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNomeOceano.setBounds(21, 155, 99, 14);
		getContentPane().add(lblNomeOceano);

		JLabel lblDataAntes = new JLabel("Data:");
		lblDataAntes.setVisible(false);
		lblDataAntes.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblDataAntes.setBounds(313, 193, 46, 14);
		getContentPane().add(lblDataAntes);

		txtDataAntes = new JTextField();
		txtDataAntes.setVisible(false);
		txtDataAntes.setBounds(359, 189, 64, 20);
		getContentPane().add(txtDataAntes);
		txtDataAntes.setColumns(10);

		JLabel lblUltimoDado = new JLabel("Nivel da \u00E1gua (antes):");
		lblUltimoDado.setVisible(false);
		lblUltimoDado.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblUltimoDado.setBounds(36, 193, 154, 14);
		getContentPane().add(lblUltimoDado);

		txtDadoAntigo = new JTextField();
		txtDadoAntigo.setVisible(false);
		txtDadoAntigo.setBounds(200, 189, 86, 20);
		getContentPane().add(txtDadoAntigo);
		txtDadoAntigo.setColumns(10);

		JLabel lblDadoRecente = new JLabel("Nivel da \u00E1gua (recente):");
		lblDadoRecente.setVisible(false);
		lblDadoRecente.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblDadoRecente.setBounds(21, 233, 168, 14);
		getContentPane().add(lblDadoRecente);

		txtDadoRecente = new JTextField();
		txtDadoRecente.setVisible(false);
		txtDadoRecente.setBounds(200, 229, 86, 20);
		getContentPane().add(txtDadoRecente);
		txtDadoRecente.setColumns(10);

		JLabel lblResultado = new JLabel("New label");
		lblResultado.setVisible(false);
		lblResultado.setBounds(261, 302, 46, 14);
		getContentPane().add(lblResultado);

		JButton btnAdd = new JButton("Add");
		btnAdd.setVisible(false);
		btnAdd.setFont(new Font("Courier New", Font.PLAIN, 11));
		btnAdd.setBounds(315, 274, 56, 23);
		getContentPane().add(btnAdd);

		Collection<JLabel> labelAnimais = new ArrayList<JLabel>();
		labelAnimais.add(lblNomeOceano);
		labelAnimais.add(lblDataAntes);
		labelAnimais.add(lblUltimoDado);
		labelAnimais.add(lblDadoRecente);

		Collection<JTextField> textsAnimal = new ArrayList<JTextField>();
		textsAnimal.add(txtNomeOceano);
		textsAnimal.add(txtDataAntes);
		textsAnimal.add(txtDadoAntigo);
		textsAnimal.add(txtDadoRecente);

		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManipularArquivo manipularArquivo = new ManipularArquivo();
				manipularArquivo.addDados(3, conteudoFila);
				System.out.println(conteudoFila);
			}
		});

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnFila.isSelected()) {
					conteudoFila.add(idAnimal+";"+ txtNomeOceano.getText()+";"+txtDataAntes.getText()+";"+txtDadoAntigo.getText()+";"+txtDadoRecente.getText());
				}else {
					conteudoPilha.push(idAnimal+";"+ txtNomeOceano.getText()+";"+txtDataAntes.getText()+";"+txtDadoAntigo.getText()+";"+txtDadoRecente.getText());
				}
				System.out.println(conteudoPilha);
				idAnimal++;
			}
		});

		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCaminho.setText(selecionarDiretorio());	
			}
		});

		rdbtnPilha.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				rdbtnFila.setEnabled(false);
				rdbtnPilha.setEnabled(false);
				for (JLabel label : labelAnimais) {
					label.setVisible(true);
				} 
				for (JTextField text : textsAnimal) {
					text.setVisible(true);
				}
				btnConfirmar.setVisible(true);
				btnAdd.setVisible(true);
				salvar(3,txtCaminho.getText(),String.valueOf(cmbTipoArq.getSelectedItem()));
			}
		});

		rdbtnFila.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				rdbtnFila.setEnabled(false);
				rdbtnPilha.setEnabled(false);
				for (JLabel label : labelAnimais) {
					label.setVisible(true);
				} 
				for (JTextField text : textsAnimal) {
					text.setVisible(true);
				}
				btnConfirmar.setVisible(true);
				btnAdd.setVisible(true);
				salvar(3,txtCaminho.getText(),String.valueOf(cmbTipoArq.getSelectedItem()));
			}
		});
		bg.add(rdbtnFila);
		bg.add(rdbtnPilha);	
		
		txtDataRecente = new JTextField();
		txtDataRecente.setBounds(359, 229, 64, 20);
		getContentPane().add(txtDataRecente);
		txtDataRecente.setColumns(10);

	}



	public void salvar(int escolha, String caminho, String tipoArq) {
		try {
			ManipularArquivo.salvarArquivo(escolha, caminho, tipoArq);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Caminho inválido", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
