package br.org.missaoart.gerenciador.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.org.missaoart.gerenciador.dao.carta.entinty.CartaEntinty;

public class CartaDAO extends GenericDAO<CartaEntinty> {
	
	Logger log = Logger.getLogger(this.getClass());

	@SuppressWarnings("static-access")
	@Override
	public Long salvar(CartaEntinty objeto) {
		log.info("Executando método salvar");
		log.info("Obtendo conexão com a Base de Dados");
		Session sessao = this.getInstance();
		Transaction transacao = sessao.beginTransaction();
		try{
			log.info("Persistindo objeto carta");
			if(objeto == null){
				throw new NullPointerException("Objeto para persistência nulo");
			}
			Serializable id = sessao.save(objeto);
			transacao.commit();
			return (Long)id;
		}catch (Exception e) {
			log.error("Erro ao persistir objeto carta", e);
			transacao.rollback();
			return null;
		}finally{
			log.info("Fechando sessao");
			sessao.close();
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public boolean atualizar(CartaEntinty objeto) {
		log.info("Executando método atualizar");
		log.info("Obtendo conexão com a Base de Dados");
		Session sessao = this.getInstance();
		Transaction transacao = sessao.beginTransaction();
		try{
			log.info("Atualizando carta [ID: "+objeto.getIdCarta()+"]");
			sessao.update(objeto);
			transacao.commit();
			return true;
		}catch (Exception e) {
			log.error("Erro ao atualizar carta", e);
			transacao.rollback();
			return false;
		}finally{
			log.info("Fechando sessao");
			sessao.close();
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public boolean excluir(CartaEntinty objeto) {
		log.info("Executando método excluir");
		log.info("Obtendo conexão com a Base de Dados");
		Session sessao = this.getInstance();
		Transaction transacao = sessao.beginTransaction();
		
		try{
			if(objeto == null){
				throw new NullPointerException("Objeto informado nulo.");
			}
			log.info("Excluindo carta [ID: "+objeto.getIdCarta()+"]");
			sessao.delete(objeto);
			transacao.commit();
			return true;
		}catch (Exception e) {
			log.error("Erro ao excluir carta", e);
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
		return this.excluir(this.obterCartaPorId(id));
	}

	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public List<CartaEntinty> selecionar() {
		log.info("Executando método selecionar");
		log.info("Obtendo conexão com a Base de Dados");
		Session sessao = this.getInstance();
		try{
			log.info("Listando objeto carta");
			List<CartaEntinty> cartas = sessao.createCriteria(CartaEntinty.class).list();
			return cartas;
		}catch (Exception e) {
			log.error("Erro ao persistir objeto carta", e);
			return null;
		}finally{
			log.info("Fechando sessao");
			sessao.close();
		}
	}
	
	@SuppressWarnings("static-access")
	public CartaEntinty obterCartaPorId(Long id){
		if(id == null){
			log.error("IdCarta nulo");
			return null;
		}
		log.info("Executando método obterCartaPorId");
		log.info("Obtendo conexão com a Base de Dados");
		Session sessao = this.getInstance();
		try{
			log.info("Buscando carta [ID: "+id+"]");
			return (CartaEntinty) sessao.get(CartaEntinty.class, id);
		}catch (Exception e) {
			log.error("Erro ao obter carta", e);
			return null;
		}finally{
			log.info("Fechando sessao");
			sessao.close();
		}
	}

}
