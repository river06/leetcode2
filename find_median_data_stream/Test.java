import java.util.*;
public class Test {
	public static void main(String[] args) {
		MedianFinder solver = new MedianFinder();
        solver.addNum(1);
        System.out.println( solver.findMedian() );
        solver.addNum(2);
        System.out.println( solver.findMedian() );
        solver.addNum(3);
        System.out.println( solver.findMedian() );
	}
}
