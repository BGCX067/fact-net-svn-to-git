package br.com.bigdogsoftwares.uniserver.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.bigdogsoftwares.uniserver.model.entidade.curso.Curso;
import br.com.bigdogsoftwares.uniserver.model.entidade.curso.Disciplina;

public class DisciplinaDAO extends GenericDAO<Disciplina> {
	
	@SuppressWarnings("unchecked")
	public List<Disciplina> buscarDisciplinasParaCurso(Curso idCurso){
		Session sessao = null;
		try{
			sessao = this.getConexao();
			Criteria query = sessao.createCriteria(Disciplina.class);
			query.add(Restrictions.eq("cursoAlvo", idCurso));
			query.setFetchMode("cursoAlvo", FetchMode.JOIN);
			return (List<Disciplina>)query.list();
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
	public List<Disciplina> obterDisciplinasSelecionadas(Long[] idsDisciplinas){
		Session sessao = null;
		try{
			sessao = this.getConexao();
			Criteria query = sessao.createCriteria(Disciplina.class);
			query.add(Restrictions.in("id", idsDisciplinas));
			return (List<Disciplina>)query.list();
		}catch(Exception e){
			System.out.println("Erro ao listar registros tente novamente");
			e.printStackTrace();
			return null;
		}finally{
			if(sessao != null){
				sessao.close();
			}
		}
	}

}
