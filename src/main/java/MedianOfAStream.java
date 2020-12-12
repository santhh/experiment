import java.util.*;

class MedianOfAStream {

  PriorityQueue<Integer> maxHeap;
  PriorityQueue<Integer> minHeap;
  public MedianOfAStream(){
    // largest value in top
    maxHeap= new PriorityQueue<>(Collections.reverseOrder());
   // smallest value in top
    minHeap = new PriorityQueue<>(Comparator.comparingInt(a->a));

  }
  public void insertNum(int num) {
    if(maxHeap.isEmpty()|| maxHeap.peek()>=num){
      maxHeap.offer(num);
    }else{
      minHeap.offer(num);
    }
    // rebalance
    if(maxHeap.size()>minHeap.size()+1){
        minHeap.offer(maxHeap.poll());
    }else if(maxHeap.size()<minHeap.size()){
      maxHeap.offer(minHeap.poll());
    }

  }

  public double findMedian() {
    if(maxHeap.size()==minHeap.size()){
      return (maxHeap.peek()+minHeap.peek())/2.0;

    }
    return maxHeap.peek();
  }

  public static void main(String[] args) {
    MedianOfAStream medianOfAStream = new MedianOfAStream();
    medianOfAStream.insertNum(3);
    medianOfAStream.insertNum(1);
    System.out.println("The median is: " + medianOfAStream.findMedian());
    medianOfAStream.insertNum(5);
    System.out.println("The median is: " + medianOfAStream.findMedian());
    medianOfAStream.insertNum(4);
    System.out.println("The median is: " + medianOfAStream.findMedian());
  }
}
