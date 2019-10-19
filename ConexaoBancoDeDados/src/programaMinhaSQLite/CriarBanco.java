package programaMinhaSQLite;

import java.sql.SQLException;
import java.sql.Statement;

import Conexoes.ConexaoSQLite;

public class CriarBanco {
	
	private final ConexaoSQLite conexaoSQLite;
	
	public CriarBanco(ConexaoSQLite pconexaoSQLite) {
		this.conexaoSQLite = pconexaoSQLite;
	}
	
	
	public void criarTabelaPessoa() {
		
		String sql = "CREATE TABLE IF NOT EXISTS tbl_pessoa"
				+"("
				+"id integer PRIMARY KEY,"
				+"nome text NOT NULL,"
				+"idade integer"
				+");";

		boolean conectou = false;
		
		try {
			conectou = this.conexaoSQLite.conectar();
			
			Statement stmt = this.conexaoSQLite.criarStatement();
			
			stmt.execute(sql);
			
			System.out.println("Tabela Pessoa Criada!");
			
		}catch(SQLException e) {
			
		}finally {
			if(conectou) {
				this.conexaoSQLite.desconectar();
			}
		}
	}
	

	

}
