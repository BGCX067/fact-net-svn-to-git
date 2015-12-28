package uninove.factnet.listeners.estoque;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class EstoqueListener {
	
	private JFrame janela;

	public JFrame getJanela() {
		return janela;
	}

	public void setJanela(JFrame janela) {
		this.janela = janela;
	}
	
	public ActionListener verificar = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Executando Verificar Estoque");
		}
	};
	
	public ActionListener cadastrar = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Executando Cadastrar Estoque");
		}
	};
	
	public ActionListener validar = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Executando Validar Estoque");
		}
	};
	
	public ActionListener atualizar = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Executando Atualizar Estoque");
		}
	};
}
