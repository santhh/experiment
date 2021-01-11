public class AlertingSystem {
 double threshold;
  public AlertingSystem(double threshold){
    this.threshold = threshold;
  }
  public boolean hasAlertQ1(int time_stamp, int interval, int min_threshold, double[] rate){

    int length = rate.length;
    int start = time_stamp - interval + 1;
    int end = start;
    int count = end - start;

    while (count <= interval && end < length){
     if(rate[end]<min_threshold){
       start++;
       end++;
     }else{
       end++;
       count++;
     }

    }
    return count==interval?true:false;
  }

  public static void main (String args[]){
      AlertingSystem as = new AlertingSystem(250.0);
     double [] rate = new double[]
        {5, 10, 7, 15, 0, 60, 55, 60, 60, 60, 0, 5, 5};
      System.out.println(as.hasAlertQ1(6,6, 55, rate));
  }
}
