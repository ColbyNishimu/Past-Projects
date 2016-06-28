/* CeilingFanSystem class represents the state of the room, including the
 * power button and the ceiling fan. It should always be created .
 */
public class CeilingFanSystem {
	public boolean isPowered;
	public CeilingFan fan;
	public void CeilingFanSystem() {
		isPowered = false;
		fan = null;
	}
	public void powerButtonPushed() { // called when user presses button
		if (isPowered) {
			fan = null; // destroy CeilingFan object to cut power
		} else {
			fan = new CeilingFan(); // create CeilingFan
		}
		isPowered = !isPowered;
	}
	public static void main() {
	 CeilingFanSystem system = new CeilingFanSystem();
	}
} 