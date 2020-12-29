import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BannedIP {
   Map<String,Boolean> map;
   Deque<String> que;
   int size;

   public BannedIP(){
     map = new HashMap<>();
     que = new LinkedList<>();
     size =3;

   }

   public boolean get(String key){
     if(map.containsKey(key)){
       que.remove(key);
       que.addFirst(key);
       return map.get(key);
     }
     return true;
   }
   public void put(String key,  boolean value){
     que.remove(key);
     que.addFirst(key);
     if (que.size()>size){
       map.remove(que.removeLast());
     }
     map.put(key, value);
   }
  boolean IsGood(String address){
    boolean found= get(address);
     if(!found){
      put(address, true);
    }
    return found;

  }
  public static void main (String args[]){
    BannedIP lruCache = new BannedIP();
     System.out.println(lruCache.IsGood("ip1"));
     System.out.println(lruCache.IsGood("ip2"));
     System.out.println(lruCache.IsGood("ip1"));
  }
}
