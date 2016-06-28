import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TriangleTypeFunctionalTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void scaleneTest()
	{
		assertEquals(1, TriangleType.triangleType(3, 4, 5));
	}

	@Test
	public void isoscelesTest(){
		assertEquals(2, TriangleType.triangleType(3, 3, 4));
	}
	
	@Test
	public void equilateralTest(){
		assertEquals(3, TriangleType.triangleType(3,  3,  3));
	}
	
	@Test
	public void nonTriangleTest(){
		assertEquals(4, TriangleType.triangleType(10, 2, 3));
	}
	
	@Test
	public void outOfBoundsTest(){
		assertEquals(5, TriangleType.triangleType(1001, 1001, 1001));
	}
	
}
