// AnimatedSmiley.java
//
// ICS 45, Fall 2012: Lab Assignment 2
//
// Completed by: Colby Nishimura, Brandon Cao
// UCInetiD:     cnishimu, btcao
// ID:           81272756, 90621888

// A smiley that can move around a screen,
//  so an extended smiley face that has
//  movement information and methods.  
//
// Each movement (X and Y coordinate) indicates
// both direction and magnitude: 
//  A positive value moves the smiley towards
//  the right on the X axis and down on the Y axis;
//  a negative value moves it left on the axis and
//  up on the Y axis.
//  The magnitude of the movement is how many
//  pixels to move in each tick of the animation
//  clock, or, if you will, in each frame of
//  animation.
//  For example, 10 for the X movement would
//  move the smiley 10 pixels to the right each
//  frame; -1 for the Y movement would move the
//  smiley up 1 pixel.
//  Both  X and Y movements are applied in each
//  frame. For example, if the movements were set
//  as just abvove, the smiley would move 10 pixels
//  to the right and 1 pixel up in each frame.
public class AnimatedSmiley extends SmileyFace
{
	// Needed fields go here...
	public int XMove;
	public int YMove;
	public SmileyFace face;
	
	// Build a from-scratch AnimatedSmiley to bounce around the display
	// It is the same as a from-scratch SmileyFace, with initial
	// movement information.
	public AnimatedSmiley(int startXMovement, int startYMovement)
	{
		super();
		XMove = startXMovement;
		YMove = startYMovement;
	}

	
	// Copy an existing AnimatedSmiley
	public AnimatedSmiley(AnimatedSmiley orig)
	{		
		super(orig);
		XMove = orig.XMove;
		YMove = orig.YMove;
	}

		
	
	// Copy an existing AnimatedSmiley, but replace its movement information
	// with new movement information
	public AnimatedSmiley(AnimatedSmiley orig, int startXMovement, int startYMovement)
	{
		super(orig);
		XMove = startXMovement;
		YMove = startYMovement;
	}

	// moveIt: Move -- translate -- the smiley along the x and y dimensions the
	// amounts and directions embodied in its current movement fields
	public void moveIt()
	{
		this.translate(XMove, YMove);
	}

	
	// Set the movements
	
	public void setCurrentXMovement(int xValue)
	{
		XMove = xValue;
	}
	
	public void setCurrentYMovement(int yValue)
	{
		YMove = yValue;
	}

	
	// Access the current movements
	
	public int getCurrentXMovement()
	{
		return XMove;
	}
	
	public int getCurrentYMovement()
	{
		return YMove;
	}
}

