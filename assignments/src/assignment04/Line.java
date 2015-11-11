import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Line.java
 * Models a line segment as a Set of Points.
 *
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2015-09-23
 *
 */
public class Line implements Comparable<Line>, Iterable<Point> {
 
   SortedSet<Point> line;
   
   /** Creates a new line with no points. */
   public Line() {
   }
   
   /** Creates a new line with all distinct collinear points in c. */
   public Line(Collection<Point> c) {
   }
 
   /** Adds p to this line if distinct and collinear with current points. */
   public boolean add(Point p) {
      return false;
   }
   
   /** Returns the first (minimum) point on this line. */
   public Point first() {
      return null;
   }
   
   /** Returns the last (maximum) point on this line. */
   public Point last() {
      return null;
   }
   
   /** Returns the number of points on this line. */
   public int length() {
      return Integer.MIN_VALUE;
   }
    
  // compare this point to that point
   @Override
   public int compareTo(Line that) {
      return Integer.MIN_VALUE;
   }
   
  // provide an iterator over all the points on this line
   @Override
   public Iterator<Point> iterator() {
      return null;
   }
   
   /** 
    * Return true if this point's x and y coordinates are
    * the same as that point's x and y coordinates.
    * Return false otherwise.
    */
   @Override 
   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (!(obj instanceof Line)) {
         return false;
      }
      Line that = (Line) obj;
      return (this.first().equals(that.first())) && (this.last().equals(that.last()));
   }
 
  // return this line as a String
   @Override
   // DO NOT MODIFY
   public String toString() {
      StringBuilder s = new StringBuilder();
      for (Point p : line) {
         s.append(p + " -> ");
      }
      s = s.delete(s.length() - 4, s.length());
      return s.toString();
   }
 
}
