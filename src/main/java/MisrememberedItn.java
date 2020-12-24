import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultimap;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.IntStream;

class Cities{
    String city;
    int order;
    public Cities(String city, int order){
        this.city = city;
        this.order = order;
    }
}

class HeapEntry{
    int distance;
    Cities node;
    public HeapEntry (int distance, Cities node){
     this.distance = distance;
     this.node= node;
    }

}


public class MisrememberedItn {
    Set<String> cities;
    ImmutableMultimap<String,String> connectionGraph;
    HashMap<City, City> backtrack;
    public  int nameDistance(String s1, String s2){
        return IntStream.range(0, s1.length()).map(i->s1.charAt(i)==s2.charAt(i)?0:1).sum();
    }

    class City {
        String name;
        int index;
        public City(String name, int index){
            this.name = name;
            this.index = index;
        }
    }

    class HeapEntry{
        int distance;
        City city;
        public HeapEntry(int distance, City city){
            this.distance = distance;
            this.city = city;

        }

    }

    public MisrememberedItn(Collection<HashMap<String, String>> cityConnections){
        ImmutableMultimap.Builder connections = ImmutableMultimap.builder();
        cityConnections.forEach(cc->{
            cc.entrySet().forEach(c->{
                cities.add(c.getKey());
                cities.add(c.getValue());
                connections.put(c.getKey(),c.getValue());
                connections.put(c.getKey(),c.getValue());


            });
        });
        connectionGraph = connections.build();
        backtrack = new HashMap<>();
    }

    public List<String> findClosestRoute(List<String> itn){
      ImmutableList.Builder routeList = ImmutableList.builder();
      PriorityQueue<HeapEntry> minHeap = new PriorityQueue<>(Comparator.comparingInt(he->he.distance));
      cities.forEach(city->{
          minHeap.offer(new HeapEntry(nameDistance(city,itn.get(0)),new City(city,0)));
      });
      while (!minHeap.isEmpty()){
          HeapEntry currntState  = minHeap.poll();
          int index = currntState.city.index;
          if(index==itn.size()-1){
              while (index >= 0){
                  routeList.add(backtrack.get(currntState.city.name));
                  index --;
              }
              return routeList.build();
          }

          for (String nb : connectionGraph.get(currntState.city.name)){

              if(backtrack.containsKey(new City(nb,index+1))) continue;

              backtrack.put(new City(nb, index+1),currntState.city);

              minHeap.offer(new HeapEntry(currntState.distance+nameDistance(nb,itn.get(index+1)),
                  new City(nb,index+1)));

          }
      }


      return routeList.build();
    }


}
