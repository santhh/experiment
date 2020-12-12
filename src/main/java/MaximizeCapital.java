import java.util.*;

class MaximizeCapital {

  static PriorityQueue<Integer> minCapital = new PriorityQueue<>();
  static PriorityQueue<Integer> maxProfit = new PriorityQueue<>(Collections.reverseOrder());


  public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
    int maxCapital =initialCapital;
    for (int i=0;i<capital.length;i++){
      minCapital.offer(capital[i]);
    }
    for (int i=0; i<numberOfProjects;i++){
      while (!minCapital.isEmpty() && capital[minCapital.peek()]<=initialCapital){
        maxProfit.offer(minCapital.poll());
      }
      if(maxProfit.isEmpty()) break;
      maxCapital += profits[maxProfit.poll()];
      initialCapital += maxCapital;
    }



    return maxCapital;
  }

  public static void main(String[] args) {
    int result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1);
    System.out.println("Maximum capital: " + result);
    result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0);
    System.out.println("Maximum capital: " + result);
  }
}