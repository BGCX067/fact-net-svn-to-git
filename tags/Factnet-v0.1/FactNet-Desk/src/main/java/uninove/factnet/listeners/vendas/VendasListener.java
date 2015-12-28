package uninove.factnet.listeners.vendas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import uninove.factnet.Janela;
import uninove.factnet.bo.vendas.VendasBO;
import uninove.factnet.datatypes.rh.Cliente;
import uninove.factnet.datatypes.rh.Funcionario;
import uninove.factnet.datatypes.vendas.ItemCarrinho;
import uninove.factnet.ui.utils.BuscaUtilsUI;
import uninove.factnet.ui.vendas.VendasUI;

public class VendasListener {
	private JFrame janela;
	private VendasUI ui;
	private JTable tabelaBusca;
	
	public JFrame getJanela() {
		return janela;
	}

	public void setJanela(JFrame janela) {
		this.janela = janela;
	}
	
	public VendasUI getUi() {
		return ui;
	}

	public void setUi(VendasUI ui) {
		this.ui = ui;
	}

	public ActionListener iniciar = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Executando Iniciar Vendas");
			
			String messageLogar = "Caso o cliente possua cadastro, está venda poderá ser salva.\nEle deseja efetuar login ?";
			int isLogar = JOptionPane.showConfirmDialog(janela, messageLogar);
			Cliente cliente = null;
			if(isLogar == 0){
				cliente = BuscaUtilsUI.buscaClienteModal(janela);
			}
			if(isLogar != 0 || cliente == null){
				cliente = new Cliente(); 
				cliente.setIdPessoa(new Long(0));
			}
			ui.setCliente(cliente);
			janela.getContentPane().remove(0);
			janela.getContentPane().add(ui.iniciarTela(),0);
			janela.repaint();
			janela.setSize(janela.getPreferredSize());
			janela.setLocationRelativeTo(null);
			System.out.println("Finalizado");
		}
	};
	
	public ActionListener buscar = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Executando Buscar Vendas");
		}
	};
	
	public ActionListener buscaProdutos = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Executando Busca de Produtos ----- ");
			
			VendasBO vendasBO = new VendasBO();
			List<ItemCarrinho> lista = vendasBO.buscarProduto("Teste");
			
			tabelaBusca = vendasBO.popularGridPesquisa(vendasBO.getTabelaZebrada(), lista);
			
			ItemCarrinho item = ui.initBuscaProdutos(tabelaBusca, lista);
			
			if(item != null){
				ui.setItemPesquisado(item);
				ui.setValueTxtProduto(item.getNomeProduto());
				ui.setValueTxtValor(item.getValorVenda().toString());
			}
		}
	};
	
	public ActionListener adicionarItem = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(ui.getItemPesquisado() != null){
				System.out.println("Executando Adicionar Item");
				DefaultTableModel model = ui.getModelVendas();
				ItemCarrinho item = ui.getItemPesquisado().clonar();
				Object[] data = {item.getNomeProduto(), item.getDescricao(), item.getValorVenda(), item.getIsRemover()};
				
				model.addRow(data);
				ui.addItemVenda(item);
				
				ui.setValorTotal(ui.getValorTotal() + item.getValorVenda());
				
				ui.setItemPesquisado(null);
				ui.setValueTxtProduto("");
				ui.setValueTxtValor("");
			}else{
				JOptionPane.showMessageDialog(null, "Faça primeiramente uma busca do produto.");
			}
		}
	};
	
	public ActionListener efetuarVendas = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Executando Efetuar Vendas");
			
			JOptionPane.showMessageDialog(janela, "Venda realizada com sucesso.");
			
			janela.getContentPane().remove(0);
			janela.getContentPane().add(new Janela().iniciarPainelInicial(new Funcionario()),0);
			janela.repaint();
			janela.setSize(janela.getPreferredSize());
			janela.setLocationRelativeTo(null);
			System.out.println("Finalizado");
		}
	};
	
	public ActionListener salvarVendas = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Executando Salvar Vendas");
			JOptionPane.showMessageDialog(null, "Ainda nao é possivel salvar vendas");
		}
	};
	
	public ActionListener limparTodosItens = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Executando Limpar Todos Itens");
			int total = ui.getModelVendas().getRowCount();
			System.out.println("Total: "+total);
			for(int i = 0; i< total; i++){
				ui.getModelVendas().removeRow(0);
				ui.removeItemVenda(0);
				ui.setValorTotal(new Double(0.00));
			}
		}
	};
	
	public ActionListener limparItens = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Executando Limpar Itens");
			boolean removido = true;
			while(removido){
				int index = -1;
				Boolean isRemover= Boolean.FALSE;
				for(int i = 0; i<ui.getModelVendas().getRowCount(); i++){
					isRemover =  (Boolean) ui.getModelVendas().getValueAt(i, 3);
					if(isRemover){
						index = i;
						break;
					}
					
				}
				if(isRemover){
					ui.getModelVendas().removeRow(index);
					
					ui.setValorTotal(ui.getValorTotal() - ui.getItensVenda().get(index).getValorVenda());
					
					ui.removeItemVenda(index);
					removido = true;
				}else{
					removido = false;
				}
			}
			
		}
	};
	
}
