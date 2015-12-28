/**
 * 
 */
package uninove.factnet.services.impl.auth;

import java.sql.SQLException;
import java.util.List;

import uninove.factnet.auth.services.AuthServices;
import uninove.factnet.dao.acesso.AcessoDAO;
import uninove.factnet.dtos.PermissaoVO;
import uninove.factnet.dtos.PessoaDTO;
import uninove.factnet.exceptions.BusinessException;

/**
 * @author cjalmeida
 *
 */
public class AuthBusiness implements AuthServices {
	
	private AcessoDAO acessoDAO;
	
	/**
	 * @param acessoDAO the acessoDAO to set
	 */
	public void setAcessoDAO(AcessoDAO acessoDAO) {
		this.acessoDAO = acessoDAO;
	}

	public PessoaDTO buscarLogin(PessoaDTO pessoaTemp)throws BusinessException {
		PessoaDTO pessoa = null;
		try{
			List<PessoaDTO> listaPessoas = acessoDAO.listarUsuarioPorLogin(pessoaTemp);
			if(listaPessoas != null){
				if(listaPessoas.size() != 1){
					throw new BusinessException("[buscarLogin] - Erro ao consultar login.Verifique as informações inseridas.");
				}else{
					pessoa = listaPessoas.get(0);
				}
			}
		}catch (SQLException e) {
			throw new BusinessException("[buscarLogin] - Erro ao acessar a Base de Dados. Tente novamente em instantes", e);
		}catch (Exception e) {
			throw new BusinessException("[buscarLogin] - Ocorreu um erro interno.Tente novamente em instantes", e);
		}
		return pessoa;
	}

	public PermissaoVO buscarPermissoes(PessoaDTO pessoaTemp)throws BusinessException {
		PermissaoVO permissao = null;
		try{
			List<PermissaoVO> listaPermissoes = acessoDAO.listarPermissoesPorId(pessoaTemp.getId().longValue(), pessoaTemp.getTipoPessoa());
			if(listaPermissoes == null || listaPermissoes.size() != 1){
				throw new BusinessException(" [buscarPermissoes] - Erro ao consultar as permissões. Verifique os dados inseridos.");
			}else{
				permissao = listaPermissoes.get(0);
			}
		}catch (SQLException e) {
			throw new BusinessException("[buscarPermissoes] - Erro ao acessar a Base de Dados. Tente novamente em instantes", e);
		}catch (Exception e) {
			throw new BusinessException("[buscarPermissoes] - Ocorreu um erro interno.Tente novamente em instantes", e);
		}
		return permissao;
	}
	
	

}
