package exercise4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LineTest {

	@Test
	void testGetNegativeSlope() {
		Line line = new Line(2, 4, 4, 2);
		assertEquals(-1, line.getSlope(), 0.001);
	}

	@Test
	void testGetPositiveSlope() {
		Line line = new Line(2, 2, 4, 4);
		assertEquals(1, line.getSlope(), 0.001);
	}

	@Test
	void testGet0Slope() {
		Line line = new Line(3, 0, 4, 0);
		assertEquals(0, line.getSlope(), 0.001);
	}

	@Test
	void testGetNullSlope() {
		Line line = new Line(0, 0, 0, 0);

		try {
			line.getSlope();
			fail("Expected an ArithmeticException to be thrown.");
		} catch(ArithmeticException anArithmeticException) {}
	}

	@Test
	void testGetNegativeDistance() {
		Line line = new Line(0, -1, 0, 0);
		assertEquals(1.0, line.getDistance(), 0.001);
	}

	@Test
	void testGetPositiveDistance() {
		Line line = new Line(0, 1, 0, 0);
		assertEquals(1.0, line.getDistance(), 0.001);
	}

	@Test
	void testGet0Distance() {
		Line line = new Line(0, 0, 0, 0);
		assertEquals(0.0, line.getDistance(), 0.001);
	}

	@Test
	void testParallelToNotEqual() {
		Line l1 = new Line(0, 0, 1, 1);
		Line l2 = new Line(1, 1, 0, 5);
		assertEquals(false, l1.parallelTo(l2));
	}

	@Test
	void testParallelToEqual() {
		Line l1 = new Line(0, 0, 1, 1);
		Line l2 = new Line(1, 1, 0, 0);
		assertEquals(true, l1.parallelTo(l2));
	}

	@Test
	void testParallelToSamePoints() {
		Line l1 = new Line(0, 0, 1, 1);
		Line l2 = new Line(0, 0, 1, 1);
		assertEquals(true, l1.parallelTo(l2));
	}

}
