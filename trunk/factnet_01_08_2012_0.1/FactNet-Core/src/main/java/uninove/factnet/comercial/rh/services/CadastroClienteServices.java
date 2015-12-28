/**
 * 
 */
package uninove.factnet.comercial.rh.services;

import uninove.factnet.comercial.rh.dtos.CadastroClienteDTO;
import uninove.factnet.exceptions.InvalidLoginException;

/**
 * Interface com os metodos de manipulação dos cadastros de clientes.
 * @author cjalmeida
 *
 */
public interface CadastroClienteServices {

	public CadastroClienteDTO cadastrarCliente(CadastroClienteDTO cadastro) throws InvalidLoginException, Exception;
	
	public boolean existeCliente(String email);
}
