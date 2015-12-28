package uninove.factnet;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import uninove.factnet.datatypes.rh.Funcionario;

public class Inicializador {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Funcionario funcionario = null;
		Janela controlador = new Janela();
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch (Exception e) {
			System.out.println("Erro ao alterar aparencia, utilizando aparencia do java.");
		}
		do{
			funcionario = controlador.iniciarLogin(); // Futuramente deverá retornar dados do login
			if(funcionario == null){
				JOptionPane.showMessageDialog(null, "Login ou senha inválidos.");
			}
		}while(funcionario == null);
		
		//Caso as permissoes sejam nulas significa que o usuario queria recuperar senhas.
		if(funcionario.getPermissoes() != null){
			controlador.iniciarSistema(funcionario);
		}
	}
}
