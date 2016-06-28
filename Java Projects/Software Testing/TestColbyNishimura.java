import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class TestColbyNishimura
{
	ColbyNishimura c;
	
	@Before
	public void setup(){
		c = new ColbyNishimura();
	}
	
	@Test
	public void fullNameTest()
	{
		assertEquals("Colby Nishimura", c.getFullName());
	}
	
	@Test
	public void firstNameTest(){
		assertEquals("Colby", c.getFirstName());
	}

	@Test
	public void lastNameTest(){
		assertEquals("Nishimura", c.getLastName());
	}
	
	@Test
	public void UCInetIDTest(){
		assertEquals("cnishimu", c.getUCInetId());
	}
	
	@Test
	public void posRotatedFullNameTest(){
		assertEquals("lby NishimuraCo", c.getRotatedFullName(2));
	}
	
	@Test
	public void negRotatedFullNameTest(){
		assertEquals("NishimuraColby ", c.getRotatedFullName(-9));
	}
	
	//I test the 0 case as well just so everything in the class is tested
	@Test
	public void noRotatedFullNameTest(){
		assertEquals("Colby Nishimura", c.getRotatedFullName(0));
	}
	
	@After
	public void tearDown(){}
}
