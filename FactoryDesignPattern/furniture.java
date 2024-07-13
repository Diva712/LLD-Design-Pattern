import java.util.Scanner;

interface FurnitureItem {
  void display();
}

class Sofa implements FurnitureItem {

  public void display() {
    System.out.println("I am Sofa from Sofa class !!");
  }
}

class Chair implements FurnitureItem {
  public void display() {
    System.out.println("I am Chair from chair class !!");
  }
}

class Table implements FurnitureItem {
  public void display() {
    System.out.println("I am Table from table class !!");
  }
}

class FurnitureFactory {
  public static FurnitureItem getFurniture(String furnitureString) {

    if (furnitureString.trim().equalsIgnoreCase("table")) {
      return new Table();
    } else if (furnitureString.trim().equalsIgnoreCase("chair")) {
      return new Chair();
    } else if (furnitureString.trim().equalsIgnoreCase("sofa")) {
      return new Sofa();
    } else {
      return null;
    }

  }
}

class furniture {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter furniture name like sofa , table , chair : ");
    String furniturString = scanner.nextLine();
    FurnitureItem furnitureItem = FurnitureFactory.getFurniture(furniturString);
    furnitureItem.display();

  }
}