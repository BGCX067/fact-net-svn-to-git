package br.com.bigdogsoftware.unidroid;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import br.com.bigdogsoftware.unidroid.model.Mensagem;
import br.com.bigdogsoftware.unidroid.requests.RequestLogin;
import br.com.bigdogsoftware.unidroid.requests.RequestRegistrar;
import br.com.bigdogsoftware.unidroid.utils.Utils;

/**
 * @author jborba
 * 
 */
public class MainActivity extends SuperActivity{

	boolean boolLoginCancelar = true;      // true login     - false cancelar
	boolean boolRegistrarCadastrar = true; // true registrar - false cadastrar
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Button btnLoginCancelar = (Button) findViewById(R.id.btnLogin);
		final Button btnRegistrarCadastrar = (Button) findViewById(R.id.btnCadastrar);
		final Context context = getApplicationContext();
		final EditText txtMatricula = (EditText) findViewById(R.id.txtMatricula);
		final EditText txtSenha = (EditText) findViewById(R.id.txtSenha);
		final EditText txtConfirmaSenha = (EditText) findViewById(R.id.txtConfirmaSenha);
		final TextView lblConfirmaSenha = (TextView) findViewById(R.id.lblConfirmaSenha);
		final TextView lblMensagem = (TextView) findViewById(R.id.lblMessage);
		
		lblMensagem.setVisibility(TextView.INVISIBLE);
		txtConfirmaSenha.setVisibility(EditText.INVISIBLE);
		lblConfirmaSenha.setVisibility(TextView.INVISIBLE);
		
		btnLoginCancelar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (boolLoginCancelar) {
					// Login 
					if (checkConnectivity()) {
						String matricula = txtMatricula.getText().toString();
						String senha = txtSenha.getText().toString();
						if (matricula != null && !matricula.equals("") && senha != null && !senha.equals("")) {
							Mensagem mensagem = request(new RequestLogin(matricula, senha));
							if (mensagem != null) {
								Utils.setErrorOrInfoAppearance(context, lblMensagem, mensagem.isError());
								Utils.setTextAndVisibilityOfLabel(lblMensagem, mensagem.getTextoDaMensagem(), TextView.VISIBLE);
								prepareLoginRegistrar(btnLoginCancelar, btnRegistrarCadastrar, txtConfirmaSenha, lblConfirmaSenha);
								
								// TODO Proxima tela
							} else {
								Utils.setErrorOrInfoAppearance(context, lblMensagem, true);
								Utils.setTextAndVisibilityOfLabel(lblMensagem, getResources().getString(R.string.nao_houve_resposta_do_servidor), TextView.VISIBLE);
							}
						} else {
							Utils.setErrorOrInfoAppearance(context, lblMensagem, true);
							Utils.setTextAndVisibilityOfLabel(lblMensagem, getResources().getString(R.string.preencha_todos_os_campos), TextView.VISIBLE);
						}
					} else {
						Utils.setErrorOrInfoAppearance(context, lblMensagem, true);
						Utils.setTextAndVisibilityOfLabel(lblMensagem, getResources().getString(R.string.sem_conectividade), TextView.VISIBLE);
					}
				} else {
					// Cancelar
					prepareLoginRegistrar(btnLoginCancelar, btnRegistrarCadastrar, txtConfirmaSenha, lblConfirmaSenha);
					cleanPassFields(txtSenha, txtConfirmaSenha);
				}
			}
		});
		
		btnRegistrarCadastrar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (boolRegistrarCadastrar) {
					// Registrar
					prepareCancelarCadastrar(btnLoginCancelar, btnRegistrarCadastrar, txtConfirmaSenha, lblConfirmaSenha);
					cleanPassFields(txtSenha, txtConfirmaSenha);
				} else {
					// Cadastrar
					String s1 = txtSenha.getText().toString();
					String s2 = txtConfirmaSenha.getText().toString();
					if (!s1.equals(s2)) {
						Utils.setErrorOrInfoAppearance(context, lblMensagem, true);
						Utils.setTextAndVisibilityOfLabel(lblMensagem, getResources().getString(R.string.senha_de_confirmacao_incorreta), TextView.VISIBLE);
					} else {
						if (checkConnectivity()) {
							String matricula = txtMatricula.getText().toString();
							String senha = txtSenha.getText().toString();
							if (matricula != null && !matricula.equals("") && senha != null && !senha.equals("")) {
								Mensagem mensagem = request(new RequestRegistrar(txtMatricula.getText().toString(), txtSenha.getText().toString()));
								if (mensagem != null) {
									Utils.setErrorOrInfoAppearance(context, lblMensagem, mensagem.isError());
									Utils.setTextAndVisibilityOfLabel(lblMensagem, mensagem.getTextoDaMensagem(), TextView.VISIBLE);
								
									// Apos cadastrar
									prepareLoginRegistrar(btnLoginCancelar, btnRegistrarCadastrar, txtConfirmaSenha, lblConfirmaSenha);
									cleanPassFields(txtSenha, txtConfirmaSenha);
								} else {
									Utils.setErrorOrInfoAppearance(context, lblMensagem, true);
									Utils.setTextAndVisibilityOfLabel(lblMensagem, getResources().getString(R.string.nao_houve_resposta_do_servidor), TextView.VISIBLE);
								}
							} else {
								Utils.setErrorOrInfoAppearance(context, lblMensagem, true);
								Utils.setTextAndVisibilityOfLabel(lblMensagem, getResources().getString(R.string.preencha_todos_os_campos), TextView.VISIBLE);
							}
						} else {
							Utils.setErrorOrInfoAppearance(context, lblMensagem, true);
							Utils.setTextAndVisibilityOfLabel(lblMensagem, getResources().getString(R.string.sem_conectividade), TextView.VISIBLE);
						}
					}
				}
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void prepareLoginRegistrar(Button btnLoginCancelar, Button btnRegistrarCadastrar, EditText txtConfirmaSenha, TextView lblConfirmaSenha) {
		txtConfirmaSenha.setVisibility(EditText.INVISIBLE);
		lblConfirmaSenha.setVisibility(TextView.INVISIBLE);
		btnLoginCancelar.setText("Login");
		btnRegistrarCadastrar.setText("Registrar");
		boolLoginCancelar = true;
		boolRegistrarCadastrar = true;
	}

	private void prepareCancelarCadastrar(Button btnLoginCancelar, Button btnRegistrarCadastrar, EditText txtConfirmaSenha, TextView lblConfirmaSenha) {
		txtConfirmaSenha.setVisibility(EditText.VISIBLE);
		lblConfirmaSenha.setVisibility(TextView.VISIBLE);
		btnLoginCancelar.setText("Cancelar");
		btnRegistrarCadastrar.setText("Cadastrar");
		boolLoginCancelar = false;
		boolRegistrarCadastrar = false;
	}

	private void cleanPassFields(EditText txtSenha, EditText txtConfirmaSenha) {
		txtSenha.setText("");
		txtConfirmaSenha.setText("");
	}

}