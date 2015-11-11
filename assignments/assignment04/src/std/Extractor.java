//package std;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

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
   Scanner s = null;
   private SortedSet<Point> points;
     
   /**
    * Builds an extractor based on the points in the
    * file named by filename. 
    */
   public Extractor(String filename) throws IOException {
	   File file = new File(filename);
	   int count = Integer.MAX_VALUE;
	   points = new TreeSet<Point>();
	   try {
		   s = new Scanner(new BufferedReader(new FileReader(file)));
		   while(s.hasNext()) {
			   for(int i = 0; i < count; i++) {
				   if(i == 0) {
					   count = s.nextInt();
				   }
				   System.out.println("" + count);
				   int x = s.nextInt();
				   int y = s.nextInt();
				   //System.out.println("" + x + ", " + y);
				   points.add(new Point(x,y));
			   }
			   //System.out.println(s.next());
		   } 
	   } finally {
		   if(s != null) {
			   s.close();
		   }
	   
	   }
   }
  
   /**
    * Builds an extractor based on the points in the
    * Collection named by pcoll. 
    */
   public Extractor(Collection<Point> pcoll) {
	   points = new TreeSet<Point>(pcoll);
   }
  
   /**
    * Returns a sorted set of all line segments of exactly four
    * collinear points. Uses a brute-force combinatorial
    * strategy. Returns an empty set if there are no qualifying
    * line segments.
    */
   public SortedSet<Line> getLinesBrute() {
	  ArrayList<Point> al = new ArrayList<Point>(points);
	  TreeSet<Line> lines = new TreeSet<Line>();
      for(int i = 0; i < al.size(); i++) {
    	  for(int j = i + 1; j < al.size(); j++) {
    		  double slope1 = al.get(i).slopeTo(al.get(j));
    		  for(int k = j + 1; k < al.size(); k++) {
    			  double slope2 = al.get(j).slopeTo(al.get(k));
    			  for(int w = k + 1; w < al.size(); w++) {
    				  double slope3 = al.get(k).slopeTo(al.get(w));
    				  if(slope3 == slope2 && slope2 == slope1) {
    					  TreeSet<Point> p = new TreeSet<Point>();
    					  p.add(al.get(i));
    					  p.add(al.get(j));
    					  p.add(al.get(k));
    					  p.add(al.get(w));
    					  System.out.println("" + slope1 + ", " + slope2 + ", " + slope3);
    					  lines.add(new Line(p));
    				  }
    			  }
    		  }
    	  }
      }
	  return lines;
   }
  
   /**
    * Returns a sorted set of all line segments of at least four
    * collinear points. The line segments are maximal; that is,
    * no sub-segments are identified separately. A sort-and-scan
    * strategy is used. Returns an empty set if there are no qualifying
    * line segments.
    */
   public SortedSet<Line> getLinesFast() {
	   TreeSet<Point> copy = new TreeSet<Point>(points);
	   TreeSet<Line> lines = new TreeSet<Line>();
	   Iterator<Point> it = copy.iterator();
	   int counter = 0;
	   while(it.hasNext()) {
		   counter++;
		   Point p = it.next();
		   //TreeSet<Point> tree = new TreeSet<Point>(p.SLOPE_ORDER);
		   ArrayList<Point> tree = new ArrayList<Point>(copy);
		   Collections.sort(tree, p.SLOPE_ORDER);
		   /*for(Point o : tree2) {
			   tree.add(o);
		   }*/
		   System.out.println("Tree " + tree);
		   TreeSet<Point> pointC = new TreeSet<Point>();
		   //pointC.add(tree.get(0));
		   Iterator<Point> it2 = tree.iterator();
		   Point prevPoint = null;
		   double prevSlopeTo = Integer.MAX_VALUE;
		   while(it2.hasNext()) {
			   System.out.println("");
			   System.out.println(" ?? ");
			   Point p2 = it2.next();
			   double slopeTo = p2.slopeTo(p);
			   //System.out.println("prevPoint: " + prevPoint + " prevSlope " + prevSlope);
			   /*if(prevPoint != null) {
				   slopeTo = p2.slopeTo(prevPoint);
				   System.out.println("prev Check works");
			   }*/
			   System.out.println("point: " + p2 + " slope " + slopeTo);
			   System.out.println("prevPoint: " + prevPoint + " prevSlope " + prevSlopeTo);
			   if(slopeTo == prevSlopeTo) {
				   System.out.println("addpoint");
				   pointC.add(p2);
			   }
			   else {
				   if(pointC.size() >= 4) {
					   lines.add(new Line(pointC));
					   System.out.println("Lines : " + lines);
				   }
				   pointC = new TreeSet<Point>();
				   pointC.add(p);
				   pointC.add(p2);
				   System.out.println("Is else running?");
			   }
			   prevPoint = p2;
			   prevSlopeTo = slopeTo;
		   }
		   if(pointC.size() >= 4) {
			   lines.add(new Line(pointC));
			   System.out.println("Lines : " + lines);
		   }
		   pointC = new TreeSet<Point>();
		   System.out.println("Is else running?");
		   it.remove();
		   System.out.println("Copy : " + copy);
	   }
	   System.out.println("Counter " + counter + " Size " + points.size());
	   return lines;
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
