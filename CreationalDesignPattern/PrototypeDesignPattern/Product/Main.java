package CreationalDesignPattern.PrototypeDesignPattern.Product;

interface ProductPrototype {
  ProductPrototype clone();

  void display();
}

class Product implements ProductPrototype {
  String name;
  Double price;

  Product(String name, Double price) {
    this.name = name;
    this.price = price;
  }

  public ProductPrototype clone() {
    return new Product(name, price);
  }

  public void display() {
    System.out.println("My product name :" + name + "and my price is : " + price);
  }
}

public class Main {
  public static void main(String[] args) {
    ProductPrototype product = new Product("Himalayan", 89.99);
    ProductPrototype cloneProduct = product.clone();
    product.display();
    cloneProduct.display();
  }
}
