class Solution {
    public int calculateTime(String keyboard, String word) {
        int result = 0;
        Map<Character, Integer> keyBoardMap = new HashMap<>();
        int index =0;
        for (char c : keyboard.toCharArray()){
            keyBoardMap.put(c,index++);
        }
        int current =0;
        for (char c : word.toCharArray()){
            result += Math.abs(keyBoardMap.get(c) - current);
            current = keyBoardMap.get(c); 
        }
        return result;
    }
}