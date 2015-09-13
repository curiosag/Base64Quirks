package codec;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalcTest {

	@Test
	public void testShift() {
		// 0 1 2 3
		assertEquals(0, Calc.shiftLeft(4, 0, 0));
		assertEquals(3, Calc.shiftLeft(4, 0, 1));
		assertEquals(1, Calc.shiftLeft(4, 1, 0));
		assertEquals(0, Calc.shiftLeft(4, 1, 1));
		assertEquals(1, Calc.shiftLeft(4, 1, 4));
		assertEquals(0, Calc.shiftLeft(4, 1, 5));
		assertEquals(3, Calc.shiftLeft(4, 1, 2));
		assertEquals(0, Calc.shiftLeft(4, 2, 2));
		assertEquals(3, Calc.shiftLeft(4, 2, 3));
		assertEquals(2, Calc.shiftLeft(4, 1, 3));

		// 0 1 2 3

		assertEquals(0, Calc.shiftRight(4, 0, 0));
		assertEquals(1, Calc.shiftRight(4, 0, 1));
		assertEquals(1, Calc.shiftRight(4, 1, 0));
		assertEquals(2, Calc.shiftRight(4, 1, 1));
		assertEquals(1, Calc.shiftRight(4, 1, 4));
		assertEquals(2, Calc.shiftRight(4, 1, 5));
		assertEquals(3, Calc.shiftRight(4, 1, 2));
		assertEquals(0, Calc.shiftRight(4, 3, 1));
		assertEquals(1, Calc.shiftRight(4, 3, 2));
		assertEquals(1, Calc.shiftRight(4, 2, 3));	
		assertEquals(2, Calc.shiftRight(10, 9, 13));

	}
}
