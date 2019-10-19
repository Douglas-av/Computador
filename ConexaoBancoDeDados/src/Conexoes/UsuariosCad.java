package Conexoes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UsuariosCad extends JFrame {

	private JPanel contentPane;
	private UsuariosCad self;
	private JTextField txtCPF;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtSexo;
	private JTextField txtCargo;
	private JTextField txtEndereco;
	private JButton btnConfirmar;
	private JButton btnVoltar;
	private ListaUsuarios janela;
	
	public UsuariosCad(ListaUsuarios janela) {
		setTitle("Cadastrar");
		self = this;
		this.janela = janela;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 509, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCpf.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpf.setBounds(10, 11, 120, 25);
		contentPane.add(lblCpf);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNome.setBounds(10, 47, 120, 25);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdade.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblIdade.setBounds(10, 83, 120, 25);
		contentPane.add(lblIdade);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSexo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSexo.setBounds(10, 119, 120, 25);
		contentPane.add(lblSexo);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCargo.setBounds(10, 155, 120, 25);
		contentPane.add(lblCargo);
		
		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndereco.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblEndereco.setBounds(10, 191, 120, 25);
		contentPane.add(lblEndereco);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(140, 13, 287, 23);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(140, 49, 287, 23);
		contentPane.add(txtNome);
		
		txtIdade = new JTextField();
		txtIdade.setColumns(10);
		txtIdade.setBounds(140, 85, 287, 23);
		contentPane.add(txtIdade);
		
		txtSexo = new JTextField();
		txtSexo.setColumns(10);
		txtSexo.setBounds(140, 121, 287, 23);
		contentPane.add(txtSexo);
		
		txtCargo = new JTextField();
		txtCargo.setColumns(10);
		txtCargo.setBounds(140, 157, 287, 23);
		contentPane.add(txtCargo);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(140, 193, 287, 23);
		contentPane.add(txtEndereco);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realiazarAcao();
			}
		});
		btnConfirmar.setBounds(324, 227, 103, 36);
		contentPane.add(btnConfirmar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(20, 227, 103, 36);
		contentPane.add(btnVoltar);
	}

	public void realiazarAcao() {
		int cpf = Integer.parseInt(txtCPF.getText());
		String nome = txtNome.getText();
		int idade = Integer.parseInt(txtIdade.getText());
		String sexo =  txtSexo.getText();
		String cargo = txtCargo.getText();
		String endereco = txtEndereco.getText();
		
		DB.connect("Usuarios.db");
		
		String query = "insert into Usuarios ('CPF', 'Cargo', 'Nome', 'Idade', 'Sexo', 'Endereco') values (";
		query = query + "'" + cpf + "' ,";
		query = query + "'" + cargo + "' ,";
		query = query + "'" + nome + "' ," ;
		query = query + "'" + idade + "' ,";
		query = query + "'" + sexo + "' ,";
		query = query + "'" + endereco + "');";
		DB.execQuery(query);	
		System.out.println("Adicionado!");
		janela.atualizaTabela();
		dispose();
		
		
	}
	
}
