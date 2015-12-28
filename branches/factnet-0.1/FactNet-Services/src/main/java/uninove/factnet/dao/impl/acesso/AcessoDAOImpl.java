/**
 * 
 */
package uninove.factnet.dao.impl.acesso;

import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import uninove.factnet.dao.acesso.AcessoDAO;
import uninove.factnet.dao.rowmapper.acesso.PermissaoRowMapper;
import uninove.factnet.dao.rowmapper.acesso.PessoaRowMapper;
import uninove.factnet.dao.sql.acesso.AcessoSQL;
import uninove.factnet.dtos.PermissaoVO;
import uninove.factnet.dtos.PessoaDTO;
import uninove.factnet.enums.ETipoPessoa;

/**
 * @author cjalmeida
 *
 */
public class AcessoDAOImpl extends SimpleJdbcDaoSupport implements AcessoDAO {

	private static String SQL = new String();
	
	private AcessoSQL sqlFactory = new AcessoSQL();
	
	private PessoaRowMapper pessoaRowMapper;
	private PermissaoRowMapper permissaoRowMapper;
	
	/**
	 * @param pessoaRowMapper the pessoaRowMapper to set
	 */
	public void setPessoaRowMapper(PessoaRowMapper pessoaRowMapper) {
		this.pessoaRowMapper = pessoaRowMapper;
	}

	/**
	 * @param permissaoRowMapper the permissaoRowMapper to set
	 */
	public void setPermissaoRowMapper(PermissaoRowMapper permissaoRowMapper) {
		this.permissaoRowMapper = permissaoRowMapper;
	}

	public List<PessoaDTO> listarUsuarioPorLogin(PessoaDTO pessoaTemp) throws SQLException {
		SQL = sqlFactory.getString(AcessoSQL.LISTAR_USUARIO_POR_LOGIN);
		List<PessoaDTO> lista = (List<PessoaDTO>) getSimpleJdbcTemplate().query(SQL, pessoaRowMapper, new Object[]{pessoaTemp.getEmailLogin(),pessoaTemp.getSenha()});
		
		return (lista.size()== 0 ? null: lista);
	}

	public List<PermissaoVO> listarPermissoesPorId(Long idPessoa, ETipoPessoa tipoPessoa) throws SQLException {
		SQL = sqlFactory.getString(AcessoSQL.LISTAR_PERMISSOES_POR_ID_E_TIPO);
		List<PermissaoVO> lista = (List<PermissaoVO>) getSimpleJdbcTemplate().query(SQL, permissaoRowMapper, new Object[]{idPessoa,tipoPessoa.getId()});
		
		return (lista.size()!= 0 ? lista : null);
	}
	
	

}
