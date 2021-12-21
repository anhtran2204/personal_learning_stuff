import java.util.Arrays;

class TransitCalculators {
  int numOfDays;
  int numOfRides;
  final double payPerRide = 2.75;
  final double unlimited7Day = 33.00;
  final double unlimited30Day = 127.00;
  
  public TransitCalculators(int days, int rides) {
    numOfDays = days;
    numOfRides = rides;
  }
  
  public double unlimited7Price() {
    int numWeeks;
     if (numOfDays % 7 == 0) {
      numWeeks = numOfDays/7;
     } else {
      numWeeks = numOfDays/7 + 1;
     }
    
    double total = numWeeks * unlimited7Day;
    double rate = total/numOfRides;
    return rate;
  }
  
  public double[] getRidePrices(){
    double rate[] = new double[3];
    rate[0] = payPerRide;
    rate[1] = unlimited7Price();
    
    int numWeeks;
     if (numOfDays % 30 == 0) {
      numWeeks = numOfDays/30;
     } else {
      numWeeks = numOfDays/30 + 1;
     }
    
    double total = numWeeks * unlimited30Day;
    double rate1 = total/numOfRides;
    
    rate[2] = rate1;
    return rate;
  }
  
  public String getBestFare() {
    double prices[] = getRidePrices();
    double temp = prices[0];
    for (int i = 0; i < prices.length; i++) {
      if (temp > prices[i]) {
        temp = prices[i];
      }
    }
    
    if (temp == prices[0]) {
      return "You should get the Pay-per-ride option at $" + temp + " per ride.";
    } else if (temp == prices[1]) {
      return "You should get the 7-day Unlimited option at $" + temp + " per ride.";
    } else {
      return "You should get the 30-day Unlimited option at $" + temp + " per ride.";
    }
  }
  
  public static void main(String[] args) {
    TransitCalculators transitA = new TransitCalculators(20,50);
    System.out.println(transitA.getBestFare());

  }
}