package Conexoes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Dictionary;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListaUsuarios extends JFrame {

	private ListaUsuarios self;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable tabela;

	public ListaUsuarios() {
		self = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblListaDeUsuarios = new JLabel("Lista de Usuarios");
		lblListaDeUsuarios.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblListaDeUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeUsuarios.setBounds(10, 0, 490, 33);
		contentPane.add(lblListaDeUsuarios);

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuariosCad janela = new UsuariosCad(self);
				janela.setVisible(true);
				dispose();
			}
		});
		btnNovo.setBounds(10, 296, 163, 25);
		contentPane.add(btnNovo);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linha = tabela.getSelectedRow();
				if (linha >= 0) {
					int id = (int) tabela.getValueAt(linha, 0);
					DB.connect("Usuarios.db");
					System.out.println("UPDATE Usuarios set " + tabela.getColumnName(tabela.getSelectedColumn()) + " = \"" + 
							tabela.getValueAt(linha, tabela.getSelectedColumn()) + "\" WHERE CPF =" + id);
					DB.execQuery("UPDATE Usuarios set " + tabela.getColumnName(tabela.getSelectedColumn()) + " = \"" + 
							tabela.getValueAt(linha, tabela.getSelectedColumn()) + "\" WHERE CPF =" + id);
				}
			}
		});
		btnAlterar.setBounds(183, 296, 147, 25);
		contentPane.add(btnAlterar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});
		btnExcluir.setBounds(340, 296, 160, 25);
		contentPane.add(btnExcluir);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 44, 490, 241);
		contentPane.add(scrollPane);
		atualizaTabela();

	}

	public void alteraBanco(int cpf, String cargo, String nome, int idade, char sexo, String endereco, ActionEvent e) {
		
	}

	public void atualizaTabela() {
		self.setVisible(true);
		DB.connect("Usuarios.db");
		tabela = new JTable();
		// Definir o cabeçalho da tabela.
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
		String[] colunas = { "CPF", "Cargo", "Nome", "Idade", "Sexo", "Endereco" };
		modelo.setColumnIdentifiers(colunas);

		ResultSet res = DB.query("Select * from Usuarios");

		try {
			while (res.next()) {
				int cpf = res.getInt("CPF");
				String cargo = res.getString("Cargo");
				String nome = res.getString("Nome");
				int idade = res.getInt("Idade");
				String sexo = res.getString("Sexo");
				String endereco = res.getString("Endereco");
				// System.out.println("CPF: " + cpf + " Nome: " + nome + " Idade:" + idade + "
				// Sexo:" + sexo + " Endereco:" + endereco + " Cargo:" + cargo);
				Object[] objects = { cpf, cargo, nome, idade, sexo, endereco };
				modelo.addRow(objects);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scrollPane.setViewportView(tabela);
	}

	public void excluir() {
		int linha = tabela.getSelectedRow();
		if (linha >= 0) {
			int id = (int) tabela.getValueAt(linha, 0);
			DB.connect("Usuarios.db");
			DB.execQuery("Delete from Usuarios where CPF = " + id);
			atualizaTabela();
			JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "É necessario selecionar uma linha.");
		}

	}

}
