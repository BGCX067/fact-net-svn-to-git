/**
 * 
 */
package uninove.factnet.services.impl.comercial.rh;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import uninove.factnet.auth.services.AuthServices;
import uninove.factnet.comercial.rh.dtos.CadastroClienteDTO;
import uninove.factnet.comercial.rh.services.CadastroClienteServices;
import uninove.factnet.dao.comercial.rh.CadastroClienteDAO;
import uninove.factnet.dtos.FuncionarioVO;
import uninove.factnet.dtos.PessoaDTO;
import uninove.factnet.exceptions.InvalidLoginException;

/**
 * @author cjalmeida
 *
 */
public class CadastroClienteBusiness implements CadastroClienteServices {
	
	private CadastroClienteDAO cadastroDAO;

	/**
	 * @param cadastroDAO the cadastroDAO to set
	 */
	public void setCadastroDAO(CadastroClienteDAO cadastroDAO) {
		this.cadastroDAO = cadastroDAO;
	}

	
	public CadastroClienteDTO cadastrarCliente(CadastroClienteDTO cadastro) throws InvalidLoginException, Exception {
		/* 
		 * Seguir a ordem de cadastro de clientes. 
		 * 1º Cadastrar Cliente então
		 * 2º Cadastrar Permissoes então 
		 * 3º Cadastrar Login então
		 * 4º Cadastrar Funcionario_Cliente
		 */
		boolean permissoesCadastrada = false;
		boolean loginCadastrado = false;
		boolean funcClienteCadastrado = false;
		
		ApplicationContext applicationContext = 
			new ClassPathXmlApplicationContext("factnet-bean-factory.xml");
		
		AuthServices authService = (AuthServices) applicationContext.getBean("authServices");
		
		if(authService.buscarLogin(cadastro.getPessoa()) != null){
			throw new InvalidLoginException("O Usuario já exite");
		}
		
		boolean clienteCadastrado = cadastroDAO.cadastrarCliente(cadastro);
		
		if(clienteCadastrado){
			cadastro.getPessoa().getPermissoes().setIdCliente(cadastroDAO.buscarIdClienteCadastrado(cadastro).intValue());
			permissoesCadastrada = cadastroDAO.
					cadastrarPermissoes(cadastro.getPessoa().getPermissoes(),cadastro.getPessoa().getTipoPessoa());
		}
		if(permissoesCadastrada){
			cadastro.getPessoa().setId(cadastro.getPessoa().getPermissoes().getIdCliente());
			loginCadastrado = cadastroDAO.cadastrarLogin(cadastro);
		}
		if(loginCadastrado){
			FuncionarioVO funcionario = new FuncionarioVO();
			funcionario.setIdFuncionario(1);
			funcClienteCadastrado = cadastroDAO.cadastrarFuncionarioCliente(cadastro, funcionario);
		}
		
		
		if(funcClienteCadastrado && cadastro.getPessoa().getId().intValue() != 0){
			return cadastro;
		}
		return null;
	}

	public boolean existeCliente(String email) {
		PessoaDTO pessoa = cadastroDAO.buscarLoginPorEmail(email);
		return (pessoa != null);
	}

}
