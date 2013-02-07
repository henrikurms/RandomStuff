package util;

public class Matrix {
	
	private final int columns;
	private final int rows;
	
	private double[][] data;
	
	public Matrix(int rows, int columns) {
		this.columns = columns;
		this.rows = rows;
		data = new double[rows][columns];
	}
	
	public void set(int row, int column, double value){
		data[row][column] = value;
	}
	
	public double[] row(int index){
		return data[index];
	}
	
	public double[] column(int index){
		double[] column = new double[rows];
		for (int i = 0; i < rows; i++){
			column[i] = data[i][index];
		}
		return column;
	}
	
	public Matrix multiply(Matrix matrix){
 		Matrix newMatrix = new Matrix(matrix.columns, rows);
		for (int i = 0; i < newMatrix.columns; i++){
			for (int j = 0; j < newMatrix.rows; j++){
				int value = new Vector(matrix.column(j)).dotProduct(new Vector(row(i)));
				newMatrix.set(j, i,value);
			}
		}
		return newMatrix;
	}
	
	public Vector apply (Vector vector) {
		Matrix matrix = multiply(vector.toMatrix());
		return new Vector(matrix.data[0]);
	}
	
	public static Matrix rotationMatrix(double angle){
		Matrix matrix = new Matrix(2,2);
		matrix.set(0,0,Math.cos(angle));
		matrix.set(0, 1,-Math.sin(angle));
		matrix.set(1, 0,Math.sin(angle));
		matrix.set(1, 1, Math.cos(angle));
		return matrix;
	}

	public void transformPoints(int[] xs1, int[] ys1) {
		for (int i = 0; i < xs1.length; i++){
			double[] point = {xs1[i],ys1[i]};
			Vector vector = new Vector(point);
			Vector transformed = apply(vector);
			xs1[i] = (int)transformed.get(0);
			ys1[i] = (int)transformed.get(1);
		}
	}
}
