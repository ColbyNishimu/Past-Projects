// SmileyFacePart.java
//
// ICS 45J: Lab Assignment 1
//
// Originally coded by Norm Jacobson, September 2006
// Minor modifications introduced by Alex Thornton, June 2009
// Face part copy constructor added by Norman Jacobson for ICS 21 
//  Fall 2009, September 2009
// computerUpperLeft() removed; that's now handled by the graphics routines,
//  by Norman Jacobson for ICS21 WInter 2011, December 2011
// Updated for ICS45J by Norman Jacobson, August 2012


// Color objects are needed to represent the color of the face part
import java.awt.Color;

// A SmileyFacePart represents one part of a smiley face (i.e.,
// the face, an eye, or the smile); it has a color, position and size
abstract class SmileyFacePart
{
	// A part consists of its color, x and y coordinates of its center,
	// and its length in the x and y coordinates

	int xc= 0;
	int yc= 0;
	double xlength = 20;
	double ylength = 20;
	Color partcolor;
	
	// When we construct an "empty" SmileyFacePart, we set its color to
	// gray, while leaving as 0 all the values of its other attributes
	public SmileyFacePart()
	{
		xc= 0;
		yc= 0;
		xlength = 0;
		ylength = 0;
		partcolor = Color.gray;
	}


	// A copy of a face part is a copy of each of its components
	public SmileyFacePart(SmileyFacePart orig)
	{
		xc= orig.xc;
		yc= orig.yc;
		xlength = orig.xlength;
		ylength = orig.ylength;
		partcolor = orig.partcolor;
				
	}


	// setAttributes() uses the appropriate helper methods to set the
	// various attributes of a SmileyFacePart.
	public void setAttributes(
		Color newColor, int newCenterX, int newCenterY,
		double newXLength, double newYLength)
	{
		partcolor = newColor;
		xc = newCenterX;
		yc = newCenterY;
		xlength = newXLength;
		ylength = newYLength;
	}


	// translate() moves a SmileyFacePart the given distance horizontally
	// (deltaX) and vertically (deltaY). Positive values move right and down;
	// negative values move left and up
	public void translate(int deltaX, int deltaY)
	{
		xc = xc + deltaX;
		yc = yc + deltaY;
	}


	// scale() changes the size of a SmileyFacePart by the given factor.
	// For example, if the part is 20 x 20 and the scaleFactor is 3.5,
	// the part's new size should be 70 x70.
	public void scale(double scaleFactor)
	{
		xlength = xlength * scaleFactor;
		ylength = ylength * scaleFactor; 
	}


	// setColor() sets the color of a SmileyFacePart to be the color
	// specified by c.
	public void setColor(Color c)
	{
		partcolor =c; 
	}


	// setCenter() sets the center x- and y-coordinates of a SmileyFacePart
	public void setCenter(int x, int y)
	{
		xc = x;
		yc = y; 
	}


	// setXLength() sets the horizontal length of a SmileyFacePart
	public void setXLength(double xLen)
	{
		xlength = xLen;
	}


	// setYLength() sets the vertical length of a SmileyFacePart
	public void setYLength(double yLen)
	{
		ylength = yLen;
	}

	// Accessor methods to return each of the attributes
	// of a SmileyFacePart.

	public Color getColor()
	{
		return partcolor;
	}


	public int getCenterX()
	{
		return xc;
	}


	public int getCenterY()
	{
		return yc;
	}


	public double getXLength()
	{
		return xlength;
	}


	public double getYLength()
	{
		return ylength;
	}
}

// Each part of the face is just a SmileyFacePart --
// but we have each face part as a separate class to
// help keep them straight, and in case in future
// we want specific parts to have characteristics
// particular to them.

// Each class as a constructor that builds a
// "default part"; that is, it calls the
// SmileyFacePart no-parameter constructor.
// Each class also has a copy constructor that 
// makes a copy of its kind of object; again, 
// since every part here is a face part, we 
// just invoke SmileyFacePart's copy constructor.

class Face extends SmileyFacePart
{
	public Face()
	{
		super();
	}

	public Face(Face orig)
	{
		super(orig);
	}
}


class Eye extends SmileyFacePart
{
	public Eye()
	{
		super();
	}

	public Eye(Eye orig)
	{
		super(orig);
	}
}


class Smile extends SmileyFacePart
{
	public Smile()
	{
		super();
	}

	public Smile(Smile orig)
	{
		super(orig);
	}

}

