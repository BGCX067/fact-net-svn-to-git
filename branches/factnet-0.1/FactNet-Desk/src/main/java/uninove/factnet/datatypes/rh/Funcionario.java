package uninove.factnet.datatypes.rh;

import java.util.Date;
import java.util.List;

import uninove.factnet.datatypes.enums.EEstadoCivil;
import uninove.factnet.datatypes.login.Login;

public class Funcionario extends Pessoa {
	
	private Cargo cargo;
	private Integer cep;
	private String cidade;
	private List<Comissao> comissoes;
	private String cpf;
	private Departamento departamento;
	private Date dtNascimento;
	private Date dtAdmissao;
	private Date dtDemissao;
	private String endereco;
	private EEstadoCivil estadoCivil;
	private FolhaPagamento folhaPagamento;
	private String rg;
	private Double salario;
	
	public Funcionario(Login login){
		super(login);
	}
	
	public Funcionario(Long idPessoa){
		super(idPessoa);
	}
	
	public Funcionario() {
		super();
	}
	
	public Integer getCep() {
		return cep;
	}
	public void setCep(Integer cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public Date getDtAdmissao() {
		return dtAdmissao;
	}
	public void setDtAdmissao(Date dtAdmissao) {
		this.dtAdmissao = dtAdmissao;
	}
	public Date getDtDemissao() {
		return dtDemissao;
	}
	public void setDtDemissao(Date dtDemissao) {
		this.dtDemissao = dtDemissao;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public EEstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EEstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public void setComissoes(List<Comissao> comissoes) {
		this.comissoes = comissoes;
	}

	public List<Comissao> getComissoes() {
		return comissoes;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setFolhaPagamento(FolhaPagamento folhaPagamento) {
		this.folhaPagamento = folhaPagamento;
	}

	public FolhaPagamento getFolhaPagamento() {
		return folhaPagamento;
	}
	
	
	
	
}
