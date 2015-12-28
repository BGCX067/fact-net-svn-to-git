package uninove.factnet.services.impl.auth;

import junit.framework.TestCase;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import uninove.factnet.auth.services.AuthServices;
import uninove.factnet.dtos.PermissaoVO;
import uninove.factnet.dtos.PessoaDTO;
import uninove.factnet.enums.ETipoPessoa;

public class AuthBusinessTest extends TestCase {
	
	
	public final ApplicationContext applicationContext = 
		new ClassPathXmlApplicationContext("factnet-bean-factory.xml");
	
	public void testBuscarLogin(){
		System.out.println("INICIO TESTE \n [AuthBusiness.buscarLogin]");
		AuthServices services = (AuthServices) applicationContext.getBean("authServices");
		PessoaDTO pessoaTemp = new PessoaDTO();
		pessoaTemp.setEmailLogin("cris");
		pessoaTemp.setSenha("cris");
		try{
			pessoaTemp = services.buscarLogin(pessoaTemp);
			System.out.println("----------------------------------------------");
			System.out.println(ToStringBuilder.reflectionToString(pessoaTemp));
			System.out.println(ToStringBuilder.reflectionToString(pessoaTemp.getPermissoes()));
			System.out.println("----------------------------------------------");
			System.out.println("FIM TESTE - SUCESSO");
		}catch (Exception e) {
			System.out.println("FIM TESTE - ERRO");
			e.printStackTrace();
		}
	}

	public void testBuscarPermissoes(){
		System.out.println("INICIO TESTE \n [AuthBusiness.buscarPermissoes]");
		AuthServices services = (AuthServices) applicationContext.getBean("authServices");
		PessoaDTO pessoaTemp = new PessoaDTO();
		pessoaTemp.setId(1);
		pessoaTemp.setTipoPessoa(ETipoPessoa.CLIENTE);
		try{
			PermissaoVO permissao = services.buscarPermissoes(pessoaTemp);
			System.out.println("----------------------------------------------");
			System.out.println(ToStringBuilder.reflectionToString(permissao));
			System.out.println("----------------------------------------------");
			System.out.println("FIM TESTE - SUCESSO");
		}catch (Exception e) {
			System.out.println("FIM TESTE - ERRO");
			e.printStackTrace();
		}
	}
}
