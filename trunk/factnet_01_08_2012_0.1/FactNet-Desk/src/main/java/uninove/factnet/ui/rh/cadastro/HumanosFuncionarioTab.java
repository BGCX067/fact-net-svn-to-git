package uninove.factnet.ui.rh.cadastro;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uninove.factnet.datatypes.login.Login;
import uninove.factnet.datatypes.rh.Funcionario;
import uninove.factnet.listeners.humanos.HumanosListener;

public class HumanosFuncionarioTab {
	
	private JComboBox cmbEstadoCivil;
	
	private JTextField txtRg,
					   txtNome,
				  	   txtEndereco,
					   txtDtNascimento,
					   txtCpf, 
					   txtCidade,
					   txtCep, 
					   txtEmail;
	
	private JButton btnProximo = new JButton("Proximo"),
					btnCancelar = new JButton("Cancelar");
	
	private Long idPessoa;
	private Boolean isAtivo = false;
	private Boolean isFuncionario = false;
	
	private HumanosListener listener;
	
	public JPanel initAbaFuncionario(HumanosListener listener){
		if(listener != null){
			this.listener = listener;
			this.listener.setDadosFuncionario(this);
		}
		JPanel painel = new JPanel(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		cons.insets = new Insets(5, 5, 5, 5);
		
		//Paineis da tela
		JPanel painelPessoal = this.initPainelPessoal();
		JPanel painelContato = this.initPainelContato();
		
		
		
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridheight = 2;
		cons.gridwidth = 4;
		cons.anchor = GridBagConstraints.WEST;
		cons.fill = GridBagConstraints.BOTH;
		cons.weightx = 1.0;
		cons.weighty = 1.0;
		painel.add(painelPessoal, cons);
		
		cons.gridx = 0;
		cons.gridy = 2;
		cons.gridheight = 2;
		cons.gridwidth = 4;
		cons.anchor = GridBagConstraints.EAST;
		cons.fill = GridBagConstraints.BOTH;
		cons.weightx = 1.0;
		cons.weighty = 1.0;
		painel.add(painelContato, cons);
		
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
	
	private JPanel initPainelPessoal(){
		
		TitledBorder areaPessoal = BorderFactory.createTitledBorder("Informações Pessoais");
		JPanel painelPessoal = new JPanel(new GridBagLayout());
		painelPessoal.setBorder(areaPessoal);
		
		GridBagConstraints cons = new GridBagConstraints();
		cons.insets = new Insets(5, 5, 5, 5);
		
		JLabel labNome = new JLabel("Nome: ");
		JLabel labRG = new JLabel("RG: ");
		JLabel labCPF = new JLabel("CPF: ");
		JLabel labNascimento = new JLabel("Dt. Nasc: ");
		JLabel labSexo = new JLabel("Sexo: ");
		
		
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		painelPessoal.add(labNome, cons);
		
		cons.gridx = 1;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 3;
		cons.anchor = GridBagConstraints.WEST;
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.weightx = 1;
		txtNome = new JTextField(25);
		painelPessoal.add(txtNome, cons);
		
		cons.gridx = 0;
		cons.gridy = 1;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.EAST;
		painelPessoal.add(labRG, cons);
		
		cons.gridx = 1;
		cons.gridy = 1;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		txtRg = new JTextField(12);
		painelPessoal.add(txtRg, cons);
		
		cons.gridx = 2;
		cons.gridy = 1;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.EAST;
		painelPessoal.add(labCPF, cons);
		
		cons.gridx = 3;
		cons.gridy = 1;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		txtCpf = new JTextField(12);
		painelPessoal.add(txtCpf, cons);
		
		cons.gridx = 0;
		cons.gridy = 2;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.EAST;
		painelPessoal.add(labNascimento, cons);
		
		cons.gridx = 1;
		cons.gridy = 2;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		txtDtNascimento = new JTextField(8);
		painelPessoal.add(txtDtNascimento, cons);
		
		cons.gridx = 2;
		cons.gridy = 2;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.EAST;
		painelPessoal.add(labSexo, cons);
		
		cons.gridx = 3;
		cons.gridy = 2;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		txtCpf = new JTextField(12);
		cmbEstadoCivil = new JComboBox(new String[]{"Selecione","Masculino", "Feminino"});
		cmbEstadoCivil.setSelectedIndex(0);
		painelPessoal.add(cmbEstadoCivil, cons);
		
		return painelPessoal;
	}
	
	private JPanel initPainelContato(){
		JPanel painelContato = new JPanel(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		cons.insets = new Insets(5, 5, 5, 5);
		
		TitledBorder areaEndereco = BorderFactory.createTitledBorder("Informações de Contato");
		painelContato.setBorder(areaEndereco);
		JLabel labCep = new JLabel("CEP: ");
		JLabel labCidade = new JLabel("Cidade: ");
		JLabel labEndereco = new JLabel("Endereço: ");
		JLabel labEmail = new JLabel("Email: ");
		
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		painelContato.add(labEndereco, cons);
		
		cons.gridx = 1;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 3;
		cons.anchor = GridBagConstraints.WEST;
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.weightx = 1;
		txtEndereco = new JTextField(25);
		painelContato.add(txtEndereco, cons);
		
		cons.gridx = 0;
		cons.gridy = 1;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.EAST;
		painelContato.add(labCep, cons);
		
		cons.gridx = 1;
		cons.gridy = 1;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		txtCep = new JTextField(12);
		painelContato.add(txtCep, cons);
		
		cons.gridx = 2;
		cons.gridy = 1;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.EAST;
		painelContato.add(labCidade, cons);
		
		cons.gridx = 3;
		cons.gridy = 1;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		txtCidade = new JTextField(12);
		painelContato.add(txtCidade, cons);
		
		cons.gridx = 0;
		cons.gridy = 2;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.EAST;
		painelContato.add(labEmail, cons);
		
		cons.gridx = 1;
		cons.gridy = 2;
		cons.gridheight = 1;
		cons.gridwidth = 2;
		cons.anchor = GridBagConstraints.WEST;
		txtEmail = new JTextField(20);
		painelContato.add(txtEmail, cons);
		
		return painelContato;
	}

	public JComboBox getCmbEstadoCivil() {
		return cmbEstadoCivil;
	}

	public void setCmbEstadoCivil(JComboBox cmbEstadoCivil) {
		this.cmbEstadoCivil = cmbEstadoCivil;
	}

	public JTextField getTxtRg() {
		return txtRg;
	}

	public void setTxtRg(JTextField txtRg) {
		this.txtRg = txtRg;
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JTextField getTxtEndereco() {
		return txtEndereco;
	}

	public void setTxtEndereco(JTextField txtEndereco) {
		this.txtEndereco = txtEndereco;
	}

	public JTextField getTxtDtNascimento() {
		return txtDtNascimento;
	}

	public void setTxtDtNascimento(JTextField txtDtNascimento) {
		this.txtDtNascimento = txtDtNascimento;
	}

	public JTextField getTxtCpf() {
		return txtCpf;
	}

	public void setTxtCpf(JTextField txtCpf) {
		this.txtCpf = txtCpf;
	}

	public JTextField getTxtCidade() {
		return txtCidade;
	}

	public void setTxtCidade(JTextField txtCidade) {
		this.txtCidade = txtCidade;
	}

	public JTextField getTxtCep() {
		return txtCep;
	}

	public void setTxtCep(JTextField txtCep) {
		this.txtCep = txtCep;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
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

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public Boolean getIsFuncionario() {
		return isFuncionario;
	}

	public void setIsFuncionario(Boolean isFuncionario) {
		this.isFuncionario = isFuncionario;
	}
	
	public Funcionario popularFuncionario(){
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(this.txtNome.getText());
		funcionario.setRg(this.txtRg.getText());
		funcionario.setCpf(this.txtCpf.getText());
		funcionario.setEndereco(this.txtEndereco.getText());
		funcionario.setCep(Integer.valueOf(this.txtCep.getText().isEmpty() ? "0" : this.txtCep.getText().replace("-", "")));
		funcionario.setCidade(this.txtCidade.getText());
		Login login = new Login();
		login.setEmail(this.txtEmail.getText());
		login.setLogin(this.txtNome.getText());
		login.setSenha(this.txtNome.getText());
		
		try {
			funcionario.setDtNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(this.txtDtNascimento.getText()));
		} catch (ParseException e) {
			funcionario.setDtNascimento(new Date());
			e.printStackTrace();
		}
		
		return funcionario;
	}
	
	
}
