/**
 * 
 */
package uninove.factnet.dao.rowmapper.acesso;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import uninove.factnet.dtos.PermissaoVO;

/**
 * @author cjalmeida
 *
 */
public class PermissaoRowMapper implements ParameterizedRowMapper<PermissaoVO> {

	public PermissaoVO mapRow(ResultSet rs, int index) throws SQLException {
		PermissaoVO dto = new PermissaoVO();
		dto.setAcessarAdminstracao(rs.getBoolean("acessaAdm"));
		dto.setAcessarCMS(rs.getBoolean("acessaCMS"));
		dto.setAcessarComercial(rs.getBoolean("acessaCom"));
		dto.setAcessarEstoque(rs.getBoolean("acessaEst"));
		dto.setAcessarFaturas(rs.getBoolean("acessaFat"));
		dto.setAcessarRelatorios(rs.getBoolean("acessaRel"));
		dto.setAcessarRH(rs.getBoolean("acessaRH"));
		return dto;
	}

}
