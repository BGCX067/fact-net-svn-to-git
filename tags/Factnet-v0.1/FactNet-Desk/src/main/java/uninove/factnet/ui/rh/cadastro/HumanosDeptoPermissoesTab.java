package uninove.factnet.ui.rh.cadastro;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uninove.factnet.datatypes.autenticacao.Permissoes;
import uninove.factnet.datatypes.rh.Departamento;
import uninove.factnet.datatypes.rh.Funcionario;
import uninove.factnet.listeners.humanos.HumanosListener;

public class HumanosDeptoPermissoesTab {

	private JComboBox cmbDepartamento;
	
	private JTextField txtResponsavel;
	
	private JCheckBox chkAcessaRH,
					  chkAcessaComercial,
					  chkAcessaEstoque,
					  chkAcessaAssistencia,
					  chkAcessaVendas;
	
	private JButton btnFinalizar = new JButton("Finalizar"),
					btnCancelar = new JButton("Cancelar");
	
	private HumanosListener listener;
	
	public JPanel initAbaDepartamentoPermissoes(HumanosListener listener){
		if(listener != null){
			this.listener = listener;
			this.listener.setDadosDptoPermissoes(this);
		}
		JPanel painel = new JPanel(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		cons.insets = new Insets(5, 5, 5, 5);
		
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridheight = 2;
		cons.gridwidth = 4;
		cons.anchor = GridBagConstraints.WEST;
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.weightx = 1.0;
		cons.weighty = 1.0;
		painel.add(this.initPainelDepartamento(), cons);
		
		cons.gridx = 0;
		cons.gridy = 3;
		cons.gridheight = 2;
		cons.gridwidth = 4;
		cons.anchor = GridBagConstraints.WEST;
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.weightx = 1.0;
		cons.weighty = 1.0;
		painel.add(this.initPainelPermissoes(), cons);
		
		cons.gridx = 1;
		cons.gridy = 5;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		cons.fill = GridBagConstraints.NONE;
		btnCancelar.addActionListener(listener.cancelar);
		painel.add(btnCancelar, cons);

		cons.gridx = 3;
		cons.gridy = 5;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.EAST;
		cons.fill = GridBagConstraints.NONE;
		btnFinalizar.addActionListener(listener.proximo);
		painel.add(btnFinalizar, cons);
		
		
		return painel;
	}
	
	private JPanel initPainelDepartamento(){
		JPanel painel = new JPanel(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		cons.insets = new Insets(5, 5, 5, 5);
		
		TitledBorder areaDepto = BorderFactory.createTitledBorder("Departamento");
		painel.setBorder(areaDepto);
		
		//Lebels
		JLabel labDepto = new JLabel("Departamento: "),
			   labResp = new JLabel("Responsavel: ");
		
		
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		painel.add(labDepto, cons);
		
		cons.gridx = 1;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		cmbDepartamento = new JComboBox();
		cmbDepartamento.addItem("Selecione");
		//Para Testes
		for(int i=0; i<=10; i++){
			Departamento dpto = new Departamento();
			dpto.setNomeDepartamento("Departamento 00"+(i+1));
			Funcionario f = new Funcionario();
			f.setNome("Responsavel "+(i+1));
			dpto.setResponsavel(f);
			cmbDepartamento.addItem(dpto);
		}
		
		cmbDepartamento.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ie) {
				txtResponsavel.setText(((Departamento)cmbDepartamento.getSelectedItem()).getResponsavel().getNome());
			}
		});
		
		//Fim testes
		painel.add(cmbDepartamento,cons);
		
		cons.gridx = 2;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		painel.add(labResp, cons);
		
		cons.gridx = 3;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		txtResponsavel = new JTextField(15);
		txtResponsavel.setEditable(false);
		painel.add(txtResponsavel,cons);
		
		return painel;
	}
	
	private JPanel initPainelPermissoes(){
		JPanel painel = new JPanel(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		cons.insets = new Insets(5, 5, 5, 5);
		
		TitledBorder areaDepto = BorderFactory.createTitledBorder("Permissões de Acesso");
		painel.setBorder(areaDepto);
		
		JLabel labTitulo = new JLabel("Este funcionario deverá ter acesso a: ");
		labTitulo.setFont(new Font(painel.getFont().getName(), Font.BOLD, painel.getFont().getSize()));
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 3;
		cons.anchor = GridBagConstraints.WEST;
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.weightx = 1.0;
		chkAcessaVendas = new JCheckBox("Acessar Vendas");
		painel.add(labTitulo, cons);
		
		cons.gridx = 0;
		cons.gridy = 1;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.weightx = 1.0;
		chkAcessaVendas = new JCheckBox("Acessar Vendas");
		painel.add(chkAcessaVendas, cons);
		
		cons.gridx = 0;
		cons.gridy = 2;
		cons.gridheight = 1;
		cons.gridwidth = 2;
		cons.anchor = GridBagConstraints.WEST;
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.weightx = 1.0;
		chkAcessaAssistencia = new JCheckBox("Acessar Assistências Técnicas");
		painel.add(chkAcessaAssistencia, cons);
		
		cons.gridx = 0;
		cons.gridy = 3;
		cons.gridheight = 1;
		cons.gridwidth = 2;
		cons.anchor = GridBagConstraints.WEST;
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.weightx = 1.0;
		chkAcessaComercial = new JCheckBox("Acessar Àrea Comercial");
		painel.add(chkAcessaComercial, cons);
		
		cons.gridx = 0;
		cons.gridy = 4;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.weightx = 1.0;
		chkAcessaEstoque = new JCheckBox("Acessar Estoque");
		painel.add(chkAcessaEstoque, cons);
		
		cons.gridx = 0;
		cons.gridy = 5;
		cons.gridheight = 1;
		cons.gridwidth = 2;
		cons.anchor = GridBagConstraints.WEST;
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.weightx = 1.0;
		chkAcessaRH = new JCheckBox("Acessar Recursos Humanos");
		painel.add(chkAcessaRH, cons);
		
		return painel;
	}

	public JComboBox getCmbDepartamento() {
		return cmbDepartamento;
	}

	public void setCmbDepartamento(JComboBox cmbDepartamento) {
		this.cmbDepartamento = cmbDepartamento;
	}

	public JTextField getTxtResponsavel() {
		return txtResponsavel;
	}

	public void setTxtResponsavel(JTextField txtResponsavel) {
		this.txtResponsavel = txtResponsavel;
	}

	public JCheckBox getChkAcessaRH() {
		return chkAcessaRH;
	}

	public void setChkAcessaRH(JCheckBox chkAcessaRH) {
		this.chkAcessaRH = chkAcessaRH;
	}

	public JCheckBox getChkAcessaComercial() {
		return chkAcessaComercial;
	}

	public void setChkAcessaComercial(JCheckBox chkAcessaComercial) {
		this.chkAcessaComercial = chkAcessaComercial;
	}

	public JCheckBox getChkAcessaEstoque() {
		return chkAcessaEstoque;
	}

	public void setChkAcessaEstoque(JCheckBox chkAcessaEstoque) {
		this.chkAcessaEstoque = chkAcessaEstoque;
	}

	public JCheckBox getChkAcessaAssistencia() {
		return chkAcessaAssistencia;
	}

	public void setChkAcessaAssistencia(JCheckBox chkAcessaAssistencia) {
		this.chkAcessaAssistencia = chkAcessaAssistencia;
	}

	public JCheckBox getChkAcessaVendas() {
		return chkAcessaVendas;
	}

	public void setChkAcessaVendas(JCheckBox chkAcessaVendas) {
		this.chkAcessaVendas = chkAcessaVendas;
	}

	public JButton getBtnFinalizar() {
		return btnFinalizar;
	}

	public void setBtnFinalizar(JButton btnFinalizar) {
		this.btnFinalizar = btnFinalizar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}
	
	public Funcionario popularDeptoPermissoes(Funcionario func){
		func.setDepartamento((Departamento) cmbDepartamento.getSelectedItem());
		
		Permissoes permissoes = new Permissoes();
		permissoes.setIsAcessaAssistencia(chkAcessaAssistencia.isSelected());
		permissoes.setIsAcessaComercial(chkAcessaComercial.isSelected());
		permissoes.setIsAcessaEstoque(chkAcessaEstoque.isSelected());
		permissoes.setIsAcessaRH(chkAcessaRH.isSelected());
		permissoes.setIsAcessaVendas(chkAcessaVendas.isSelected());
		
		func.setPermissoes(permissoes);
		
		return func;
	}
	
}
