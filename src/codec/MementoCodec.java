package codec;

public class MementoCodec implements Codec {

	final Codec inner;
	
	String lastEncodeIn = "";
	String lastEncodeOut = "";
	String lastDecodeIn = "";
	String lastDecodeOut = "";
	
	public MementoCodec(Codec inner)
	{
		Check.isTrue(inner != null);
		this.inner = inner;
	}
	
	@Override
	public String encode(String s) {
		Check.isTrue(s != null);
		if(s.equals(lastEncodeIn))
			return lastEncodeOut;
		
		lastEncodeIn = s;
		lastEncodeOut = inner.encode(s);
		return lastEncodeOut;
	}

	@Override
	public String decode(String s) {
		Check.isTrue(s != null);
		
		if(s.equals(lastDecodeIn))
			return lastDecodeOut;
		
		lastDecodeIn = s;
		lastDecodeOut = inner.encode(s);
		return lastDecodeOut;		
	}

}
