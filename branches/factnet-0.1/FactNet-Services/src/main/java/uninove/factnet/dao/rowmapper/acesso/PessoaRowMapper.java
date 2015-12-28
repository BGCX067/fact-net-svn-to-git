/**
 * 
 */
package uninove.factnet.dao.rowmapper.acesso;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import uninove.factnet.dtos.PermissaoVO;
import uninove.factnet.dtos.PessoaDTO;
import uninove.factnet.enums.ETipoPessoa;

/**
 * @author cjalmeida
 *
 */
public class PessoaRowMapper implements ParameterizedRowMapper<PessoaDTO>{

	public PessoaDTO mapRow(ResultSet rs, int index) throws SQLException {
		PessoaDTO dto = new PessoaDTO();
		dto.setId(rs.getInt("idPessoa"));
		dto.setEmailLogin(rs.getString("login"));
		dto.setSenha(rs.getString("senha"));
		dto.setNome(rs.getString("nome"));
		dto.setTipoPessoa(ETipoPessoa.parse(rs.getInt("tipoPessoa")));
		
		PermissaoVO per = new PermissaoRowMapper().mapRow(rs, index);
		per.setIdCliente(dto.getId());
		dto.setPermissoes(per);
		
		return dto;
	}
	
	

}
