package uninove.factnet.ui.vendas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import uninove.factnet.datatypes.autenticacao.Transacoes;
import uninove.factnet.datatypes.rh.Cliente;
import uninove.factnet.datatypes.vendas.ItemCarrinho;
import uninove.factnet.listeners.vendas.VendasListener;

public class VendasUI {
	
	private VendasListener listener = new VendasListener();
	private DefaultTableModel modelVendas = null;
	private ItemCarrinho itemPesquisado = null;
	private List<ItemCarrinho> itensVenda = new ArrayList<ItemCarrinho>();
	
	private JTextField txtProduto, txtValor, txtValorTotal;
	private Cliente cliente;
	
	public JMenu montarMenuVendas(Transacoes transacoes, JFrame janela){
		listener.setJanela(janela);
		listener.setUi(this);
		JMenu vendas = new JMenu("Vendas");
		vendas.setToolTipText("Opções de processos de venda");
		
		if(transacoes.getTransacao("VENDA_INICIAR")!= null){
			JMenuItem item = new JMenuItem("Iniciar Venda");
			item.addActionListener(listener.iniciar);
			item.setToolTipText(transacoes.getTransacao("VENDA_INICIAR"));
			vendas.add(item);
		}
		if(transacoes.getTransacao("VENDA_BUSCAR")!= null){
			JMenuItem item = new JMenuItem("Buscar Venda");
			item.addActionListener(listener.buscar);
			item.setToolTipText(transacoes.getTransacao("VENDA_BUSCAR"));
			vendas.add(item);
		}
		
		return vendas;
	}
	
	public JPanel iniciarTela(){
		
		listener.setUi(this);
		
		
		JPanel principal = new JPanel(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		cons.insets = new Insets(4,7,2,7);
		JLabel titulo = new JLabel("Modulo de Venda");
		titulo.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		titulo.setBorder(BorderFactory.createEmptyBorder(2, 2, 4, 2));

		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridwidth = 2;
		cons.gridheight = 1;
		cons.anchor = GridBagConstraints.WEST;
		principal.add(titulo, cons,0);
		
		cons.gridx = 0;
		cons.gridy = 1;
		cons.gridheight = 2;
		cons.gridwidth = 4;
		cons.anchor = GridBagConstraints.WEST;
		cons.fill = GridBagConstraints.BOTH;
		principal.add(this.initPainelPesquisa(), cons,1);
		
		cons.gridx = 0;
		cons.gridy = 4;
		cons.gridheight = 3;
		cons.gridwidth = 4;
		cons.weightx = 1;
		cons.weighty = 2;
		cons.anchor = GridBagConstraints.WEST;
		cons.fill = GridBagConstraints.BOTH;
		principal.add(this.initPainelItens(),cons,2);
		
		cons.gridx = 0;
		cons.gridy = 8;
		cons.gridheight = 1;
		cons.gridwidth = 4;
		cons.anchor = GridBagConstraints.WEST;
		cons.fill = GridBagConstraints.NONE;
		principal.add(this.initAreaTotal() ,cons,3);
		
		cons.gridx = 0;
		cons.gridy = 9;
		cons.gridheight = 2;
		cons.gridwidth = 4;
		cons.weightx = 1;
		cons.weighty = 1;
		cons.anchor = GridBagConstraints.WEST;
		cons.fill = GridBagConstraints.BOTH;
		principal.add(this.initBotoesVendas(),cons,4);
		
		principal.setVisible(true);
		return principal; 
		
	}
	
	private JPanel initPainelPesquisa(){
		TitledBorder grupoProduto = new TitledBorder("Produto");
		grupoProduto.setTitleFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
		
		GridBagConstraints cons = new GridBagConstraints();
		cons.insets = new Insets(2, 2, 2, 3);
		JPanel painelProduto = new JPanel(new GridBagLayout());
		painelProduto.setBorder(grupoProduto);
		
		JLabel labProduto = new JLabel("Produto: ");
		labProduto.setBackground(Color.BLUE);
		
		txtProduto = new JTextField(25);
		
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.weightx = 0.0;
		cons.fill = GridBagConstraints.NONE;
		cons.anchor = GridBagConstraints.WEST;
		painelProduto.add(labProduto,cons);
		
		cons.gridx = 1;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 3;
		cons.weightx = 0.0;
		cons.anchor = GridBagConstraints.WEST;
		cons.fill = GridBagConstraints.NONE;
		painelProduto.add(txtProduto, cons);
		
		JButton btnPesquisar = new JButton(new ImageIcon(this.loadIcon("/icones/busca.png").getScaledInstance(15, 15, Image.SCALE_SMOOTH)));
		btnPesquisar.addActionListener(listener.buscaProdutos);
		btnPesquisar.setPreferredSize(new Dimension(20, 20));
		
		cons.gridx = 4;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.weightx = 0.1;
		cons.fill = GridBagConstraints.NONE;
		cons.anchor = GridBagConstraints.WEST;
		painelProduto.add(btnPesquisar, cons);
		
		JLabel labValor = new JLabel("Valor R$: ");
		
		cons.gridx = 0;
		cons.gridy = 1;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.weightx = 0;
		cons.fill = GridBagConstraints.NONE;
		cons.anchor = GridBagConstraints.WEST;
		painelProduto.add(labValor, cons);
		
		txtValor = new JTextField(8);
		txtValor.setEditable(false);
		
		cons.gridx = 1;
		cons.gridy = 1;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.weightx = 0;
		cons.fill = GridBagConstraints.NONE;
		cons.anchor = GridBagConstraints.WEST;
		painelProduto.add(txtValor, cons);
		
		JButton btnConfirmar = new JButton("Adicionar");
		btnConfirmar.addActionListener(listener.adicionarItem);
		
		cons.gridx = 2;
		cons.gridy = 1;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.weightx = 0;
		cons.fill = GridBagConstraints.NONE;
		cons.anchor = GridBagConstraints.WEST;
		painelProduto.add(btnConfirmar, cons);
		
		return painelProduto;
	}
	
	private JPanel initPainelItens(){
		
		JPanel painelItens = new JPanel(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		
		TitledBorder grupoItens = new TitledBorder("Itens desta Compra");
		grupoItens.setTitleFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
		
		painelItens.setBorder(grupoItens);
		
		JTable tabItens = new JTable(){
			
			private static final long serialVersionUID = 3631224648163737636L;
			private Border outside = new MatteBorder(1, 0, 1, 0, Color.BLUE);
			private Border inside = new EmptyBorder(0, 1, 0, 1);
			private Border highlight = new CompoundBorder(outside, inside);
			
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				
				Component c = super.prepareRenderer(renderer, row, column);
				JComponent jc = (JComponent)c;

				if (isRowSelected(row))
					jc.setBorder( highlight );
				else if (!isRowSelected(row))
					c.setBackground(row % 2 == 0 ? getBackground() : new Color(230,230,230));

				return c;
			}
			
			@Override
			public Class<?> getColumnClass(int column) {
				switch (column) {
	                case 0:
	                    return String.class;
	                case 1:
	                    return String.class;
	                case 2:
	                    return Double.class;
	                default:
	                    return Boolean.class;
				}
			}
			
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column != 3){
					return false;
				}
				return super.isCellEditable(row, column);
			}
		};
		
		String[] colunas = {"Produto","Descrição","Valor", "Remover"}; 
		tabItens.setModel(setModelVendas(new Object[][]{}, colunas));
		tabItens.setFillsViewportHeight(true);
		
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridheight = 2;
		cons.gridwidth = 1;
		cons.weightx = 1;
		cons.anchor = GridBagConstraints.WEST;
		cons.fill = GridBagConstraints.BOTH;
		tabItens.getTableHeader().setReorderingAllowed(false);
		painelItens.add(tabItens.getTableHeader(),cons);
		
		cons.gridx = 0;
		cons.gridy = 1;
		cons.gridheight = 1;
		cons.gridwidth = 2;
		cons.weightx = 1;
		cons.anchor = GridBagConstraints.WEST;
		cons.fill = GridBagConstraints.BOTH;
		tabItens.setPreferredScrollableViewportSize(new Dimension(600, 100));
		JScrollPane scroll = new JScrollPane(tabItens);
		painelItens.add(scroll, cons);
		
		return painelItens;
	}
	
	private JPanel initBotoesVendas(){
		JPanel painelVendas = new JPanel(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		
		JPanel subPainelItens = new JPanel(new GridBagLayout()), subPainelVenda = new JPanel(new GridBagLayout()); 
		
		JButton btnVender = new JButton("Efetuar Venda");
		JButton btnSalvar = new JButton("Salvar Venda");
		JButton btnRemoverItens = new JButton("Remover itens selecionados");
		JButton btnRemoverTodos = new JButton("Remover todos itens");
		
		cons.insets = new Insets(5, 3, 4, 3);
		
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridwidth = 1;
		cons.gridheight = 1;
		cons.fill = GridBagConstraints.BOTH;
		subPainelVenda.add(btnVender, cons);
		
		cons.gridx = 1;
		cons.gridy = 0;
		cons.gridwidth = 1;
		cons.gridheight = 1;
		cons.fill = GridBagConstraints.BOTH;
		subPainelVenda.add(btnSalvar, cons);
		
		btnVender.addActionListener(listener.efetuarVendas);
		btnSalvar.addActionListener(listener.salvarVendas);
		
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridwidth = 1;
		cons.gridheight = 1;
		cons.fill = GridBagConstraints.BOTH;
		subPainelItens.add(btnRemoverItens, cons);
		
		cons.gridx = 1;
		cons.gridy = 0;
		cons.gridwidth = 1;
		cons.gridheight = 1;
		cons.fill = GridBagConstraints.BOTH;
		subPainelItens.add(btnRemoverTodos, cons);
		
		
		btnRemoverItens.addActionListener(listener.limparItens);
		btnRemoverTodos.addActionListener(listener.limparTodosItens);
		
		subPainelItens.setBorder(BorderFactory.createTitledBorder("Ações do Carrinho"));
		subPainelVenda.setBorder(BorderFactory.createTitledBorder("Ações da Venda"));
		
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridwidth = 2;
		cons.gridheight = 1;
		cons.fill = GridBagConstraints.BOTH;
		cons.anchor = GridBagConstraints.WEST;
		painelVendas.add(subPainelVenda, cons);
		
		cons.gridx = 2;
		cons.gridy = 0;
		cons.gridwidth = 2;
		cons.gridheight = 1;
		cons.fill = GridBagConstraints.BOTH;
		cons.anchor = GridBagConstraints.WEST;
		painelVendas.add(subPainelItens, cons);
		
		return painelVendas;
	}
	
	private JPanel initAreaTotal(){
		JPanel painel = new JPanel(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		cons.insets = new Insets(5, 5, 5, 5);
		
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.EAST;
		cons.fill = GridBagConstraints.NONE;
		painel.add(new JLabel("Valor total: R$"),cons);
		
		cons.gridx = 1;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		cons.fill = GridBagConstraints.NONE;
		txtValorTotal = new JTextField(8);
		txtValorTotal.setEditable(false);
		painel.add(txtValorTotal,cons);
		
		return painel;
	}
	
	public ItemCarrinho initBuscaProdutos(final JTable tabela, List<?> dados){
		final JDialog modal = new JDialog(listener.getJanela(), true);
		modal.setTitle("Resultado da Pesquisa");
		JScrollPane scroll = new JScrollPane(tabela);
		scroll.setPreferredSize(tabela.getPreferredSize());
		
		final int[] i = {-1};
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				i[0] = tabela.getSelectedRow();
				modal.dispose();
			}
		});
		modal.add(tabela.getTableHeader());
		modal.add(scroll);
		modal.setSize(modal.getPreferredSize());
		modal.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		modal.setLocationRelativeTo(null);
		modal.setVisible(true);
		if(i[0] > -1){
			System.out.println("Item selecionado: "+ i[0]);
			return (ItemCarrinho) dados.get(i[0]);
		}else{
			return null;
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new VendasUI().iniciarTela());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
	}
	
	private Image loadIcon(String patch){
		
		URL imgURL = getClass().getResource(patch);
		ImageIcon icone = new ImageIcon(imgURL);
		return icone.getImage();
	}

	/**
	 * @return the modelVendas
	 */
	public DefaultTableModel getModelVendas() {
		return modelVendas;
	}

	/**
	 * @param modelVendas the modelVendas to set
	 */
	public void setModelVendas(DefaultTableModel modelVendas) {
		this.modelVendas = modelVendas;
	}
	
	public DefaultTableModel setModelVendas(Object[][] data, String[] colunas) {
		this.modelVendas = new DefaultTableModel(data, colunas);
		return this.modelVendas;
	}

	/**
	 * @return the itemPesquisado
	 */
	public ItemCarrinho getItemPesquisado() {
		return itemPesquisado;
	}

	/**
	 * @param itemPesquisado the itemPesquisado to set
	 */
	public void setItemPesquisado(ItemCarrinho itemPesquisado) {
		this.itemPesquisado = itemPesquisado;
	}
	
	public void setValueTxtProduto(String texto){
		txtProduto.setText(texto);
	}
	
	public void setValueTxtValor(String texto){
		txtValor.setText(texto);
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void addItemVenda(ItemCarrinho item){
		itensVenda.add(item);
	}
	
	public void removeItemVenda(int index){
		itensVenda.remove(index);
	}
	
	public List<ItemCarrinho> getItensVenda(){
		return itensVenda;
	}
	
	public void setValorTotal(Double valor){
		this.txtValorTotal.setText(String.valueOf(valor));
	}
	
	public Double getValorTotal(){
		Double valorFormatado = new Double(0);
		System.out.println("=====================Valor total: '"+txtValorTotal.getText()+"'");
		if(txtValorTotal.getText() != null && !txtValorTotal.getText().isEmpty()){
			valorFormatado = new Double(txtValorTotal.getText());
		}
		return valorFormatado;
	}
	
}
