package uninove.factnet.listeners.assistencia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class AssistenciaListener {
	
	private JFrame janela;

	public JFrame getJanela() {
		return janela;
	}

	public void setJanela(JFrame janela) {
		this.janela = janela;
	}
	
	public ActionListener iniciar = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Executando Iniciar Assistencia");
		}
	};
	
	public ActionListener buscar = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Executando Buscar Assistencia");
		}
	};
	
	public ActionListener finalizar = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Executando Finalizar Assistencia");
		}
	};
	
	
}
