package BehaviralDesignPattern.NullObjectDesignPattern;

interface Vehicle {
  int getSittingCapicity();

  int getFuelCapicity();
}

class Car implements Vehicle {
  public int getFuelCapicity() {
    return 40;
  }

  public int getSittingCapicity() {
    return 5;
  }
}

class NullObject implements Vehicle {
  public int getFuelCapicity() {
    return 0;
  }

  public int getSittingCapicity() {
    return 0;
  }
}

class VehicleFactory {

  static Vehicle creatVehicle(String typeOfVehicle) {
    if ("Car".equals(typeOfVehicle)) {
      return new Car();
    }
    return new NullObject();
  }
}

public class Main {

  public static void main(String[] args) {

    Vehicle vehicle = VehicleFactory.creatVehicle("Car");
    System.out.println("Fuel Capacity of vehicle : " + vehicle.getFuelCapicity());
    System.out.println("Sitting Capacity of Vehicle : " + vehicle.getSittingCapicity());
  }

}
