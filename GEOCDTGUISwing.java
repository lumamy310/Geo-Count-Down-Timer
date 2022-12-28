package project1_ver5;

import javax.swing.*;

public class GEOCDTGUISwing {
	public static void main(String arg[]){

		JMenu fileMenu;
		JMenuItem quitItem;
		JMenuBar menus;

		fileMenu = new JMenu("File");
		quitItem = new JMenuItem("Quit");
		fileMenu.add(quitItem);
		menus = new JMenuBar();

		menus.add(fileMenu);

		JFrame gui = new JFrame("GEO Count Down Timer");
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MainPanel main = new MainPanel(quitItem);
		gui.getContentPane().add(main);

		gui.setSize(600,400);
		gui.setJMenuBar(menus);
		gui.pack();
		gui.setVisible(true);
	}



}
