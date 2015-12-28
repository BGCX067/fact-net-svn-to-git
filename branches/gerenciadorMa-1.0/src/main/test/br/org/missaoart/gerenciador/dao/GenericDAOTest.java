package br.org.missaoart.gerenciador.dao;

import java.io.File;

import junit.framework.TestCase;

import org.hibernate.Session;

public class GenericDAOTest extends TestCase{
	
	
	public void testObterArquivoConfigHibernate(){
		File file = GenericDAO.getArquivoConfiguracao();
		System.out.println("Arquivo existente? : "+file.exists());
		System.out.println("Path : "+file.getAbsolutePath());
		assertTrue("Arquivo não encontrado", file.exists());
	}
	
	public void testSessionCriada(){
		Session session = GenericDAO.getInstance();
		assertNotNull(session);
		assertTrue("Sessao nao conectada...",session.isConnected());
		assertTrue("Sessao nao aberta...",session.isOpen());
		
		session.close();
	}

}
