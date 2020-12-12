class SearchRotatedArray {

  public static int search(int[] arr, int key) {
    int start = 0;
    int end = arr.length-1;
    int mid = start +(end -start) /2;
    int result = -1;

      if (arr[mid] > arr[start]) {
          end = mid-1;
          if(key>=arr[start] && key<=arr[mid]){
            result = searchElement(arr, key, start, end);
          }else{

          }


      } else {


      }



    return result;
  }

  public static int searchElement(int[] arr, int key, int start, int end){
    while (start <= end){
      int mid = start + (end - start) /2;
      if(key > arr[mid]){
        start = mid + 1;

      }else if (key < arr[mid] ){
        end = mid-1;
      } else{
        return mid;
      }


    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(SearchRotatedArray.search(new int[] { 10, 15, 1, 3, 8 }, 15));
    System.out.println(SearchRotatedArray.search(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
  }
}
