import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class RacingGroup implements RacingGroupInterface
{
	public int NUMBER_OF_SMILEYS = 5;
	public int count = 0;
	public int strat;
	public int rspeed;
	public RacingSmiley s;
	public ArrayList<RacingSmiley> smileyList;
	public RacingGroup(Color background){
		smileyList = new ArrayList<RacingSmiley>();
		Random r = new Random();
		while(count != NUMBER_OF_SMILEYS){
			s = new RacingSmiley(new AnimatedSmiley(0, 0), "Smiley"+Integer.toString(count), Color.CYAN);
			strat = r.nextInt(2);
			rspeed = r.nextInt(5)+1;
			s.speed = rspeed;
			if(strat == 0){
				s.strategy = "constant";
			}
			else if(strat == 1){
				s.strategy = "earlypeak";
			}
			else{
				s.strategy = "latepeak";
			}
			smileyList.add(count, s);
			count++;
		}
	}
	public ArrayList<RacingSmiley> getRacers(){
		return smileyList;
	}
}

