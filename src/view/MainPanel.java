package view;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Drawable;
import model.Floyd;
import model.FloydModel;
import model.Model;
import model.PointModel;
import model.Vector;
import util.Casts;
import util.Matrix;
import util.Null;
import util.Observer;
import control.MouseListener;


public class MainPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private static final Dimension SIZE = new Dimension(900,500);
	
	private Model model = new FloydModel();
	private boolean clicked = false;

	public MainPanel(){
		setPreferredSize(SIZE);
		model.addClickedObserver(new ClickedObserver());
		model.addDrawObserver(new DrawObserver());
		MouseListener ml = new MouseListener(model);
		this.addMouseListener(ml);
		this.addMouseMotionListener(ml);
	}
	
	private class DrawObserver implements Observer<Null> {

		@Override
		public void update(Null t) {
			repaint();
		}
		
	}
	
	public class ClickedObserver implements Observer<Null> {
		@Override
		public void update(Null t) {
			if (clicked) return;
			clicked = true;
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					model.run();
				}
			}).start();
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.Component#repaint()
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (!clicked) return;
		for (Drawable drawable : model.getDrawables()) {
			drawable.draw(g);
		}
	}

	public Model getModel() {
		return model;
	}
	
}
