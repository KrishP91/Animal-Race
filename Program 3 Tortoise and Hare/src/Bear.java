/** Bear class
*   inherits from abstract Racer class
*/

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Bear extends Racer
{
   /** Default Constructor: calls Racer default constructor
   */
   public Bear( )
   {
     super( );
   }

   /** Constructor
   *    @param rID   racer Id, passed to Racer constructor
   *    @param rX    x position, passed to Racer constructor
   *    @param rY    y position, passed to Racer constructor
   */
   public Bear( String rID, int rX, int rY )
   {
     super( rID, rX, rY );
   }

   /** move:  calculates the new x position for the racer
   *   Bear move characteristics:  80% of the time, Bear jumps 2 pixels
   *                               20% of the time, Bear jumps 8 pixels
   *   generates random number between 1 & 10
   *          for 1 - 2,  x position is incremented by 8
   *          for 3 - 10, x position is incremented by 2
   */
   public void move( )
   {
      Random rand = new Random( );
     int move =  rand.nextInt( 10 ) + 1 ;

     if ( getX( ) < 100 )
     {
      if ( move >= 3 )
       setX( getX( ) + 2 );
     }
     else
     {
      if ( move < 3 )
       setX( getX( ) + 8 );
     }
   }

   /** draw: draws the Bear at current (x, y) coordinate
   *   @param g   Graphics context
   */
   public void draw( Graphics g )
   {
     int startY = getY( );
     int startX = getX( );

     // tail
     g.setColor( Color.BLACK );
     g.fillOval( startX - 37, startY + 3,  12, 12 ) ;

     //body
     g.setColor( Color.BLACK );
     g.fillOval( startX - 28, startY - 10,  12,  25 );
     g.fillOval( startX - 20, startY - 8, 12,  12 );

     //head
     g.fillOval( startX - 28, startY - 20, 17, 12 );
    // g.fillOval( startX - 13, startY - 8, 8, 28 );

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
	  	 g.fillRect( startX - 28, startY - 22, 15, 8);
	  	 g.fillRect( startX - 23, startY - 24, 8, 5);
	  
	}
}