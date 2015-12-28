/**
 * 
 */
package uninove.factnet.dao.sql.comercial.rh;

import java.util.ListResourceBundle;

/**
 * @author cjalmeida
 *
 */
public class CadastroClienteSQL extends ListResourceBundle{

	@Override
	protected Object[][] getContents() {
		return new Object[][] {
				{BUSCA_LOGIN_POR_EMAIL, this.buscaLoginEmail()},
				{CADASTRAR_CLIENTE, this.cadastrarCliente()},
				{OBTER_ID_CLIENTE, this.obterSequencialCliente()},
				{CADASTRAR_PERMISSOES, this.cadastrarPermissoes()},
				{CADASTRAR_LOGIN, this.cadastrarLogin()},
				{CADASTRAR_CLIENTE_FUNCIONARIO, this.cadastrarClienteFuncionario()}
		};
	}
	
	public final static String BUSCA_LOGIN_POR_EMAIL = "BUSCA_LOGIN_POR_EMAIL";
	public final static String CADASTRAR_CLIENTE = "CADASTRAR_CLIENTE";
	public final static String OBTER_ID_CLIENTE = "OBTER_ID_CLIENTE";
	public final static String CADASTRAR_PERMISSOES = "CADASTRAR_PERMISSOES";
	public final static String CADASTRAR_LOGIN = "CADASTRAR_LOGIN";
	public final static String CADASTRAR_CLIENTE_FUNCIONARIO = "CADASTRAR_CLIENTE_FUNCIONARIO";
	
	private String buscaLoginEmail(){
		StringBuffer string = new StringBuffer();
		string.append(" SELECT * FROM login a \n");
		string.append(" INNER JOIN permissoes b ON b.idPessoa = a.idPessoa \n");
		string.append(" WHERE a.login = ?");
		return string.toString(); 
	}
	
	private String cadastrarCliente(){
		StringBuffer string = new StringBuffer();
		string.append(" INSERT INTO \n");
		string.append(" cliente(id_cliente, nome, endereco, telefone, email, pl_ativo) \n");
		string.append(" SELECT MAX(id_cliente)+1, ?, ?, ?, ?, ? FROM cliente ");
		return string.toString();
	}
	
	private String obterSequencialCliente(){
		StringBuffer string = new StringBuffer();
		string.append(" SELECT MAX(id_cliente) as sequencial FROM cliente WHERE nome = ? AND email = ?");
		return string.toString();
	}

	private String cadastrarPermissoes(){
		StringBuffer string = new StringBuffer();
		string.append(" INSERT INTO \n");
		string.append(" permissoes(idPessoa, acessaAdm, acessaCMS, acessaCom, acessaEst, \n");
		string.append(" acessaFat, acessaRel, acessaRH, tipoPessoa) \n");
		string.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?) ");
		return string.toString();
	}
	
	private String cadastrarLogin(){
		StringBuffer string = new StringBuffer();
		string.append(" INSERT INTO \n");
		string.append(" login (login, senha, idPessoa, tipoPessoa) \n");
		string.append(" VALUES( ?, ?, ? ,?) ");
		return string.toString();
	}

	private String cadastrarClienteFuncionario(){
		StringBuffer string = new StringBuffer();
		string.append(" INSERT INTO \n");
		string.append(" funcionario_cliente(meio_inclusao, data_inclusao, id_cliente, id_funcionario) \n");
		string.append(" VALUES (?, ?, ?, ?) ");
		return string.toString();
	}
}
