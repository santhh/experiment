class Solution {
    public int[][] indexPairs(String text, String[] words) {
     
        List<int []> result = new ArrayList<>();
        for (String word: words){
            int start =0;
            while(text.indexOf(word, start) >=0){
                int index = text.indexOf(word, start);
                result.add(new int[]{index, index + word.length()-1});
                start = index+1;
            }
        }
     
        result.sort((a, b) -> a[0] - b[0] == 0 ? (a[1] - b[1]) : (a[0] - b[0]));
        return result.toArray(new int[0][0]);
        
 
    }
}