import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest {

  public static void main (String args[]){
    List<String> words = ImmutableList.of("hello", "world", " ");
    words.stream().filter(s->s.length()>0).count();
     Map<Integer,Integer> countMap = new HashMap<>();
    countMap.entrySet().stream()
        .sorted(Map.Entry.<Integer,Integer>comparingByValue().reversed())
        .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldValue, newValue)-> oldValue,
            LinkedHashMap::new)).forEach((k,v)->System.out.println(k));


    List<Integer> list = ImmutableList.of(1,2,3);
    list.stream().mapToInt(Integer::intValue).sum();



  }
}
