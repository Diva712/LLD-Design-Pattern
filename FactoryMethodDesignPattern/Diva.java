package FactoryMethodDesignPattern;

interface FurnitureItem {
  void display();
}

class Sofa implements FurnitureItem {
  public void display() {
    System.out.println("I am from Sofa Class !!");
  }
}

class Chair implements FurnitureItem {
  public void display() {
    System.out.println("I am from Chair Class !!");
  }
}

class Table implements FurnitureItem {
  public void display() {
    System.out.println("I am from Table Class !!");
  }
}

interface FurnitureFactory {
  FurnitureItem createFurnitureItem();
}

class SofaFactory implements FurnitureFactory {
  public FurnitureItem createFurnitureItem() {
    return new Sofa();
  }
}

class ChairFactory implements FurnitureFactory {
  public FurnitureItem createFurnitureItem() {
    return new Chair();
  }
}

class TableFactory implements FurnitureFactory {
  public FurnitureItem createFurnitureItem() {
    return new Table();
  }
}

public class Diva {
  public static void main(String[] args) {

    FurnitureFactory sofaFactory = new SofaFactory();
    FurnitureFactory chairFactory = new ChairFactory();
    FurnitureFactory tableFactory = new TableFactory();

    FurnitureItem sofa = sofaFactory.createFurnitureItem();
    FurnitureItem chair = chairFactory.createFurnitureItem();
    FurnitureItem table = tableFactory.createFurnitureItem();

    sofa.display();
    table.display();
    chair.display();
  }
}