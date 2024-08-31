package StructuralDesignPattern.Robotexample;

import java.util.HashMap;
import java.util.Map;

interface Robot {
  void display(int x, int y);
}

class HumanRobot implements Robot {
  private String type;
  private String body;

  HumanRobot(String type, String body) {
    this.body = body;
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public String getBody() {
    return body;
  }

  @Override
  public void display(int x, int y) {
    // TODO Auto-generated method stub

    System.out.println("Human Robot is created at x : " + x + " y : " + y + " whose type is " + type
        + " and its body is made of " + body + " .");

  }
}

class DogRobot implements Robot {

  private String type;
  private String body;

  DogRobot(String type, String body) {
    this.type = type;
    this.body = body;
  }

  public String getType() {
    return type;
  }

  public String getBody() {
    return body;
  }

  @Override
  public void display(int x, int y) {
    System.out.println("Dog Robot is created at x : " + x + " y: " + y + " its type is  " + type
        + " and body is  made of " + body + " .");
  }

}

class RobotFactory {

  public static Map<String, Robot> mpp = new HashMap<>();

  public static Robot createRobot(String Robotype) {
    if (mpp.containsKey(Robotype)) {
      System.out.println("Cached Object !!");
      return mpp.get(Robotype);
    } else if (Robotype == "Human") {
      Robot HumanObject = new HumanRobot(Robotype, "Steel");
      mpp.put(Robotype, HumanObject);
      return HumanObject;
    } else if (Robotype == "Dog") {
      Robot DogObject = new DogRobot(Robotype, "Metal");
      mpp.put(Robotype, DogObject);
      return DogObject;
    }

    return null;
  }
}

public class Main {

  public static void main(String[] args) {
    Robot humanRobot = RobotFactory.createRobot("Human");
    humanRobot.display(3, 6);

    Robot humaRobot2 = RobotFactory.createRobot("Human");
    humaRobot2.display(4, 5);
  }

}
