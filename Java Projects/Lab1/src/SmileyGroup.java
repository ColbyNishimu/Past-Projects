// SmileyGroup.java
//
// ICS 45J: Lab Assignment 1
//
// Originally coded by Norman Jacobson, September 2006
// Minor modifications introduced by Alex Thornton, June 2009
// Minor modifications by Norman Jacobson for ICS 21 Fall 2009, September 2009
// Revised and adapted by Norman Jacobson for ICS45J Fall 2012, August 2012
//

// SmileyGroup is going to be specifying (to other methods) the 
// colors various smaily face parts ought to be, so we need to 
// have the Color library available:

import java.awt.Color;

// The predefined Colors (they are final Color objects) are
//		BLACK, BLUE, CYAN, GRAY, DARK_GRAY, LIGHT_GRAY, GREEN, MAGENTA,
//		ORANGE, PINK, RED, WHITE, YELLOW


// A SmileyGroup represents a collection of up to three smiley faces,
// each with its own attributes.

public class SmileyGroup
{
	// Provide fields for the three smiley faces that make up the group
	public SmileyFace smiley1;
	public SmileyFace smiley2;
	public SmileyFace smiley3;

	// The constructor builds up to three smileys in the group.  You
	// can construct each face either from scratch or as a copy of an
	// existing one, setting the attributes of the various face parts,
	// translating and/or scaling face parts, or translating the
	// entire smiley face, by calling the appropriate methods.
	//
	// See the lab write-up for the kinds of smiley faces we're expecting
	// you to create and the methods we expect you to employ; withint those
	// requirements, the exact characteristics (shape, color, position) of 
	// each smiley is up to you.
	
	public SmileyGroup()
	{
		smiley1 = new SmileyFace();
		smiley1.getFace().setAttributes(Color.green, 255, 255, 100, 100);
		smiley1.getRightEye().setAttributes(Color.red, 235, smiley1.getTopEdge()+40, 10, 30);
		smiley1.getLeftEye().setAttributes(Color.red, smiley1.getRightEdge()-30, 245, 10, 30);
		smiley1.getSmile().setAttributes(Color.red, 255, smiley1.getBottomEdge()-20, 30, 5);
		smiley2 = new SmileyFace(smiley1);
		smiley2.translate(130, 0);
		smiley2.getSmile().setCenter(385, 295);
		smiley2.getFace().setColor(Color.gray);
		smiley2.getRightEye().setYLength(40);
		smiley2.getLeftEye().setXLength(20);
		smiley3 = new SmileyFace();
		smiley3.getFace().setAttributes(Color.white, 125, 255, 100, 100);
		smiley3.getFace().scale(1.5);
		smiley3.getRightEye().setAttributes(Color.orange, smiley3.getLeftEdge()+55, 265, 10, 30);
		smiley3.getLeftEye().setAttributes(Color.orange, 145, 265, 10, 30);
		smiley3.getSmile().setAttributes(Color.orange, 125, 225, 30, 5);
	}
	
	
	
	// Obtain the first smiley face of the group
	public SmileyFace getSmiley1()
	{
		return smiley1;	
	}
	
	
	// Obtain the second smiley face of the group
	public SmileyFace getSmiley2()
	{
		return smiley2;
	}
	
	
	// Obtain the third smiley face of the group
	public SmileyFace getSmiley3()
	{
		return smiley3;	
	}
}
