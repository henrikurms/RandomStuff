package view;

import model.PointModel;
import util.Observer;

public class PointObserver implements Observer<PointModel> {

	private MainPanel mainPanel;

	public PointObserver(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	@Override
	public void update(PointModel t) {
		mainPanel.repaint();
	}

}
