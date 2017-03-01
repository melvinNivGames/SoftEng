package ui;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

@SuppressWarnings("deprecation")
public class LoginUI extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JPanel centerP;
	private JLabel usernameL, passwordL, bgL;
	private JTextField usernameTF;
	private JPasswordField passwordPF;
	private JButton loginB;
	private SystemUI systemUI;
	//private LoginHandler loginHandler;
	//private UserDA userDA;
	private Connection connection;
	
	public LoginUI(SystemUI systemUI)
	{
		setLayout(new GridLayout(1, 1));
		
		//loginHandler = new LoginHandler();
		
		this.systemUI = systemUI;
				
		usernameL = new JLabel("Username:");
		passwordL = new JLabel("Password:");
		
		bgL = new JLabel();
		bgL.setIcon(new ImageIcon(""));
		
		usernameTF = new JTextField(10);
		usernameTF.getCursor();
		passwordPF = new JPasswordField(10);
		
		loginB = new JButton("Login");
		loginB.setForeground(Color.BLUE);
		loginB.setOpaque(false);
		loginB.setContentAreaFilled(false);
		
		centerP = new JPanel();
		centerP.setLayout(null);
		
		centerP.add(usernameL); 
		centerP.add(usernameTF); 
		centerP.add(passwordL); 
		centerP.add(passwordPF); 
		centerP.add(loginB);
		centerP.add(bgL);
		
		bgL.setBounds(0,-80,500,500);
		usernameTF.setBounds(75,240,250,25); 
		passwordPF.setBounds(75,280,250,25); 
		loginB.setBounds(255,310,70,25); 
		usernameL.setBounds(75,220,80,25);
		passwordL.setBounds(75,260,80,25);
		
		//loginB.addActionListener(loginHandler);
		//printScreenB.addActionListener(loginHandler);
		//companyB.addActionListener(loginHandler);
		
		validate();
		
		add(centerP);
	}
}
		/*
		usernameTF.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				int key = e.getKeyCode();
				
				if(key==KeyEvent.VK_ENTER && !getUsernameTF().getText().isEmpty() && !getPasswordPF().getText().isEmpty())
				{
					validateUser();
					usernameTF.setText("");
					passwordPF.setText("");
				}
				
				else if(key==KeyEvent.VK_ENTER && getUsernameTF().getText().isEmpty() && getPasswordPF().getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,	"Valid account is required. Check your username and password.",
							"Login Error", JOptionPane.ERROR_MESSAGE);
					usernameTF.setText("");
					passwordPF.setText("");
				}	
			}
		});
		
		passwordPF.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				int key = e.getKeyCode();
				
				if(key==KeyEvent.VK_ENTER && !getUsernameTF().getText().isEmpty() && !getPasswordPF().getText().isEmpty())
				{
					validateUser();
					usernameTF.setText("");
					passwordPF.setText("");
				}
				
				else if(key==KeyEvent.VK_ENTER && getUsernameTF().getText().isEmpty() && getPasswordPF().getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,	"Valid account is required. Check your username and password.",
							"Login Error", JOptionPane.ERROR_MESSAGE);
					usernameTF.setText("");
					passwordPF.setText("");
				}	
			}
		});
		
		loginB.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				int key = e.getKeyCode();
				
				if(key==KeyEvent.VK_ENTER && !getUsernameTF().getText().isEmpty() && !getPasswordPF().getText().isEmpty())
				{
					validateUser();
					usernameTF.setText("");
					passwordPF.setText("");
				}
				
				else if(key==KeyEvent.VK_ENTER && getUsernameTF().getText().isEmpty() && getPasswordPF().getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,	"Valid account is required. Check your username and password.",
							"Login Error", JOptionPane.ERROR_MESSAGE);
					usernameTF.setText("");
					passwordPF.setText("");
				}	
			}
		});
	}
	
	private class LoginHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{			
			String action = e.getActionCommand();
			
			if(action.equals("Login") && !getUsernameTF().getText().isEmpty() && !getPasswordPF().getText().isEmpty())
			{
				validateUser();
				usernameTF.setText("");
				passwordPF.setText("");
			}
			else
			{
				JOptionPane.showMessageDialog(null,	"Valid account is required. Check your username and password.",
						"Login Error", JOptionPane.ERROR_MESSAGE);
				usernameTF.setText("");
				passwordPF.setText("");
			}	
		}
	}
	
	public void validateUser()
	{
		User user = new User();
		user.setUsername(usernameTF.getText());
		user.setPassword(passwordPF.getText());
		
		UserDA tempUserDA = new UserDA(getConnection());
		
		if(user.getUsername().equals(tempUserDA.getUser(user).getUsername()) &&
				user.getPassword().equals(tempUserDA.getUser(user).getPassword()) &&
				!tempUserDA.getUser(user).getStamp().contains("DELETED"))
		{
			User loginUser = new User();
			loginUser = tempUserDA.getUser(user);
			userDA = new UserDA(getConnection(), loginUser);

			systemUI.showMainMenu(loginUser, userDA);
		}
		else
		{
			JOptionPane.showMessageDialog(null,	"Valid account is required. Check your username and password.",
					"Login Error", JOptionPane.ERROR_MESSAGE);
			usernameTF.setText("");
			passwordPF.setText("");
		}	
	}
	
	public Connection getConnection()
	{
		try
		{
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			connection = DriverManager.getConnection("jdbc:db2://localhost:50000/sysdfinc",
					"melvin", "UY09104139863");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} 
		
		return connection;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public JTextField getUsernameTF() {
		return usernameTF;
	}

	public void setUsernameTF(JTextField usernameTF) {
		this.usernameTF = usernameTF;
	}

	public JPasswordField getPasswordPF() {
		return passwordPF;
	}

	public void setPasswordPF(JPasswordField passwordPF) {
		this.passwordPF = passwordPF;
	}
}
*/