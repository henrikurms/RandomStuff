package util;

public class Casts {

	public static double[] toDouble(int[] xs1) {
		double[] array = new double[xs1.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = xs1[i];
		}
		return array;
	}

	public static int[] toInt(double[] data) {
		int[] array = new int[data.length];
		for (int i = 0; i < data.length; i++){
			array[i] = (int)data[i];
		}
		return array;
	}

}
