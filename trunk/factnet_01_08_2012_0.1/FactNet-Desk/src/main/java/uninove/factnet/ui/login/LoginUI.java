package uninove.factnet.ui.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import uninove.factnet.datatypes.login.Login;
import uninove.factnet.listeners.login.LoginListener;

public class LoginUI {
	LoginListener listener  = null;
	
	public JPanel iniciarLogin(LoginListener listener){
		this.listener = listener;
		
		JPanel login = new JPanel(new GridBagLayout());
		login.setBorder(new EmptyBorder(3, 5, 5, 10));
		
		GridBagConstraints cons = new GridBagConstraints();
		cons.insets = new Insets(1, 1, 1, 1);
		
		//Adicionando campos
		cons.gridx = 0;
		cons.gridy = 2;
		cons.gridheight = 1;
		cons.gridwidth = GridBagConstraints.REMAINDER;
		cons.anchor = GridBagConstraints.WEST;
		login.add(this.iniciarCampos(), cons, 0);
		
		//Criando Titulo
		cons.fill = GridBagConstraints.NONE;
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 2;
		cons.anchor = GridBagConstraints.WEST;
		
		JLabel labTitulo = new JLabel("Login FACT Net");
		labTitulo.setFont(new Font("Arial", Font.BOLD, 16));
		labTitulo.setForeground(new Color(50, 50, 50));
		login.add(labTitulo, cons);
		
		//Criando Info
		cons.gridx = 0;
		cons.gridy = 1;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		
		JLabel labInfo = new JLabel("Sistema adminstrativo interno.");
		labInfo.setFont(new Font("Arial", Font.BOLD, 9));
		labInfo.setForeground(new Color(100, 100, 100));
		login.add(labInfo, cons);
		
		
		//Adicionando botoes
		cons.gridx = 0;
		cons.gridy = 3;
		cons.gridheight = GridBagConstraints.REMAINDER;
		cons.gridwidth = GridBagConstraints.REMAINDER;
		cons.anchor = GridBagConstraints.EAST;
		login.add(this.criarBotoes(), cons);
		return login;
	}
	
	private JPanel iniciarCampos(){
		
		JPanel campos = new JPanel(new GridBagLayout());
		campos.setBorder(new EmptyBorder(10,0,0,0));
		GridBagConstraints cons = new GridBagConstraints();
		cons.insets = new Insets(2, 2, 2, 2);
		
		cons.gridx = 1;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		JTextField txtLogin = new JTextField(15);
		campos.add(txtLogin, cons, Login.LOGIN);
		
		cons.gridx = 1;
		cons.gridy = 1;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		JPasswordField txtSenha = new JPasswordField(15);
		campos.add(txtSenha, cons, Login.SENHA);
		
		cons.gridx = 1;
		cons.gridy = 2;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.EAST;
		JCheckBox checkRecuperar = new JCheckBox("Recuperar Senha");
		campos.add(checkRecuperar, cons, Login.RECUPERAR_SENHA);
		
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		JLabel labLogin = new JLabel("Login: ");
		campos.add(labLogin, cons);
		
		cons.gridx = 0;
		cons.gridy = 1;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		JLabel labSenha = new JLabel("Senha: ");
		campos.add(labSenha, cons);
		
		listener.setConteudo(campos);
		return campos;
	}
	
	private JPanel criarBotoes(){
		JPanel botoes = new JPanel(new GridBagLayout());
		botoes.setBorder(new EmptyBorder(10,0,0,0));
		
		GridBagConstraints cons = new GridBagConstraints();
		cons.insets = new Insets(2, 2, 2, 2);
		
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		JButton btnLogin = new JButton("Logar");
		btnLogin.addActionListener(listener.logar);
		botoes.add(btnLogin, cons);
		
		cons.gridx = 1;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(listener.cancelar);
		botoes.add(btnCancelar, cons);
		
		return botoes;
	}
}
