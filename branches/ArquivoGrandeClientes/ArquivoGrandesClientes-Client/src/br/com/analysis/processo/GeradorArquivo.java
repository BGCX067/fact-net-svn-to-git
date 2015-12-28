package br.com.analysis.processo;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import br.com.analysis.modelo.exception.ProcessoException;
import br.com.analysis.processo.util.CarregarConfiguracoes;

public class GeradorArquivo {
	
	private final static String DIRETORIO_RAIZ = CarregarConfiguracoes.carregar();
	private final static String EXTENSAO_ARQUIVO = ".txt";
	
	static{
		File file = new File(DIRETORIO_RAIZ);
		if(!file.exists()) file.mkdir();
		file = null;
	}
	
	public String gerarArquivo(String conteudo) throws ProcessoException{
		try{
			String arquivo = (this.getDirName()+"/"+this.getFileName()).concat(EXTENSAO_ARQUIVO);
			File file = new File(arquivo);
			if(file.exists()){
				throw new ProcessoException("Arquivo já existente, não foi possivel criar novo arquivo");
			}
			if(!file.createNewFile()){
				throw new ProcessoException("Não foi possivel criar o arquivo :"+arquivo);
			}
			FileOutputStream fileOS = new FileOutputStream(file);
			fileOS.write(conteudo.getBytes());
			fileOS.flush();
			fileOS.close();
			return file.getAbsolutePath();
		}catch (Exception e) {
			throw new ProcessoException("Erro ao gerar arquivo",e);
		}
		
	}
	
	public String getFileName(){
		SimpleDateFormat format = new SimpleDateFormat("HHmmss");
		return format.format(new Date());
	}
	
	public String getDirName(){
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
		File file = new File(DIRETORIO_RAIZ+"/"+format.format(new Date()));
		if(!file.exists()){
			file.mkdir();
		}
		
		return file.getAbsolutePath();
	}
	
	public static void main(String[] args) {
		/*GeradorArquivo arquivo = new GeradorArquivo();
		String msg = "Teste de gerador de arquivos";
		try {
			File f = new File("C:\\FONTLOG.txt");
			Scanner scan = new Scanner(f).useDelimiter("\\Z");
			arquivo.gerarArquivo(scan.next());
		} catch (ProcessoException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		*/
		JOptionPane.showMessageDialog(null, DIRETORIO_RAIZ);
	}

}
