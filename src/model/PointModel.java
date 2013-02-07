package model;

import util.Observable;

public class PointModel extends Observable<PointModel> {
	
	private int x;
	private int y;
	
	public PointModel(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public PointModel(Vector p) {
		this ((int)p.getX(),(int)p.getY());
	}

	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
		notifyObservers(this);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PointModel [x=" + x + ", y=" + y + "]";
	}

	public void changeLocation(int x, int y){
		setLocation(this.x+x,this.y+y);
	}
	
	public void changeLocation(Vector vector){
		changeLocation((int)vector.getX(),(int)vector.getY());
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
}
