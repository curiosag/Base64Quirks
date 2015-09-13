# Base64Quirks

Java implementation to encode/decode [ayudasystem's secret dev challenge](http://www.ayudasystems.com/Jobs/SecretDevChallenge) codes as of 2015-09-11. 

That's the encoding: each character of the clear text gets shifted to the right on the clear text alphabet by a fixed number plus the character index on the clear text itself. Shifting happens in a round-robin-fashion. The resulting string gets base64 encoded. Check out README.txt for a detailed description.
  	  	   	
Class Ayudasystem.java has a constructor in case you know the fixed number factor. Alternatively you can brute force the offset for each character with another constructor which takes these parameters:

    - a sample of clear text, at least as long as the text to decode
    - the corresponding encoding of that clear text sample. 

There's an web app to [try it](http://socorro-pronto.appspot.com/).

Another published [solution from 2013](https://github.com/amokhtar/AyudaDev) gives a hint, that another manipulation was the order of the Base64 encoding alphabet. This is not the case right now, though.