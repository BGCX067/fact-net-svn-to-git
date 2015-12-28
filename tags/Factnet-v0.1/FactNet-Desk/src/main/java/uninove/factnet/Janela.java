package uninove.factnet;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import uninove.factnet.datatypes.autenticacao.Permissoes;
import uninove.factnet.datatypes.login.Login;
import uninove.factnet.datatypes.rh.Funcionario;
import uninove.factnet.listeners.login.LoginListener;
import uninove.factnet.ui.assistencia.AssistenciaUI;
import uninove.factnet.ui.estoque.EstoqueUI;
import uninove.factnet.ui.humanos.HumanosUI;
import uninove.factnet.ui.login.LoginUI;
import uninove.factnet.ui.vendas.VendasUI;

public class Janela {
	
	private static final long serialVersionUID = -2134210469862149100L;
	
	private JanelaListener listenerJanela = new JanelaListener();
	private JDialog janela = new JDialog();
	
	public Funcionario iniciarLogin(){
		LoginUI uiLogin = new LoginUI();
		Funcionario form = new Funcionario(new Login());
		LoginListener listener = new LoginListener();
		listener.setParent(janela);
		listener.setForm(form);
		janela.addWindowListener(listenerJanela);
		JPanel painelLogin = uiLogin.iniciarLogin(listener);
		janela.add(painelLogin);
		janela.pack();
		janela.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setResizable(true);
		janela.setVisible(true);
		
		while(!listener.isFinalizado()){
			
		}
		janela.setVisible(false);
		return listener.getLogado();
	}
	
	public void iniciarSistema(Funcionario form){
		JFrame janelaPrincipal = new JFrame("Fact Net - "+form.getNome());
		janelaPrincipal.addWindowListener(listenerJanela);
		janelaPrincipal.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		
		cons.fill = GridBagConstraints.BOTH;
		cons.gridx = 0;
		cons.gridy = 0;
		cons.anchor = GridBagConstraints.WEST;
		cons.weightx = 1.0;
		cons.weighty = 1.0;
		
		janelaPrincipal.getContentPane().add(this.iniciarPainelInicial(form), 0);
		janelaPrincipal.setJMenuBar(this.iniciarMenu(form.getPermissoes(), janelaPrincipal));
		janelaPrincipal.pack();
		janelaPrincipal.setLocationRelativeTo(null);
		janelaPrincipal.setVisible(true);
		
	}
	
	private JMenuBar iniciarMenu(Permissoes permissoes, JFrame janela){
		JMenuBar menu = new JMenuBar();
		menu.add(this.montarMenuDefault());
		if(permissoes.isAcessaVendas()){
			VendasUI uiVendas = new VendasUI();
			menu.add(uiVendas.montarMenuVendas(permissoes.getTransacoes(), janela));
		}
		if(permissoes.isAcessaEstoque()){
			EstoqueUI uiEstoque = new EstoqueUI();
			menu.add(uiEstoque.montarMenuEstoque(permissoes.getTransacoes()));
		}
		if(permissoes.isAcessaRH()){
			HumanosUI uiHumanos = new HumanosUI();
			menu.add(uiHumanos.montarMenuHumanos(permissoes.getTransacoes(), janela));
		}
		if(permissoes.isAcessaAssistencia()){
			AssistenciaUI uiAssistencia = new AssistenciaUI();
			menu.add(uiAssistencia.montarMenuVendas(permissoes.getTransacoes()));
		}
		return menu;
	}
	
	private JMenu montarMenuDefault(){
		
		JMenu defaultMenu = new JMenu("Arquivo");
		defaultMenu.setToolTipText("Opções do Sistema");
		
		JMenuItem sair = new JMenuItem("Sair");
		sair.setToolTipText("Fechar Sistema");
		sair.addActionListener(listenerJanela);
		defaultMenu.add(sair);
	
		return defaultMenu;
	}
	
	public JPanel iniciarPainelInicial(Funcionario funcionario){
		JPanel painel = new JPanel();
		painel.setLayout(new GridBagLayout());
		
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagConstraints cons = new GridBagConstraints();
		
		JLabel boasVindas = new JLabel("Bem Vindo(a), ");
		boasVindas.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.EAST;
		
		painel.add(boasVindas, cons);
		
		JLabel nomeUsuario = new JLabel(funcionario.getNome());
		nomeUsuario.setFont(new Font("Arial", Font.BOLD, 16));
		cons.gridx = 1;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		painel.add(nomeUsuario, cons);
		
		String mensagem = "<html>Este sistema é de uso exclusivo de funcionarios da FACT Net<br/>"+
						  "Sua utilização somente será permitida nas dependencias internas da loja,<br/>"+
						  " com pessoal préviamente treinado para a utilização de tal sistema.<br/><br/>"+
						  "Caso tenha alguma duvida referente ao funcionamento do sistema, <br/>" +
						  "por favor contate seu superior para possivel treinamento.</html>";
		
		TitledBorder border = new TitledBorder("Informações");
		border.setTitleFont(new Font(painel.getFont().getFontName(), Font.BOLD, painel.getFont().getSize()));
		JPanel info = new JPanel();
		info.setBorder(border);
		JLabel infoLabel = new JLabel(mensagem);
		infoLabel.setFont(new Font(painel.getFont().getFontName(), Font.PLAIN, painel.getFont().getSize()));
		info.add(infoLabel);
		
		cons.insets = new Insets(10, 0, 10, 5);
		cons.gridx = 0;
		cons.gridy = 2;
		cons.gridheight = 2;
		cons.gridwidth =3;
		cons.anchor = GridBagConstraints.WEST;
		
		painel.add(info, cons);
		return painel;
	}
}
