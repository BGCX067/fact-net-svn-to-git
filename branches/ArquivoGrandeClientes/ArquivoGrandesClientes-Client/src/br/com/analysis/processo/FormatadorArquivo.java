package br.com.analysis.processo;

import java.util.List;

import br.com.analysis.modelo.ArquivoMensagem;
import br.com.analysis.modelo.Cabecalho;
import br.com.analysis.modelo.Destinatario;
import br.com.analysis.modelo.Endereco;
import br.com.analysis.modelo.Imagem;
import br.com.analysis.modelo.Mensagem;
import br.com.analysis.modelo.Remetente;
import br.com.analysis.modelo.Rodape;
import br.com.analysis.modelo.constantes.ETamanhoCabecalho;
import br.com.analysis.modelo.constantes.ETamanhoDestinatario;
import br.com.analysis.modelo.constantes.ETamanhoEndereco;
import br.com.analysis.modelo.constantes.ETamanhoImagem;
import br.com.analysis.modelo.constantes.ETamanhoMensagem;
import br.com.analysis.modelo.constantes.ETamanhoRemetente;
import br.com.analysis.modelo.constantes.ETamanhoRodape;

public class FormatadorArquivo {
	
	private final static String CARACTER_ZERO = "0";
	private final static String CARACTER_ESPACO = " ";
	private final static String CARACTER_ESPACO_ESPECIAL = Character.toString((char)160);
	
	public String formatar(ArquivoMensagem arquivo){
		return "";
	}
	
	public String formatarCabecalho(Cabecalho cabecalho){
		StringBuffer cabecalhoString = new StringBuffer();
		cabecalhoString.append(this.completarCampos(
				ETamanhoCabecalho.NUM_CODIGO_REMESSA.getTamanho(), cabecalho.getNumCodigoRemessa(), CARACTER_ZERO));
		cabecalhoString.append(this.completarCampos(
				ETamanhoCabecalho.TP_CLIENTE.getTamanho(), cabecalho.getTpCliente()));
		cabecalhoString.append(this.completarCampos(
				ETamanhoCabecalho.DDD_TEL_COBRANCA.getTamanho(), cabecalho.getDddTelCobranca(), CARACTER_ZERO));
		cabecalhoString.append(this.completarCampos(
				ETamanhoCabecalho.NUM_TEL_COBRACA.getTamanho(), cabecalho.getNumTelCobraca(), CARACTER_ZERO));
		cabecalhoString.append(this.completarCampos(
				ETamanhoCabecalho.COD_ADMINISTRATIVO.getTamanho(), cabecalho.getCodAdministrativo(), CARACTER_ZERO));
		cabecalhoString.append(this.completarCampos(
				ETamanhoCabecalho.NUM_CONTRATO_JURIDICO.getTamanho(), cabecalho.getNumContratoJuridico(), CARACTER_ESPACO));
		cabecalhoString.append(this.completarCampos(
				ETamanhoCabecalho.NUM_CARTAO_CLIENTE_POSTAGEM.getTamanho(), cabecalho.getNumCartaoClientePostagem(), CARACTER_ZERO));
		cabecalhoString.append(this.completarCampos(
				ETamanhoCabecalho.FORMA_PAGAMENTO.getTamanho(), cabecalho.getFormaPagamento(), CARACTER_ZERO));
		cabecalhoString.append(this.completarCampos(
				ETamanhoCabecalho.DT_ENVIO_ARQUIVO.getTamanho(), cabecalho.getDtEnvioArquivo()));
		cabecalhoString.append(this.completarCampos(
				ETamanhoCabecalho.RAZAO_SOCIAL.getTamanho(), cabecalho.getRazaoSocial(), CARACTER_ESPACO));
		
		return cabecalhoString.toString();
	}
	
	
	public String formatarDadosRemetente(List<Remetente> remetentes){
		StringBuffer remetenteString = new StringBuffer();
//		boolean tpRegistroExistente = false;
		for(Remetente remetente : remetentes){
			
			
//			if(tpRegistroExistente){
			remetenteString.append(this.completarCampos(
					ETamanhoRemetente.TP_REGISTRO.getTamanho(), remetente.getTpRegistro()));
//				tpRegistroExistente = true;
//			}
			remetenteString.append(this.completarCampos(
					ETamanhoRemetente.TITULO.getTamanho(), remetente.getTitulo(),CARACTER_ESPACO));
			remetenteString.append(this.completarCampos(
					ETamanhoRemetente.NOME.getTamanho(), remetente.getNome(), CARACTER_ESPACO));
			
			Endereco endereco = remetente.getEndereco();
			
			remetenteString.append(this.completarCampos(
					ETamanhoEndereco.TP_LOGRADOURO.getTamanho(), endereco.getTpLogradouro(), CARACTER_ESPACO));
			remetenteString.append(this.completarCampos(
					ETamanhoEndereco.LOGRADOURO.getTamanho(), endereco.getLogradouro(), CARACTER_ESPACO));
			remetenteString.append(this.completarCampos(
					ETamanhoEndereco.NUM_LOGRADOURO.getTamanho(), endereco.getNumLogradouro(), CARACTER_ESPACO));
			remetenteString.append(this.completarCampos(
					ETamanhoEndereco.COMPLEMENTO.getTamanho(), endereco.getComplemento(), CARACTER_ESPACO));
			remetenteString.append(this.completarCampos(
					ETamanhoEndereco.BAIRRO.getTamanho(), endereco.getBairro(), CARACTER_ESPACO));
			remetenteString.append(this.completarCampos(
					ETamanhoEndereco.LOCALIDADE.getTamanho(), endereco.getLocalidade(),CARACTER_ESPACO));
			remetenteString.append(this.completarCampos(
					ETamanhoEndereco.UF.getTamanho(), endereco.getUF(), CARACTER_ESPACO));
			remetenteString.append(this.completarCampos(
					ETamanhoEndereco.CEP.getTamanho(), endereco.getCEP().replace("-", ""), CARACTER_ESPACO));
			remetenteString.append(this.completarCampos(
					ETamanhoEndereco.EMAIL.getTamanho(), endereco.getEmail(), CARACTER_ESPACO));
			remetenteString.append("\n");
		}
		return remetenteString.toString();
	}
	
	public String formatarDadosDestinatario(List<Destinatario> destinatarios){
		StringBuffer destinatarioString = new StringBuffer();
//		boolean tpRegistroExistente = false;
		for(Destinatario destinatario: destinatarios){
//			if(tpRegistroExistente){
			destinatarioString.append(this.completarCampos(
					ETamanhoDestinatario.TP_REGISTRO.getTamanho(), destinatario.getTpRegistro()));
//				tpRegistroExistente = true;
//			}
			destinatarioString.append(this.completarCampos(
					ETamanhoDestinatario.TITULO.getTamanho(), destinatario.getTitulo(),CARACTER_ESPACO));
			destinatarioString.append(this.completarCampos(
					ETamanhoDestinatario.NOME.getTamanho(), destinatario.getNome(), CARACTER_ESPACO));
			
			Endereco endereco = destinatario.getEndereco();
			
			destinatarioString.append(this.completarCampos(
					ETamanhoEndereco.TP_LOGRADOURO.getTamanho(), endereco.getTpLogradouro(), CARACTER_ESPACO));
			destinatarioString.append(this.completarCampos(
					ETamanhoEndereco.LOGRADOURO.getTamanho(), endereco.getLogradouro(), CARACTER_ESPACO));
			destinatarioString.append(this.completarCampos(
					ETamanhoEndereco.NUM_LOGRADOURO.getTamanho(), endereco.getNumLogradouro(), CARACTER_ESPACO));
			destinatarioString.append(this.completarCampos(
					ETamanhoEndereco.COMPLEMENTO.getTamanho(), endereco.getComplemento(), CARACTER_ESPACO));
			destinatarioString.append(this.completarCampos(
					ETamanhoEndereco.BAIRRO.getTamanho(), endereco.getBairro(), CARACTER_ESPACO));
			destinatarioString.append(this.completarCampos(
					ETamanhoEndereco.LOCALIDADE.getTamanho(), endereco.getLocalidade(),CARACTER_ESPACO));
			destinatarioString.append(this.completarCampos(
					ETamanhoEndereco.UF.getTamanho(), endereco.getUF(), CARACTER_ESPACO));
			destinatarioString.append(this.completarCampos(
					ETamanhoEndereco.CEP.getTamanho(), endereco.getCEP().replace("-", ""), CARACTER_ESPACO));
			destinatarioString.append(this.completarCampos(
					ETamanhoEndereco.PAIS.getTamanho(), endereco.getPais(), CARACTER_ESPACO));
			
			destinatarioString.append(this.completarCampos(
					ETamanhoDestinatario.AMBITO.getTamanho(), destinatario.getAmbito(),CARACTER_ESPACO));
			destinatarioString.append(this.completarCampos(
					ETamanhoDestinatario.PEDIDO_COPIA.getTamanho(), destinatario.getPedidoCopia(), CARACTER_ESPACO));
			destinatarioString.append(this.completarCampos(
					ETamanhoDestinatario.PEDIDO_CONFIRMACAO_ENTREGA.getTamanho(), destinatario.getPedidoConfirmacaoEntrega(),CARACTER_ESPACO));
			destinatarioString.append(this.completarCampos(
					ETamanhoDestinatario.DT_PRE_DATADO.getTamanho(), destinatario.getDtPreDatado(),CARACTER_ESPACO));
			destinatarioString.append(this.completarCampos(
					ETamanhoDestinatario.SIGLA_SERVICO.getTamanho(), destinatario.getSiglaServico(),CARACTER_ESPACO));
			destinatarioString.append(this.completarCampos(
					ETamanhoDestinatario.INFO_ENTREGA.getTamanho(), destinatario.getInfoEntrega(), CARACTER_ESPACO));
			destinatarioString.append(this.completarCampos(
					ETamanhoDestinatario.GRUPO.getTamanho(), destinatario.getGrupo(),CARACTER_ESPACO));
			destinatarioString.append(this.completarCampos(
					ETamanhoDestinatario.COTA.getTamanho(), destinatario.getCota(), CARACTER_ESPACO));
			destinatarioString.append(this.completarCampos(
					ETamanhoDestinatario.OBSERVACAO.getTamanho(), destinatario.getObservacao(),CARACTER_ESPACO));
			destinatarioString.append(this.completarCampos(
					ETamanhoDestinatario.CABECALHO_MENSAGEM.getTamanho(), destinatario.getCabecalhoMensagem(), CARACTER_ESPACO));
			destinatarioString.append(this.completarCampos(
					ETamanhoDestinatario.RODAPE_MENSAGEM.getTamanho(), destinatario.getRodapeMensagem(),CARACTER_ESPACO));
			destinatarioString.append(this.completarCampos(
					ETamanhoDestinatario.ENDERECAMENTO_SERVICO_ADICIONAL.getTamanho(), destinatario.getEnderecamentoServicoAdicional(),CARACTER_ZERO));
			
			
			destinatarioString.append("\n");
		}
		return destinatarioString.toString();
	}
	
	public String formatarDadosImagem(Imagem imagem){
		StringBuffer mensagemString = new StringBuffer();
		mensagemString.append(this.completarCampos(
				ETamanhoImagem.TP_REGISTRO.getTamanho(), imagem.getTpRegistro()));
		mensagemString.append(this.completarCampos(
				ETamanhoImagem.COD_IMAGEM_TOPO.getTamanho(), imagem.getTpRegistro(), CARACTER_ZERO));
		mensagemString.append(this.completarCampos(
				ETamanhoImagem.COD_IMAGEM_RODAPE.getTamanho(), imagem.getTpRegistro(),CARACTER_ZERO));
		
		return mensagemString.toString();
	}
	
	public String formatarDadosMensagem(Mensagem mensagem){
		StringBuffer mensagemString = new StringBuffer();
		mensagemString.append(this.completarCampos(
				ETamanhoMensagem.TP_REGISTRO.getTamanho(), mensagem.getTpRegistro(),CARACTER_ESPACO));
		mensagemString.append(mensagem.getMensagem().replace(" ", CARACTER_ESPACO_ESPECIAL));
		
		return mensagemString.toString();
	}
	
	public String formatarDadosRodape(Rodape rodape){
		StringBuffer mensagemString = new StringBuffer();
		mensagemString.append(this.completarCampos(
				ETamanhoRodape.INDENTIFICADOR_LINHA_RODAPE.getTamanho(), rodape.getIndentificadorLinhaRodape()));
		mensagemString.append(this.completarCampos(
				ETamanhoRodape.NUM_REGISTRO.getTamanho(), rodape.getNumRegistro(), CARACTER_ZERO));
		mensagemString.append(this.completarCampos(
				ETamanhoRodape.NUM_TELEGRAMAS.getTamanho(), rodape.getNumTelegramas(),CARACTER_ZERO));
		
		return mensagemString.toString();
	}
	
	private String completarCampos(int tamanhoCampo, String valorCampo){
		return this.completarCampos(tamanhoCampo, valorCampo, CARACTER_ESPACO).trim();
	}
	
	private String completarCampos(int tamanhoCampo, String valorCampo, String valorACompletar){
		while(valorCampo.length() < tamanhoCampo){
			if(valorACompletar.equalsIgnoreCase("0")){
				valorCampo = valorACompletar+valorCampo;
			}else{
				valorCampo = valorCampo+valorACompletar;
			}
		}
		return valorCampo;
	}
	
	/*public static void main(String[] args) throws Exception {
		
		 Teste Cabeçalho 
		Cabecalho cabecalho = new Cabecalho();
		cabecalho.setNumCodigoRemessa("07315");
		cabecalho.setTpCliente("PJ");
		cabecalho.setDddTelCobranca("");			
		cabecalho.setNumTelCobraca("");				
		cabecalho.setCodAdministrativo("40096900");		
		cabecalho.setNumContratoJuridico("0072900911");			
		cabecalho.setNumCartaoClientePostagem("057675864");		
		cabecalho.setFormaPagamento("08");			
		cabecalho.setDtEnvioArquivo("04032013");			
		cabecalho.setRazaoSocial("RICARDO MACEDO SOARES");
		
		System.out.println(new FormatadorArquivo().formatarCabecalho(cabecalho));
	
		Teste Remetente
		
		List<Remetente> remetentes = new ArrayList<Remetente>();
		
		Remetente remetente = new Remetente();
		remetente.setTpRegistro("01");
		remetente.setTitulo("SR");
		remetente.setNome("RICARDO MACEDO SOARES");
		Endereco endereco = new Endereco();
		endereco.setTpLogradouro("RUA");
		endereco.setLogradouro("PAULO GONCALVES");
		endereco.setNumLogradouro("205");
		endereco.setComplemento("121");
		endereco.setBairro("SANTANA");
		endereco.setLocalidade("SAO PAULO");
		endereco.setUF("SP");
		endereco.setCEP("02403020");
		endereco.setEmail("");
		
		Remetente remetente2= new Remetente();
		remetente2.setTpRegistro("01");
		remetente2.setTitulo("SR");
		remetente2.setNome("JULIANO FALCAO BORBA");
		Endereco endereco2 = new Endereco();
		endereco2.setTpLogradouro("AVENIDA");
		endereco2.setLogradouro("GUIDO CALOI");
		endereco2.setNumLogradouro("1000");
		endereco2.setComplemento("BLOCO 3");
		endereco2.setBairro("SANTO AMARO");
		endereco2.setLocalidade("SAO PAULO");
		endereco2.setUF("SP");
		endereco2.setCEP("12345-678");
		endereco2.setEmail("JBORBA@STEFANINI.COM");
		
		remetente.setEndereco(endereco);
		remetente2.setEndereco(endereco2);
		
		remetentes.add(remetente);
		remetentes.add(remetente2);
		
		System.out.println(new FormatadorArquivo().formatarDadosRemetente(remetentes));
		
		Teste dos Destinatarios
		
		Destinatario destinatario = new Destinatario();
		destinatario.setTpRegistro("02");
		destinatario.setTitulo("");
		destinatario.setNome("MARIO QUITANDA");

		Endereco enderecoDes = new Endereco();
		
		enderecoDes.setTpLogradouro("AVENIDA");
		enderecoDes.setLogradouro("CONSELHEIRO NEBIAS");
		enderecoDes.setNumLogradouro("263");
		enderecoDes.setComplemento("7");
		enderecoDes.setBairro("CAMPOS ELISEOS");
		enderecoDes.setLocalidade("SAO PAULO");
		enderecoDes.setUF("SP");
		enderecoDes.setCEP("01203-000");
		enderecoDes.setPais("BRASIL");

		destinatario.setAmbito("N");
		destinatario.setPedidoCopia("N");
		destinatario.setPedidoConfirmacaoEntrega("N");
		destinatario.setDtPreDatado("");
		destinatario.setSiglaServico("TLGC");
		destinatario.setInfoEntrega("N");
		destinatario.setGrupo("1");
		destinatario.setCota("");
		destinatario.setObservacao("");
		destinatario.setCabecalhoMensagem("");
		destinatario.setRodapeMensagem("");
		destinatario.setEnderecamentoServicoAdicional("1");
		
		destinatario.setEndereco(enderecoDes);
		
		List<Destinatario> destinatarios = new ArrayList<Destinatario>();
		destinatarios.add(destinatario);

		System.out.println(new FormatadorArquivo().formatarDadosDestinatario(destinatarios));
		
		Mensagem mensagem = new Mensagem();
		mensagem.setTpRegistro("04");
		mensagem.setMensagem("NOVA MESAGEM DE TESTE DE TELEGRAMA 4 NOVA MESAGEM DE TESTE DE TELEGRAMA 4 NOVA MESAGEM DE TESTE DE TELEGRAMA 4 NOVA MESAGEM DE TESTE DE TELEGRAMA 4 NOVA MESAGEM DE TESTE DE TELEGRAMA 4 NOVA MESAGEM DE TESTE DE TELEGRAMA 4 NOVA MESAGEM DE TESTE DE TELEGRAMA 4");
		System.out.println(new FormatadorArquivo().formatarDadosMensagem(mensagem));
		
		
	}*/

}
