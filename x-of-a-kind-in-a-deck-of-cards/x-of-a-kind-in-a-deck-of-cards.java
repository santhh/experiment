class Solution {
    public int gcd (int n1, int n2){
        if(n2==0) return n1;
        return gcd(n2, n1 % n2);
    }
    public boolean hasGroupsSizeX(int[] deck) {
       if(deck.length < 2) return false;
        Map<Integer,Integer> map = new HashMap<>();
        int minValue  = Integer.MAX_VALUE;
        for (int i =0;  i< deck.length; i++){
            map.put(deck[i], map.getOrDefault(deck[i],0)  +1);
        }
        List<Integer> feqList = map.values().stream().collect(Collectors.toList());
        int temp = feqList.get(0);
        for (int i =1; i< feqList.size();i++){
             temp=  gcd(temp, feqList.get(i));
        }
        
        return temp > 1;
    }
}