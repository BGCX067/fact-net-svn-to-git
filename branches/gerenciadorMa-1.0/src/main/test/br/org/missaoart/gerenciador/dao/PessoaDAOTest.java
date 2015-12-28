package br.org.missaoart.gerenciador.dao;

import java.util.Date;
import java.util.List;

import junit.framework.TestCase;
import br.org.missaoart.gerenciador.dao.membros.entinty.EnderecoEntinty;
import br.org.missaoart.gerenciador.dao.membros.entinty.PessoaEntinty;

public class PessoaDAOTest extends TestCase{
	
	PessoaDAO dao = null;
	EnderecoDAO daoEnd = null;
	Long idPessoaSalva;
	@Override
	protected void setUp() throws Exception {
		dao = new PessoaDAO();
		daoEnd = new EnderecoDAO();
	}
	
	public void testSalvar(){
		PessoaEntinty pessoa = new PessoaEntinty();
		pessoa.setDtNasc(new Date());
		pessoa.setEmail("teste@teste.com");
		pessoa.setMembroPrincipal(null);
		pessoa.setLogin("manolo");
		pessoa.setMinisterio("ADORACAO");
		pessoa.setNmPessoa("Manolo");
		pessoa.setNuCelular(new Long(123412345));
		pessoa.setNuIdentidade("12.345.678-9");
		pessoa.setNuTelefone(new Long(12345678));
		pessoa.setSenha("teste");
		pessoa.setTpPessoa("MEMBRO");
		
		EnderecoEntinty endereco = new EnderecoEntinty();
		endereco.setBairro("Sto Amaro");
		endereco.setCep("04821-010");
		endereco.setCidade("SAO PAULO");
		endereco.setEstado("SP");
		endereco.setNuResidencia(1254);
		endereco.setLogradouro("Av. Teste");
		endereco.setLatitude(12345.4564);
		endereco.setLongitude(125.64);
		
		daoEnd.salvar(endereco);
		pessoa.setEndereco(endereco);
		
		idPessoaSalva = dao.salvar(pessoa);
		assertTrue("Erro ao inserir pessoa", idPessoaSalva != null);
	}
	
	public void testObterPessoa(){
		if(idPessoaSalva == null){
			idPessoaSalva = dao.selecionar().get(0).getIdPessoa();
		}
		PessoaEntinty pessoa1 = dao.obterPessoa(idPessoaSalva);
		assertNotNull("Pessoa nulo - Qndo objeto era esperado",pessoa1);
		
		PessoaEntinty pessoa2 = dao.obterPessoa(idPessoaSalva+1);
		assertNull("Pessoa nao esperada - Chave nao existente", pessoa2);
	}
	
	public void testSelecionar(){
		List<PessoaEntinty> pessoas = dao.selecionar();
		assertNotNull("List de pessoas nulo",pessoas);
		assertEquals(1, pessoas.size());
	}
	
	public void testAtualizar(){
		if(idPessoaSalva == null){
			idPessoaSalva = dao.selecionar().get(0).getIdPessoa();
		}
		PessoaEntinty pessoa = dao.obterPessoa(idPessoaSalva);
		String oldNome = pessoa.getNmPessoa();
		pessoa.setNmPessoa("Derp");
		dao.atualizar(pessoa);
		pessoa = dao.obterPessoa(idPessoaSalva);
		assertTrue("Pessoa nao atualizada", !oldNome.equalsIgnoreCase(pessoa.getNmPessoa()));
	}
	
	public void testDelete(){
		if(idPessoaSalva == null){
			idPessoaSalva= dao.selecionar().get(0).getIdPessoa();
		}
		assertTrue("Falha ao excluir pessoa",dao.excluir(idPessoaSalva));
		assertNull("Ainda existe pessoas na base de dados", dao.selecionar().size() > 1 ? new Object() : null);
		
		if(!this.limparTabelas()){
			fail("Problemas ao limpar bases");
		}
	}
	
	private boolean limparTabelas(){
		EnderecoDAO daoEndereco = new EnderecoDAO();
		List<EnderecoEntinty> enderecos = daoEndereco.selecionar();
		
		System.out.println("============================================");
		System.out.println("Quantidade de linhas ENDERECOS:"+enderecos.size());
		System.out.println("============================================");
		
		try{
			for (int i = 0; i < enderecos.size(); i++) {
				daoEndereco.excluir(enderecos.get(i));
			}
		}catch (Exception e) {
			System.out.println("Erro ao limpar base");
			return false;
		}
		return true;
	}
}
