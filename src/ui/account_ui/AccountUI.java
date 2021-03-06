package ui.account_ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import business.account_operations.AccountOperations;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.report_ui.ReportUI;
import ui.search_ui.*;
import ui.player_management.*;

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

	private void createAccount() {
		String pass = new String(password.getPassword());
		if(AccountOperations.checkExistsAccountByUserName(textName.getText())) {
			JOptionPane.showMessageDialog(frame, "Conta já existente");
		} else {
			if (pass.length() == 0) {
				JOptionPane.showMessageDialog(frame, "Por favor insira um nome");
			} else if (AccountOperations.checkPassword(pass)) {
				AccountOperations.register(textName.getText(), pass);
				JOptionPane.showMessageDialog(frame, "Conta criada");
			} else {
				JOptionPane.showMessageDialog(frame, "Senha muito fácil");
			}
		}
	}

	private void login() {
		String pass = new String(password.getPassword());
		String[] loginParameters = {textName.getText(), pass};
		if(AccountOperations.checkExistsAccountByUserNameAndPassword(loginParameters[0], pass)) {
			frame.dispose();
			if(AccountOperations.checkIsAdmin(loginParameters[0])) {
				ReportUI.main(loginParameters);
			} else {
				PlayerManagementUI.main(loginParameters);

			}

		} else {
			JOptionPane.showMessageDialog(frame, "Usuário ou senha incorretos");
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
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
		
		JLabel lblName = new JLabel("Nome");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(77, 76, 62, 30);
		frame.getContentPane().add(lblName);
		
		JLabel lblPassword = new JLabel("Senha");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(77, 147, 56, 30);
		frame.getContentPane().add(lblPassword);
		
		JButton btnCreateAccount = new JButton("Cadastrar-se");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createAccount();
			}
		});
		btnCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCreateAccount.setBounds(77, 239, 160, 59);
		frame.getContentPane().add(btnCreateAccount);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setBounds(363, 239, 160, 59);
		frame.getContentPane().add(btnLogin);
	}
}
