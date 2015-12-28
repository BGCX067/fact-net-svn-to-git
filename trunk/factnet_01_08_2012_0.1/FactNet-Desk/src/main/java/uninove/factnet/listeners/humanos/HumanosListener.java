package uninove.factnet.listeners.humanos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uninove.factnet.Janela;
import uninove.factnet.datatypes.rh.Funcionario;
import uninove.factnet.ui.humanos.HumanosUI;
import uninove.factnet.ui.rh.cadastro.HumanosCargoTab;
import uninove.factnet.ui.rh.cadastro.HumanosDeptoPermissoesTab;
import uninove.factnet.ui.rh.cadastro.HumanosFuncionarioTab;

public class HumanosListener {
	
	private JFrame janela = new JFrame();
	
	private HumanosUI ui;
	
	private HumanosFuncionarioTab dadosFuncionario;
	private HumanosCargoTab dadosCargo;
	private HumanosDeptoPermissoesTab dadosDptoPermissoes;
	private Funcionario funcionario;
	private int abaTelaCadastro = 0;

	public void setJanela(JFrame janela) {
		this.janela = janela;
	}

	public void setUi(HumanosUI ui) {
		this.ui = ui;
	}

	public void setDadosFuncionario(HumanosFuncionarioTab dadosFuncionario) {
		this.dadosFuncionario = dadosFuncionario;
	}

	public void setDadosCargo(HumanosCargoTab dadosCargo) {
		this.dadosCargo = dadosCargo;
	}

	public void setDadosDptoPermissoes(HumanosDeptoPermissoesTab dadosDptoPermissoes) {
		this.dadosDptoPermissoes = dadosDptoPermissoes;
	}




	public ActionListener cadastrar = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Executando Cadastrar RH");
			
			String messageCadastro = "Deseja Cadastrar um funcionário ?";
			int isFuncionario = JOptionPane.showConfirmDialog(janela, messageCadastro);
			if(isFuncionario != 0){
				JOptionPane.showMessageDialog(janela, "Funcionalidade ainda nao disponivel.");
			}
			
			janela.getContentPane().remove(0);
			janela.getContentPane().add(ui.initTelaCadastroFuncionario(),0);
			janela.repaint();
			janela.setSize(janela.getPreferredSize());
			janela.setLocationRelativeTo(null);
			System.out.println("Finalizado");
		}
	};
	
	public ActionListener atualizar = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Executando Atualizar RH");
		}
	};
	
	
	public ActionListener cancelar = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Executando Acao Cancelar");
			
			janela.getContentPane().remove(0);
			janela.getContentPane().add( new Janela().iniciarPainelInicial(new Funcionario()),0);
			janela.repaint();
			janela.setSize(janela.getPreferredSize());
			janela.setLocationRelativeTo(null);
			System.out.println("Finalizado");
			
		}
	};
	
	public ActionListener proximo = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Executando Acao Proximo");
			switch (abaTelaCadastro) {
			case 0:
				funcionario = dadosFuncionario.popularFuncionario();
				abaTelaCadastro++;
				ui.alterarAba(abaTelaCadastro);
				break;
			case 1:
				funcionario = dadosCargo.popularCargo(funcionario);
				abaTelaCadastro++;
				ui.alterarAba(abaTelaCadastro);
				break;
			default:
				funcionario = dadosDptoPermissoes.popularDeptoPermissoes(funcionario);
				abaTelaCadastro = 0;
				JOptionPane.showMessageDialog(janela, "Cadastro realizado com sucesso, login disponivel a partir de amanhã.");
				janela.getContentPane().remove(0);
				janela.getContentPane().add( new Janela().iniciarPainelInicial(new Funcionario()),0);
				janela.repaint();
				janela.setSize(janela.getPreferredSize());
				janela.setLocationRelativeTo(null);
				break;
			}
		}
	};
	
	
	
	

}
