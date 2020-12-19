// import java.util.*;
//
//
// class Element {
//   int row ;
//   int col;
//   public Element(int row, int col){
//     this.row = row;
//     this.col = col;
//   }
// }
// class KthSmallestInSortedMatrix {
//
//
//   public static int findKthSmallest(int[][] matrix, int k) {
//     int result = 0;
//     int count =0;
//     PriorityQueue<Element> minHeap = new PriorityQueue<>(
//         Comparator.comparingInt(e -> matrix[e.row][e.col]));
//
//      for (int i=0; i<matrix.length;i++){
//        minHeap.offer(new Element(i,0));
//      }
//
//      while (!minHeap.isEmpty()){
//        Element current = minHeap.poll();
//        result = matrix[current.row][current.col];
//        if(++count==k){
//          break;
//        }
//        current.col++;
//        if(matrix[current.row].length>current.col){
//          minHeap.offer(new Element(current.row,current.col));
//        }
//      }
//
//     return result;
//   }
//
//   public static void main(String[] args) {
//     int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
//     int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 5);
//     System.out.print("Kth smallest number is: " + result);
//   }
// }
