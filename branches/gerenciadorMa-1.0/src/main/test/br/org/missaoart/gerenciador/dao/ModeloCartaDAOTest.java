package br.org.missaoart.gerenciador.dao;

import java.util.List;

import br.org.missaoart.gerenciador.dao.carta.entinty.ModeloCartaEntinty;
import junit.framework.TestCase;

public class ModeloCartaDAOTest extends TestCase {

	ModeloCartaDAO dao;
	
	@Override
	protected void setUp() throws Exception {
		this.dao = new ModeloCartaDAO();
	}

	public final void testSalvar() {
		ModeloCartaEntinty modelo = new ModeloCartaEntinty();
		modelo.setDescricao("Carta para Aniversariantes");
		modelo.setNmArquivo("carta_niver.jasper");
		modelo.setNmModelo("carta de aniversario".toUpperCase());
		
		assertTrue("Modelo não salvo",dao.salvar(modelo));
		
		assertFalse("Modelo salvo", dao.salvar(null));
	}
	
	public final void testSelecionar() {
		List<ModeloCartaEntinty> modelos = dao.selecionar();
		assertTrue("Lista nula ou vazia", modelos != null && modelos.size()>0);
		System.out.println("Objeto recuperado: "+modelos.get(0).getNmModelo());
	}

	public final void testAtualizar() {
		List<ModeloCartaEntinty> modelos = dao.selecionar();
		ModeloCartaEntinty modelo = modelos.get(0);
		String oldNome = modelo.getNmModelo();
		modelo.setNmModelo("carta de aviso".toUpperCase());
		assertTrue("Modelo não atualizado", dao.atualizar(modelo));
		String novoNome = dao.selecionar().get(0).getNmModelo();
		assertFalse("Modelo nao atualizado, continua mesmo nome", oldNome.equalsIgnoreCase(novoNome));
		System.out.println("Antigo nome:" +oldNome);
		System.out.println("Novo nome: "+novoNome);
	}
	

	public void testObterModeloPorID(){
		assertNotNull("Objeto nulo", dao.obterModeloPorId(dao.selecionar().get(0).getIdModelo()));
		assertNull("Objeto retornado", dao.obterModeloPorId(null));
	}
	
	
	public final void testExcluirLong() {
		Long id = dao.selecionar().get(0).getIdModelo();
		assertTrue("Erro ao excluir modelo por id", dao.excluir(id));
		assertNull("Objeto retornado", dao.obterModeloPorId(id));
	}

	public final void testExcluirModeloCartaEntinty() {
		this.testSalvar();
		List<ModeloCartaEntinty> modelos = dao.selecionar();
		ModeloCartaEntinty modelo = modelos.get(0);
		
		assertTrue("Falha ao excluir modelo", dao.excluir(modelo));
		modelos = dao.selecionar();
		assertTrue("Objeto retornado", modelos == null || modelos.size()==0);
		System.out.println("Size da lista apos exclusao:"+modelos.size());
	}
	
	

}
