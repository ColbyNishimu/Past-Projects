import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CeilingFanTest
{
	CeilingFan cf;
	CeilingFanSystem cfs;
	
	@Before
	public void setUp()
	{
		cf = new CeilingFan();
		cfs = new CeilingFanSystem();
	}

	@Test
	public void speedCordTestLow()
	{
		cf.speedCordPulled();
		assertEquals(1, cf.speed);
	}
	
	@Test
	public void speedCordTestMedium(){
		cf.speedCordPulled();
		cf.speedCordPulled();
		assertEquals(2, cf.speed);
	}
	
	@Test
	public void speedCordTestHigh(){
		cf.speedCordPulled();
		cf.speedCordPulled();
		cf.speedCordPulled();
		assertEquals(3, cf.speed);
	}
	
	@Test
	public void speedCordTestOff(){
		assertEquals(0, cf.speed);
		cf.speedCordPulled();
		cf.speedCordPulled();
		cf.speedCordPulled();
		cf.speedCordPulled();
		assertEquals(0, cf.speed);
	}
	
	@Test
	public void lightCordPulledTestOn(){
		assertFalse(cf.isLightOn);
	}
	
	@Test
	public void lightCordPulledTestOff(){
		cf.lightCordPulled();
		assertTrue(cf.isLightOn);
	}
	
	@After
	public void tearDown()
	{
	}

}
