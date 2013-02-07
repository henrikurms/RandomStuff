package model;

import java.util.ArrayList;
import java.util.Iterator;

import util.Iteration;


public class FloydModel extends Model {
	
	private Floyd floyd = new Floyd(point);
	private ArrayList<Floyd> floyds = new ArrayList<Floyd>();

	public FloydModel(){
		floyds.add(new Floyd(new PointModel(50,50)));
		floyds.add(new Floyd(new PointModel(70,30)));
		floyds.add(new Floyd(new PointModel(70,70)));
		floyds.add(new Floyd(new PointModel(30,70)));
		for (int i = 0; i < 10; i++){
			floyds.add(new Floyd(new PointModel(20, 20)));
		}
		floyd.setColor(java.awt.Color.blue);
		floyds.add(floyd);
	}

	public void moveObjects() {
		int number = floyds.size();
		Vector velocity = new Vector(0,0);
		Vector position = new Vector(0,0);
		for (Floyd floyd : floyds){
			velocity = velocity.add(floyd.velocity);
			position = position.add(new Vector(new PointModel(0, 0),floyd.position));
		}
		velocity = velocity.multiply(1/number);
		position = position.multiply(1/number);
		for (Floyd floyd : floyds){
			floyd.flock(floyds,cursorPoint);
		}
	}

	public Iterable<Drawable> getDrawables() {
		return new Iteration<Drawable>(floyds);
	}

}
