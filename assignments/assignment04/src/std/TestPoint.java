package std;
import java.io.*;
import java.util.SortedSet;
import java.util.TreeSet;

public class TestPoint {
	public static void main(String[] args) {
		/*Point p = new Point( 1, 2);
		Point p2 = new Point( 7, 6);
		System.out.println("Slope 1 : " + p.slopeTo(p2));
		//p.ComparePointsBySlope.compare(p2, p);
		p.SLOPE_ORDER.compare(p2, p);*/
		try {
			Extractor ext = new Extractor("grid4x4.txt");
			//TreeSet<Line> l = new TreeSet<Line>(ext.getLinesBrute());
			TreeSet<Line> p = new TreeSet<Line>(ext.getLinesFast());
			//System.out.println("" + l);
			System.out.println("" + p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
