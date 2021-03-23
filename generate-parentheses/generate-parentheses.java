class Solution {
   
   
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();  
        backtrack(result, "", n, 0, 0);
        return result;
        
    }
    public void backtrack(List<String> result, String combine, int n, int open, int close){
        if(combine.length()==n *2){
            result.add(combine);
            return;
        }
        if(open < n){
            backtrack(result, combine +"(",n, open +1, close);
        }
        if(close < open){
             backtrack(result, combine+ ")",n, open, close + 1);
        }
        
    }
  
}