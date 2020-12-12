class MinimumDifference {

  public static int searchMinDiffElement(int[] arr, int key) {
    int minDiff = Integer.MAX_VALUE;
    int res=0;
    for (int i=0;i<arr.length;i++){
      int localDiff = key-arr[i]>=0?key-arr[i]:Integer.MAX_VALUE;
      if(minDiff>localDiff){
        minDiff = localDiff;
        res = arr[i];
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
  }
}
