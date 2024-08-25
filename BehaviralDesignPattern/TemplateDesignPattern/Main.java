package BehaviralDesignPattern.TemplateDesignPattern;

abstract class Payment {
  public abstract void validateRequest();

  public abstract void calculateMoney();

  public abstract void debitMoney();

  public abstract void creditAmount();

  public final void sendMoney() {

    // first we have to validate request;
    validateRequest();

    // debit the amount
    debitMoney();

    // calculate the money
    calculateMoney();

    // credit the money
    creditAmount();
  }
}

class PaymentWithFriend extends Payment {
  public void validateRequest() {
    System.out.println("Payment request is validate !!");
  }

  public void calculateMoney() {
    System.out.println("Calculate money implementation done !!");
  }

  public void debitMoney() {
    System.out.println("Money is debited !!");
  }

  public void creditAmount() {
    System.out.println("You receive some amount of money !!");
  }
}

class PaymentWithMerchant extends Payment {
  public void validateRequest() {
    System.out.println("Payment request is validate for merchat!!");
  }

  public void calculateMoney() {
    System.out.println("Calculate money implementation done !!");
  }

  public void debitMoney() {
    System.out.println("Money is debited !! by 2% GST");
  }

  public void creditAmount() {
    System.out.println("You receive some amount of money !!");
  }
}

public class Main {
  public static void main(String[] args) {
    Payment payment = new PaymentWithFriend();
    payment.sendMoney();

    System.out.println("**********************************************");
    Payment payment2 = new PaymentWithMerchant();
    payment2.sendMoney();

  }
}
