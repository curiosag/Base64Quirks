package codec;

public class AyudaSystems implements Codec {

	private final Codec base64 = new Base64();
	private final int baseAlphabetSize = 256;
	private final int[] offsets;
	private Feedback feedback = null;

	interface ShiftOp {
		int shift(int arrayLength, int index, int shiftBy);
	}

	private String normalize(String c) {
		return c.replace("\n", "").replace("\r", "");
	}

	private void echo(String message) {
		if (feedback != null)
			feedback.echo(message);
	}

	/**
	 * This constructor covers any shifting manipulations of the source text
	 * as used at least until the last github push of this very file. 
	 * It is brute forcing the number to shift for each position of the clear text
	 * 
	 * @param clear
	 *            a sample of clear text (just anything, e.g. "???...", ), at
	 *            least as long as the real message to decode
	 * @param code
	 *            the encoding of the value for clear.
	 */
	public AyudaSystems(String clear, String code, Feedback f) {
		Check.isTrue(clear != null);
		Check.isTrue(code != null);
		this.feedback = f;

		offsets = new int[clear.length()];
		bruteForceOffsets(clear, normalize(code));
	}

	/**
	 * valid constructor as of 12-09-2015
	 * 
	 * @param shiftBy
	 *            every character will be shifted to the right by a base number plus...
	 *            
	 * @param indexMultiplier
	 *            ...plus the index of each clear text character. The value of
	 *            indexMultiplier as of 12-09-2015 is 1
	 * @param messageSize
	 *            expected size of message
	 */
	public AyudaSystems(int shiftBy, int indexMultiplier, int messageSize) {
		Check.isTrue(shiftBy >= 0);
		Check.isTrue(messageSize > 0);

		offsets = new int[messageSize];

		for (int i = 0; i < offsets.length; i++)
			offsets[i] = shiftBy + i * indexMultiplier;
	}

	/**
	 * 
	 * @param offsets
	 *            supply a custom set of offsets, e.g. the decimal places of pi
	 *            or some strange number. make sure that it is large enough to
	 *            cover the length of the messages to process
	 */
	public AyudaSystems(int[] offsets) {
		Check.isTrue(offsets != null);
		this.offsets = offsets.clone();
	}

	private void bruteForceOffsets(String clear, String code) {
		for (int i = 0; i < clear.length(); i++)
			bruteForceOffset(i, clear.substring(0, i + 1), normalize(code));
	}

	/**
	 * really brute
	 */
	private void bruteForceOffset(int currentOffsetIndex, String substring,
			String code) {
		for (int i = 0; i < baseAlphabetSize; i++) {
			offsets[currentOffsetIndex] = i;
			if (decode(code).startsWith(substring)) {
				echo(String.format("offset for character at index %d is %d",
						substring.length() - 1, i));
				return;
			}
		}
		echo("Failed to find offset index for last character in " + substring);
		assert (false);
	}

	private String shiftCharacters(String s, ShiftOp op, int alphabetLength) {
		Check.isTrue(op != null);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			int currIndex = (int) s.charAt(i);
			Check.isTrue(currIndex < 256);

			sb.append((char) op.shift(alphabetLength, currIndex, offsets[i]));
		}
		return sb.toString();
	}

	public String shiftCharactersRight(String s) {
		Check.isTrue(s != null);
		return shiftCharacters(s, new ShiftOp() {

			@Override
			public int shift(int arrayLength, int index, int shiftBy) {
				return Calc.shiftRight(arrayLength, index, shiftBy);
			}
		}, baseAlphabetSize);
	}

	public String shiftCharactersLeft(String s) {
		Check.isTrue(s != null);
		return shiftCharacters(s, new ShiftOp() {

			@Override
			public int shift(int arrayLength, int index, int shiftBy) {
				return Calc.shiftLeft(arrayLength, index, shiftBy);
			}
		}, baseAlphabetSize);
	}

	@Override
	public String encode(String s) {
		Check.isTrue(s != null);
		Check.isTrue(offsets.length >= s.replace("=", "").length());
		return base64.encode(shiftCharactersRight(s));
	}

	@Override
	public String decode(String s) {
		Check.isTrue(s != null);
		Check.isTrue(offsets.length >= normalize(s).replace("=", "").length() / 4 * 3);

		return shiftCharactersLeft(base64.decode(s));
	}
}
