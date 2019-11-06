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

import javax.swing.AbstractButton;
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

public class TelaCriarAnimal extends ManipularArquivo{
	private static final long serialVersionUID = 1L;
	private TelaPrincipal telaPrincipal;
	private JTextField txtCaminho;
	private JTextField txtNomeAnimal;
	private ButtonGroup bg = new ButtonGroup();
	private JTable tblValores;
	private JTextField textField;
	private JTextField txtStatus;
	private JTextField txtHabitat;
	private JTextField txtNomeCientifico;
	Queue conteudoFila = new LinkedList();
	Stack conteudoPilha = new Stack();
	private int idAnimal=1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCriarAnimal window = new TelaCriarAnimal();
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
	public TelaCriarAnimal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		new JFrame();
		setBounds(100, 100, 410, 377);
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

		txtNomeAnimal = new JTextField();
		txtNomeAnimal.setVisible(false);
		txtNomeAnimal.setFont(new Font("Courier New", Font.PLAIN, 11));
		txtNomeAnimal.setBounds(66, 175, 86, 20);
		getContentPane().add(txtNomeAnimal);
		txtNomeAnimal.setColumns(10);

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

		JLabel lblNomeAnimal = new JLabel("Nome:");
		lblNomeAnimal.setVisible(false);
		lblNomeAnimal.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNomeAnimal.setBounds(21, 178, 35, 14);
		getContentPane().add(lblNomeAnimal);

		JLabel lblNomeCientifico = new JLabel("Nome Cientifico:");
		lblNomeCientifico.setVisible(false);
		lblNomeCientifico.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNomeCientifico.setBounds(165, 178, 119, 14);
		getContentPane().add(lblNomeCientifico);

		txtNomeCientifico = new JTextField();
		txtNomeCientifico.setVisible(false);
		txtNomeCientifico.setBounds(283, 174, 86, 20);
		getContentPane().add(txtNomeCientifico);
		txtNomeCientifico.setColumns(10);

		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setVisible(false);
		lblStatus.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblStatus.setBounds(10, 222, 64, 14);
		getContentPane().add(lblStatus);

		txtStatus = new JTextField();
		txtStatus.setVisible(false);
		txtStatus.setBounds(66, 218, 86, 20);
		getContentPane().add(txtStatus);
		txtStatus.setColumns(10);

		JLabel lblHabitat = new JLabel("Habitat:");
		lblHabitat.setVisible(false);
		lblHabitat.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblHabitat.setBounds(220, 222, 64, 14);
		getContentPane().add(lblHabitat);

		txtHabitat = new JTextField();
		txtHabitat.setVisible(false);
		txtHabitat.setBounds(283, 218, 86, 20);
		getContentPane().add(txtHabitat);
		txtHabitat.setColumns(10);

		JLabel lblResultado = new JLabel("New label");
		lblResultado.setVisible(false);
		lblResultado.setBounds(261, 302, 46, 14);
		getContentPane().add(lblResultado);

		JButton btnAdd = new JButton("Add");
		btnAdd.setVisible(false);
		btnAdd.setFont(new Font("Courier New", Font.PLAIN, 11));
		btnAdd.setBounds(313, 252, 56, 23);
		getContentPane().add(btnAdd);

		Collection<JLabel> labelAnimais = new ArrayList<JLabel>();
		labelAnimais.add(lblNomeAnimal);
		labelAnimais.add(lblNomeCientifico);
		labelAnimais.add(lblStatus);
		labelAnimais.add(lblHabitat);

		Collection<JTextField> textsAnimal = new ArrayList<JTextField>();
		textsAnimal.add(txtNomeAnimal);
		textsAnimal.add(txtNomeCientifico);
		textsAnimal.add(txtStatus);
		textsAnimal.add(txtHabitat);

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
					conteudoFila.add(idAnimal+";"+ txtNomeAnimal.getText()+";"+txtNomeCientifico.getText()+";"+txtStatus.getText()+";"+txtHabitat.getText());
				}else {
					conteudoPilha.push(idAnimal+";"+ txtNomeAnimal.getText()+";"+txtNomeCientifico.getText()+";"+txtStatus.getText()+";"+txtHabitat.getText());
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

	public void preencherDadosFila() {
		
	}
}
