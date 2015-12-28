package br.org.missaoart.gerenciador.dao;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public abstract class GenericDAO<T> {
	
	private static SessionFactory sessionFactory;
	private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private static File file = new File(ClassLoader.getSystemResource("hibernate.cfg.xml").getPath());
	
	private static Logger log = Logger.getLogger(GenericDAO.class);
	
	static{
		log.debug("Iniciando SessionFactory");
		try{
		sessionFactory = new AnnotationConfiguration().configure(file).buildSessionFactory();
		}catch (Throwable t) {
			log.error("Erro ao iniciar SessionFactory", t);
			throw new ExceptionInInitializerError("Erro ao iniciar SessionFactory");
		}
	}
	
	public static Session getInstance(){
		log.debug("Gerando nova Session");
		Session session = threadLocal.get();
		session = sessionFactory.openSession();
		log.debug("Adcionando Session na ThreadLocal");
		threadLocal.set(session);
		
		log.info("Session gerada com sucesso.. Retornando Session");
		return session;
	}
	
	public static File getArquivoConfiguracao(){
		return file;
	}
	
	public abstract Long salvar(T objeto);
	public abstract boolean atualizar(T objeto);
	public abstract boolean excluir(T objeto);
	public abstract boolean excluir(Long id);
	public abstract List<T> selecionar();
	
}
