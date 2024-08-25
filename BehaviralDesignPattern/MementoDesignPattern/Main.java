package MementoDesignPattern;

import java.util.*;

class CareTaker {
  List<ConfigurationMemento> history = new ArrayList<>();

  public void addMemento(ConfigurationMemento memento) {
    history.add(memento);
  }

  public ConfigurationMemento undo() {
    if (history.size() != 0) {
      int LastIndex = history.size() - 1;
      ConfigurationMemento lastMemento = history.get(LastIndex);
      history.remove(LastIndex);
      return lastMemento;
    }
    return null;
  }
}

class ConfigurationMemento {
  int height;
  int width;

  ConfigurationMemento(int height, int width) {
    this.height = height;
    this.width = width;
  }

}

class ConfigurationOriginator {
  int height;
  int width;

  ConfigurationOriginator(int height, int width) {
    this.height = height;
    this.width = width;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public ConfigurationMemento createMemento() {
    return new ConfigurationMemento(height, width);
  }

  public void restoreConfigurationByMemento(ConfigurationMemento configurationMemento) {
    this.height = configurationMemento.height;
    this.width = configurationMemento.width;
  }

}

public class Main {

  public static void main(String[] args) {
    CareTaker careTaker = new CareTaker();
    ConfigurationOriginator obj1 = new ConfigurationOriginator(10, 12);
    // 1st change in original configuration
    ConfigurationMemento snapshot1 = obj1.createMemento();
    careTaker.addMemento(snapshot1);

    System.out.println("Height of Configuration : " + obj1.height);
    System.out.println("Width of Configuration : " + obj1.width);
    System.out.println("************************First Snapshot****************************");
    // 2nd change in original configuration
    obj1.setHeight(18);
    obj1.setWidth(14);
    ConfigurationMemento snapshot2 = obj1.createMemento();
    careTaker.addMemento(snapshot2);
    System.out.println("Height of Configuration : " + obj1.height);
    System.out.println("Width of Configuration : " + obj1.width);

    System.out.println("************************Second Snapshot****************************");

    // 3rd change but after that we want configuration revert;
    obj1.setHeight(23);
    obj1.setWidth(29);
    System.out.println("Height of Configuration : " + obj1.height);
    System.out.println("Width of Configuration : " + obj1.width);

    System.out.println("************************Third Changed Hppens****************************");

    ConfigurationMemento revertConfiguration = careTaker.undo();
    obj1.restoreConfigurationByMemento(revertConfiguration);

    System.out.println("Height of Configuration : " + obj1.height);
    System.out.println("Width of Configuration : " + obj1.width);

    System.out.println("********************************Undo***************************************");

  }

}
