public class DecimalToBinary {

  public static void main (String args[]){
    int N =5;
    System.out.println(Integer.toBinaryString(5));
    // custom decimal - > binary
    int base =2;
    StringBuilder sb = new StringBuilder();
    while (N>0){
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

    // convert binary -> decimal
    int binary = Integer.parseInt(sb.toString());
    int decimal =0;
    int b = 1;
    while (binary>0){
      int reminder = binary % 10;
      binary = binary /10;
      decimal += reminder * b;
      b *=  2;

    }
    System.out.println(decimal);

  }
}
