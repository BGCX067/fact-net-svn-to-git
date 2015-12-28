package br.com.bigdogsoftwares.uniserver.model.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.bigdogsoftwares.uniserver.model.entidade.pessoa.Pessoa;

public class CadastroDAO extends GenericDAO<Pessoa> {
	
	public Pessoa efetuarLogin(Long matricula, String senha){
		Session sessao = this.getConexao();
		try{
			Criteria query = sessao.createCriteria(Pessoa.class);
			query.add(Restrictions.and(Restrictions.eq("matricula", matricula), Restrictions.eq("senha", senha)));
			return (Pessoa) query.uniqueResult();
		}catch(Exception e){
			System.out.println("Erro ao efetuar login, ");
			e.printStackTrace();
		}finally{
			sessao.close();
		}
		return null;
	}
	
	public Pessoa verificarLogin(Long matricula){
		Session sessao = this.getConexao();
		try{
			Criteria query = sessao.createCriteria(Pessoa.class);
			query.add(Restrictions.eq("matricula", matricula));
			return (Pessoa) query.uniqueResult();
		}catch(Exception e){
			System.out.println("Erro ao efetuar login, ");
			e.printStackTrace();
		}finally{
			sessao.close();
		}
		return null;
	}

}
