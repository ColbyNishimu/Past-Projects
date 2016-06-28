/* CeilingFan class represents the state of the ceiling fan. When created,
 * its fields correspond to the light and fan speed of the physical fan.
 * When destroyed, the fan and lights are turned off (effectively turning off
 * the power to the fan.
 */
public class CeilingFan {
	public int speed;
	public boolean isLightOn;
	public void CeilingFan() { // ceiling fan created when powered on
		speed = 0; // 0=off, 1=low, 2=medium, 3=high
		isLightOn = true;
	}
	public void speedCordPulled() { // called when user pulls speed cord
		speed = (speed + 1) % 4;
	}
	public void lightCordPulled() { // called when user pulls light cord
		isLightOn = !isLightOn;
	}
}
