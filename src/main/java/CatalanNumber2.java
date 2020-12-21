public class CatalanNumber2 {

  public static int recurseFact(int n){
      int fact = 1;
      while(n > 1)
      {
        fact *= n;
        n -= 1;
      }
      return fact;
    }

  public static int calculateCatalaNumber(int n){
      return  recurseFact(2*n)/(recurseFact(n+1)* recurseFact(n));
  }
  public static int totalBST(int [] arr) {
    int sum =0;
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      int smallerThanRoot = 0;
      for (int j = 0; j < n; j++) {
        if (arr[j] < arr[i]) {
          smallerThanRoot +=1;
        }
      }
      long leftBst = calculateCatalaNumber(smallerThanRoot);
      long rightBst = calculateCatalaNumber(n - smallerThanRoot - 1);
      sum += leftBst*rightBst;
    }
    return sum;
  }

  public static void main (String args[]){
    int [] arr1 = { 20, 10, 30 };
    int []arr2 = { 1, 2, 3, 4, 5 };
    System.out.println(totalBST(arr1));
    System.out.println(totalBST(arr2));
  }
}
