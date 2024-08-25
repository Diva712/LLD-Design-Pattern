class Product {
}

class ProductDao {

  Product createProduct(int ProductId) {
    System.out.println("Product is Created !! Id of product is " + ProductId);
    return new Product();
  }

}

class Payment {

  void DoPayment() {
    System.out.println("Payment is Successfully Done !! ");
  }
}

class Invoice {
  void InvoiceImplemented() {
    System.out.println("Invoice is send to buyer by seller !!");
  }
}

class Notification {
  void SendNotification() {
    System.out.println("Notification is send to buyer who ordered Order !! ");
  }
}

class OrderFacade {

  ProductDao productDao;
  Payment payment;
  Notification notification;
  Invoice invoice;

  OrderFacade() {
    productDao = new ProductDao();
    payment = new Payment();
    invoice = new Invoice();
    notification = new Notification();
  }

  void OrderCreated() {
    productDao.createProduct(123);
    payment.DoPayment();
    invoice.InvoiceImplemented();
    notification.SendNotification();

    System.out.println("Order is created !! Successfully");
  }
}

public class Main {

  public static void main(String[] args) {

    OrderFacade order = new OrderFacade();
    order.OrderCreated();
  }
}
