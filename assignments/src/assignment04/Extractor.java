import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Extractor.java. Implements feature extraction for collinear points in
 * two dimensional data.
 *
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 2015-09-23
 *
 */
public class Extractor {
   
  /** resolution settings for stdlib drawing. */
   private static int HI_RES = 32768;
   private static int LO_RES = 32;
     
   /**
    * Builds an extractor based on the points in the
    * file named by filename. 
    */
   public Extractor(String filename) {
   }
  
   /**
    * Builds an extractor based on the points in the
    * Collection named by pcoll. 
    */
   public Extractor(Collection<Point> pcoll) {
   }
  
   /**
    * Returns a sorted set of all line segments of exactly four
    * collinear points. Uses a brute-force combinatorial
    * strategy. Returns an empty set if there are no qualifying
    * line segments.
    */
   public SortedSet<Line> getLinesBrute() {
      return null;
   }
  
   /**
    * Returns a sorted set of all line segments of at least four
    * collinear points. The line segments are maximal; that is,
    * no sub-segments are identified separately. A sort-and-scan
    * strategy is used. Returns an empty set if there are no qualifying
    * line segments.
    */
   public SortedSet<Line> getLinesFast() {
      return null;
   }
  
  // Draw all points to a graphics window. 
   public void drawPoints() {
   // optional
   }
  
  // Draw all identified lines, if any, to a graphics window. 
   public void drawLines() {
   // optional
   }
      
}
