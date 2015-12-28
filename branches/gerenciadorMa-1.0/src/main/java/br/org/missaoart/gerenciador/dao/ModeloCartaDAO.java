package br.org.missaoart.gerenciador.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.org.missaoart.gerenciador.dao.carta.entinty.ModeloCartaEntinty;

public class ModeloCartaDAO extends GenericDAO<ModeloCartaEntinty>{
	
	Logger log = Logger.getLogger(this.getClass());

	@SuppressWarnings("static-access")
	@Override
	public Long salvar(ModeloCartaEntinty objeto) {
		log.info("Executando método salvar");
		log.info("Obtendo conexão com a Base de Dados");
		Session sessao = this.getInstance();
		Transaction transacao = sessao.beginTransaction();
		try{
			log.info("Persistindo objeto modelo carta");
			if(objeto == null){
				throw new NullPointerException("Objeto para persistência nulo");
			}
			Serializable id = sessao.save(objeto);
			transacao.commit();
			return (Long)id;
		}catch (Exception e) {
			log.error("Erro ao persistir objeto modelo carta", e);
			transacao.rollback();
			return null;
		}finally{
			log.info("Fechando sessao");
			sessao.close();
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public boolean atualizar(ModeloCartaEntinty objeto) {
		log.info("Executando método atualizar");
		log.info("Obtendo conexão com a Base de Dados");
		Session sessao = this.getInstance();
		Transaction transacao = sessao.beginTransaction();
		try{
			log.info("Atualizando modelo carta [ID:"+objeto.getIdModelo()+"]");
			sessao.update(objeto);
			transacao.commit();
			return true;
		}catch (Exception e) {
			log.error("Erro ao atualizar modelo carta", e);
			transacao.rollback();
			return false;
		}finally{
			log.info("Fechando sessao");
			sessao.close();
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public boolean excluir(ModeloCartaEntinty objeto) {
		log.info("Executando método excluir");
		log.info("Obtendo conexão com a Base de Dados");
		Session sessao = this.getInstance();
		Transaction transacao = sessao.beginTransaction();
		
		try{
			if(objeto == null){
				throw new NullPointerException("Objeto informado nulo.");
			}
			log.info("Excluindo modelo carta [ID: "+objeto.getIdModelo()+"]");
			sessao.delete(objeto);
			transacao.commit();
			return true;
		}catch (Exception e) {
			log.error("Erro ao excluir modelo carta", e);
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
		return this.excluir(this.obterModeloPorId(id));
	}

	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public List<ModeloCartaEntinty> selecionar() {
		log.info("Executando método selecionar");
		log.info("Obtendo conexão com a Base de Dados");
		Session sessao = this.getInstance();
		try{
			log.info("Listando objeto modelo carta");
			List<ModeloCartaEntinty> modelos = sessao.createCriteria(ModeloCartaEntinty.class).list();
			return modelos;
		}catch (Exception e) {
			log.error("Erro ao persistir objeto modelo carta", e);
			return null;
		}finally{
			log.info("Fechando sessao");
			sessao.close();
		}
	}
	
	@SuppressWarnings("static-access")
	public ModeloCartaEntinty obterModeloPorId(Long id){
		if(id == null){
			log.error("IdModelo nulo");
			return null;
		}
		log.info("Executando método obterStatusPorId");
		log.info("Obtendo conexão com a Base de Dados");
		Session sessao = this.getInstance();
		try{
			log.info("Buscando modelo de carta [ID: "+id+"]");
			return (ModeloCartaEntinty) sessao.get(ModeloCartaEntinty.class, id);
		}catch (Exception e) {
			log.error("Erro ao obter modelo carta", e);
			return null;
		}finally{
			log.info("Fechando sessao");
			sessao.close();
		}
	}
	

}
