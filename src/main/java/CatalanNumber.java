public class CatalanNumber {

  public static int findNCatalan(int n) {
    if( n<=0){
      return 0;
    }
    int[] result = new int[n + 1];
    result[0] = 1;
    result[1] = 1;
    for (int i = 2; i <= n; i++) {
      result[i] = 0;
      for (int j = 0; j < i; j++) {
        result[i] += result[j] * result[i - j - 1];
      }
    }
      return result[n];

  }
  public static void main (String args[]){
    int arr[] = {20,10,30};
    int sum =0;
    for (int i=0; i<arr.length;i++) {
      sum +=findNCatalan(arr[i]);

    }
    System.out.println(sum);
  }
}
