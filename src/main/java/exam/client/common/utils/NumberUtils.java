package exam.client.common.utils;

public class NumberUtils {

	private static final float EPSILON = 0.00000000000000000000000000000001f;

	private NumberUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static boolean isEqual(double number, double expected) {
		return Math.abs(number - expected) <= EPSILON;
	}

	public static boolean isEqual(float number, float expected) {
		return Math.abs(number - expected) <= EPSILON;
	}

	public static boolean isEqual(long number, long expected) {
		return Math.abs(number - expected) <= EPSILON;
	}

}
