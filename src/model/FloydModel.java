package model;

import java.util.ArrayList;
import java.util.Iterator;

import util.Iteration;


public class FloydModel extends Model {
	
	private static final int NUMBER_OF_OBJECTS = 50;
	private ArrayList<Floyd> floyds = new ArrayList<Floyd>();

	public FloydModel(){
		for (int i = 0; i < NUMBER_OF_OBJECTS; i++){
			floyds.add(new Floyd(new PointModel(20, 20)));
		}
		Floyd floyd = new Floyd(new PointModel(30,30));
		floyd.setColor(java.awt.Color.blue);
		floyds.add(floyd);
	}

	public void moveObjects() {
		for (Floyd floyd : floyds){
			floyd.flock(floyds,cursorPoint);
		}
	}

	public Iterable<Drawable> getDrawables() {
		return new Iteration<Drawable>(floyds);
	}

}
