import codec.AyudaSystems;
import codec.Feedback;

public class Main {

	private static final int estimatedMaxMessageLength = 521;
	private static final int indexMultiplier = 1;

	private static void decode(AyudaSystems e, String[] messages) {
		for (int i = 0; i < messages.length; i++)
			System.out
					.println(String.format("%d %s", i, e.decode(messages[i])));
	}

	public static void main(String[] args) {

		String[] msg77 = {
				"oba0cL63xse2vbx4ws2VfH+hx9XEzYOy1NjZ0dyKzs3bjuTe2uaT6Nrp65je6O/l7+Of4fHy7+3o5/vx+Pj+rAT3A/ix87MH/gT+BP66/A8QAxEUz8TD9wYaHBoNCyTMFiHPEdEZIiMZ1hsZMtovK90xLiw3J+M0OkBBNC49+Q==",
				"lMC0scVyvcO3d3eswb97ycLR0sHIx4PN2KCHir3S0Izc4NjX2uDU4JXp593c4+Hl4N/z6fDwo+f09Pvp8vjw8K3x/v73/vz3Cf8F/7kMAA0SBxEFDgcRGBjUycgADw8aEiETESrSHCfVF9cfKCkf3CEfOOA1MeM3NDI9Lek6QEZHOjRD/w==" };

		// shifting increased by one about every week

		decode(new AyudaSystems(77, indexMultiplier, estimatedMaxMessageLength),
				msg77);

		String[] msg78 = {
				"oLC+tcHAdMK7ysu6wcB81MfLzIHI0tDR1d6iiYysjL/d3NHfkurV4eHqmOLo7+ud35/i4vSvpO318+z8qgD8rQIG/7H4/AL8+wkLxbr8CgG+EgEaFc/Ex+wQHg7KDRESICLc0SIfGRYpHNrn3NsTIiItJTQmJD3lLzroKuoyOzwy7zQyS/NIRPZKR0VQQPxNU1laTUdWEg==",
				"p77Fcbq0yrp2u728yb/BwX7TyMaC0MnY2cjPzqSLjrnP49Xk5pPn6ujt3fKa7uTs9fKg9erk+KW5p/f+/qv7867DsAH3AgQB+7cF+gUAvBIOv9fWx8MTC8YbEA7KIhsfGhPXJNIjIyUrIxktIyoq6+DfFCk3NTcpJ0DoMj3rLe01Pj818jc1TvZLR/lNSkhTQ/9QVlxdUEpZFQ==",
				"lcG1ssZzvsS4eHitwsB8ysPS08LJyITO2aGIi63T4dDZj77g5OXd6Jba2eea7uvp9OSg9eropNn1/u37/av7867X8f8B/LT+BLcHB/+7CQwUBM7DwukWDgoIIckTHswOzhYfIBbTGBYv1ywo2i4rKTQk4DE3PT4xKzr29w==",
				"lcG1ssZzvsS4eHitwsB8ysPS08LJyITO2aGIi7PRjLaO5tHf5tjYldeX79rs6Jzj8/n6+qLp6ery8PbwtqvVtPKv8f8G/PUB//gLuQcUvAQQABAJCwYXxsjH+woeIB4RDyjQGiXTFdUdJicd2h8dNt4zL+E1MjA7K+c4PkRFODJB/Q==",
				"lcG1ssZzvsS4eHitwsB8ysPS08LJyITO2aGIi77T0d/Tj9Hj15Pj4+LwmO3x6pzl3/Hkofbr7fPt+qjy+KvP/Pv/BQX3BbTo+QD9B/0A1r0BAAMJB8MNExwIFBIODCAWHR3c0SAUIR4kHtgtIiQqJDHr4CIwJ+Q0LC31K0P4Ozsz7zVDREJGSAT5+CxPSUA+V/9JVAJEBExVVkwJTkxlDWJeEGRhX2paFmdtc3RnYXAsLQ==" };

		decode(new AyudaSystems(78, indexMultiplier, estimatedMaxMessageLength),
				msg78);

		String calibrationString = "aaaaaaaaaaaaaaaaaaeeeeeeeeeaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String calibrationStringEncoded = "r7CxsrO0tba3uLm6u7y9vr/AxcbHyMnKy8zNysvMzc7P0NHS09TV1tfY2drb3N3e3+Dh4uPk5ebn6Onq6+zt7u/w8fLz9PX29/j5+vv8/f7/AAECAwQFBgcICQoLDA0ODxAREhMUFRYXGBkaGxwdHh8gISIjJCUmJygpKissLS4vMDEyMzQ1Njc4OTo7PD0+P0BBQkNERUZHSElKS0xNTk9QUVJTVFVWV1hZWltcXV5fYGFiY2RlZmdoaWprbG1ub3BxcnN0dXZ3eHl6e3x9fn+AgYKDhIWGh4iJiouMjY6PkJGSk5SVlpeYmZqbnJ2en6ChoqOkpaanqKmqq6ytrq+wsbKztLW2t7i5uru8vb6/wMHCw8TFxsfIycrLzM3Oz9DR0tPU1dbX2A==";

		Feedback f = new Feedback() {

			@Override
			public void echo(String message) {
				System.out.println(message);
			}
		};
		System.out.println("brute forced: "
				+ new AyudaSystems(calibrationString, calibrationStringEncoded,
						f).decode(msg78[1]));
	}
}
