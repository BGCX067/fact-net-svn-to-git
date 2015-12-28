package uninove.factnet.ui.rh.cadastro;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uninove.factnet.datatypes.rh.Cargo;
import uninove.factnet.datatypes.rh.Funcionario;
import uninove.factnet.listeners.humanos.HumanosListener;

public class HumanosCargoTab {
	
	private JComboBox cmbCargo;

	private JTextField txtDtAdmissao, 
					   txtSalarioAcordado,
					   txtSalarioBase,
					   txtEscolaridadeMinima,
					   txtValorMedico,
					   txtValorVr,
					   txtValorVt,
					   txtValorFGTS;
	
	private JButton btnProximo = new JButton("Proximo"),
					btnCancelar = new JButton("Cancelar");
	
	private JCheckBox chkPossuiMedico,
					  chkPossuiVr,
					  chkPossuiVt,
					  chkIsCLT,
					  chkPossuiEscolaridade;
	
	private HumanosListener listener;
	
	public JPanel initAbaCargo(HumanosListener listener){
		if(listener != null){
			this.listener = listener;
			this.listener.setDadosCargo(this);
		}
		JPanel painel = new JPanel(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		cons.insets = new Insets(5, 5, 5, 5);
		
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridheight = 2;
		cons.gridwidth = 3;
		cons.anchor = GridBagConstraints.EAST;
		cons.fill = GridBagConstraints.BOTH;
		cons.weightx = 1.0;
		cons.weighty = 1.0;
		painel.add(this.initPainelBasico(), cons);
		
		cons.gridx = 0;
		cons.gridy = 2;
		cons.gridheight = 2;
		cons.gridwidth = 3;
		cons.anchor = GridBagConstraints.EAST;
		cons.fill = GridBagConstraints.BOTH;
		cons.weightx = 1.0;
		cons.weighty = 1.0;
		painel.add(this.initPainelBeneficios(), cons);
		
		cons.gridx = 1;
		cons.gridy = 4;
		cons.gridheight = 1;
		cons.gridwidth = 2;
		cons.anchor = GridBagConstraints.EAST;
		cons.fill = GridBagConstraints.NONE;
		btnProximo.addActionListener(listener.proximo);
		painel.add(btnProximo, cons);
		
		cons.gridx = 1;
		cons.gridy = 4;
		cons.gridheight = 1;
		cons.gridwidth = 2;
		cons.anchor = GridBagConstraints.WEST;
		cons.fill = GridBagConstraints.NONE;
		btnCancelar.addActionListener(listener.cancelar);
		painel.add(btnCancelar, cons);
		
		return painel;
	}
	
	private JPanel initPainelBasico(){
		
		TitledBorder areaBasica = BorderFactory.createTitledBorder("Informações Basicas");
		JPanel painelBasico = new JPanel(new GridBagLayout());
		painelBasico.setBorder(areaBasica);
		GridBagConstraints cons = new GridBagConstraints();
		cons.insets = new Insets(5, 5, 5, 5);
		
		JLabel labDtAdmissao = new JLabel("Dt. Admissão: ");
		JLabel labCargo = new JLabel("Cargo: ");
		JLabel labEscolaridade = new JLabel("Escolaridade Min: ");
		
		
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.EAST;
		painelBasico.add(labDtAdmissao, cons);
		
		cons.gridx = 1;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		txtDtAdmissao = new JTextField(8);
		txtDtAdmissao.setEditable(false);
		
		txtDtAdmissao.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		painelBasico.add(txtDtAdmissao, cons);
		
		cons.gridx = 2;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.EAST;
		painelBasico.add(labCargo, cons);
		
		cons.gridx = 3;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 2;
		cons.anchor = GridBagConstraints.WEST;
		cons.fill = GridBagConstraints.HORIZONTAL;
		cmbCargo = new JComboBox();
		
		//Para testes
		for (int i = 0; i < 10; i++) {
			Cargo cargo = new Cargo();
			cargo.setNomeCargo("Cargo  "+(i+1));
			cargo.setEscolaridadeMinima("Curso "+(i+1));
			cargo.setSalarioBase(new Double(i*100.98));
			cmbCargo.addItem(cargo);
		}
		//Fim teste
		cmbCargo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				txtEscolaridadeMinima.setText(((Cargo)e.getItem()).getEscolaridadeMinima());
				txtSalarioBase.setText(((Cargo)e.getItem()).getSalarioBase().toString());
				txtSalarioAcordado.setText(((Cargo)e.getItem()).getSalarioBase().toString());
			}
		});
		
		painelBasico.add(cmbCargo, cons);
		
		
		cons.gridx = 0;
		cons.gridy = 1;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.EAST;
		painelBasico.add(labEscolaridade, cons);
		
		cons.gridx = 1;
		cons.gridy = 1;
		cons.gridheight = 1;
		cons.gridwidth = 2;
		cons.anchor = GridBagConstraints.WEST;
		txtEscolaridadeMinima = new JTextField(12);
		txtEscolaridadeMinima.setEditable(false);
		painelBasico.add(txtEscolaridadeMinima, cons);
		
		cons.gridx = 3;
		cons.gridy = 1;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.EAST;
		chkPossuiEscolaridade = new JCheckBox("Possui");
		painelBasico.add(chkPossuiEscolaridade, cons);
		
		return painelBasico;
	}
	
	private JPanel initPainelBeneficios(){
		
		TitledBorder areaBeneficios = BorderFactory.createTitledBorder("Informações Basicas");
		JPanel painelBeneficios = new JPanel(new GridBagLayout());
		painelBeneficios.setBorder(areaBeneficios);
		GridBagConstraints cons = new GridBagConstraints();
		cons.insets = new Insets(5, 5, 5, 5);
		
		JLabel labSalBase = new JLabel("Sal. Base: "),
			   labSalRegistrado = new JLabel("Sal. Contratado: "),
			   labVrFGTS = new JLabel("Valor FGTS: "),
			   labVrVr = new JLabel("Valor VR: "),
			   labVrVt = new JLabel("Valor VT: "),
			   labVrMedico = new JLabel("Valor Médico: ");
		
		
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		painelBeneficios.add(labSalBase, cons);
		
		cons.gridx = 1;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		txtSalarioBase = new JTextField(12);
		txtSalarioBase.setEditable(false);
		painelBeneficios.add(txtSalarioBase, cons);
		
		cons.gridx = 2;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		painelBeneficios.add(labSalRegistrado, cons);
		
		cons.gridx = 3;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		txtSalarioAcordado = new JTextField(12);
		painelBeneficios.add(txtSalarioAcordado, cons);
		
		cons.gridx = 0;
		cons.gridy = 1;
		cons.gridheight = 1;
		cons.gridwidth = 2;
		cons.anchor = GridBagConstraints.WEST;
		chkIsCLT = new JCheckBox("Contrato CLT");
		chkIsCLT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtValorFGTS.setEditable(chkIsCLT.isSelected());
				txtValorFGTS.setText("");
			}
		});
		painelBeneficios.add(chkIsCLT, cons);
		
		cons.gridx = 2;
		cons.gridy = 1;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		painelBeneficios.add(labVrFGTS, cons);
		
		cons.gridx = 3;
		cons.gridy = 1;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		txtValorFGTS = new JTextField(12);
		txtValorFGTS.setEditable(false);
		painelBeneficios.add(txtValorFGTS, cons);
		
		cons.gridx = 0;
		cons.gridy = 2;
		cons.gridheight = 1;
		cons.gridwidth = 2;
		cons.anchor = GridBagConstraints.WEST;
		chkPossuiVr = new JCheckBox("Beneficio VR");
		chkPossuiVr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtValorVr.setEditable(chkPossuiVr.isSelected());
				txtValorVr.setText("");
			}
		});
		painelBeneficios.add(chkPossuiVr, cons);
		
		cons.gridx = 2;
		cons.gridy = 2;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		painelBeneficios.add(labVrVr, cons);
		
		cons.gridx = 3;
		cons.gridy = 2;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		txtValorVr = new JTextField(12);
		txtValorVr.setEditable(false);
		painelBeneficios.add(txtValorVr, cons);
		
		cons.gridx = 0;
		cons.gridy = 3;
		cons.gridheight = 1;
		cons.gridwidth = 2;
		cons.anchor = GridBagConstraints.WEST;
		chkPossuiVt = new JCheckBox("Beneficio VR");
		chkPossuiVt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtValorVt.setEditable(chkPossuiVt.isSelected());
				txtValorVt.setText("");
			}
		});
		painelBeneficios.add(chkPossuiVt, cons);
		
		cons.gridx = 2;
		cons.gridy = 3;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		painelBeneficios.add(labVrVt, cons);
		
		cons.gridx = 3;
		cons.gridy = 3;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		txtValorVt = new JTextField(12);
		txtValorVt.setEditable(false);
		painelBeneficios.add(txtValorVt, cons);
		
		cons.gridx = 0;
		cons.gridy = 4;
		cons.gridheight = 1;
		cons.gridwidth = 2;
		cons.anchor = GridBagConstraints.WEST;
		chkPossuiMedico = new JCheckBox("Beneficio Ass. Medica");
		chkPossuiMedico.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtValorMedico.setEditable(chkPossuiMedico.isSelected());
				txtValorMedico.setText("");
			}
		});
		painelBeneficios.add(chkPossuiMedico, cons);
		
		cons.gridx = 2;
		cons.gridy = 4;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		painelBeneficios.add(labVrMedico, cons);
		
		cons.gridx = 3;
		cons.gridy = 4;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		txtValorMedico = new JTextField(12);
		txtValorMedico.setEditable(false);
		painelBeneficios.add(txtValorMedico, cons);
		
		return painelBeneficios;
	}

	public JComboBox getCmbCargo() {
		return cmbCargo;
	}

	public void setCmbCargo(JComboBox cmbCargo) {
		this.cmbCargo = cmbCargo;
	}

	public JTextField getTxtDtAdmissao() {
		return txtDtAdmissao;
	}

	public void setTxtDtAdmissao(JTextField txtDtAdmissao) {
		this.txtDtAdmissao = txtDtAdmissao;
	}

	public JTextField getTxtSalarioAcordado() {
		return txtSalarioAcordado;
	}

	public void setTxtSalarioAcordado(JTextField txtSalarioAcordado) {
		this.txtSalarioAcordado = txtSalarioAcordado;
	}

	public JTextField getTxtSalarioBase() {
		return txtSalarioBase;
	}

	public void setTxtSalarioBase(JTextField txtSalarioBase) {
		this.txtSalarioBase = txtSalarioBase;
	}

	public JTextField getTxtEscolaridadeMinima() {
		return txtEscolaridadeMinima;
	}

	public void setTxtEscolaridadeMinima(JTextField txtEscolaridadeMinima) {
		this.txtEscolaridadeMinima = txtEscolaridadeMinima;
	}

	public JTextField getTxtValorMedico() {
		return txtValorMedico;
	}

	public void setTxtValorMedico(JTextField txtValorMedico) {
		this.txtValorMedico = txtValorMedico;
	}

	public JTextField getTxtValorVr() {
		return txtValorVr;
	}

	public void setTxtValorVr(JTextField txtValorVr) {
		this.txtValorVr = txtValorVr;
	}

	public JTextField getTxtValorVt() {
		return txtValorVt;
	}

	public void setTxtValorVt(JTextField txtValorVt) {
		this.txtValorVt = txtValorVt;
	}

	public JTextField getTxtValorFGTS() {
		return txtValorFGTS;
	}

	public void setTxtValorFGTS(JTextField txtValorFGTS) {
		this.txtValorFGTS = txtValorFGTS;
	}

	public JButton getBtnProximo() {
		return btnProximo;
	}

	public void setBtnProximo(JButton btnProximo) {
		this.btnProximo = btnProximo;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JCheckBox getChkPossuiMedico() {
		return chkPossuiMedico;
	}

	public void setChkPossuiMedico(JCheckBox chkPossuiMedico) {
		this.chkPossuiMedico = chkPossuiMedico;
	}

	public JCheckBox getChkPossuiVr() {
		return chkPossuiVr;
	}

	public void setChkPossuiVr(JCheckBox chkPossuiVr) {
		this.chkPossuiVr = chkPossuiVr;
	}

	public JCheckBox getChkPossuiVt() {
		return chkPossuiVt;
	}

	public void setChkPossuiVt(JCheckBox chkPossuiVt) {
		this.chkPossuiVt = chkPossuiVt;
	}

	public JCheckBox getChkIsCLT() {
		return chkIsCLT;
	}

	public void setChkIsCLT(JCheckBox chkIsCLT) {
		this.chkIsCLT = chkIsCLT;
	}

	public JCheckBox getChkPossuiEscolaridade() {
		return chkPossuiEscolaridade;
	}

	public void setChkPossuiEscolaridade(JCheckBox chkPossuiEscolaridade) {
		this.chkPossuiEscolaridade = chkPossuiEscolaridade;
	}
	
	public Funcionario popularCargo(Funcionario func){
		if(chkPossuiEscolaridade.isSelected()){
			func.setCargo((Cargo) cmbCargo.getSelectedItem());
			func.setSalario(Double.valueOf(txtSalarioAcordado.getText().replace(",", ".")));
		}
		return func;
		
	}
	
}
