package control;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

import model.FloydModel;
import model.Model;

import view.MainPanel;

public class MouseListener implements MouseInputListener {

	private Model model;
	
	public MouseListener(Model model) {
		this.model = model;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
				
		model.click();
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseDragged(MouseEvent e) {}
	@Override
	public void mouseMoved(MouseEvent e) {
		model.getCursorPoint().setLocation(e.getX(), e.getY());
		//model.getFloyd().moveTowards(e.getX(),e.getY());
	}
}
