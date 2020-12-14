import java.util.*;

class ConnectRopes {

  public static int minimumCostToConnectRopes(int[] ropeLengths) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int result =0;
    for (int ropeLength :  ropeLengths){
      minHeap.offer(ropeLength);
    }

   while (minHeap.size()>1){
     int temp = minHeap.poll()+minHeap.poll();
     result += temp;
     minHeap.offer(temp);
   }

    return result;
  }

  public static void main(String[] args) {
    int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
    System.out.println("Minimum cost to connect ropes: " + result);
    result = ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
    System.out.println("Minimum cost to connect ropes: " + result);
    result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
    System.out.println("Minimum cost to connect ropes: " + result);
  }
}
