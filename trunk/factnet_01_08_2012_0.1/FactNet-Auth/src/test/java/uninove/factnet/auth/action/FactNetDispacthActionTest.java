/**
 * 
 */
package uninove.factnet.auth.action;

import org.apache.log4j.Logger;

import uninove.factnet.exceptions.BusinessException;

import junit.framework.TestCase;

/**
 * Responsavel por testar todos os metodo publicos/privados desde que não sejam Actions<br>
 * da classe FactNetDispacthAction.
 * @author cjalmeida
 * @since 0.1
 * @version 1.0
 */
public class FactNetDispacthActionTest extends TestCase{

	Logger log = Logger.getLogger(this.getClass());
	
	public void testObterServicos_1() throws Exception{
		System.out.println("INICIO TESTE - [FactNetDispacthActionTest.testObterServicos_1]");
		FactNetDispacthAction factAction = new FactNetDispacthAction();
		try {
			factAction.obterServicos("authServices");
		} catch (BusinessException e) {
			System.out.println("1º Teste completo com ERRO.");
			System.out.println("FIM TESTE 1 - ERRO");
		}
	}
	public void testObterServicos_2() throws Exception{
		System.out.println("INICIO TESTE - [FactNetDispacthActionTest.testObterServicos_2]");
		FactNetDispacthAction factAction = new FactNetDispacthAction();
		try{
			factAction.obterServicos("acessoServices");
		}catch (Exception e) {
			System.out.println("2º Teste completo com ERRO");
			System.out.println("FIM TESTE - SUCESSO : ");
		}
		System.out.println("2º Teste completo - SUCESSO");
	}
}
