package model;

import util.Null;
import util.Observable;
import util.Observer;

public abstract class Model {

	private Observable<Null> clickedObservable = new Observable<Null>();
	private Observable<Null> drawObservable = new Observable<Null>();
	protected PointModel cursorPoint = new PointModel(0, 0);
	
	public void addClickedObserver(Observer<Null> observer) {
		clickedObservable.addObserver(observer);
	}

	public void addDrawObserver(Observer<Null> observer) {
		drawObservable.addObserver(observer);
	}

	public void run() {
		while (true){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			moveObjects();
			drawObservable.notifyObservers(Null.NULL);
		}
	}

	public void click() {
		clickedObservable.notifyObservers(Null.NULL);
	}

	public PointModel getCursorPoint() {
		return cursorPoint;
	}
	
	public abstract void moveObjects();
	
	public abstract Iterable<Drawable> getDrawables();

}
