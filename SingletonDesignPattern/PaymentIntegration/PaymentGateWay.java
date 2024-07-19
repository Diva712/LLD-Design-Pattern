package SingletonDesignPattern.PaymentIntegration;

class PayementGatewayManager {
  private PayementGatewayManager() {
    System.out.println("Singleton object of payment manager class is initiated !!");
  };

  public static PayementGatewayManager instance;

  public static PayementGatewayManager getInstance() {

    if (instance == null) {
      synchronized (PayementGatewayManager.class) {
        try {

          if (instance == null) {
            instance = new PayementGatewayManager();
          }

        } catch (Exception e) {
          System.err.println(e);
        }
      }
    }
    return instance;
  }

  public void doPayment(double amount) {
    System.out.println("Pyament of amount $" + amount + "has been done successfully !!");
  }
}

public class PaymentGateWay {

  public static void main(String[] args) {
    PayementGatewayManager instance = PayementGatewayManager.getInstance();
    instance.doPayment(500.00);

    PayementGatewayManager otherInstance = PayementGatewayManager.getInstance();
    if (otherInstance == instance) {
      System.out.println("Singleton Pattern is exicuting !!");
    } else {
      System.out.println("It is not working !!");
    }
  }

}
