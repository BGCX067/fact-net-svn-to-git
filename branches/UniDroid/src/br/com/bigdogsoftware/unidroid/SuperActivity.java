package br.com.bigdogsoftware.unidroid;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import br.com.bigdogsoftware.unidroid.model.Mensagem;
import br.com.bigdogsoftware.unidroid.requests.Request;
import br.com.bigdogsoftware.unidroid.utils.Utils;

public class SuperActivity extends Activity {

	public ConnectivityManager obterGerenciadorConexoes(){
		return (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
	}
	
	public boolean checkConnectivity() {
		ConnectivityManager connection = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
		boolean redesDisponiveis = false;
		NetworkInfo rede1 = connection.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		NetworkInfo rede2 = connection.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		redesDisponiveis = rede1.isConnected() || rede2.isConnected();
		return redesDisponiveis;
	}
	
	public Mensagem request(Request runnable){
		String json = Utils.doRequest(runnable);
		Mensagem mensagem = Utils.getMessage(json);
		return mensagem;
	}
}
