package CommandDesignPattern.AirConditionor;

import java.util.*;

class AirCondition {
  boolean isOn;
  int temperature;

  public void TurnOn() {
    isOn = true;
    System.out.println("AC is On");
  }

  public void TurnOff() {

    isOn = true;
    System.out.println("AC is Off");
  }

}

interface Command {
  void execute();

  void undo();
}

class TurnOnCommand implements Command {
  AirCondition ac;

  TurnOnCommand(AirCondition ac) {
    this.ac = ac;
  }

  public void execute() {
    ac.TurnOn();
  }

  public void undo() {
    ac.TurnOff();

  }
}

class TurnOffCommand implements Command {
  AirCondition ac;

  TurnOffCommand(AirCondition ac) {
    this.ac = ac;
  }

  public void execute() {
    ac.TurnOff();
  }

  public void undo() {
    ac.TurnOff();
  }
}

class Invoker {
  Command command;
  Stack<Command> commandHistory = new Stack<>();

  public void setCommand(Command command) {
    this.command = command;
  }

  public void pressButton() {
    command.execute();
    commandHistory.push(command);
  }

  public void pressUndo() {
    Command command = commandHistory.pop();
    command.undo();
  }

}

public class Main {
  public static void main(String[] args) {

    AirCondition ac = new AirCondition();
    Invoker remote = new Invoker();

    // setting a turnOn
    remote.setCommand(new TurnOnCommand(ac));
    remote.pressButton();

    System.out.println("**********************");
    remote.setCommand(new TurnOffCommand(ac));
    remote.pressButton();
    System.out.println("**********************");

    remote.setCommand(new TurnOnCommand(ac));
    remote.pressButton();

    System.out.println("********UNDO********");
    remote.pressUndo();
    remote.pressUndo();

  }

}
