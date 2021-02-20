public class Primes {

  public static boolean isPrimeBrute(int num){
    if (num<=1) return false;
    for (int i =2; i<num; i++){
      if(num % i==0){
        return false;
      }
    }
    return true;
  }

  public static boolean isPrimeOptimized1(int num){
    if (num<=1) return false;
    for (int i =2; i<=(int)Math.sqrt(num); i++){
      if(num % i==0){
        return false;
      }
    }
    return true;
  }

  public static void main(String args[]){
    System.out.println(isPrimeBrute(2));
    System.out.println(isPrimeBrute(4));
    System.out.println(isPrimeBrute(5));
    System.out.println(isPrimeBrute(7));
    System.out.println();
    System.out.println(isPrimeOptimized1(2));
    System.out.println(isPrimeOptimized1(4));
    System.out.println(isPrimeOptimized1(5));
    System.out.println(isPrimeOptimized1(7));

  }

}
