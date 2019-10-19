package Conexoes;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Prog {

	public static void main(String[] args) {

		ListaUsuarios janela = new ListaUsuarios();
		janela.setVisible(true);
		
		DB.connect("Usuarios.db");

		ResultSet res = DB.query("Select * from Usuarios");	

		try {
			while (res.next()) {
				int cpf = res.getInt("CPF");
				String cargo = res.getString("Cargo");
				String nome = res.getString("Nome");
				int idade = res.getInt("Idade");
				String sexo = res.getString("Sexo");
				String endereco = res.getString("Endereco");			
				System.out.println("CPF: " + cpf + " Nome: " + nome + " Idade:" + idade + " Sexo:" + sexo + " Endereco:" + endereco + " Cargo:" + cargo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
