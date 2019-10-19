import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrimeiraPag extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimeiraPag frame = new PrimeiraPag();
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
	public PrimeiraPag() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Ajuda");
		btnNewButton.setBounds(10, 220, 107, 30);
		contentPane.add(btnNewButton);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastro cadastrar = new TelaCadastro();
				//cadastrar.setvisible(true);
				dispose();
			}
		});
		btnCadastrar.setBounds(317, 220, 107, 30);
		contentPane.add(btnCadastrar);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(164, 220, 107, 30);
		contentPane.add(btnEntrar);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(59, 86, 317, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(59, 63, 317, 20);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setBounds(59, 127, 317, 20);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(59, 148, 317, 20);
		contentPane.add(passwordField);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(59, 11, 317, 41);
		contentPane.add(lblLogin);
	}
}
