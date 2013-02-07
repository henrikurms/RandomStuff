package model;

public class Vector {
	
	private double x;
	private double y;
	
	public Vector(PointModel p1, PointModel p2){
		x = p2.getX() - p1.getX();
		y = p2.getY() - p1.getY();
	}
	
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vector() {
		this(0,0);
	}

	public Vector(PointModel position) {
		this(position.getX(),position.getY());
	}

	public double getX(){
		return x;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vector [x=" + x + ", y=" + y + "]";
	}

	public double getY(){
		return y;
	}

	public Vector withLength(double d) {
		if (this.getLength() == 0){
			return new Vector(0,0);
		}
		return this.multiply(d/this.getLength());
	}
	
	public Vector multiply(double d) {
		return new Vector(x*d, y*d);
	}

	public double getLength(){
		return Math.sqrt(x*x + y*y);
	}

	public Vector add(Vector vector) {
		return new Vector(vector.x+x,vector.y+y);
	}

	public Vector negate() {
		return new Vector(-x,-y);
	}

	public Vector checkLength(int length) {
		if (this.getLength() < length){
			return this;
		}
		else {
			return this.withLength(length);
		}
	}
	
	public Vector project(Vector vector){
		return vector; 
	}
	
	public double angle() {
		return Math.atan2(y,x);
	}
}
