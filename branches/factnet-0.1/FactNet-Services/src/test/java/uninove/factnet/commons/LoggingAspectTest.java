/**
 * 
 */
package uninove.factnet.commons;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import uninove.factnet.auth.services.AuthServices;
import uninove.factnet.dtos.PessoaDTO;

/**
 * Classe responsavel por testar os Aspectos definidos no arquivo de configura��o do Spring.
 * <br>Os aspectos interferem nas classes dos pacotes DAO e SERVICES, unicamente para a gera��o de Logs do Sistema.
 * <br>Ser� gerado Log na Chamada e Saida de metodos, e em casos de ERRO.
 * <br>Os logs tamb�m informar�o sobre o retorno dos metodos.
 * @author cjalmeida
 * @since 0.1
 * @version 1.0
 */
public class LoggingAspectTest extends TestCase {

	public final ApplicationContext applicationContext = 
		new ClassPathXmlApplicationContext("factnet-bean-factory.xml");
	
	public void testLogEntradaSaidaMetodos(){
		System.out.println("INICIO TESTE - [LoggingAspectTest.testLogEntradaSaidaMetodos]");
		AuthServices services = (AuthServices) applicationContext.getBean("authServices");
		PessoaDTO pessoaTemp = new PessoaDTO();
		pessoaTemp.setEmailLogin("cris");
		pessoaTemp.setSenha("cris");
		try{
			services.buscarLogin(pessoaTemp);
			System.out.println("FIM TESTE - SUCESSO");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("FIM TESTE - ERRO");
		}
	}
	
	public void testLogErro(){
		System.out.println("INICIO TESTE - [LoggingAspectTest.testLogErro]");
		AuthServices services = (AuthServices) applicationContext.getBean("authServices");
		try{
			services.buscarLogin(null);
			System.out.println("FIM TESTE - ERRO");
		}catch (Exception e) {
			System.out.println("FIM TESTE - SUCESSO");
		}
	}
}
