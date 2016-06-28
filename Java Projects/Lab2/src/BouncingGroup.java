// BouncingGroup.java
//
// ICS 45, Fall 2012: Lab Assignment 2
//
// Completed by: Colby Nishimura, Brandon Cao
// UCInetiD:     cnishimu, btcao
// ID:           81272756, 90621888
//
// A BouncingGroup represents a collection of up to 
// bouncing three smiley faces, each with its own attributes.
//
// Same as Lab 1, except that the smileys are boncing smileys
// rather than vanilla smiley faces.


import java.awt.Color;

// The group of three bouncing smileys
public class BouncingGroup
{
	// The three animated smiley faces (the fields) that make up the group
	
	private AnimatedSmiley Smiley1;
	private AnimatedSmiley Smiley2;
	private AnimatedSmiley Smiley3;

	// This constructor builds up to three smileys in the group.  You
	// can construct each face either from scratch or as a copy of an
	// existing bouncing smiley, setting the attributes of the various
	// face parts, translating and/or scaling face parts, or translating 
	// the entire smiley face.
	//
	// The predefined Colors are
	//		BLACK, BLUE, CYAN, GRAY, DARK_GRAY, LIGHT_GRAY, GREEN, MAGENTA,
	//		ORANGE, PINK, RED, WHITE, YELLOW
	//
	// The exact characteristics (shape, color, position) of each smiley are
	// up to you, within the requirements given in the lab write-up.
	
	public BouncingGroup()
	{
		Smiley1 = new AnimatedSmiley(10,10);
		Smiley1.getFace().setAttributes(Color.LIGHT_GRAY, 150, 150, 50, 50);
		Smiley1.getSmile().setAttributes(Color.WHITE, 150, 160, 20, 20);
		Smiley1.getLeftEye().setAttributes(Color.WHITE, 140, 140, 10, 10);
		Smiley1.getRightEye().setAttributes(Color.WHITE, 160, 140, 10, 10);
		
		Smiley2 = new AnimatedSmiley(Smiley1);
		Smiley2.getFace().setAttributes(Color.ORANGE, 150, 150, 50, 50);
		
		Smiley3 = new AnimatedSmiley(Smiley1, 20, 10);
		Smiley1.getFace().setAttributes(Color.MAGENTA, 150, 150, 50, 50);

	}
	
	
	// Accessor methods that return each of the smileys in the group
	
	public AnimatedSmiley getSmiley1()
	{
		return Smiley1;
	}
	
	
	public AnimatedSmiley getSmiley2()
	{
		return Smiley2;
	}
	
	
	public AnimatedSmiley getSmiley3()
	{
		return Smiley3;
	}
}
