import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TriangleTypeStructuralTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testTriangleTypeObject(){
		TriangleType tt = new TriangleType();
	}
	
	@Test
	public void testTriangleType4SidesLessThanZero() {
		assertEquals(4, TriangleType.triangleType(0, 0, 0));
	}
	
	@Test
	public void testNotScalene(){
		assertEquals(4, TriangleType.triangleType(1, 2, 5));
		assertEquals(4, TriangleType.triangleType(2, 5, 1));
	}
	
	@Test
	public void testConfirmIsocelesOneThreeGreaterThanTwo(){
		assertEquals(2, TriangleType.triangleType(2, 3, 2));
		assertEquals(2, TriangleType.triangleType(4, 2, 4));
		assertEquals(4, TriangleType.triangleType(3, 6, 3));
	}
	
	@Test
	public void testConfirmIsocelesTwoThreeGreaterThanOne(){
		assertEquals(2, TriangleType.triangleType(3, 2, 2));
		assertEquals(4, TriangleType.triangleType(6, 3, 3));
	}
	
	@Test
	public void testConfirmNotATriangle(){
		assertEquals(4, TriangleType.triangleType(2, 2, 6));
	}
	
	@Test
	public void testConfirmPositiveSides(){
		assertEquals(4, TriangleType.triangleType(2, 2, 0));
		assertEquals(4, TriangleType.triangleType(2, 0, 2));
	}
	
	@Test
	public void testOutOfBounds(){
		assertEquals(5, TriangleType.triangleType(3, 1001, 3));
		assertEquals(5, TriangleType.triangleType(3, 3, 1001));
	}
	
}
