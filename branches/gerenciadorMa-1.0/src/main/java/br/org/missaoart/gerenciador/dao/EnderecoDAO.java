package br.org.missaoart.gerenciador.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.org.missaoart.gerenciador.dao.membros.entinty.EnderecoEntinty;

public class EnderecoDAO extends GenericDAO<EnderecoEntinty>{
	
	Logger log = Logger.getLogger(this.getClass());
	
	@SuppressWarnings("static-access")
	@Override
	public Long salvar(EnderecoEntinty objeto) {
		log.info("Executando m�todo salvar");
		Session sessao = this.getInstance();
		Transaction transacao = sessao.beginTransaction();
		try{
			log.info("Obtendo conex�o com a Base de Dados");
			log.info("Persistindo objeto pessoa");
			Serializable id = sessao.save(objeto);
			transacao.commit();
			return (Long)id;
		}catch (Exception e) {
			log.error("Erro ao persistir objeto Pessoa", e);
			transacao.rollback();
			return null;
		}finally{
			log.info("Fechando sessao");
			sessao.close();
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public boolean atualizar(EnderecoEntinty objeto) {
		log.info("Executando m�todo atualizar");
		Session sessao = this.getInstance();
		Transaction transacao = sessao.beginTransaction();
		try{
			log.info("Obtendo conex�o com a Base de Dados");
			log.info("Atualizando pessoa [ID:"+objeto.getIdEndereco()+"]");
			sessao.update(objeto);
			transacao.commit();
			return true;
		}catch (Exception e) {
			log.error("Erro ao atualizar pessoa", e);
			transacao.rollback();
			return false;
		}finally{
			log.info("Fechando sessao");
			sessao.close();
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public boolean excluir(EnderecoEntinty objeto) {
		log.info("Executando m�todo excluir");
		log.info("Obtendo conex�o com a Base de Dados");
		Session sessao = this.getInstance();
		Transaction transacao = sessao.beginTransaction();
		
		try{
			if(objeto == null){
				throw new NullPointerException("Objeto informado nulo.");
			}
			log.info("Excluindo endereco [ID: "+objeto.getIdEndereco()+"]");
			sessao.delete(objeto);
			transacao.commit();
			return true;
		}catch (Exception e) {
			log.error("Erro ao excluir endereco", e);
			transacao.rollback();
			return false;
		}finally{
			log.info("Fechando sessao");
			sessao.close();
		}
	}

	@Override
	public boolean excluir(Long id) {
		log.info("Executando m�todo excluir");
		return this.excluir(this.obterEnderecoPorId(id));
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	@Override
	public List<EnderecoEntinty> selecionar() {
		log.info("Executando m�todo selecionar");
		log.info("Obtendo conex�o com a Base de Dados");
		Session sessao = this.getInstance();
		try{
			log.info("Listando objeto pessoa");
			List<EnderecoEntinty> enderecos = sessao.createCriteria(EnderecoEntinty.class).list();
			return enderecos;
		}catch (Exception e) {
			log.error("Erro ao persistir objeto Pessoa", e);
			return null;
		}finally{
			log.info("Fechando sessao");
			sessao.close();
		}
	}
	
	@SuppressWarnings("static-access")
	public EnderecoEntinty obterEnderecoPorId(Long id){
		log.info("Executando m�todo obterEnderecoPorId");
		log.info("Obtendo conex�o com a Base de Dados");
		Session sessao = this.getInstance();
		try{
			return (EnderecoEntinty) sessao.get(EnderecoEntinty.class, id);
		}catch (Exception e) {
			log.error("Erro ao obter endereco", e);
			return null;
		}finally{
			log.info("Fechando sessao");
			sessao.close();
		}
	}

	
}
