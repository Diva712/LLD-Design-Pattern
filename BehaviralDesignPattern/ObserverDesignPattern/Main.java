import java.util.*;

class Order {
  private int id;
  private String status;

  Order(int id) {
    this.id = id;
    this.status = "Order Placed";
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
    notifyAllObservers();
  }

  private List<Observer> observers = new ArrayList<>();
  // subscribe

  void subscribe(Observer ob) {
    observers.add(ob);
  }

  // unsbscribe
  void unsbscribe(Observer ob) {
    observers.remove(ob);
  }
  // notifyAll

  void notifyAllObservers() {
    for (Observer observer : observers) {
      observer.notified(this);
    }
  }

}

interface Observer {
  void notified(Order order);
}

class Customer implements Observer {
  String name;

  Customer(String name) {
    this.name = name;
  }

  public void notified(Order order) {
    System.out.println("Hello, " + name + "! Order #" + order.getId() + " is now " + order.getStatus() + ".");
  }

}

class CallCenter implements Observer {
  public void notified(Order order) {
    System.out.println("Call center " + "! Order #" + order.getId() + " is now " + order.getStatus() + ".");

  }
}

class Resturant implements Observer {
  String name;

  Resturant(String name) {
    this.name = name;
  }

  public void notified(Order order) {
    System.out.println("Resturant " + name + "! Order #" + order.getId() + " is now " + order.getStatus() + ".");
  }
}

class DeleviryBoy implements Observer {
  String name;

  DeleviryBoy(String name) {
    this.name = name;
  }

  public void notified(Order order) {
    System.out.println("Delivery Boy " + name + "! Order #" + order.getId() + " is now " + order.getStatus() + ".");
  }

}

public class Main {
  public static void main(String[] args) {
    // Observer created
    Observer customer = new Customer("Customer 1");
    Observer deliveryBoy = new DeleviryBoy("Delivery Boy 1");
    Observer resturant = new Resturant("Resturant 1");
    Observer callcenter = new CallCenter();

    // order created
    Order order = new Order(123);

    // observer subscribed
    order.subscribe(resturant);
    order.subscribe(customer);
    order.subscribe(callcenter);
    order.subscribe(deliveryBoy);

    order.setStatus("Order goes for delivery !!");
    System.out.println("********************************************");
    order.unsbscribe(callcenter);
    order.setStatus("Order Deliverd!!");
  }
}
