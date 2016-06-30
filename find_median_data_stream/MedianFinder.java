import java.util.*;

public class MedianFinder {
    MedianFinder() {
        min_heap = new PriorityQueue<Integer>(); // a minimum heap for storing the large values
        max_heap = new PriorityQueue<Integer>(100, new InverseComparator() ); // a maximum heap for storing the small values
    }
    
    private PriorityQueue<Integer> min_heap;
    private PriorityQueue<Integer> max_heap;
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        int size1 = max_heap.size();
        int size2 = min_heap.size();
        if(size1 == 0){
            max_heap.add(num);
        } else if (size2 == 0) {
            if( num < max_heap.peek()) {
                int tmp = max_heap.poll();
                max_heap.add(num);
                min_heap.add(tmp);
            } else {
                min_heap.add(num);
            }
        } else {
            int n1 = max_heap.peek();
            int n2 = min_heap.peek();
            if( num>=n1 && num<=n2) {
                if( size1 <= size2 ) {
                    max_heap.add(num);
                } else {
                    min_heap.add(num);
                }
            } else if (num< n1) {
                max_heap.add(num);
            } else {
                min_heap.add(num);
            }
            if( max_heap.size() - min_heap.size() == 2) min_heap.add( max_heap.poll());
            if( min_heap.size() - max_heap.size() == 2) max_heap.add( min_heap.poll());
        }
    }
    
    // Returns the median of current data stream
    public double findMedian() {
        double ret;
        if( min_heap.size() == max_heap.size()) {
            ret = (double)(max_heap.peek() + min_heap.peek())/2;
        } else if (max_heap.size() > min_heap.size() ) {
            ret = max_heap.peek();
        } else {
            ret = min_heap.peek();
        }
        return ret;
    }
    
}

class InverseComparator implements Comparator<Integer> {
    @Override // just a notation to tell the compiler what to do
    public int compare(Integer int1, Integer int2) {
        return int1 < int2 ? 1 : int1==int2 ? 0 : -1;
    }
}
                         

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();