public class HourGlass {
    /*1 1 1 0 0 0
    0 1 0 0 0 0
    1 1 1 0 0 0
    0 0 2 4 4 0
    0 0 0 2 0 0
    0 0 1 2 4 0*/
    static int[][] arr = new int[][]{
        { 1, 1, 1, 0, 0, 0 },
        { 0, 1, 0, 0, 0, 0 },
        { 1, 1, 1, 0, 0, 0 },
        { 0, 0, 2, 4, 4, 0 },
        { 0, 0, 0, 2, 0, 0 },
        { 0, 0, 1, 2, 4, 0 }
    };

  public static void main (String args[]) {

      int maxSum = Integer.MIN_VALUE;
      int r = 6;
      int c = 6;

      for (int i =0; i<r-2;i++){
        int localSum =0;
        for (int j=0; j<c-2;j++){
          localSum = (arr[i][j]+arr[i][j+1]+arr[i][j+2])
              +(arr[i+1][j+1])
              +(arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2]);
          maxSum = Math.max(maxSum,localSum);
        }

      }

      System.out.println(maxSum);




  }


 }