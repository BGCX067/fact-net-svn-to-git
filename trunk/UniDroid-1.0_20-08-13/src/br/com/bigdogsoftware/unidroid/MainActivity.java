package br.com.bigdogsoftware.unidroid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btnLogin = (Button) findViewById(R.id.btnLogin);
		Button btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
		final EditText txtMatricula = (EditText) findViewById(R.id.txtMatricula);
		final EditText txtSenha = (EditText) findViewById(R.id.txtSenha);
		btnLogin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), "Login!", Toast.LENGTH_SHORT).show();
				
				// Create a new HttpClient and Post Header
				HttpClient httpclient = new DefaultHttpClient();
				HttpPost httppost = new HttpPost("http://10.40.80.43:8080/UniServer/login.do");

				try {
				    // Add your data
				    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
				    nameValuePairs.add(new BasicNameValuePair("acao", "efetuarLogin"));
				    nameValuePairs.add(new BasicNameValuePair("matricula", txtMatricula.getText().toString()));
				    nameValuePairs.add(new BasicNameValuePair("senha", txtSenha.getText().toString()));
				    
				    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

				    // Execute HTTP Post Request
				    httpclient.execute(httppost);
				    
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnCadastrar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
