package ui.account_ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import ui.search_ui.*;

public class AccountUI {

	private JFrame frame;
	private JPasswordField password;
	private JTextField textName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountUI window = new AccountUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AccountUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 594, 435);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Login");
		password = new JPasswordField();
		password.setBounds(149, 147, 374, 30);
		frame.getContentPane().add(password);
		
		textName = new JTextField();
		textName.setBounds(149, 76, 374, 30);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(77, 76, 62, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSenha.setBounds(77, 147, 56, 30);
		frame.getContentPane().add(lblSenha);
		
		JButton btnCreateAccount = new JButton("Cadastrar-se");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(AccountOperations.checkAccount(textName.getText())) {
					JOptionPane.showMessageDialog(frame, "Conta já existente");
				} else { 
					AccountOperations.createAccount(textName.getText(), password.getPassword());
					JOptionPane.showMessageDialog(frame, "Conta criada");
				}
				
				
				
			}
		});
		btnCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCreateAccount.setBounds(77, 239, 160, 59);
		frame.getContentPane().add(btnCreateAccount);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] loginParameters = {textName.getText(), password.getPassword().toString()};
				if(AccountOperations.login(loginParameters[0], loginParameters[1])) {
					frame.dispose();
					if(AccountOperations.isAdmin(loginParameters[0], loginParameters[1])) {
						ReportUI.main(loginParameters);
					} else {
						PlayerManagementUI.main(loginParameters);
					}			
					
				} else { 
					JOptionPane.showMessageDialog(frame, "Usuário ou senha incorretos");;
				}
				
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setBounds(363, 239, 160, 59);
		frame.getContentPane().add(btnLogin);
	}
}
