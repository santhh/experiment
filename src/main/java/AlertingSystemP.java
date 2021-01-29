import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;

public class AlertingSystemP {


  public static boolean isAlertQ1(List<Double> rates, int timestamp, int interval, double minThreshold){

    int errorWindLen = 0;
    int time = Math.max(0, timestamp-interval);
    int n = rates.size() ;
    while (errorWindLen < interval &&  time < timestamp + interval && time < n){
      if(rates.get(time) >= minThreshold){
        errorWindLen +=1;
      }else {
        errorWindLen =0;
      }
      time +=1;
    }

    return errorWindLen >= interval;

  }

  public static void main (String args[]){
    Double [] rates  = new Double[] {
        5.0,
        10.0,
        7.0,
        15.0,
        0.0,
        60.0,
        55.0,
        60.0,
        60.0,
        60.0,
        0.0,
        5.0,
        5.0};
    System.out.println(isAlertQ1(Arrays.asList(rates), 6, 6, 55.0));
    System.out.println(isAlertQ1(Arrays.asList(rates), 6, 5, 55.0));

  }
}
