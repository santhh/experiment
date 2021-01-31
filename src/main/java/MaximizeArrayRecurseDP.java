public class MaximizeArrayRecurseDP {
  static int [][] dp;

  public MaximizeArrayRecurseDP( int n) {
    dp = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        dp[i][j] = -1;
      }
    }
  }
  public static int recurse (int left, int right, int[] cardPoints, int[] multiplier, int k){
     int index =  cardPoints.length - (right - left + 1);
     if(index == k) return 0;
     return Math.max(recurse(left+1,right,cardPoints,multiplier,k)+cardPoints[left] * multiplier[index],
         recurse(left,right-1,cardPoints,multiplier,k)+cardPoints[right] * multiplier[index]);
  }

  public static int recurseWithDp (int left, int right, int[] cardPoints, int[] multiplier, int k){
    if(dp[left][right] != -1){
      return dp[left][right];
    }
    int index =  cardPoints.length - (right - left + 1);
    if(index == k) return 0;
    dp[left][right] = Math.max(recurse(left+1,right,cardPoints,multiplier,k)+cardPoints[left] * multiplier[index],
        recurse(left,right-1,cardPoints,multiplier,k)+cardPoints[right] * multiplier[index]);
    return  dp[left][right];
  }

  public static void main (String args[]){
    int [] cardPoints = new int[]{1,2,3,4,5,6,1};
    int [] multiplier = new int[]{2,3,4};
    int k = 3;
    int n = cardPoints.length ;
    new MaximizeArrayRecurseDP(n);
    System.out.println(recurse(0, n-1, cardPoints,multiplier,k));
    System.out.println(recurseWithDp(0, n-1, cardPoints,multiplier,k));

  }
}
