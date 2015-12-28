package uninove.factnet.ui.estoque;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import uninove.factnet.datatypes.autenticacao.Transacoes;
import uninove.factnet.listeners.estoque.EstoqueListener;

public class EstoqueUI {
	
	private EstoqueListener listener = new EstoqueListener();
	
	public JMenu montarMenuEstoque(Transacoes transacoes){
		JMenu estoque = new JMenu("Estoque");
		estoque.setToolTipText("Gerenciamento de mercadorias");
		
		if(transacoes.getTransacao("ESTOQUE_REPOR")!= null){
			JMenuItem item = new JMenuItem("Verificar");
			item.setToolTipText(transacoes.getTransacao("ESTOQUE_REPOR"));
			item.addActionListener(listener.verificar);
			estoque.add(item);
		}
		if(transacoes.getTransacao("ESTOQUE_CADASTRAR")!= null){
			JMenuItem item = new JMenuItem("Cadastrar Produto");
			item.setToolTipText(transacoes.getTransacao("ESTOQUE_CADASTRAR"));
			item.addActionListener(listener.cadastrar);
			estoque.add(item);
		}
		if(transacoes.getTransacao("ESTOQUE_ANALISE")!= null){
			JMenuItem item = new JMenuItem("Validar Pedidos");
			item.setToolTipText(transacoes.getTransacao("ESTOQUE_ANALISE"));
			item.addActionListener(listener.validar);
			estoque.add(item);
		}
		if(transacoes.getTransacao("ESTOQUE_ENTRADA")!= null){
			JMenuItem item = new JMenuItem("Atualizar");
			item.setToolTipText(transacoes.getTransacao("ESTOQUE_ENTRADA"));
			item.addActionListener(listener.atualizar);
			estoque.add(item);
		}
		
		return estoque;
	}

}
