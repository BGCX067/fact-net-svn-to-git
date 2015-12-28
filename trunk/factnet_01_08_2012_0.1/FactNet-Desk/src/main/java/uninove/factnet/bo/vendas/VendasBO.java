package uninove.factnet.bo.vendas;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import uninove.factnet.datatypes.vendas.ItemCarrinho;

public class VendasBO {
	
	public List<ItemCarrinho> buscarProduto(String pesquisa){
		List<ItemCarrinho> lista = new ArrayList<ItemCarrinho>();
		for(int i = 0; i<= 10 ; i++){
			ItemCarrinho item = new ItemCarrinho();
			item.setDescricao("Teste .... "+i+1);
			item.setIdProduto(new Long(i));
			item.setIsRemover(false);
			item.setNomeProduto("Produto Teste..."+i+1);
			item.setValorVenda(new Double(i+1*4.89));
			
			lista.add(item);
		}
		
		return lista;
	}
	
	public JTable popularGridPesquisa(JTable table, List<ItemCarrinho> dados){
		
		String[] colunas = {"Nome", "Valor"};
		
		DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{}, colunas);
		
		for (ItemCarrinho item : dados) {
			tableModel.addRow(new Object[]{item.getNomeProduto(), item.getValorVenda()});
		}
		
		table.setModel(tableModel);
		
		return table;
	}
	
	public JTable getTabelaZebrada(){
		JTable model = new JTable(){
			private static final long serialVersionUID = -4196200015815826825L;

			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				// TODO Auto-generated method stub
				Component c =  super.prepareRenderer(renderer, row, column);
				c.setBackground(row % 2 == 0 ? getBackground() : new Color(230,230,230));
				return c;
			}
		};
		
		return model;
	};

}
