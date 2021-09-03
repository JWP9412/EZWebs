package mytest;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalcTest {
	private Calc calc = new Calc();
	
	@Test
	public void testPlus() {
		assertEquals(30, calc.plus(20, 10));
	}

	@Test
	public void testMinus() {
		assertEquals(10, calc.minus(20, 10));
	}

	@Test
	public void testMulti() {
		assertEquals(200, calc.multi(20, 10));
	}

	@Test
	public void testDiv() {
		assertEquals(30, calc.div(20, 0));
	}

}
