/**
 * 
 */
package uninove.factnet.dao.impl.comercial.rh;

import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import uninove.factnet.comercial.rh.dtos.CadastroClienteDTO;
import uninove.factnet.dao.comercial.rh.CadastroClienteDAO;
import uninove.factnet.dao.rowmapper.acesso.PessoaRowMapper;
import uninove.factnet.dao.sql.comercial.rh.CadastroClienteSQL;
import uninove.factnet.dtos.FuncionarioVO;
import uninove.factnet.dtos.PermissaoVO;
import uninove.factnet.dtos.PessoaDTO;
import uninove.factnet.enums.ETipoPessoa;

/**
 * Classe com todas as operações de acesso a dados referentes a cadastros de funcionarios e clientes. (WEB e DESK)
 * @author cjalmeida
 *
 */
public class CadastroClienteDAOImpl extends SimpleJdbcDaoSupport implements CadastroClienteDAO {

	private static String SQL = new String();  
	private static CadastroClienteSQL sqlFactory = new CadastroClienteSQL();
	
	private PessoaRowMapper pessoaRowMapper;
	
	/**
	 * @param pessoaRowMapper the pessoaRowMapper to set
	 */
	public void setPessoaRowMapper(PessoaRowMapper pessoaRowMapper) {
		this.pessoaRowMapper = pessoaRowMapper;
	}
	
	public PessoaDTO buscarLoginPorEmail(String loginEmail) {
		SQL = sqlFactory.getString(CadastroClienteSQL.BUSCA_LOGIN_POR_EMAIL);
		PessoaDTO dto = null;
		List<PessoaDTO> listaPessoas =  getSimpleJdbcTemplate().query(SQL, pessoaRowMapper, new Object[]{loginEmail});
		
		if(listaPessoas.size() == 1){
			dto = listaPessoas.get(0);
		}
		
		return dto;
	}

	public boolean cadastrarCliente(CadastroClienteDTO cadastro) {
		SQL = sqlFactory.getString(CadastroClienteSQL.CADASTRAR_CLIENTE);
		int linhasAlteradas = getSimpleJdbcTemplate().update(SQL, 
				new Object[]{cadastro.getPessoa().getNome()+" "+cadastro.getPessoa().getSobrenome(), 
							 cadastro.getEndereco(), cadastro.getTelefone(),
							 cadastro.getPessoa().getEmailLogin(), cadastro.getFlAtivo()});
		return linhasAlteradas != 0;
	}

	public int cadastrarFuncionario(FuncionarioVO funcionario) {
		// TODO Auto-generated method stub
		return 0;
	}


	public PessoaDTO buscarClientePorLoginSenha(String loginEmail, String senha) {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean cadastrarPermissoes(PermissaoVO permissao, ETipoPessoa tipoPessoa) {
		SQL = sqlFactory.getString(CadastroClienteSQL.CADASTRAR_PERMISSOES);
		if(permissao.getIdCliente() != null && permissao.getIdCliente().intValue() != 0){
			
			int linhasAlteradas = getSimpleJdbcTemplate().update(SQL, new Object[]{
					permissao.getIdCliente(), permissao.isAcessarAdminstracao(), permissao.isAcessarCMS(),
					permissao.isAcessarComercial(), permissao.isAcessarEstoque(), permissao.isAcessarFaturas(),
					permissao.isAcessarRelatorios(), permissao.isAcessarRH(), tipoPessoa.getId()
			});
			
			return (linhasAlteradas != 0);
		}
		return false;
	}


	public boolean cadastrarLogin(CadastroClienteDTO cadastro) {
		SQL = sqlFactory.getString(CadastroClienteSQL.CADASTRAR_LOGIN);
		if(cadastro.getPessoa().getId().intValue() == 0){
			return false;
		}
		
		int linhasAlteradas = getSimpleJdbcTemplate().update(SQL, new Object[]{
			cadastro.getPessoa().getEmailLogin(), cadastro.getPessoa().getSenha(),
			cadastro.getPessoa().getId(), cadastro.getPessoa().getTipoPessoa().getId()
		});
		
		return (linhasAlteradas != 0);
	}


	public boolean cadastrarFuncionarioCliente(CadastroClienteDTO cadastro, FuncionarioVO funcionario) {
		SQL = sqlFactory.getString(CadastroClienteSQL.CADASTRAR_CLIENTE_FUNCIONARIO);
		if(cadastro.getPessoa().getId().intValue() == 0 && funcionario.getIdFuncionario().intValue() == 0){
			return false;
		}
		
		int linhasAlteradas = getSimpleJdbcTemplate().update(SQL, new Object[]{
			cadastro.getMeioInclusao().getNome(), new Date(), cadastro.getPessoa().getId(), funcionario.getIdFuncionario()	
		});
		return (linhasAlteradas != 0);
	}
	
	public Long buscarIdClienteCadastrado(CadastroClienteDTO cadastro){
		SQL = sqlFactory.getString(CadastroClienteSQL.OBTER_ID_CLIENTE);
		try{
			return getSimpleJdbcTemplate().queryForLong(SQL, 
					new Object[]{cadastro.getPessoa().getNome()+" "+cadastro.getPessoa().getSobrenome(), 
								 cadastro.getPessoa().getEmailLogin()}); 
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	

}
