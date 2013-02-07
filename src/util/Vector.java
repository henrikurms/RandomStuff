package util;

import java.util.Iterator;

public class Vector {
	
	private final double[] data;
	
	public Vector(int size){
		data = new double[size];
	}
	
	public Vector(double... data){
		this.data = data;
	}
	
	public int dotProduct(Vector vector){
		int sum = 0;
		for (int i = 0; i < data.length; i++){
			sum += data[i]*vector.data[i];
		}
		return sum;
	}
	
	public Matrix toMatrix(){
		Matrix matrix = new Matrix(data.length,1);
		for (int i = 0; i < data.length; i++){
			matrix.set(i, 0, data[i]);
		}
		return matrix;
	}

	public double get(int i) {
		return data[i];
	}

	public static int[] translatePoints(double x, double... xs1) {
		Vector vector = new Vector(xs1);
		vector.add(x);
		return Casts.toInt(vector.data);
	}

	private void add(double x) {
		for (int i = 0; i < data.length; i++){
			data[i] += x;
		}
	}
}
