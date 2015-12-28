package uninove.factnet.ui.assistencia;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import uninove.factnet.datatypes.autenticacao.Transacoes;
import uninove.factnet.listeners.assistencia.AssistenciaListener;

public class AssistenciaUI {
	
	private AssistenciaListener listener = new AssistenciaListener();
	
	public JMenu montarMenuVendas(Transacoes transacoes){
		JMenu assistencia = new JMenu("Assistencia Técnica");
		assistencia.setToolTipText("Gerenciamento de Assistencias Técnicas");
		
		if(transacoes.getTransacao("ASSISTENCIA_INCLUIR")!= null){
			JMenuItem item = new JMenuItem("Iniciar Assistência");
			item.setToolTipText(transacoes.getTransacao("ASSISTENCIA_INCLUIR"));
			item.addActionListener(listener.iniciar);
			assistencia.add(item);
		}
		if(transacoes.getTransacao("ASSISTENCIA_VISUALIZAR")!= null){
			JMenuItem item = new JMenuItem("Buscar Assistências");
			item.setToolTipText(transacoes.getTransacao("ASSISTENCIA_VISUALIZAR"));
			item.addActionListener(listener.buscar);
			assistencia.add(item);
		}
		if(transacoes.getTransacao("ASSISTENCIA_FINALIZAR")!= null){
			JMenuItem item = new JMenuItem("Finalizar Assistência");
			item.setToolTipText(transacoes.getTransacao("ASSISTENCIA_FINALIZAR"));
			item.addActionListener(listener.finalizar);
			assistencia.add(item);
		}
		return assistencia;
	}

}
