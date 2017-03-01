package ui;

import java.awt.CardLayout;
import java.awt.Container;
import javax.swing.*;

public class SystemUI extends JFrame
{
	private static final long serialVersionUID = 1L;
	private Container container;
	private CardLayout card;
	private SeatingArrangementUI seatingArrangementUI;
	private LoginUI loginUI;
	private ImageIcon img;
	
	public SystemUI()
	{	
		img = new ImageIcon("");
		setIconImage(img.getImage());
		
		container = getContentPane();
		
		card = new CardLayout();
		container.setLayout(card);
		
		seatingArrangementUI = new SeatingArrangementUI(this);
		container.add(seatingArrangementUI, "Seat");
		loginUI = new LoginUI(this);
		container.add(loginUI, "Login");
		
		setTitle("Movie Seating System");	
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void showSeat()
	{
		setSize(500, 500);
		setLocationRelativeTo(null);
		card.show(container, "Seat");
		pack();
		repaint();
	}
	
	public void showLogin()
	{
		setSize(400, 399);
		setLocationRelativeTo(null);
		card.show(container, "Login");
		repaint();
	}
	
		
	public static void main(String [] args)
	{
		new SystemUI().showLogin();
	}
}