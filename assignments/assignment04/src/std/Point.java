package std;
import java.util.Comparator;

/**
 * Point.java. Models a two dimensional point in terms
 * of (x, y) coordinates.
 *
 * @author:  Dean Hendrix (dh@auburn.edu)
 * @version: 2015-09-23
 *
 */
public class Point implements Comparable<Point> {

  /** Compare points with respect to the slope each makes with this point. */
   public final Comparator<Point> SLOPE_ORDER = new ComparePointsBySlope();

  /** x,y coordinates of this point. */
   private int x;
   private int y;

   /** Create a point from the given x and y coordinates. */
   public Point(int x, int y) {
      this.x = x;
      this.y = y;
   }
   
   /** Plot this point to standard drawing. */
   public void draw() {
      // If you choose to use this, simply uncomment the following line.
      // StdDraw.point(x, y);
   }

   /** Draw a line between this point and that point to standard drawing. */
   public void drawTo(Point that) {
      // If you choose to use this, simply uncomment the following line.
      // StdDraw.line(this.x, this.y, that.x, that.y);
   }
   
   /** Return the slope between this point and that point. */
   public double slopeTo(Point that) {
      double xdiff = this.x - that.x;
      double ydiff = this.y - that.y;
      
	   //double slope = 0;
	   
      if (xdiff == 0 && ydiff == 0)
		   return Double.NEGATIVE_INFINITY;
	   if (ydiff == 0)
		   return 0.0;
	   if (xdiff == 0)
		   return Double.POSITIVE_INFINITY;
	   return ydiff/xdiff;
   }
   
  /** 
   * Indicate whether this point is less than, greater than, 
   * or equal to that point. Total order is defined first on
   * y values with ties being broken by x values.
   */
   @Override
   public int compareTo(Point that) {
      if((this.y < that.y) || (this.y == that.y && this.x < that.x))
    	  return -1;
      if((this.y > that.y) || (this.y == that.y && this.x > that.x))
    	  return 1;
       return 0;
   }
   
   /** 
    * Return true if this point's x and y coordinates are
    * the same as that point's x and y coordinates.
    * Return false otherwise.
    */
   @Override
   public boolean equals(Object obj) {
   // DO NOT MODIFY
      if (obj == this) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (!(obj instanceof Point)) {
         return false;
      }
      Point that = (Point) obj;
      return (this.x == that.x) && (this.y == that.y);
   }
    
   
   /** Return a string representation of this point. */
   @Override
   public String toString() {
    // DO NOT MODIFY
      return "(" + x + ", " + y + ")";
   }
   
   /**
    * Comparator used for SLOPE_ORDER.
    * Total order is defined by the slope that two points make
    * with this point.
    */
   private class ComparePointsBySlope implements Comparator<Point> {
   
   // compare by slope wrt to self
      public int compare(Point p1, Point p2) {
    	 double slope1 = slopeTo(p1);
    	 double slope2 = slopeTo(p2);
    	 if(slope1 < slope2) {
    		 return -1;
    	 }
    	 if(slope1 > slope2) {
    		 return 1;
    	 }
       return 0;
      }
   
   }
   
}
