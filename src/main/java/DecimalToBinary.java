public class DecimalToBinary {

  public static void main (String args[]){
    int N =125;
    System.out.println(Integer.toBinaryString(5));
    // custom

    int base =2;
    StringBuilder sb = new StringBuilder();
    while (N!=0){
      int reminder = N % base;
      sb.append(reminder);
      N= N/base;
    }
    System.out.println(sb.toString());
    int maxOne= Integer.MIN_VALUE;
    int localCount =0;
    for (Character c: sb.toString().toCharArray()){

        if(c=='1'){
         localCount +=1;
          maxOne = Math.max(maxOne,localCount);
        }else{
          localCount =0;
        }
    }

    System.out.println(maxOne);

  }
}
