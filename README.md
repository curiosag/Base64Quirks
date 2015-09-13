# Base64Quirks

Java implementation to encode/decode [ayudasystem's secret dev challenge](http://www.ayudasystems.com/Jobs/SecretDevChallenge) codes as of 2015-09-11. 

That's the encoding: each character of the clear text gets shifted to the right on the clear text alphabet by a fixed number plus the character index on the clear text itself. Shifting happens in a round-robin-fashion. The resulting string gets base64 encoded.
  	  	 
ALPHABET

0 1 2 3 4 5 6 7 8 9
a b c d e f h i j k

COMMON Factor is 2 (say)
INPUT is "fake"
OUTPUT is "idck" (used in the next step for straight base64 encoding)

INPUT	ic	ia 	cs 	in 		new character 
  f		0	5	2	7		i
  a		1	0	2	3		d	
  k		2	9	2	2		c		
  e		3	4	2	9		k
 
ia ... index of the character in the input alphabet
ic ... index of the character in the input string
cs ... common factor to shift by
la ... length of alphabet
in ... new index: (ia + cs + ic) modulo la
  	
Class Ayudasystem.java has a constructor in case you know factor cs. Alternatively you can brute force the offset for each character with another constructor which takes these parameters:

    - a sample of clear text, at least as long as the text to decode
    - the corresponding encoding of that clear text sample. 

There's an web app to [try it](http://socorro-pronto.appspot.com/).

Another published [solution from 2013](https://github.com/amokhtar/AyudaDev) gives a hint, that another manipulation was the order of the Base64 encoding alphabet. This is not the case right now, though.