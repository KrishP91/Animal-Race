/** Mouse class
*   inherits from abstract Racer class
*/

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Mouse extends Racer
{
   /** Default Constructor: calls Racer default constructor
   */
   public Mouse( )
   {
     super( );
   }

   /** Constructor
   *    @param rID   racer Id, passed to Racer constructor
   *    @param rX    x position, passed to Racer constructor
   *    @param rY    y position, passed to Racer constructor
   */
   public Mouse( String rID, int rX, int rY )
   {
     super( rID, rX, rY );
   }

   /** move:  calculates the new x position for the racer
   *   Mouse move characteristics:  45% of the time, Mouse jumps 5 pixels
   *                               45% of the time, Mouse jumps 2 pixels
   *                               10% of the time, no movement)
   *   generates random number between 1 & 10
   *          for 1 - 4,  x incremented by 5
   *          for 6 - 10, x position is incremented by 5
   *          for 5, no change in x
   */
   public void move( )
   {
      Random rand = new Random( );
     int move =  rand.nextInt( 10 ) + 1 ;

     if ( getX( ) < 100 )
     {
      if ( move < 5 )
       setX( getX( ) + 5 );
     }
     else
     {
      if ( move > 5 )
       setX( getX( ) + 2 );
     }
   }

   /** draw: draws the Mouse at current (x, y) coordinate
   *   @param g   Graphics context
   */
   public void draw( Graphics g )
   {
     int startY = getY( );
     int startX = getX( );

     // tail
     g.setColor( Color.LIGHT_GRAY );
     g.fillOval( startX - 37, startY + 8,  20, 4 ) ;

     //body
     g.setColor( Color.GRAY );
     g.fillOval( startX - 30, startY,  17,  15 );

     //head
     g.fillOval( startX - 20, startY + 2, 13, 8 );
     g.fillOval( startX - 20, startY - 4, 8, 8 );

     //flatten bottom
     g.clearRect( startX - 37, startY + 15, 32, 5 );
     if (this.isWinner) {
    	 this.morph(g);
     }
     
   }
   public void morph( Graphics g ) {
	  	 int startY = getY();
	  	 int startX = getX();
	  	 
	  	 g.setColor( Color.BLACK );
	  	 g.fillRect( startX - 20, startY - 6, 10, 5);
	  	 g.fillRect( startX - 17, startY - 8, 5, 3);
	  
	}
}