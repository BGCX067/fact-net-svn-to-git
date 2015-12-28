/**
 * 
 */
package uninove.factnet.dao.comercial.rh;

import uninove.factnet.comercial.rh.dtos.CadastroClienteDTO;
import uninove.factnet.dtos.FuncionarioVO;
import uninove.factnet.dtos.PermissaoVO;
import uninove.factnet.dtos.PessoaDTO;
import uninove.factnet.enums.ETipoPessoa;

/**
 * @author cjalmeida
 *
 */
public interface CadastroClienteDAO {
	
	public PessoaDTO buscarLoginPorEmail(String loginEmail);
	
	public PessoaDTO buscarClientePorLoginSenha(String loginEmail, String senha);
	
	public boolean cadastrarCliente(CadastroClienteDTO cadastro);
	
	public boolean cadastrarPermissoes(PermissaoVO permissao, ETipoPessoa tipoPessoa);
	
	public boolean cadastrarLogin(CadastroClienteDTO cadastro);
	
	public boolean cadastrarFuncionarioCliente(CadastroClienteDTO cadastro, FuncionarioVO funcionario);
	
	public int cadastrarFuncionario(FuncionarioVO funcionario);
	
	public Long buscarIdClienteCadastrado(CadastroClienteDTO cadastro);

}
