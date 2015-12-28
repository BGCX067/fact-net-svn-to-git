package uninove.factnet.ui.utils;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import uninove.factnet.datatypes.login.Login;
import uninove.factnet.datatypes.rh.Cliente;

public class BuscaUtilsUI {
	
	
	public static Cliente buscaCliente(Cliente cliente){
		System.out.println("Buscando Clientes");
		cliente.setNome("Fulano de tal");
		cliente.setIdPessoa(new Long(2));
		return cliente;
	}
	
	public static Cliente buscaClienteModal(JFrame janela){
		final JDialog dialog = new JDialog(janela, true);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setLayout(new GridBagLayout());
		
		JLabel labTitulo = new JLabel("Busca Cliente ");
		JLabel labCliente = new JLabel("Cliente: ");
		JLabel labSenha = new JLabel("Senha: ");
		JTextField txtCliente = new JTextField(16);
		JPasswordField txtSenha = new JPasswordField(16);
		JButton btnBuscar = new JButton("Buscar");
		JButton btnCancelar = new JButton("Cancelar");
		
		GridBagConstraints cons = new GridBagConstraints();
		cons.insets = new Insets(5, 5, 5, 5);
		
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridheight = 1;
		cons.gridwidth = 2;
		labTitulo.setFont(new Font(janela.getFont().getName(), Font.BOLD, 14));
		dialog.add(labTitulo, cons);
		
		cons.gridx = 0;
		cons.gridy = 1;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		dialog.add(labCliente, cons);
		
		cons.gridx = 0;
		cons.gridy = 2;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		dialog.add(labSenha, cons);
		
		cons.gridx = 1;
		cons.gridy = 1;
		cons.gridheight = 1;
		cons.gridwidth = 2;
		dialog.add(txtCliente, cons);
		
		cons.gridx = 1;
		cons.gridy = 2;
		cons.gridheight = 1;
		cons.gridwidth = 2;
		dialog.add(txtSenha, cons);
		
		cons.gridx = 1;
		cons.gridy = 3;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.EAST;
		dialog.add(btnBuscar, cons);
		
		cons.gridx = 2;
		cons.gridy = 3;
		cons.gridheight = 1;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.WEST;
		dialog.add(btnCancelar, cons);
		
		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(false);
				dialog.dispose();
			}
		});
		final int isCancelar[] ={0}; 
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isCancelar[0] = 1;
				dialog.dispose();
			}
		});
		
		dialog.pack();
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
		
		Cliente cliente = null;
		if(isCancelar[0] == 0){
			Login login = new Login();
			login.setLogin(txtCliente.getText());
			login.setSenha(new String(txtSenha.getPassword()));
			cliente = new Cliente(login);
			cliente = BuscaUtilsUI.buscaCliente(cliente);
		}
		return cliente;
	}

}
