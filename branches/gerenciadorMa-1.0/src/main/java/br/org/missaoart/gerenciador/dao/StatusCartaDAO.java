package br.org.missaoart.gerenciador.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.org.missaoart.gerenciador.dao.carta.entinty.StatusCartaEntinty;

public class StatusCartaDAO extends GenericDAO<StatusCartaEntinty>{

	Logger log = Logger.getLogger(this.getClass());
	
	@SuppressWarnings("static-access")
	@Override
	public Long salvar(StatusCartaEntinty objeto) {
		log.info("Executando método salvar");
		log.info("Obtendo conexão com a Base de Dados");
		Session sessao = this.getInstance();
		Transaction transacao = sessao.beginTransaction();
		try{
			log.info("Persistindo objeto status carta");
			Serializable id = sessao.save(objeto);
			transacao.commit();
			return (Long)id;
		}catch (Exception e) {
			log.error("Erro ao persistir objeto status carta", e);
			transacao.rollback();
			return null;
		}finally{
			log.info("Fechando sessao");
			sessao.close();
		}
	}

	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public List<StatusCartaEntinty> selecionar() {
		log.info("Executando método selecionar");
		log.info("Obtendo conexão com a Base de Dados");
		Session sessao = this.getInstance();
		try{
			log.info("Listando objeto status carta");
			List<StatusCartaEntinty> status = sessao.createCriteria(StatusCartaEntinty.class).list();
			return status;
		}catch (Exception e) {
			log.error("Erro ao persistir objeto status carta", e);
			return null;
		}finally{
			log.info("Fechando sessao");
			sessao.close();
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public boolean atualizar(StatusCartaEntinty objeto) {
		log.info("Executando método atualizar");
		log.info("Obtendo conexão com a Base de Dados");
		Session sessao = this.getInstance();
		Transaction transacao = sessao.beginTransaction();
		try{
			log.info("Atualizando status carta [ID:"+objeto.getIdStatus()+"]");
			sessao.update(objeto);
			transacao.commit();
			return true;
		}catch (Exception e) {
			log.error("Erro ao atualizar status carta", e);
			transacao.rollback();
			return false;
		}finally{
			log.info("Fechando sessao");
			sessao.close();
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public boolean excluir(StatusCartaEntinty objeto) {
		log.info("Executando método excluir");
		log.info("Obtendo conexão com a Base de Dados");
		Session sessao = this.getInstance();
		Transaction transacao = sessao.beginTransaction();
		
		try{
			if(objeto == null){
				throw new NullPointerException("Objeto informado nulo.");
			}
			log.info("Excluindo status carta [ID: "+objeto.getIdStatus()+"]");
			sessao.delete(objeto);
			transacao.commit();
			return true;
		}catch (Exception e) {
			log.error("Erro ao excluir status carta", e);
			transacao.rollback();
			return false;
		}finally{
			log.info("Fechando sessao");
			sessao.close();
		}
	}

	@Override
	public boolean excluir(Long id) {
		log.info("Executando método excluir");
		return this.excluir(this.obterStatusPorId(id));
	}

	@SuppressWarnings("static-access")
	public StatusCartaEntinty obterStatusPorId(Long id){
		if(id == null){
			log.error("IdStatus nulo");
			return null;
		}
		log.info("Executando método obterStatusPorId");
		log.info("Obtendo conexão com a Base de Dados");
		Session sessao = this.getInstance();
		try{
			return (StatusCartaEntinty) sessao.get(StatusCartaEntinty.class, id);
		}catch (Exception e) {
			log.error("Erro ao obter status carta", e);
			return null;
		}finally{
			log.info("Fechando sessao");
			sessao.close();
		}
	}
	

}
