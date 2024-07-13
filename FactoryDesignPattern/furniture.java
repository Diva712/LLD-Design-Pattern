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
  FurnitureItem getFurniture(String furnitureString) {

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
    try {
      FurnitureFactory furniturefactory = new FurnitureFactory();
      FurnitureItem furniture1 = furniturefactory.getFurniture("chair");
      FurnitureItem furniture2 = furniturefactory.getFurniture("table");
      FurnitureItem furniture3 = furniturefactory.getFurniture("sofa");

      furniture1.display();
      furniture2.display();
      furniture3.display();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}