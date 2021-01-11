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
  public boolean hasAlertQ2(double[] rate){
    int n = rate.length;
    int maxArea =0;
    for (int i =0; i<n; i++ ){
      int minHeight = Integer.MAX_VALUE;
      for (int j =i; j<n; j++){
        minHeight = Math.min(minHeight, (int)(rate[j]));
        int width = j -i +1;
        maxArea = Math.max(maxArea,minHeight * width );

      }
    }
    return maxArea>=threshold;
  }

  public static void main (String args[]){
      AlertingSystem as = new AlertingSystem(250.0);
     double [] rate = new double[]
        {5, 10, 7, 15, 0, 60, 55, 60, 60, 60, 0, 5, 5};
      //System.out.println(as.hasAlertQ1(6,6, 55, rate));
     System.out.println(as.hasAlertQ2(rate));
  }
}
