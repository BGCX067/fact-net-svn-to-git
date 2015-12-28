package br.com.analysis.processo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import br.com.analysis.modelo.exception.ProcessoException;
import br.com.analysis.processo.GeradorArquivo;

public class CarregarConfiguracoes {
	
	private final static String NOME_ARQUIVO = "config.properties";
	private final static String NOME_PASTA =  "/config/";
	private final static String PROPRIEDADE = "geradorarquivo.constantes.pastaDefault";
	private final static String RAIZ = new File(CarregarConfiguracoes.class.getProtectionDomain().getCodeSource().getLocation().getFile()).getParent(); 
	
	/**
	 * Carrega as configuracoes iniciais
	 * @throws ProcessoException
	 */
	public static String carregar(){
		try{
			File diretorio = new File(RAIZ.concat(NOME_PASTA));
			if(!diretorio.exists()){
				criarConfigInicial();
			}
			//Retorna para constante o valor carregado
			return (String) carregarProperties().get(PROPRIEDADE);
		}catch (ProcessoException e) {
			System.out.println("Falha interna ao carregar properties, utilizando pasta default");
			e.printStackTrace();
			return System.getProperty("user.dir")+"/arquivos_gerados/";
		}catch (Exception e) {
			System.out.println("Falha desconhecida ao carregar properties, utilizando pasta default"+e);
			e.printStackTrace();
			return System.getProperty("user.dir")+"/arquivos_gerados/";
		}
	}
	
	/**
	 * Caso nao exista a pasta de configuracoes será criada uma nova pasta
	 * @param path Caminho do diretorio a ser criado
	 * @throws ProcessoException Erro ao gerar arquivos
	 */
	private static void criarConfigInicial() throws ProcessoException{
		File diretorio = new File(RAIZ+NOME_PASTA);
		try{
			diretorio.mkdir();
			diretorio =  new File(RAIZ+NOME_PASTA.concat(NOME_ARQUIVO));
			
			String commentario = "Arquivo de configurações iniciais do sistema, " +
								 "para alterar a pasta de destino dos arquivos gerados"+
								 " alterar apenas o valor apos a virgula";
			
			//Cria um arquivo properties com dados default
			Properties prop = new Properties();
			prop.setProperty(PROPRIEDADE, RAIZ+"/arquivos_gerados/");
			prop.store(new FileOutputStream(diretorio), commentario);
			prop = null;
		}catch (Exception e) {
			throw new ProcessoException("Falha ao criar arquivos de configuraçao inicial", e);
		}
	}
	
	
	//Caso exista carrega o properties da pasta
	private static Properties carregarProperties() throws ProcessoException{
		try{
			Properties prop = new Properties();
			File file = new File(RAIZ+NOME_PASTA.concat(NOME_ARQUIVO));
			prop.load(new FileInputStream(file));
			
			return prop;
		}catch (Exception e) {
			throw new ProcessoException("Erro ao carregar arquivo config.properties", e);
		}
	}
	
}
