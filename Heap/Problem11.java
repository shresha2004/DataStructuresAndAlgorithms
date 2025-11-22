//Problem:https://leetcode.com/problems/find-median-from-data-stream/description/
import java.util.*;
class MedianFinder {
    PriorityQueue<Integer> leftHeap;
    PriorityQueue<Integer> rightHeap;
    public MedianFinder() {
      leftHeap = new PriorityQueue<>((a,b)->b-a);
      rightHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
     if(leftHeap.isEmpty() || leftHeap.peek()>=num)
            leftHeap.offer(num);
    else rightHeap.offer(num);

    if(leftHeap.size()>rightHeap.size()+1)
        rightHeap.offer(leftHeap.poll());
    else if(rightHeap.size()>leftHeap.size()) leftHeap.offer(rightHeap.poll());

    }
    
    public double findMedian() {
        if(leftHeap.size()>rightHeap.size()) return leftHeap.peek();
        else return (leftHeap.peek()+rightHeap.peek())/2.0;
    }
}
public class Problem11 {
public static void main(String[] args) {
    
    MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
System.out.println("Solution:"+medianFinder.findMedian()); // return 2.0
 
}
}
