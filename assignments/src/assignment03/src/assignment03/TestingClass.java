package assignment03;
import files.TimingLab;

public class TestingClass {
	
	public static void main(String[] args)
	{
		double BILLION = 1000000000d; // nanoseconds to seconds
	    double start = 0;         // start time of the current run
	    double elapsedTime = 0;   // elapsed time of current run
	    double prevTime = 0;      // elapsed time of previous run
	    double ratio = 1;         // currentTime / prevTime
	    double lgratio = 0;       // log base 2 of ratio
	    int N = 1;                // problem size parameter
	    int key = 23;             // selects internal method of RunningTime
		
	    //TimingLab four = new TimingLab(24);
	    for(int x = 71; x >= 0; x--) {
		    TimingLab tl = new TimingLab(x);
		    System.out.println("Time complexity for Key: " + x);
		    System.out.println("");
		    for(int i = N; i <= 1024; i = i*2) {
		    	start = System.nanoTime();
		    	tl.timeTrial(i);
		    	elapsedTime = (System.nanoTime() - start) / BILLION;
		    	System.out.print("This call to method TimingLab.timeTrial("
		    		+ i + ") took ");
		    	System.out.printf("%4.3f", elapsedTime);
		    	System.out.println(" seconds.");
		    	if(prevTime != 0) {
		    		ratio = elapsedTime/prevTime;
		    		System.out.println("R = " + ratio);
		    		System.out.println("K = " + (Math.log10(ratio)/Math.log10(2)));
		    	}
		    	prevTime = elapsedTime;
		    }
		    prevTime = 0;
		    System.out.println("");
	    }
		    
	}

}
