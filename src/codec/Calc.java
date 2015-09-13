package codec;

public final class Calc {
	
	public static int shiftLeft(int alphabetLength, int index, int shiftBy) {
		shiftBy = shiftBy % alphabetLength;
		
		if (shiftBy <= index)
			return index - shiftBy;
		else
			return alphabetLength - (shiftBy - index);
		
	}
		
	public static int shiftRight(int alphabetLength, int index, int shiftBy) {
		return (index + shiftBy) % alphabetLength;
	}
	
	public static int shiftForCodeBlock(int index, int codeBlockIndex)
	{
		int offsetMultiplierPerCodeblock = 3;
		
		return shiftLeft(256,
				index, codeBlockIndex
						* offsetMultiplierPerCodeblock);
	}
	
}
