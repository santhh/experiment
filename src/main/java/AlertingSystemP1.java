import java.util.Arrays;

public class AlertingSystemP1 {
  static Double[] rates = new Double[]{
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
  public static boolean isHealthy(int threshold){
    int maxArea =0;
    for (int i =0; i<rates.length; i++){
      int minHeight =  Integer.MAX_VALUE;
      for (int j = i; j<rates.length; j++ ){
        minHeight = Math.min(minHeight,rates[j].intValue());
        int area = (j -i +1) *  minHeight;
        maxArea = Math.max(area, maxArea);

      }

    }

    return maxArea >=threshold;
  }

  public static void main (String args[]) {

    System.out.println(isHealthy(250));
    System.out.println(isHealthy(350));
  }
}
