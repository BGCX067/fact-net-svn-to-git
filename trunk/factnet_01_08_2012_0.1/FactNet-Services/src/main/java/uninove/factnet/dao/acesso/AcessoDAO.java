/**
 * 
 */
package uninove.factnet.dao.acesso;

import java.sql.SQLException;
import java.util.List;

import uninove.factnet.dtos.PermissaoVO;
import uninove.factnet.dtos.PessoaDTO;
import uninove.factnet.enums.ETipoPessoa;

/**
 * @author cjalmeida
 *
 */
public interface AcessoDAO {

	public List<PessoaDTO> listarUsuarioPorLogin(PessoaDTO pessoaTemp)throws SQLException;
	
	public List<PermissaoVO> listarPermissoesPorId(Long idPessoa, ETipoPessoa tipoPessoa) throws SQLException;
}
