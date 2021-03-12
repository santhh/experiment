class MaxStack {

    Stack<Integer> stack;
    PriorityQueue<Integer> pq;  

    /** initialize your data structure here. */
    public MaxStack() {
     stack = new Stack<>();   
     pq = new PriorityQueue<>(Collections.reverseOrder());  
    }
    
    public void push(int x) {
        pq.offer(x);
        stack.push(x);
    }
    
    public int pop() {
        int value = stack.pop();
        pq.remove(value);
        return value;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return pq.peek();
    }
    
    public int popMax() {
       Stack <Integer> temp = new Stack<>();
       int max = pq.poll(); 
      while (!stack.isEmpty()){
         if(stack.peek() != max){
             temp.push(stack.pop());
         }else{
             stack.pop();
             break;
         } 
      }
        
      while (!temp.isEmpty()){
          stack.push(temp.pop());
      }
     return max;
       
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */