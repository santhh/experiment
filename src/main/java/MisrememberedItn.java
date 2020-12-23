import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
    ImmutableMultimap<String, String> cityGraph;
    Map<Cities, Cities> backconnection;
    PriorityQueue<HeapEntry>  minHeap = new PriorityQueue<>(Comparator.comparingInt(d->d.distance));
    public static int calculateDistance(String c1, String c2){
        if(c1.length()!=c2.length()){ return -1; }
        return IntStream.range(0,c1.length()).map(i->c1.charAt(i)==c2.charAt(i)?0:1).sum();
    }

    public MisrememberedItn(Collection<HashMap<String, String>> cityConnections){
        ImmutableMultimap.Builder<String, String> connectionnBuilder = ImmutableMultimap.builder();
        cityConnections.forEach(city->{
            city.entrySet().forEach(c->{
                cities.add(c.getKey());
                cities.add(c.getValue());
                connectionnBuilder.put(c.getKey(), c.getValue());
                connectionnBuilder.put(c.getValue(), c.getKey());
            });
        });

        cityGraph =connectionnBuilder.build();
        backconnection = new HashMap<>();

    }

    public List<String> findClosestRoute(List<String> itn){
        ImmutableList.Builder listBuilder = ImmutableList.builder();
        if(itn.isEmpty()){
            return listBuilder.build();
        }

        cities.forEach(city->{
            minHeap.offer(new HeapEntry(calculateDistance(city,itn.get(0)),new Cities(city,0)));
        });
        while (!minHeap.isEmpty()){

            HeapEntry current = minHeap.poll();
            if(current.node.order==itn.size()-1){

                int index = current.node.order;
                Cities currentCity  = current.node;
                while (index>=0){
                    listBuilder.add(backconnection.get(currentCity));
                    index --;
                }
                return listBuilder.build();

            }

            for (String nb : cityGraph.get(current.node.city)){

                if(backconnection.containsKey(new Cities(nb,current.node.order+1))){
                    continue;
                }
                backconnection.put(new Cities(nb,current.node.order+1),current.node);

                minHeap.offer(new HeapEntry(current.distance+calculateDistance(nb,
                    itn.get(current.node.order+1)),new Cities(nb,current.node.order+1)));


            }
        }


        return listBuilder.build();
    }


}
