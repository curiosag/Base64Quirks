package codec;

public class Check {

	public static void isTrue(boolean b) {
		if (!b)
			throw new IllegalArgumentException("smthgs wrong");
	}
}
