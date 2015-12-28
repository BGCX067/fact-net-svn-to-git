package br.org.missaoart.gerenciador.dao;

import java.util.Date;
import java.util.List;

import br.org.missaoart.gerenciador.dao.carta.entinty.StatusCartaEntinty;
import br.org.missaoart.gerenciador.dao.membros.entinty.EnderecoEntinty;
import junit.framework.TestCase;

public class StatusCartaDAOTest extends TestCase {

	StatusCartaDAO dao;
	
	protected void setUp() throws Exception {
		dao = new StatusCartaDAO();
		
		
	}

	public final void testSalvar() {

		StatusCartaEntinty status = new StatusCartaEntinty();
		status.setDescricao("Falha durante envio da carta");
		status.setDtStatus(new Date());
		status.setNmStatus("Falha envio".toUpperCase());
		
		assertTrue("Erro ao salvar status", dao.salvar(status));
	}

	public final void testSelecionar() {
		List<StatusCartaEntinty> lista = dao.selecionar();
		assertTrue("Erro, lista vazia", lista.size() > 0);
		StatusCartaEntinty status = lista.get(0);
		System.out.println("Status obtido: "+status.getNmStatus());
	}
	
	public final void testAtualizar() {
		StatusCartaEntinty status = dao.selecionar().get(0);
		String oldStatus = status.getNmStatus();
		status.setNmStatus("Sucesso envio".toUpperCase());
		
		dao.atualizar(status);
		
		status = dao.selecionar().get(0);
		assertFalse("Alteração com falha", oldStatus.equalsIgnoreCase(status.getNmStatus()));
	}
	
	public void testSelecionarPorId(){
		this.testSalvar();
		assertNotNull("Objeto nulo", dao.obterStatusPorId(dao.selecionar().get(0).getIdStatus()));
		assertNull("Objeto não nulo", dao.obterStatusPorId(null));
	}
	
	
	public final void testExcluirLong() {
		Long id = dao.selecionar().get(0).getIdStatus();
		assertTrue("Falha ao excluir",dao.excluir(id));
		assertNull("Objeto deveria ter sido excluido", dao.obterStatusPorId(id));
	}


	public final void testExcluirStatusCartaEntinty() {
		this.testSalvar();
		StatusCartaEntinty status = null;
		List<StatusCartaEntinty> listaStatus = dao.selecionar();
		if(listaStatus == null || listaStatus.size() < 1){
			fail("Falha ao recuperar objetos");
		}else{
			status = listaStatus.get(0);
			assertTrue("Objeto nao excluido",dao.excluir(status));
			assertNull("Objeto deveria ser nulo", dao.obterStatusPorId(status.getIdStatus()));
		}
		if(!limparTabela()){
			fail("Falha ao limpar tabela");
		}
	}

	private boolean limparTabela(){
		List<StatusCartaEntinty> status = dao.selecionar();
		
		System.out.println("============================================");
		System.out.println("Quantidade de linhas ENDERECOS:"+status.size());
		System.out.println("============================================");
		
		try{
			for (int i = 0; i < status.size(); i++) {
				dao.excluir(status.get(i));
			}
		}catch (Exception e) {
			System.out.println("Erro ao limpar base");
			return false;
		}
		return true;
	}

}
