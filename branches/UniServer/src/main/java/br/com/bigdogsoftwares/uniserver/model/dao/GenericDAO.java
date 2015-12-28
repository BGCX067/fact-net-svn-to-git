package br.com.bigdogsoftwares.uniserver.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.bigdogsoftwares.uniserver.model.entidade.HibernateUtils;

public class GenericDAO<T> {
	
	protected Session getConexao(){
		return HibernateUtils.getConection();
	}
	
	public Long salvar(T t){
		Session sessao = null;
		Transaction transacao = null;
		try{
			sessao = this.getConexao();
			transacao = sessao.beginTransaction();
			transacao.begin();
			Long id = (Long) sessao.save(t);
			transacao.commit();
			return id;
		}catch(Exception e){
			System.out.println("Erro ao salvar registro,");
			e.printStackTrace();
			if(transacao != null){
				transacao.rollback();
			}
		}finally{
			sessao.close();
		}
		return null;
	}
	
	public boolean apagar(T t){
		Session sessao = null;
		Transaction transacao = null;
		try{
			sessao = this.getConexao();
			transacao = sessao.beginTransaction();
			sessao.delete(t);
			transacao.commit();
			return true;
		}catch(Exception e){
			System.out.println("Erro ao apagar registro, ");
			e.printStackTrace();
			if(transacao != null){
				transacao.rollback();
			}
			return false;
		}finally{
			sessao.close();
		}
	}
	
	public boolean atualizar(T t){
		Session sessao = null;
		Transaction transacao = null;
		
		try{
			sessao = this.getConexao();
			transacao = sessao.beginTransaction();
			sessao.update(t);
			transacao.commit();
			return true;
		}catch(Exception e){
			System.out.println("Erro ao atualizar registro, ");
			e.printStackTrace();
			if(transacao != null){
				transacao.rollback();
			}
			return false;
		}finally{
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listarTodos(T t){
		Session sessao = null;
		try{
			sessao = this.getConexao();
			Criteria query = sessao.createCriteria(t.getClass());
			return (List<T>)query.list();
		}catch(Exception e){
			System.out.println("Erro ao listar Registros tente novamente");
			e.printStackTrace();
			return null;
		}finally{
			if(sessao != null){
				sessao.close();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public T obter(Long id, T t){
		Session sessao = null;
		try{
			sessao = this.getConexao();
			return (T) sessao.get(t.getClass(), id);
		}catch(Exception e){
			System.out.println("Erro ao obter objeto, ");
			e.printStackTrace();
			return null;
		}finally{
			if(sessao != null){
				sessao.close();
			}
		}
	}
	
	

}
