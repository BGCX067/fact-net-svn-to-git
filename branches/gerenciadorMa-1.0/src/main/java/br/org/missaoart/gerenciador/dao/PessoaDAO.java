package br.org.missaoart.gerenciador.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.org.missaoart.gerenciador.dao.membros.entinty.PessoaEntinty;

public class PessoaDAO extends GenericDAO<PessoaEntinty>{

	Logger log = Logger.getLogger(this.getClass());
	
	@SuppressWarnings("static-access")
	@Override
	public Long salvar(PessoaEntinty objeto) {
		log.info("Executando método salvar");
		Session sessao = this.getInstance();
		Transaction transacao = sessao.beginTransaction();
		try{
			log.info("Obtendo conexão com a Base de Dados");
			log.info("Persistindo objeto pessoa");
			Serializable id = sessao.save(objeto);
			transacao.commit();
			return (Long) id;
		}catch (Exception e) {
			log.error("Erro ao persistir objeto Pessoa", e);
			transacao.rollback();
			return null;
		}finally{
			sessao.close();
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public boolean atualizar(PessoaEntinty objeto) {
		log.info("Executando método atualizar");
		Session sessao = this.getInstance();
		Transaction transacao = sessao.beginTransaction();
		try{
			log.info("Obtendo conexão com a Base de Dados");
			log.info("Atualizando pessoa ["+objeto.getIdPessoa()+"]");
			sessao.update(objeto);
			transacao.commit();
			return true;
		}catch (Exception e) {
			log.error("Erro ao atualizar pessoa", e);
			transacao.rollback();
			return false;
		}finally{
			sessao.close();
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public boolean excluir(PessoaEntinty objeto) {
		log.info("Executando método excluir");
		Session sessao = this.getInstance();
		Transaction transacao = sessao.beginTransaction();
		try{
			if(objeto == null){
				log.error("Objeto esperado nulo");
				throw new NullPointerException("Objeto esperado nulo");
			}
			log.info("Obtendo conexão com a Base de Dados");
			log.info("Excluindo pessoa [ID: "+objeto.getIdPessoa()+"]");
			objeto.setEndereco(null);
			sessao.delete(objeto);
			transacao.commit();
			return true;
		}catch (Exception e) {
			log.error("Erro ao excluir pessoa", e);
			transacao.rollback();
			return false;
		}finally{
			sessao.close();
		}
	}

	@Override
	public boolean excluir(Long id) {
		log.info("Executando método excluir");
		return this.excluir(this.obterPessoa(id));
	}

	@SuppressWarnings( { "static-access", "unchecked" })
	@Override
	public List<PessoaEntinty> selecionar() {
		log.info("Executando método selecionar");
		log.info("Obtendo conexão com a Base de Dados");
		Session sessao = this.getInstance();
		try{
			log.info("Listando objeto pessoa");
			List<PessoaEntinty> pessoas = sessao.createCriteria(PessoaEntinty.class).list();
			return pessoas;
		}catch (Exception e) {
			log.error("Erro ao persistir objeto Pessoa", e);
			return null;
		}finally{
			sessao.close();
		}
	}
	
	@SuppressWarnings("static-access")
	public PessoaEntinty obterPessoa(Long idPessoa){
		log.info("Executando método obterPessoa");
		Session sessao = this.getInstance();
		try{
			log.info("Obtendo conexão com a Base de Dados");
			log.info("Buscando pessoa na Base de Dados");
			PessoaEntinty pessoa = (PessoaEntinty) sessao.get(PessoaEntinty.class, idPessoa);
			if(pessoa == null ){
				log.fatal("Pessoa não encontrada");
			}
			return pessoa;
		}catch (Exception e) {
			log.error("Erro ao obter objeto Pessoa", e);
			return null;
		}finally{
			sessao.close();
		}
	}

}
