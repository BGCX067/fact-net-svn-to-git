package br.com.bigdogsoftwares.uniserver.model.dao.admin;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.bigdogsoftwares.uniserver.model.dao.GenericDAO;
import br.com.bigdogsoftwares.uniserver.model.entidade.admin.Adminstrador;
import br.com.bigdogsoftwares.uniserver.model.entidade.admin.Permissoes;

public class AdminstradorDAO extends GenericDAO<Adminstrador> {
	
	@Override
	public Long salvar(Adminstrador admin) {
		if(admin.getPermissoes().getId() == null){
			admin.getPermissoes().setId(new GenericDAO<Permissoes>().salvar(admin.getPermissoes()));
		}
		return super.salvar(admin);
	}
	
	public Adminstrador verificarLogin(String login, String senha){
		Session sessao = null;
		try{
			sessao = super.getConexao();
			Criteria query = sessao.createCriteria(Adminstrador.class);
			query.add(Restrictions.and(Restrictions.eq("login", login), Restrictions.eq("senha", senha)));
			query.setFetchMode("permissoes", FetchMode.JOIN);
			return (Adminstrador) query.uniqueResult();
		}catch(Exception e){
			System.out.println("Erro ao buscar login, ");
			e.printStackTrace();
		}finally{
			if(sessao != null){
				sessao.close();
			}
		}
		return null;
	}
}
