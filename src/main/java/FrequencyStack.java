import java.util.*;

class FrequencyStack  {




  class E {
    int value;
    int frequency;
    int sequence;

    public E(int value, int frequency, int sequence ){
      this.value = value;
      this.frequency = frequency;
      this.sequence = sequence;

    }
  }

  class EComparator implements Comparator<E>{

    @Override
    public int compare(E o1, E o2) {
      if(o1.frequency!=o2.frequency){
        return o2.frequency - o1.frequency;
      }else{
        return o2.sequence - o1.sequence;
      }
    }
  }
  PriorityQueue<E> maxHeap;
  Map<Integer,Integer> charMap;
  static int sequence=0;
  public FrequencyStack(){
      maxHeap =  new PriorityQueue<>(new EComparator());
      charMap = new HashMap<>();
  }

  public void push(int num) {
    charMap.put(num, charMap.getOrDefault(num, 0)+ 1);
    maxHeap.offer(new E(num, charMap.get(num),sequence++));
  }

  public int pop() {
    E temp = maxHeap.poll();
    if(charMap.get(temp.value)>1) {
      charMap.put(temp.value, charMap.getOrDefault(temp.value, 0)- 1);
    }else{
      charMap.remove(temp.value);
    }
    return temp.value;
  }

  public static void main(String[] args) {
    FrequencyStack frequencyStack = new FrequencyStack();
    frequencyStack.push(1);
    frequencyStack.push(2);
    frequencyStack.push(3);
    frequencyStack.push(2);
    frequencyStack.push(1);
    frequencyStack.push(2);
    frequencyStack.push(5);
    System.out.println(frequencyStack.pop());
    System.out.println(frequencyStack.pop());
    System.out.println(frequencyStack.pop());
  }
}