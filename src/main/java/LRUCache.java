import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {

  Map<Integer, Integer> map;
  Deque<Integer> queue;
  int size;
  public LRUCache(int capacity) {
    map = new HashMap<>();
    queue = new LinkedList<>();
    size = capacity;

  }

  public int get(int key) {
    if(map.containsKey(key)){
      queue.remove(key);
      queue.addFirst(key);
      return map.get(key);
    }
    return -1;
  }

  public void put(int key, int value) {
    queue.remove(key);
    queue.addFirst(key);
    if(queue.size()>size){
      int n = queue.removeLast();
      map.remove(n);
    }
       map.put(key,value);
  }
}