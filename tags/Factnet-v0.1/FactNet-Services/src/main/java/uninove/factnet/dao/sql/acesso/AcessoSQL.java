/**
 * 
 */
package uninove.factnet.dao.sql.acesso;

import java.util.ListResourceBundle;

/**
 * @author cjalmeida
 *
 */
public class AcessoSQL extends ListResourceBundle {
	

	@Override
	protected Object[][] getContents() {
		return new Object[][] {
				{LISTAR_USUARIO_POR_LOGIN, this.listarUsuarioPorLogin()},
				{LISTAR_PERMISSOES_POR_ID_E_TIPO, this.listarPermissoesPorId()}
		};
	}

	
	public final static String LISTAR_USUARIO_POR_LOGIN = "LISTAR_USUARIO_POR_LOGIN";
	public final static String LISTAR_PERMISSOES_POR_ID_E_TIPO = "LISTAR_PERMISSOES_POR_ID_E_TIPO";
	
	private String listarUsuarioPorLogin(){
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT \n");
		sql.append(" a.*, CASE WHEN a.tipoPessoa = 1 THEN c.nome ELSE d.nome END AS nome, \n");
		sql.append(" b.acessaAdm, acessaCMS, acessaCom, acessaEst,  \n");
	    sql.append(" acessaFat, acessaRel, acessaRH \n");
	    sql.append(" FROM login a \n");
	    sql.append(" INNER JOIN permissoes b ON b.tipoPessoa = a.tipoPessoa AND b.idPessoa = a.idPessoa \n");
	    sql.append(" LEFT JOIN cliente c ON c.id_cliente = a.idPessoa  \n");
	    sql.append(" LEFT JOIN funcionario d ON d.id_Funcionario = a.idPessoa \n");
	    sql.append(" WHERE a.login = ? AND a.senha = ?");
		return sql.toString();	
	}
	
	private String listarPermissoesPorId(){
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * \n");
		sql.append(" FROM permissoes \n");
		sql.append(" WHERE \n");
		sql.append(" idPessoa = ? AND tipoPessoa = ? ");
		return sql.toString();	
	}

}
