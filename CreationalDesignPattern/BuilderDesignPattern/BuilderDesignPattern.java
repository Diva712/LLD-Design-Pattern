
class Desktop {
  String monitor;
  String mouse;
  String keyboard;
  String speaker;
  String processor;
  String motherBoard;

  public void setMonitor(String monitor) {
    this.monitor = monitor;
  }

  public void setMouse(String mouse) {
    this.mouse = mouse;
  }

  public void setKeyboard(String keyboard) {
    this.keyboard = keyboard;
  }

  public void setSpeaker(String speaker) {
    this.speaker = speaker;
  }

  public void setProcessor(String processor) {
    this.processor = processor;
  }

  public void setMotherBoard(String motherBoard) {
    this.motherBoard = motherBoard;
  }

  public String getMonitor() {
    return monitor;
  }

  public String getMouse() {
    return mouse;
  }

  public String getKeyboard() {
    return keyboard;
  }

  public String getSpeaker() {
    return speaker;
  }

  public String getProcessor() {
    return processor;
  }

  public String getMotherBoard() {
    return motherBoard;
  }

  public String showSpecs() {
    return "Desktop [monitor=" + monitor + ", mouse=" + mouse + ", keyboard=" + keyboard + ", speaker=" + speaker
        + ", processor=" + processor + ", motherBoard=" + motherBoard + "]";
  }

}

// DesktopBuilder has a Desktop
// to provide access to contcreate class builder , to desktop we using protected
abstract class DesktopBuilder {
  protected Desktop desktop = new Desktop();

  public abstract void buildMotherboard();

  public abstract void buildMonitor();

  public abstract void buildMouse();

  public abstract void buildKeyboard();

  public abstract void buildSpeaker();

  public abstract void buildProcessor();

  public Desktop getDesktop() {
    return desktop;
  }
}

class DellDesktopBuilder extends DesktopBuilder {
  public void buildMotherboard() {
    desktop.setMotherBoard("Dell Motherboard ");
  }

  public void buildMonitor() {
    desktop.setMonitor("Dell Monitor");
  }

  public void buildKeyboard() {
    desktop.setKeyboard("Dell Keyboard");
  }

  public void buildMouse() {
    desktop.setMouse("Dell Mouse");
  }

  public void buildProcessor() {
    desktop.setProcessor("Dell Processor");
  }

  public void buildSpeaker() {
    desktop.setSpeaker("Dell Speaker");
  }
}

class HPDesktopBuilder extends DesktopBuilder {
  public void buildMotherboard() {
    desktop.setMotherBoard("HP Motherboard ");
  }

  public void buildMonitor() {
    desktop.setMonitor("HP Monitor");
  }

  public void buildKeyboard() {
    desktop.setKeyboard("HP Keyboard");
  }

  public void buildMouse() {
    desktop.setMouse("HP Mouse");
  }

  public void buildProcessor() {
    desktop.setProcessor("HP Processor");
  }

  public void buildSpeaker() {
    desktop.setSpeaker("HP Speaker");
  }
}

class DesktopDirector {
  public Desktop buildDesktop(DesktopBuilder builder) {
    builder.buildMotherboard();
    builder.buildProcessor();
    builder.buildMonitor();
    builder.buildKeyboard();
    builder.buildMouse();
    builder.buildSpeaker();
    return builder.getDesktop();
  }
}

public class BuilderDesignPattern {
  public static void main(String[] args) {
    DesktopBuilder hpDesktopBuilder = new HPDesktopBuilder();
    DesktopBuilder dellDesktopBuilder = new DellDesktopBuilder();

    DesktopDirector director = new DesktopDirector();
    Desktop dellDesktop = director.buildDesktop(dellDesktopBuilder);

    Desktop hpDesktop = director.buildDesktop(hpDesktopBuilder);

    String DellDesktopSpecs = dellDesktop.showSpecs();
    System.out.println(DellDesktopSpecs);
    System.out.println("--------------------------------------------------------------------");
    String HPDesktopSpecs = hpDesktop.showSpecs();
    System.out.println(HPDesktopSpecs);
  }

}
