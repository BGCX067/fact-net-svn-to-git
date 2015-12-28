package uninove.factnet.bo.login;

import uninove.factnet.datatypes.autenticacao.Permissoes;
import uninove.factnet.datatypes.autenticacao.Transacoes;
import uninove.factnet.datatypes.login.Login;
import uninove.factnet.datatypes.rh.Funcionario;

public class LoginBO {
	
	public static Funcionario logar(Login login){
		//Conectar a base de dados e efetuar login
		
		Funcionario funcionario = new Funcionario(login);
		funcionario.setIsAtivo(true);
		funcionario.setNome("Cristiano Almeida");
		Permissoes permissoes = new Permissoes();
		permissoes.enableAllOptions();
		Transacoes transacoes = new Transacoes();
		
		transacoes.addTransacao("ASSISTENCIA_INCLUIR", "Incluir pedido de assistencia");
		transacoes.addTransacao("ASSISTENCIA_VISUALIZAR", "Busca pedidos de assistencia");
		transacoes.addTransacao("ASSISTENCIA_FINALIZAR", "Fechar pedido de assistencia");
		transacoes.addTransacao("ESTOQUE_REPOR", "Analisar produtos para repor estoque ");
		transacoes.addTransacao("ESTOQUE_CADASTRAR", "Cadastrar novo produto");
		transacoes.addTransacao("ESTOQUE_ANALISE", "Verificar pedido de entrada de produtos");
		transacoes.addTransacao("ESTOQUE_ENTRADA", "Informar chegada de produtos");
		transacoes.addTransacao("HUMANOS_CADASTRAR", "Cadastrar novo funcionario ou cliente");
		transacoes.addTransacao("HUMANOS_ATUALIZAR", "Atualizar dados de funcionarios ou clientes");
		transacoes.addTransacao("VENDA_INICIAR", "Iniciar nova venda");
		transacoes.addTransacao("VENDA_BUSCAR", "Buscar vendas abertas ou finalizadas");

		permissoes.setTransacoes(transacoes);
		funcionario.setPermissoes(permissoes);
		
		return funcionario;
	}
	
	public static Login recuperarSenha(Login login)throws NullPointerException, IllegalArgumentException{
			if(login.getEmail() == null){
				throw new NullPointerException("Email nao informado");
			}else if(!login.getEmail().contains("@") || !login.getEmail().contains("factnet.com")){
				throw new IllegalArgumentException("Login invalido");
			}else{
				//Busca login
				login.setSenha("minhaSenha123");
			}
			return login;
	}

}
