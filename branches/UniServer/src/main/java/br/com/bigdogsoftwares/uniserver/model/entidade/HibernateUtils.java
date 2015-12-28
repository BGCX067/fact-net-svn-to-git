package br.com.bigdogsoftwares.uniserver.model.entidade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.bigdogsoftwares.uniserver.model.dao.CadastroDAO;
import br.com.bigdogsoftwares.uniserver.model.dao.GenericDAO;
import br.com.bigdogsoftwares.uniserver.model.entidade.admin.Adminstrador;
import br.com.bigdogsoftwares.uniserver.model.entidade.admin.Permissoes;
import br.com.bigdogsoftwares.uniserver.model.entidade.pessoa.Pessoa;
import br.com.bigdogsoftwares.uniserver.model.entidade.pessoa.Professor;

public class HibernateUtils {
	
	public static SessionFactory factory;
	
	static{
		try{
		factory = new AnnotationConfiguration()
								.configure().buildSessionFactory();
		}catch (Exception e) {
			System.out.println("Erro ao carregar configurações do Hibernate, ");
			e.printStackTrace();
		}
	}
	
	 
	/**
	 * Obtem uma instância ativa de conexão ({@link Session}) com o Banco de Dados
	 * @return Sessão ativa com o banco de dados.
	 */
	public static Session getConection(){
		return factory.openSession();
	}
	
	
	public static void main(String[] args) {
		Adminstrador admin = new Adminstrador();
		admin.setLogin("admin");
		admin.setSenha("admin");
		admin.setNome("Big Dog Master");
		
		Permissoes p = new Permissoes();
		p.setEdit(true);
		p.setReport(true);
		p.setVisualize(true);
		
		p.setId(new GenericDAO<Permissoes>().salvar(p));
		
		admin.setPermissoes(p);
		
		System.out.println(new GenericDAO<Adminstrador>().salvar(admin));
	}
}
