// SmileyFace.java
//
// ICS 21: Lab Assignment 1
//
// Originally coded by Norm Jacobson, September 2006
// Minor modifications introduced by Alex Thornton, June 2009
// Revised and adapted for ICS45J Fall 2012 by Norman Jacobson, August 2012
//

// The class representing one smiley face
public class SmileyFace
{
// A SmileyFace consists of four parts:
// * A face (the circle that underlies the entire smiley face)
// * A left eye
// * A right eye
// * A smile
// Provide fields for each
	private Face face;
	private Eye righteye;
	private Eye lefteye;
	private Smile smile;
	
	

	// When we construct a new SmileyFace from scratch, we create
	// a new face, new eyes, and a new smile, but don't give them
	// any characteristics; they are filled in later.
	public SmileyFace()
	{
		face = new Face();
		righteye = new Eye();
		lefteye = new Eye();
		smile = new Smile();
	}

	// When we construct a new SmileyFace that is intended to be a
	// copy of an original SmileyFace, we construct each new part
	// from the same part of the old face
	public SmileyFace(SmileyFace original)
	{
		face = new Face(original.face);
		righteye = new Eye(original.righteye);
		lefteye = new Eye(original.lefteye);
		smile = new Smile(original.smile);
	}

	// translate() moves the entire face, including all of its parts,
	// by the given horizontal (deltaX) and vertical (deltaY)
	// distances. Positive values move the figure right and down; 
	// negative ones up and left
	public void translate(int deltaX, int deltaY)
	{
		face.translate(deltaX, deltaY);
		righteye.translate(deltaX, deltaY);
		lefteye.translate(deltaX, deltaY);
		smile.translate(deltaX, deltaY);
		
	}


	// Accessors that return each part of a SmileyFace:

	public Face getFace()
	{
		return face;
	}


	public Eye getLeftEye()
	{
		return lefteye;
	}


	public Eye getRightEye()
	{
		return righteye;
	}


	public Smile getSmile()
	{
		return smile;
	}
	
	// Accessors that return the 'edges' of the
	// smiley - the leftmost, rightmost, topmost,  
	// and bottom-most points
	
	public int getLeftEdge()
	{
		return (int)(face.xc - (face.xlength/2));
	}
	
	public int getRightEdge()
	{
		return (int) (face.xc + (face.xlength/2));
	}
	
	public int getTopEdge()
	{
		return (int) (face.yc - (face.ylength/2));
	}

	public int getBottomEdge()
	{
		return (int) (face.yc + (face.ylength/2));
	}
}


