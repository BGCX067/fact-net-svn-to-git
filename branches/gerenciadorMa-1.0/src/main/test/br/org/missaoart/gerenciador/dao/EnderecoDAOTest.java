package br.org.missaoart.gerenciador.dao;

import java.util.List;

import junit.framework.TestCase;
import br.org.missaoart.gerenciador.dao.membros.entinty.EnderecoEntinty;

public class EnderecoDAOTest extends TestCase{
	
	EnderecoDAO dao = null;
	Long idEnderecoSalvo;
	
	@Override
	protected void setUp() throws Exception {
		dao = new EnderecoDAO();
	}
	
	public void testSalvar(){
		EnderecoEntinty endereco = new EnderecoEntinty();
		endereco.setBairro("Sto Amaro");
		endereco.setCep("04821-010");
		endereco.setCidade("SAO PAULO");
		endereco.setEstado("SP");
		endereco.setNuResidencia(1254);
		endereco.setLogradouro("Av. Teste");
		endereco.setLatitude(12345.4564);
		endereco.setLongitude(125.64);
		
		idEnderecoSalvo = dao.salvar(endereco);
		assertTrue("Falha ao salvar endereco", idEnderecoSalvo != null);
	}
	
	public void testSelecionar(){
		List<EnderecoEntinty> listEndereco = dao.selecionar();
		System.out.println("Quantidade de Enderecos obtidas: "+listEndereco.size());
		assertEquals(1, listEndereco.size());
	}
	
	public void testAtualizar(){
		if(idEnderecoSalvo == null){
			idEnderecoSalvo = dao.selecionar().get(0).getIdEndereco();
		}
		EnderecoEntinty end = dao.obterEnderecoPorId(idEnderecoSalvo);
		String oldCidade = end.getCidade();
		end.setCidade("Rio de Janeiro");
		dao.atualizar(end);
		end = dao.obterEnderecoPorId(idEnderecoSalvo);
		assertTrue("Endereco nao atualizado", !oldCidade.equalsIgnoreCase(end.getCidade()));
	}
	
	public void testObterEnderecoPorId(){
		if(idEnderecoSalvo == null){
			List<EnderecoEntinty> listEndereco = dao.selecionar();
			if(listEndereco != null && listEndereco.size() > 0){
				idEnderecoSalvo = listEndereco.get(0).getIdEndereco();
			}else{
				this.testSalvar();
			}
		}
		EnderecoEntinty end = dao.obterEnderecoPorId(dao.selecionar().get(0).getIdEndereco());
		System.out.println("Endereco recuperado: "+end.getLogradouro()+","+end.getNuResidencia());
		assertNotNull("Erro ao obter endereco", end);
	}
	
	public void testExcluir(){
		if(idEnderecoSalvo == null){
			idEnderecoSalvo = dao.selecionar().get(0).getIdEndereco();
		}
		assertTrue("Erro ao apagar endereco",dao.excluir(idEnderecoSalvo));
		assertTrue("Tabela ainda contem dados", dao.selecionar().size() == 0);
		
		if(!this.limparTabela()){
			fail("Erro ao limpar tabela");
		}else{
			this.testSalvar();
			assertEquals("Exceção nao lancada",false, dao.excluir(dao.selecionar().get(0).getIdEndereco()+1));
		}
		if(!this.limparTabela()){
			fail("Erro ao limpar tabela - Final");
		}
	}
	
	private boolean limparTabela(){
		List<EnderecoEntinty> enderecos = dao.selecionar();
		
		System.out.println("============================================");
		System.out.println("Quantidade de linhas ENDERECOS:"+enderecos.size());
		System.out.println("============================================");
		
		try{
			for (int i = 0; i < enderecos.size(); i++) {
				dao.excluir(enderecos.get(i));
			}
		}catch (Exception e) {
			System.out.println("Erro ao limpar base");
			return false;
		}
		return true;
	}

}
