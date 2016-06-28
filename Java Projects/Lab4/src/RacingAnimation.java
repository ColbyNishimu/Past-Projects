import java.util.ArrayList;
import java.awt.Color;


public class RacingAnimation implements RacingAnimationInterface
{
	public RacingDisplay display;
	public int right = RacingDisplay.RIGHT_EDGE;
	public int left = RacingDisplay.LEFT_EDGE;
	public RacingGroup group;
	public int total;
	public int fewest = 0;
	public int most = 0;
	public String fastest = null;
	public String slowest = null;
	public double average = 0.00;
	public int pause = 2;
	public RacingAnimation(RacingGroup g, RacingDisplay d){
		display = d;
		group = g;
	}
	public void animate(){
		if(group.smileyList.size() == 0){
			return;
		}
		int count = 0;
		int space = display.getHeight()/group.smileyList.size();
		for(int i = 0; i!=group.smileyList.size(); i++){
			group.smileyList.get(i).getFace().setAttributes(Color.YELLOW, 0, (space*i)+space/2, space, space);
			
			group.smileyList.get(i).getRightEye().setAttributes(Color.RED, group.smileyList.get(i).getRightEdge()-(int)Math.round(group.smileyList.get(i).getFace().getXLength()/4), group.smileyList.get(i).getTopEdge()+(int)Math.round(group.smileyList.get(i).getFace().getXLength()/4), group.smileyList.get(i).getFace().getXLength()/4, group.smileyList.get(i).getFace().getXLength()/4);
			
			group.smileyList.get(i).getLeftEye().setAttributes(Color.YELLOW, group.smileyList.get(i).getLeftEdge()+(int)Math.round(group.smileyList.get(i).getFace().getXLength()/4), group.smileyList.get(i).getTopEdge()+(int)Math.round(group.smileyList.get(i).getFace().getXLength()/4), group.smileyList.get(i).getFace().getXLength()/4, group.smileyList.get(i).getFace().getXLength()/4);
			
			group.smileyList.get(i).getSmile().setAttributes(Color.black, group.smileyList.get(i).getRightEdge()-(int)Math.round(group.smileyList.get(i).getFace().getXLength()/4), group.smileyList.get(i).getBottomEdge()-(int)Math.round(group.smileyList.get(i).getFace().getXLength()/6), group.smileyList.get(i).getFace().getXLength()/2, group.smileyList.get(i).getFace().getXLength()/3);
			
		}
		while(count != group.smileyList.size()){
			count = 0;
			for(int i = 0; i<group.smileyList.size(); i++){
				if(group.smileyList.get(i).finishedRace() == false){
					group.smileyList.get(i).raceForOneTick();
					if(group.smileyList.get(i).direction == 1){
						if(group.smileyList.get(i).getRightEdge() >= right){
							group.smileyList.get(i).currentLap++;
							group.smileyList.get(i).getRightEye().setColor(Color.YELLOW);
							group.smileyList.get(i).getLeftEye().setColor(Color.RED);
							group.smileyList.get(i).getSmile().translate(-(int)group.smileyList.get(i).getFace().getXLength()/2,0);
							if(group.smileyList.get(i).finishedRace()){
								group.smileyList.get(i).direction = 0;
								group.smileyList.get(i).finished = true;
							}
							else{
								group.smileyList.get(i).direction = -1;
								if(group.smileyList.get(i).strategy == "earlypeak"){
									if(group.smileyList.get(i).speed != 1){
										group.smileyList.get(i).speed--;
									}
								}
								else if(group.smileyList.get(i).strategy == "latepeak"){
									if(group.smileyList.get(i).speed != 10){
										group.smileyList.get(i).speed++;
									}
								}
							}
						}
					}
					else if(group.smileyList.get(i).direction == -1){
						if(group.smileyList.get(i).getLeftEdge() <= left){
							group.smileyList.get(i).currentLap++;
							group.smileyList.get(i).getLeftEye().setColor(Color.YELLOW);
							group.smileyList.get(i).getRightEye().setColor(Color.RED);
							group.smileyList.get(i).getSmile().translate((int)group.smileyList.get(i).getFace().getXLength()/2,0);
							if(group.smileyList.get(i).finishedRace()){
								group.smileyList.get(i).direction = 0;
								group.smileyList.get(i).finished = true;
							}
							else{
								group.smileyList.get(i).direction = 1;
								if(group.smileyList.get(i).strategy == "earlypeak"){
									if(group.smileyList.get(i).speed != 1){
										group.smileyList.get(i).speed--;
									}
								}
								else if(group.smileyList.get(i).strategy == "latepeak"){
									if(group.smileyList.get(i).speed != 10){
										group.smileyList.get(i).speed++;
									}
								}
							}
						}
					}
					display.repaint();
					try{
					Thread.sleep(pause);
					}
					catch(InterruptedException e){
					}
				}
				else{
					count++;
				}
			}
		}
	}
	public ArrayList<RacingSmiley> getRacers(){
		return group.smileyList;
	}
	public String getStatisticsTitle(){
		return "Stats for "+Integer.toString(group.smileyList.size())+" Racers";
	}
	public double getAverageTicks(){
		for(int i = 0; i<group.smileyList.size(); i++){
			total = total + group.smileyList.get(i).getTicks();
		}
		return total/group.smileyList.size();
	}
	public int getFewestTicks(){
		fewest = 0;
		for(int i = 0; i<group.smileyList.size(); i++){
			if(i == 0){
				fewest = group.smileyList.get(i).getTicks();
			}
			else if(group.smileyList.get(i).getTicks() < fewest){
				fewest = group.smileyList.get(i).getTicks();
			}
		}
		return fewest;
	}
	public int getMostTicks(){
		most = 0;
		for(int i = 0; i<group.smileyList.size(); i++){
			if(group.smileyList.get(i).getTicks() > most){
				most = group.smileyList.get(i).getTicks();
			}
		}
		return most;
	}
	public String getFastestSmileyName(){
		boolean tie = false;
		for(int i = 0; i<group.smileyList.size(); i++){
			if(group.smileyList.get(i).getTicks() == getFewestTicks()){
				if(tie == false){
					fastest = fastest + group.smileyList.get(i).getSmileyName();
					tie = true;
				}
				else{
					fastest = fastest + ", "+group.smileyList.get(i).getSmileyName();
				}
			}
		}
		return fastest;
	}
	public String getSlowestSmileyName(){
		boolean tie = false;
		for(int i = 0; i<group.smileyList.size(); i++){
			if(group.smileyList.get(i).getTicks() == getMostTicks()){
				if(tie == false){
					slowest = slowest + group.smileyList.get(i).getSmileyName();
					tie = true;
				}
				else{
					slowest = slowest + ", "+group.smileyList.get(i).getSmileyName();
				}
			}
		}
		return slowest;
	}
}
