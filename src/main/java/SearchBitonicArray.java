class SearchBitonicArray {

  public static int search(int[] arr, int key) {
    int result = -1;
    int start =0;
    int end = arr.length-1;
    int indexMaxNum=findMaxElementIndex(arr);
    result = searchElement(arr, start,indexMaxNum,key);
    if(result < 0){
      result = searchElement(arr, indexMaxNum+1,end,key);
    }
    return result;
  }
  public static int searchElement(int[] arr, int start, int end, int target){

    while (start<=end){
      int mid = start + (end - start) /2;
      if(target > arr[mid]){
        start = mid + 1;
      }else if (target < arr[mid]){
        end = mid - 1;
      }else{
        return mid;
      }
    }

    return -1;
  }

  public static int findMaxElementIndex(int[] arr){
    int start = 0;
    int end = arr.length-1;
    while (start<end){
      int mid = start + (end - start) /2;
      if(arr[mid] > arr[mid+1]){
        end =mid;
      }else{
        start = mid+1;
      }

    }
    return start;
  }



  public static void main(String[] args) {
    System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 4, 3 }, 4));
    System.out.println(SearchBitonicArray.search(new int[] { 3, 8, 3, 1 }, 8));
    System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 12 }, 12));
    System.out.println(SearchBitonicArray.search(new int[] { 10, 9, 8 }, 10));
  }
}