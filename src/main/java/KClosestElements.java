import java.util.*;

class Entry {
  int key;
  int value;

  public Entry(int key, int value) {
    this.key = key;
    this.value = value;
  }
}

class KClosestElements {

  public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {
    List<Integer> result = new ArrayList<>();
    int indexFoundElement = binarySearch(arr, 0, arr.length-1, X);
    int low =  Math.max(0,indexFoundElement - K);
    int high = Math.min(arr.length-1, indexFoundElement + K);
    PriorityQueue<Entry> minHeap = new PriorityQueue<>((a,b)->(a.value==b.value)?0:a.value-b.value);
    for (int i=low; i<=high;i++){
      minHeap.offer(new Entry(arr[i], Math.abs(X-arr[i])));
    }
    for (int i=0; i<K; i++){
      result.add(minHeap.poll().key);
    }
    Collections.sort(result);
    return result;
  }
  public static int binarySearch(int[] arr, int start, int end, int target){
    while (start<=end){
      int mid = start + (end - start)/2;
      if(target > arr[mid]){
        start =  mid+1;
      }else if(target < arr[mid]){
        end = mid -1;
      }else {
        return mid;
      }
    }

    if (start > 0) {
      return start - 1;
    }
    return start;
  }

  public static void main(String[] args) {
    List<Integer> result = KClosestElements.findClosestElements(new int[] { 0,0,1,2,3,3,4,7,7,8 }, 3, 5);
    System.out.println("'K' closest numbers to 'X' are: " + result);

    // result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
    // System.out.println("'K' closest numbers to 'X' are: " + result);
    // //
    //  result =  KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
    // System.out.println("'K' closest numbers to 'X' are: " + result);
  }
}