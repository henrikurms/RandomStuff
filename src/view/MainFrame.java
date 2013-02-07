package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;

	private MainFrame(){
		super("Mechanics");
		setContentPane(makePanel());
		this.pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private JPanel makePanel() {
		return new MainPanel();
	}
	
	public static void main(String[] _){
		final MainFrame mainFrame = new MainFrame();
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				mainFrame.setVisible(true);
			}
		});
	}
}
