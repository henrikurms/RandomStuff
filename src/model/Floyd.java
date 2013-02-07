package model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import util.Casts;
import util.Matrix;

public class Floyd implements Drawable {
	
	private static final int SEPARATION_DISTANCE = 20;
	public PointModel position;
	private int speed = 8;
	public Vector velocity = new Vector(0,0);
	private int acceleration = 1;
	private int maxSpeed = 10;
	private Color color = null;

	public Floyd(int x, int y) {
		position = new PointModel(x, y);
	}
	
	public Floyd(PointModel position){
		this.position = position;
	}

	public void moveTowards(int x, int y) {
		Vector vector = new Vector(position, new PointModel(x, y));
		moveInDirection(vector);
	}
	
	public void accelerateTowards(int x, int y){
		Vector direction = new Vector(position,new PointModel(x,y));
		Vector accVector = getAcceleration(direction);
		velocity = velocity.add(accVector);
		move();
	}
	
	private void move() {
		velocity = velocity.checkLength(maxSpeed);
		position.changeLocation(velocity);
	}

	private Vector getAcceleration(Vector direction) {
		Vector accVector = direction.withLength(acceleration);
		return accVector;
	}

	public void moveInDirection(Vector vector) {
		velocity = vector.withLength(speed);
		move();
	}

	public void draw(Graphics g) {
		int x = position.getX();
		int y = position.getY();
		int[] xs = {0,5,0,-5};
		int[] ys = {-15,5,0,5};
		Matrix.rotationMatrix(Math.PI/2).transformPoints(xs,ys);
		double angle = velocity.angle();
		Matrix.rotationMatrix(angle).transformPoints(xs,ys);
		xs = util.Vector.translatePoints(x,Casts.toDouble(xs));
		ys = util.Vector.translatePoints(y,Casts.toDouble(ys));
		g.drawPolygon(xs,ys, 4);
		if (color  == null) return;
		g.setColor(color);
		g.fillPolygon(xs, ys, 4);
	}

	public void flock(ArrayList<Floyd> floyds, PointModel cursorPoint) {
		Vector seperation = new Vector();
		Vector v = new Vector();
		Vector p = new Vector();
		for (Floyd floyd : floyds){
			if (floyd == this) {
//				p = p.add(new Vector(floyd.position));
				continue;
			}
			Vector distance = new Vector(position,floyd.position).negate();
			if (distance.negate().getLength() < SEPARATION_DISTANCE) {
				seperation = seperation.add(distance);
//				p = p.add(new Vector(floyd.position));
				v = v.add(floyd.velocity);
			}
		}
		v = v.multiply(1/floyds.size());
//		if (p.getLength() > 0 ) System.out.println(p);
		p = p.multiply(1/floyds.size());
//		if (p.getLength() > 0 ) System.out.println(p);
		Vector center = p.add(new Vector(position).negate());
		velocity = velocity.add(center.multiply(999/1000)); // Doesn't work otherwise
		velocity = velocity.add(v);
		velocity = velocity.add(seperation);
		velocity = velocity.add(getAcceleration(new Vector(position, cursorPoint)));
		move();
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
}
