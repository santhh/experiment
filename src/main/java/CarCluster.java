import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarCluster {

  public static List<Integer> getClusterSize(List<Integer> speedList){
      List<Integer> clusterSize = new ArrayList<>();
      int currentSpeed = speedList.get(0);
      int currentCluster =1;
      for (int i =1; i<speedList.size();i++){
        if(speedList.get(i)<currentSpeed){
          clusterSize.add(currentCluster++);
          currentSpeed= speedList.get(i);
          currentCluster =0;

        }
        currentCluster++;
      }

      clusterSize.add(currentCluster);
      return clusterSize;
  }
  public static void main (String srgs[]){
      System.out.println(getClusterSize(Arrays.asList(2,4,1,3)));
  }
}
