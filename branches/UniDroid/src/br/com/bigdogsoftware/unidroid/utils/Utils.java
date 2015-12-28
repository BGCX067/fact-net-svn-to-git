package br.com.bigdogsoftware.unidroid.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import br.com.bigdogsoftware.unidroid.R;
import br.com.bigdogsoftware.unidroid.model.Mensagem;
import br.com.bigdogsoftware.unidroid.requests.Request;

public class Utils {
	
	public static String SERVER_IP = "10.40.80.50"; 
	
	public static String httpPost(List<NameValuePair> nameValuePairs, HttpPost httpPostAddrs) {
		HttpClient httpclient = new DefaultHttpClient();
		try {
			httpPostAddrs.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httpPostAddrs);
			BufferedReader reader = new BufferedReader(new InputStreamReader( response.getEntity().getContent(), "CP-1252"));
			return reader.readLine();
		} catch (Exception e) {
			Log.e("UniDroid", e.getMessage());
			return "";
		}
	}
	
	public static String doRequest(Runnable runnable) {
		Thread thread = new Thread(runnable);
		thread.start();
		String json = "";
		try {
			thread.join();
			json = ((Request) runnable).getJson();
		} catch (InterruptedException e) {
			Log.e("UniDroid", e.getMessage());
		}
		return json;
	}
	
	public static Mensagem getMessage(String json) {
		Mensagem mensagem = null;
		try {
			JSONObject jsonObject = (JSONObject) new JSONTokener(json).nextValue();
			mensagem = new Mensagem((String) jsonObject.get("textoDaMensagem"), (Boolean) jsonObject.get("isError"));
		} catch (Exception e) {
			Log.e("UniDroid", e.getMessage());
		}
		return mensagem;
	}
	
	public static void setErrorOrInfoAppearance(Context context, TextView textView, boolean isError) {
		if (isError) {
			textView.setTextAppearance(context, R.style.error_message);
		} else {
			textView.setTextAppearance(context, R.style.info_message);
		}
	}
	
	public static void setTextAndVisibilityOfLabel(TextView textView, String texto, int visibility) {
		textView.setText(texto);
		textView.setVisibility(visibility);
	}
	
}