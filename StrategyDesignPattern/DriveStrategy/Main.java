
/**
 * DeriveStrategy
 */

interface DeriveStrategy {

  void derive();

}

class NormalDriveStrategy implements DeriveStrategy {

  public void derive() {
    System.out.println("I am using a normal drive strategy !!");
  }
}

class TravleDriveStrategy implements DeriveStrategy {

  public void derive() {
    System.out.println("I am using travel drive strategy !!");
  }
}

class SportDriveStrategy implements DeriveStrategy {
  public void derive() {
    System.out.println("I am using a sport drive strategy !!");
  }
}

class Vehicle {

  DeriveStrategy deriveStrategy;

  Vehicle(DeriveStrategy deriveStrategy) {
    this.deriveStrategy = deriveStrategy;
  }

  public void drive() {
    deriveStrategy.derive();
  }
}

class Bus extends Vehicle {
  Bus() {
    super(new TravleDriveStrategy());
  }
}

class SportCar extends Vehicle {
  SportCar() {
    super(new SportDriveStrategy());
  }
}

class NormalCar extends Vehicle {
  NormalCar() {
    super(new NormalDriveStrategy());
  }
}

public class Main {
  public static void main(String[] args) {
    Vehicle vehicle = new NormalCar();
    vehicle.drive();

    System.out.println("--------------------------------------------");
    Vehicle vehicle2 = new Bus();
    vehicle2.drive();
    System.out.println("--------------------------------------------");
    Vehicle vehicle3 = new SportCar();
    vehicle3.drive();

  }

}
