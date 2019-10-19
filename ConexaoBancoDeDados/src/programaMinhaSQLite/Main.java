package programaMinhaSQLite;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Conexoes.ConexaoSQLite;

public class Main {

	public static void main(String[] args) {

		ConexaoSQLite conexaoSQLite = new ConexaoSQLite();
		CriarBanco criarBanco = new CriarBanco(conexaoSQLite);
		criarBanco.criarTabelaPessoa();

		Pessoa pessoa1 = new Pessoa();
		pessoa1.setId(10);
		pessoa1.setNome("Douglas");
		pessoa1.setIdade(19);

		String sqlInsert = "INSERT INTO tbl_pessoa (" + "id," + "nome," + "idade" + ") VALUES(?,?,?)" + ";"; // ? =
																												// Parametro
																												// 1,2,3...
																												// para
																												// o
																												// preparedStatement.set...

		PreparedStatement preparedStatement = conexaoSQLite.criarPreparedStatement(sqlInsert);

		try {

			preparedStatement.setInt(1, pessoa1.getId());
			preparedStatement.setString(2, pessoa1.getNome());
			preparedStatement.setInt(3, pessoa1.getIdade());

			int resultado = preparedStatement.executeUpdate();

			if (resultado == 1) {
				System.out.println("Pessoa inserida!");
			} else {
				System.out.println("Pessoa não inserida!");
			}

		} catch (SQLException e) {
			System.out.println("Erro! Pessoa nao inserida!");
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conexaoSQLite.desconectar();
			}
		}
	}

}
