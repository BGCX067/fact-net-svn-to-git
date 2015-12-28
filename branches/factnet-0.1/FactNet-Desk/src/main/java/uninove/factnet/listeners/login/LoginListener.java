package uninove.factnet.listeners.login;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import uninove.factnet.bo.login.LoginBO;
import uninove.factnet.datatypes.login.Login;
import uninove.factnet.datatypes.rh.Funcionario;

public class LoginListener {
	
	private JDialog parent;
	private JPanel conteudo;
	private Funcionario form;
	private Funcionario logado = null;
	private boolean isFinalizado = false;
	
	public ActionListener logar = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Component[] camposLogin = conteudo.getComponents();
			String message = null;
			Login login = form.getLogin();
			
			login.setLogin(((JTextField)camposLogin[Login.LOGIN]).getText());
			login.setSenha(new String(((JPasswordField)camposLogin[Login.SENHA]).getPassword()));
			login.setRecuperarSenha(((JCheckBox)camposLogin[Login.RECUPERAR_SENHA]).isSelected());
			
			//Verifica se é Recuperacao de Senhas
			if(login.isRecuperarSenha()){
				if(login == null || login.getLogin().equalsIgnoreCase("")){
					message = "Necessario informar login.";
				}else{
					login.setEmail(JOptionPane.showInputDialog(parent, "Digite seu email cadastrado no sistema: "));
					Login recuperacao = null;
					try{
						recuperacao = LoginBO.recuperarSenha(login);
					}catch (NullPointerException npe) {
						System.out.println("Usuario nao informou email");
					}catch (IllegalArgumentException iae) {
						message = "Email inserido inválido";
					}
					if(recuperacao != null){
						StringBuffer mensagem = new StringBuffer("Login Recuperado: \n");
						mensagem.append("Login: ");
						mensagem.append(recuperacao.getLogin());
						mensagem.append("\nSenha: ");
						mensagem.append(recuperacao.getSenha());
						JOptionPane.showMessageDialog(parent, mensagem.toString());
					}else{
						message = "Login não encontrado, contate seu superior";
					}
				}
			}else{ // Caso nao seja Recuperacao de Senhas.
				logado = LoginBO.logar(login);
			}
			if(message ==null){
				isFinalizado = true;
			}else{
				JOptionPane.showMessageDialog(parent, message);
			}
		}
	};
	
	public ActionListener cancelar = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			parent.dispose();
		}
	};

	public WindowListener fechar = new WindowListener() {
		
		@Override
		public void windowOpened(WindowEvent e) {
			
			
		}
		
		@Override
		public void windowIconified(WindowEvent e) {
			
			
		}
		
		@Override
		public void windowDeiconified(WindowEvent e) {
			
			
		}
		
		@Override
		public void windowDeactivated(WindowEvent e) {
			
			
		}
		
		@Override
		public void windowClosing(WindowEvent e) {
			isFinalizado = true;
			
		}
		
		@Override
		public void windowClosed(WindowEvent e) {
			System.exit(0);
			
		}
		
		@Override
		public void windowActivated(WindowEvent e) {
			
			
		}
	};
	
	public void setParent(JDialog parent) {
		this.parent = parent;
	}

	public void setConteudo(JPanel conteudo) {
		this.conteudo = conteudo;
	}

	public boolean isFinalizado() {
		return isFinalizado;
	}
	
	public void setForm(Funcionario form) {
		this.form = form;
	}
	
	public Funcionario getLogado() {
		return logado;
	}

}
