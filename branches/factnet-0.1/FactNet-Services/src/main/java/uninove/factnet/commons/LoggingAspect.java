/**
 * 
 */
package uninove.factnet.commons;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

/**
 * Classe com todos os metodos para inserção de log via aspectos (AOP).
 * Esta classe possui metodos especificos para determinados tipos de aspectos.
 * @author cjalmeida
 * @since 0.1
 * @version 1.0
 */

public class LoggingAspect {

	private Logger log; 
	
	public void iniciandoSERV(JoinPoint jp){
		log = Logger.getLogger(jp.getTarget().getClass());
		String initMessage = "";
		initMessage = "[§] - Iniciando metodo.";
		Object args[] = jp.getArgs();
		StringBuilder argumentos = new StringBuilder();
		if(args.length > 0){
			argumentos.append("PARAMETROS:");
			for (Object object : args) {
				argumentos.append(" "+ToStringBuilder.reflectionToString(object, ToStringStyle.DEFAULT_STYLE)+", ");
			}
		}else{
			argumentos.append("Metodo sem paramtros.");
		}
		initMessage+=argumentos.toString();
		initMessage = initMessage.replace("§", jp.getSignature().getName());
		log.info(initMessage);
	}
	
	public void finalizando(JoinPoint jp){
		log = Logger.getLogger(jp.getTarget().getClass());
		String message = "[§] - Saindo do Metodo.";
		log.info(message.replace("§", jp.getSignature().getName()));
	}
	
	public void executadoSucessoSERV(JoinPoint jp, Object r){
		log = Logger.getLogger(jp.getTarget().getClass());
		String message = "[§] - Metodo finalizado com SUCESSO.";
		StringBuffer arg = new StringBuffer("Retornando os valor(es): ");
		
		arg.append(ToStringBuilder.reflectionToString(r)+", ");  
		message+= arg.toString();
		
		log.info(message.replace("§", jp.getSignature().getName()));
	}
	
	public void executadoErroSERV(JoinPoint jp, Exception e){
		log = Logger.getLogger(jp.getTarget().getClass());
		String message = "[§] - Metodo finalizado com ERRO. Excessão lançada: "+e.getCause();
		log.error(message.replace("§", jp.getSignature().getName()), e);
	}
	
	public void iniciandoDAO(JoinPoint jp){
		log = Logger.getLogger(jp.getTarget().getClass());
		String initMessage = "";
		initMessage = "[§] - Iniciando metodo de acesso a Dados.";
		Object args[] = jp.getArgs();
		StringBuilder argumentos = new StringBuilder();
		if(args.length > 0){
			argumentos.append("PARAMETROS:");
			for (Object object : args) {
				argumentos.append(" "+ToStringBuilder.reflectionToString(object, ToStringStyle.DEFAULT_STYLE)+", ");
			}
		}else{
			argumentos.append("Metodo sem paramtros.");
		}
		initMessage+=argumentos.toString();
		initMessage = initMessage.replace("§", jp.getSignature().getName());
		log.info(initMessage);
	}
	
	
	public void executadoSucessoDAO(JoinPoint jp, Object r){
		log = Logger.getLogger(jp.getTarget().getClass());
		String message = "[§] - Acesso a dados finalizado com SUCESSO.";
		StringBuffer arg = new StringBuffer("Retornando as informações: ");
		
		arg.append(ToStringBuilder.reflectionToString(r)+", ");  
		message+= arg.toString();
		
		log.info(message.replace("§", jp.getSignature().getName()));
	}
	
	public void executadoErroDAO(JoinPoint jp, Exception e){
		log = Logger.getLogger(jp.getTarget().getClass());
		String message = "[§] - Falha ao acessar dados. Excessão lançada: "+e.getCause();
		log.error(message.replace("§", jp.getSignature().getName()), e);
	}
	
	public void observarSQL(JoinPoint jp, Object r){
		log = Logger.getLogger(jp.getTarget().getClass());
		String message = "[§] - Executando a query:/n[#]";
		message = message.replace("§", jp.getSignature().getName());
		message = message.replace("[#]", r.toString());
		log.info(message);
	}
	
	public void queryNaoEncontrada(JoinPoint jp, Exception e){
		log = Logger.getLogger(jp.getTarget().getClass());
		String message = "[§] - Falha ao buscar query.Query não encontrada. Excessão lançada: "+e.getCause();
		log.error(message.replace("§", jp.getSignature().getName()), e);
	}
	
}
