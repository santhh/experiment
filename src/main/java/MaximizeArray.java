import java.util.Arrays;

public class MaximizeArray {
  //0(k) 0(n)
  public static int maxScore(int[] cardPoints, int k) {
    int maxScore = 0;
    int[] leftSum = new int[k+1];
    leftSum[0] = 0;
    int [] rightSum = new int [k+1];
    rightSum[0] = 0;
    int n = cardPoints.length;
    for (int i =1; i<leftSum.length; i++){
      leftSum[i] = leftSum[i-1] + cardPoints[i-1];
    }
    System.out.println("LS+"+Arrays.toString(leftSum));

    for (int i=1; i<rightSum.length; i++){
      rightSum[i] = rightSum[i-1] + cardPoints[n-i];
    }
    System.out.println("RS+"+ Arrays.toString(rightSum));
    for (int i =0; i<=k; i++){
      maxScore = Math.max(maxScore, leftSum[i] + rightSum[k-i]);
    }

    return maxScore;

  }
  // o(k), o(1)
  public  static int maxScore_1(int[] cardPoints, int k) {
    int maxSum =0;
    int sum = 0;
    int n = cardPoints.length;
    for (int i =0; i<k; i++) {
      sum += cardPoints[i];
    }
    maxSum = sum;
    for (int i =1; i<=k; i++){
      sum = sum + cardPoints[n-i] - cardPoints[k-i];
      maxSum = Math.max(sum, maxSum);
    }

    return maxSum;
  }

  public static void main (String args[]){
      int [] cardPoints = new int[]{1,2,3,4,5,6,1};
      int k = 3;
     System.out.println(maxScore(cardPoints,k));
      System.out.println(maxScore_1(cardPoints,k));
  }
}
