package br.com.bigdogsoftware.unidroid.requests;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import br.com.bigdogsoftware.unidroid.utils.Utils;

/**
 * @author jborba
 * 
 */
public class RequestLogin extends Request {
	
	private String matricula;
	private String senha;
	
	public RequestLogin(String matricula, String senha) {
		super();
		this.matricula = matricula;
		this.senha = senha;
	}
	
	@Override
	public void run() {
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
	    nameValuePairs.add(new BasicNameValuePair("acao", "efetuarLogin"));
	    nameValuePairs.add(new BasicNameValuePair("matricula", matricula));
	    nameValuePairs.add(new BasicNameValuePair("senha", senha));
	    HttpPost httpPostAddrs = new HttpPost("http://" + Utils.SERVER_IP + ":8080/UniServer/login.do");
	    setJson(Utils.httpPost(nameValuePairs, httpPostAddrs));
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}