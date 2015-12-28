package br.org.missaoart.gerenciador.dao;

import java.util.List;

import junit.framework.TestCase;
import br.org.missaoart.gerenciador.dao.carta.entinty.CartaEntinty;
import br.org.missaoart.gerenciador.dao.carta.entinty.ModeloCartaEntinty;
import br.org.missaoart.gerenciador.dao.carta.entinty.StatusCartaEntinty;
import br.org.missaoart.gerenciador.dao.membros.entinty.EnderecoEntinty;
import br.org.missaoart.gerenciador.dao.membros.entinty.PessoaEntinty;

public class CartaDAOTest extends TestCase {
	
	CartaDAO daoCarta;
	PessoaDAO daoPessoa;
	ModeloCartaDAO daoModelo;
	StatusCartaDAO daoStatus;
	Long idCartaSalva;
	
	@Override
	protected void setUp() throws Exception {
		this.daoCarta = new CartaDAO();
		this.daoPessoa = new PessoaDAO();
		this.daoModelo = new ModeloCartaDAO();
		this.daoStatus = new StatusCartaDAO();
		
		System.out.println("Preparando dados na tabela Pessoa");
		PessoaDAOTest pessoaTest = new PessoaDAOTest();
		pessoaTest.setUp();
		pessoaTest.testSalvar();
		
		System.out.println("Preparando dados na tabela Modelo");
		ModeloCartaDAOTest modeloTest = new ModeloCartaDAOTest();
		modeloTest.setUp();
		modeloTest.testSalvar();
		
		System.out.println("Preparando dados na tabela Status");
		StatusCartaDAOTest statusTest = new StatusCartaDAOTest();
		statusTest.setUp();
		statusTest.testSalvar();
	}
	
	public final void testSalvar() {
		CartaEntinty carta = new CartaEntinty();
		
		carta.setDescricao("Carta para Aniversariantes");
		carta.setTpCarta("carta de aniversario".toUpperCase());
		carta.setDestinatario(daoPessoa.obterPessoa(daoPessoa.selecionar().get(0).getIdPessoa()));
		carta.setModelo(daoModelo.obterModeloPorId(daoModelo.selecionar().get(0).getIdModelo()));
		carta.setStatusCarta(daoStatus.obterStatusPorId(daoStatus.selecionar().get(0).getIdStatus()));
		
		idCartaSalva = daoCarta.salvar(carta);
		
		assertTrue("Modelo não salvo", idCartaSalva != null);
		
		assertFalse("Modelo salvo", daoCarta.salvar(null) == null);
	}
	
	public final void testSelecionar() {
		List<CartaEntinty> cartas = daoCarta.selecionar();
		assertTrue("Lista nula ou vazia", cartas != null && cartas.size()>0);
		System.out.println("Objeto recuperado: "+cartas.get(0).getIdCarta());
	}

	public final void testAtualizar() {
		if(idCartaSalva == null){
			idCartaSalva = daoCarta.selecionar().get(0).getIdCarta();
		}
		CartaEntinty carta = daoCarta.obterCartaPorId(idCartaSalva);
		String oldDescricao = carta.getDescricao();
		carta.setDescricao("Carta de Teste");
		assertTrue("Modelo não atualizado", daoCarta.atualizar(carta));
		String novaDescricao = daoCarta.obterCartaPorId(idCartaSalva).getDescricao();
		assertFalse("Modelo nao atualizado, continua mesmo nome", oldDescricao.equalsIgnoreCase(novaDescricao));
		System.out.println("Antiga descricao:" +oldDescricao);
		System.out.println("Nova descricao: "+novaDescricao);
	}
	
	public void testObterCartaPorId(){
		if(idCartaSalva == null){
			this.testSalvar();
		}
		assertNotNull("Objeto nulo", daoCarta.obterCartaPorId(idCartaSalva));
		assertNull("Objeto retornado", daoCarta.obterCartaPorId(null));
		
	}
	
	public final void testExcluir() {
		if(idCartaSalva == null){
			idCartaSalva = daoCarta.selecionar().get(0).getIdCarta();
		}
		assertTrue("Erro ao excluir modelo por id", daoCarta.excluir(idCartaSalva));
		assertNull("Objeto retornado", daoCarta.obterCartaPorId(idCartaSalva));
		idCartaSalva = null;
		if(!limparTabelas()){
			fail("Erro ao limpar base de dados");
		}
	}
	
	private boolean limparTabelas(){
		System.out.println("Apagando  dados na tabela Pessoa");
		List<PessoaEntinty> pessoas = daoPessoa.selecionar();
		
		
		System.out.println("Apagando dados na tabela Modelo");
		List<ModeloCartaEntinty> modelos = daoModelo.selecionar();
		
		System.out.println("Apagando dados na tabela Status");
		List<StatusCartaEntinty> status = daoStatus.selecionar();
		EnderecoDAO daoEndereco = new EnderecoDAO();
		List<EnderecoEntinty> enderecos = daoEndereco.selecionar();
		
		System.out.println("============================================");
		System.out.println("Quantidade de linhas PESSOAS:"+pessoas.size());
		System.out.println("Quantidade de linhas ENDERECOS:"+enderecos.size());
		System.out.println("Quantidade de linhas MODELOS:"+modelos.size());
		System.out.println("Quantidade de linhas STATUS:"+status.size());
		System.out.println("============================================");
		
		try{
			for (int i = 0; i < pessoas.size(); i++) {
				daoModelo.excluir(modelos.get(i));
				daoPessoa.excluir(pessoas.get(i));
				daoStatus.excluir(status.get(i));
				daoEndereco.excluir(enderecos.get(i));
			}
		}catch (Exception e) {
			System.out.println("Erro ao limpar base");
			return false;
		}
		return true;
	}
	

}
