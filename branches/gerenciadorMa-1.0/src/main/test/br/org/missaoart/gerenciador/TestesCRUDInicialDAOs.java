package br.org.missaoart.gerenciador;

import br.org.missaoart.gerenciador.dao.CartaDAOTest;
import br.org.missaoart.gerenciador.dao.EnderecoDAOTest;
import br.org.missaoart.gerenciador.dao.GenericDAOTest;
import br.org.missaoart.gerenciador.dao.ModeloCartaDAOTest;
import br.org.missaoart.gerenciador.dao.PessoaDAOTest;
import br.org.missaoart.gerenciador.dao.StatusCartaDAOTest;
import junit.framework.Test;
import junit.framework.TestSuite;

public class TestesCRUDInicialDAOs {

	public static Test suite() {
		TestSuite suite = new TestSuite(TestesCRUDInicialDAOs.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(GenericDAOTest.class);
		suite.addTestSuite(PessoaDAOTest.class);
		suite.addTestSuite(EnderecoDAOTest.class);
		suite.addTestSuite(ModeloCartaDAOTest.class);
		suite.addTestSuite(StatusCartaDAOTest.class);
		suite.addTestSuite(CartaDAOTest.class);
		//$JUnit-END$
		return suite;
	}

}
