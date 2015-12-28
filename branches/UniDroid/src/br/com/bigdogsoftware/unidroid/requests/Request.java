package br.com.bigdogsoftware.unidroid.requests;

/**
 * @author jborba
 * 
 */
public class Request implements Runnable {
	
	private String json;
	
	public Request() {
	}
	
	@Override
	public void run() {
	}
	
	public String getJson() {
		return json;
	}
	
	public void setJson(String json) {
		this.json = json;
	}
	
}