import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Queue;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import javafx.scene.control.RadioButton;

import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

public class TelaSecundaria extends ManipularArquivo {

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

	public TelaSecundaria(int escolha) {
		String complemento = "";
		String[] columnNames= {"teste"};
		if (escolha == 1) {
			complemento = "do Aumento dos Oceanos";
		} else if (escolha == 2) {
			complemento = "do derretimento das Calotas";
		} else {
			complemento = "da extinção dos animais";
		}
		initialize(complemento, escolha);
	}

	private void initialize(String complemento, int escolha) {
		setVisible(true);
		setBounds(100, 100, 619, 458);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblTituloTelaSecundaria = new JLabel("Gerenciamento de dados\r\n");
		lblTituloTelaSecundaria.setBounds(85, 11, 295, 14);
		lblTituloTelaSecundaria.setFont(new Font("Courier New", Font.BOLD, 20));
		getContentPane().add(lblTituloTelaSecundaria);

		JLabel lblEscolha = new JLabel(complemento);
		lblEscolha.setBounds(144, 38, 208, 14);
		getContentPane().add(lblEscolha);



		JButton btnAlterar = new JButton("Alterar\r\n");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManipularArquivo manipularArquivo = new ManipularArquivo();
				Queue<String> conteudo = manipularArquivo.abrirArquivo();
				DefaultListModel<String> dlm = new DefaultListModel<String>();
				dlm.addElement(manipularArquivo.getHeader());
				System.out.println(conteudo.size());
				for (int i = 0; i <= conteudo.size(); i++) {
					//					System.out.println(conteudo.poll());
					//					System.out.println(conteudo.size());
					dlm.addElement(conteudo.poll());
				}
				dlm.addElement(conteudo.poll());
				//				list.setModel(dlm);
			}
		});
		btnAlterar.setFont(new Font("Courier New", Font.PLAIN, 11));
		btnAlterar.setBounds(10, 122, 89, 23);
		getContentPane().add(btnAlterar);

		JButton btnVoltar = new JButton("Voltar\r\n");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaPrincipal = new TelaPrincipal();
				dispose();
				telaPrincipal.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Courier New", Font.PLAIN, 11));
		btnVoltar.setBounds(165, 88, 89, 23);
		getContentPane().add(btnVoltar);

		//		JButton btnOrdenar = new JButton("Ordenar");
		//		btnOrdenar.addActionListener(new ActionListener() {
		//			public void actionPerformed(ActionEvent e) {
		//				String[] teste = new String[list.getModel().getSize()-1];
		//				int j = 0;
		//				for (int i = 1; i < list.getModel().getSize(); i++) {
		//					String elemento = list.getModel().getElementAt(i).toString();
		//					String element = elemento.split(";")[1];
		//					teste[j] = element;
		//					j++;
		//				}
		//				for (String i : teste) {
		//					System.out.println(i);
		//				}

		//				int testeInt[] = new int[list.getModel().getSize()-1];
		//				int j2 = 0;
		//				for (int i = 1; i < list.getModel().getSize(); i++) {
		//					String elemento2 = list.getModel().getElementAt(i);
		//					String element2 = elemento2.split(";")[1];
		//					testeInt[j2] = Integer.parseInt(element2);
		//					j2++;
		//				}

		//				metodosOrdenacao metodosOrdencao = new metodosOrdenacao();
		//				testeInt = metodosOrdenacao.ordenacaoSelecao(testeInt);
		//				System.out.println("--------------------");
		//
		////				Arrays.sort(testeInt);
		//				for (int i : testeInt) {
		//					System.out.println(i);
		//				}


		//				try {
		//					FileWriter arq = new FileWriter(path + "/quicksort" + getTipoArq());
		//					PrintWriter escreverArq = new PrintWriter(arq);
		//
		//					for (String i : teste) {
		//						escreverArq.print(i);
		//					}
		//					arq.close();
		//
		//				} catch (IOException e1) {
		//					// TODO Auto-generated catch block
		//					e1.printStackTrace();
		//				}
		//
		//			}
		//		});
		//		btnOrdenar.setBounds(10, 156, 89, 23);
		//		getContentPane().add(btnOrdenar);

		JLabel lblEnfeite = new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		lblEnfeite.setBounds(0, 63, 515, 14);
		getContentPane().add(lblEnfeite);
		
		JButton btnCriar = new JButton("Criar\r\n");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (escolha==3) {
					TelaCriarAnimal telaCriarAnimal = new TelaCriarAnimal();
					telaCriarAnimal.setVisible(true);
				}else if(escolha==2) {
					
				}else {
					
				}
				dispose();
			}
		});
		btnCriar.setFont(new Font("Courier New", Font.PLAIN, 11));
		btnCriar.setBounds(10, 88, 89, 23);
		getContentPane().add(btnCriar);

	}
}
