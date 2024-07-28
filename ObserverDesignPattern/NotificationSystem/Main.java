import java.util.*;

interface NotificationObserver {
  void notified();
}

class EmailObserver implements NotificationObserver {
  String emailId;
  StockObservable observable;

  EmailObserver(String emailId, StockObservable stockObservable) {
    this.emailId = emailId;
    this.observable = stockObservable;
  }

  public void notified() {
    sendMail(emailId, "product is in stock hurry up!!");
  }

  private void sendMail(String emaString, String msg) {
    System.out.println("email is sent to :" + emaString);
  }

}

class MsgObserver implements NotificationObserver {
  String number;
  StockObservable observable;

  MsgObserver(String number, StockObservable sObservable) {
    this.number = number;
    this.observable = sObservable;
  }

  public void notified() {
    sendMsg(number, "product is in stock hurry up!!");
  }

  private void sendMsg(String number, String msg) {
    System.out.println("Messge is sent to : " + number);
  }
}

interface StockObservable {
  void add(NotificationObserver notificationObserver);

  void remove(NotificationObserver notificationObserver);

  void notifyObserver();

  void setStockCount(int stockCount);

  int getStockCount();
}

class Iphone implements StockObservable {
  List<NotificationObserver> list = new ArrayList<>();

  int stockCount = 0;

  public void add(NotificationObserver notificationObserver) {
    list.add(notificationObserver);
  }

  public void remove(NotificationObserver notificationObserver) {
    list.remove(notificationObserver);
  }

  public void notifyObserver() {
    for (NotificationObserver observer : list) {
      observer.notified();
    }
  }

  public void setStockCount(int stock) {
    if (stockCount == 0) {
      notifyObserver();
    }
    stockCount = stockCount + stock;
  }

  public int getStockCount() {
    return stockCount;
  }

}

public class Main {
  public static void main(String[] args) {
    StockObservable iphoneStock = new Iphone();

    NotificationObserver emailObserver = new EmailObserver("diva@gmail.com", iphoneStock);
    NotificationObserver emailObserver2 = new EmailObserver("hdkdd@gmail.com", iphoneStock);
    NotificationObserver msgObserver = new MsgObserver("9887766668", iphoneStock);

    iphoneStock.add(msgObserver);
    iphoneStock.add(emailObserver);
    iphoneStock.add(emailObserver2);

    iphoneStock.setStockCount(10);
    iphoneStock.setStockCount(0);
    iphoneStock.setStockCount(100);

    System.out.println("Stock of iphone is :" + iphoneStock.getStockCount());

  }
}
