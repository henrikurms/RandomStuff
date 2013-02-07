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
	
	public class ClickedObserver implements Observer<Null> {
		@Override
		public void update(Null t) {
			boolean isClicked = isClicked();
			clicked = true;
			if (isClicked){
				return;
			}
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					model.run();
				}
			}).start();
		}
	}

	private static final long serialVersionUID = 1L;
	
	private Model model = new FloydModel();

	private boolean clicked = false;
	public Observer<Null> clickedObserver = new ClickedObserver();

	public MainPanel(){
		setPreferredSize(new Dimension(900,500));
//		model.addPointObserver(new PointObserver(this));
		model.addClickedObserver(clickedObserver);
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

	public boolean isClicked() {
		return clicked;
	}

	private void drawCircle(int x, int y, Graphics g) {
		g.fillOval(x-10, y-10, 20, 20);
	}

	/* (non-Javadoc)
	 * @see java.awt.Component#repaint()
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (!clicked ) return;
//		model.getFloyd().draw(g);
		for (Drawable drawable : model.getDrawables()) {
			drawable.draw(g);
		}
	}

	public Model getModel() {
		return model;
	}
	
}
