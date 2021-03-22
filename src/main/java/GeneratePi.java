import java.math.BigDecimal;
import java.math.MathContext;

public class GeneratePi {
  private static final String PI =
      "3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679";

  private static double nilakantha(long iterations) {
    double pi = 3.0;
    int sign = -1;
    for (long i = 1; i <= iterations ; ++i) {
      sign *= -1;
      pi +=  (sign *4.0) / ((2.0 + i ) * (2.0   * i + 1) * (2.0 * i + 2));
    }

    return pi;
  }

  private static BigDecimal nilakantha_bigdecimal(long iterations) {
    BigDecimal pi = new BigDecimal(3.0);
    MathContext mc = new MathContext(100);
    int sign = -1;
    for (long i = 1; i <= iterations ; ++i) {
      sign *= -1;
      double temp = (2.0d * i) + (2.0d * i +1) + (2.0d * i +2);
      pi = pi.add(BigDecimal.valueOf(sign * 4.0).divide(BigDecimal.valueOf(temp),mc));

    }

    return pi;
  }

  public static void main(String[] args) {
    double localPI = 0d;
    long iterations =  args.length>0 ? Long.parseLong(args[0]) : 3;
    System.out.println("Actual PI          " + PI);
    localPI = nilakantha(iterations);
    System.out.println("Double Nilakantha           " + localPI);
    BigDecimal lpi = nilakantha_bigdecimal(iterations);
    System.out.println("BigDecimal Nilakantha           " + lpi);
  }
}
