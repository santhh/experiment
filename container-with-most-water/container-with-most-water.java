class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left =0;
        int right = height.length-1;
        while (left < right){
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            maxArea = Math.max(maxArea, h*w);
            if(height[left] <= height[right]){
                left ++;
            }else{
                right --;
            }
        }
        return maxArea;
    }
}


// class Solution {
//     public int maxArea(int[] height) {
//         int maxArea = 0;
//         int n = height.length;
//         for (int i =0; i<n; i++){
//             for (int j =i+1; j< n; j++){
//                 int h = Math.min(height[i], height[j]);
//                 int w = j -i;
//                 maxArea = Math.max(h * w, maxArea);
//             }
          
//         }
//         return maxArea;
//     }
// }