import java.util.*;

interface Command {

  void execute();

}

class Document {

  public void onSave() {
    System.out.println("Document is Saved !!");
  }

  public void onOpen() {
    System.out.println("Documnet is Opened !!");
  }

}

class openCommand implements Command {
  private Document docs;

  openCommand(Document docs) {
    this.docs = docs;
  }

  public void execute() {
    docs.onOpen();
  }
}

class saveCommand implements Command {
  private Document docs;

  saveCommand(Document docs) {
    this.docs = docs;
  }

  public void execute() {
    docs.onSave();
  }
}

class MenuOption {
  List<Command> commands = new ArrayList<>();

  public void addCommand(Command command) {
    commands.add(command);
  }

  public void executeCommand() {
    for (Command command : commands) {
      command.execute();
    }
  }

}

public class Main {
  public static void main(String[] args) {
    Document docs = new Document();

    Command clickOpen = new openCommand(docs);
    Command clickSave = new saveCommand(docs);

    MenuOption menuOption = new MenuOption();
    menuOption.addCommand(clickSave);
    menuOption.addCommand(clickOpen);

    menuOption.executeCommand();
  }
}
