package uninove.factnet.ui.humanos;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import uninove.factnet.datatypes.autenticacao.Transacoes;
import uninove.factnet.listeners.humanos.HumanosListener;
import uninove.factnet.ui.rh.cadastro.HumanosCargoTab;
import uninove.factnet.ui.rh.cadastro.HumanosDeptoPermissoesTab;
import uninove.factnet.ui.rh.cadastro.HumanosFuncionarioTab;

public class HumanosUI {
	
	private HumanosListener listener = new HumanosListener();
	private JTabbedPane pane = new JTabbedPane();
	
	public JMenu montarMenuHumanos(Transacoes transacoes, JFrame janela){
		listener.setJanela(janela);
		listener.setUi(this);

		JMenu humanos = new JMenu("Recursos Humanos");
		humanos.setToolTipText("Opções de gerenciamento de funcionarios");
		
		if(transacoes.getTransacao("HUMANOS_CADASTRAR")!= null){
			JMenuItem item = new JMenuItem("Cadastrar");
			item.setToolTipText(transacoes.getTransacao("HUMANOS_CADASTRAR"));
			item.addActionListener(listener.cadastrar);
			humanos.add(item);
		}
		if(transacoes.getTransacao("HUMANOS_ATUALIZAR")!= null){
			JMenuItem item = new JMenuItem("Atualizar Dados");
			item.setToolTipText(transacoes.getTransacao("HUMANOS_ATUALIZAR"));
			item.addActionListener(listener.atualizar);
			humanos.add(item);
		}
		
		return humanos;
	}
	
	public JPanel initTelaCadastroFuncionario(){
		listener.setUi(this);
		JPanel painel = new JPanel(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		cons.insets = new Insets(2, 2, 2, 2);
		
		JLabel labTitulo = new JLabel("Cadastro de Pessoas - Funcionario");
		labTitulo.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 2;
		cons.anchor = GridBagConstraints.WEST;
		painel.add(labTitulo, cons);
		
		cons.gridx = 0;
		cons.gridy = 1;
		cons.gridheight = 4;
		cons.gridwidth = 5;
		cons.anchor = GridBagConstraints.WEST;
		pane.setEnabled(false);
		pane.addTab("Informações Basicas", new HumanosFuncionarioTab().initAbaFuncionario(listener));
		pane.addTab("Cargo", new HumanosCargoTab().initAbaCargo(listener));
		pane.addTab("Deto e Permissoes: ", new HumanosDeptoPermissoesTab().initAbaDepartamentoPermissoes(listener));
		painel.add(pane, cons);
		return painel;
	}
	
	public void alterarAba(int aba){
		try{
		pane.setSelectedIndex(aba);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar sistema, tente novamente em breve.");
			System.exit(0);
		}
	}
	
	
}
