class TwoSum {

 
    List<Integer> list;
    
    /** Initialize your data structure here. */
    public TwoSum() {
       list = new ArrayList<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        list.add(number);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
       Set set = new HashSet<>();
        for (int num : list){
          if(set.contains(value-num)){
              return true;
          }else{
              set.add(num);
          }
      }
      return false;  
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */