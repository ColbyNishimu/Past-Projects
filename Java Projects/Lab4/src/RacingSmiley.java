import java.awt.Color;


public class RacingSmiley extends AnimatedSmiley implements RacingSmileyInterface
{
	public String nname;
	public Color color;
	public int currentLap;
	public int direction;
	public int ticks;
	public int speed;
	public String strategy;
	public boolean finished;
	public int TOTAL_LAPS = 6;
	public RacingSmiley(AnimatedSmiley existingFace, String name, Color nameColor){
		super(existingFace);
		nname = name;
		color = nameColor;
		currentLap = 0;
		direction = 1;
		ticks = 0;
		speed = 0;
		strategy = "constant";
		finished = false;
	}
	
	public boolean finishedRace(){
		if(this.currentLap == TOTAL_LAPS){
			this.finished = true;
		}
		return this.finished;
	}
	
	public void raceForOneTick(){
		this.translate(speed*direction, 0);
		ticks++;
	}
	
	public int getTicks(){
		return this.ticks;
	}
	
	public String getSmileyName(){
		return this.nname;
	}
	
	public Color getSmileyNameColor(){
		return this.color;
	}
	
	public int getLapsCompleted(){
		return this.currentLap;
	}
}

