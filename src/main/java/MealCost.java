public class MealCost {

  public static long calc(double meal_cost, int tip_percent, int tax_percent){
    double tipCost = meal_cost * (double) tip_percent / 100.00;
    System.out.println(tipCost);
    double taxCost =  meal_cost *  (double) tax_percent / 100.00;
    System.out.println(taxCost);
    double totalCost =  meal_cost + tipCost + taxCost;
    System.out.println(totalCost);
    return Math.round(totalCost);

  }

  public static void main (String args[]){

    System.out.println(calc(12,20,8));
  }
}
