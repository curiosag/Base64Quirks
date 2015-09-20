An example for the current encoding:

ALPHABET

0 1 2 3 4 5 6 7 8 9
a b c d e f h i j k

COMMON Factor to shift by is 2 (say)
INPUT is "fake"
OUTPUT is "idck" (used in the next step for base64 encoding)

INPUT	ic	ia 	cs 	in 		new character 
  f     0	5	2	7		i
  a     1	0	2	3		d	
  k     2	9	2	2		c		
  e     3	4	2	9		k
 
ia ... index of the character in the input alphabet
ic ... index of the character in the input string
cs ... common factor to shift by
la ... length of alphabet
in ... new index: (ia + cs + ic) modulo la
