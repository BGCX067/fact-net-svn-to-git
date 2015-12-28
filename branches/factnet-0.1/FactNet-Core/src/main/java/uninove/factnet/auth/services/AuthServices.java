/**
 * 
 */
package uninove.factnet.auth.services;

import uninove.factnet.dtos.PermissaoVO;
import uninove.factnet.dtos.PessoaDTO;
import uninove.factnet.exceptions.BusinessException;

/**
 * Interface que declara todos os serviços disponiveis para o modulo de Autorização de Login.
 * @author cjalmeida
 * @since 0.1
 * @version 1.0
 *
 */
public interface AuthServices {
	
	public PessoaDTO buscarLogin(PessoaDTO pessoaTemp) throws BusinessException ;
	
	public PermissaoVO buscarPermissoes(PessoaDTO pessoaTemp) throws BusinessException ; 
	
}
