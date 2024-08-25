package CreationalDesignPattern.AbstractFactoryDesignPattern;

import java.util.Scanner;

/**
 * IButton
 */
interface IButton {
  void onclick();
}

class MacButton implements IButton {
  public void onclick() {
    System.out.println("You clicked Mac Button !!");
  }
}

class WinButton implements IButton {
  public void onclick() {
    System.out.println("You clicked Window Button !!");
  }
}

interface ITextBox {
  void display();
}

class MacTextBox implements ITextBox {
  public void display() {
    System.out.println("I am from Mac Text Box !!");
  }
}

class WinTextBox implements ITextBox {
  public void display() {
    System.out.println("I am from Window Text Box !!");
  }
}

interface GUIFactory {
  IButton createButton();

  ITextBox createTextBox();

  public static GUIFactory createFactory(String OSType) {
    if (OSType.equals("Mac")) {
      return new MacFactory();
    } else {
      return new WindowFactory();
    }
  }

}

class MacFactory implements GUIFactory {
  public IButton createButton() {
    return new MacButton();
  }

  public ITextBox createTextBox() {
    return new MacTextBox();
  }
}

class WindowFactory implements GUIFactory {
  public IButton createButton() {
    return new WinButton();
  }

  public ITextBox createTextBox() {
    return new WinTextBox();
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter your OS type : ");
    try {
      String OStype = scanner.nextLine();
      GUIFactory guifactory = GUIFactory.createFactory(OStype);
      IButton button = guifactory.createButton();
      button.onclick();

      ITextBox textBox = guifactory.createTextBox();
      textBox.display();
    } finally {
      scanner.close();
    }
  }
}
