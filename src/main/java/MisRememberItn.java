import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.IntStream;

class City{
  Set<String> cityNames;
  ImmutableMultimap<String, String> connections;
  PriorityQueue<HeapElement> minHeap = new PriorityQueue<>(Comparator.comparingInt(e->e.distance));

  public City(Map<String,String> cities){
    ImmutableMultimap.Builder builder = ImmutableMultimap.builder();
    for (Map.Entry<String,String> city : cities.entrySet()){
      cityNames.add(city.getKey());
      cityNames.add(city.getValue());
      builder.put(city.getKey(),city.getValue());
      builder.put(city.getValue(),city.getKey());
    }
    connections = builder.build();

  }

  public List<String> closestRoute(List<String> itn){
    List<String> result = new ArrayList<>();
    for (String city : itn){
      minHeap.add(new HeapElement(ImmutableList.of(city),findDistance(city,itn.get(0))));
    }
    while (!minHeap.isEmpty()){

      HeapElement e = minHeap.poll();
      if(e.partialItn.size()==itn.size()){
        return e.partialItn;
      }
      String currCity = e.partialItn.get(0);
      String nxtCity= e.partialItn.get(e.partialItn.size()-1);
      for (String neighbour : connections.get(currCity)){
        ImmutableList.Builder builder = ImmutableList.builder();
        builder.addAll(e.partialItn);
        builder.add(neighbour);
        int distance = e.distance + findDistance(neighbour,nxtCity);
        minHeap.add(new HeapElement(builder.build(),distance));

      }
    }
    return result;
  }
  public static int findDistance(String city1, String city2) {
    return IntStream.range(0, city1.length()).map(i -> city1.charAt(i) == city2.charAt(i) ? 0 : 1)
        .sum();
  }
}

class HeapElement {
  List<String> partialItn;
  int distance;
  public HeapElement(List<String> itn, int distance){
    this.partialItn =itn;
    this.distance = distance;
  }
}




public class MisRememberItn {

  public static void main (String args[]){

  }



}
