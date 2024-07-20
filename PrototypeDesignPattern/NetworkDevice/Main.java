package PrototypeDesignPattern.NetworkDevice;

interface NetworkDevice {
  NetworkDevice clone();

  public void display();

  public void update(String updateName);

}

class Switch implements NetworkDevice {
  String name;
  String ip;
  String securityPolicy;

  Switch(String name, String ip, String securityPolicy) {
    this.name = name;
    this.ip = ip;
    this.securityPolicy = securityPolicy;
  }

  public NetworkDevice clone() {
    return new Switch(name, ip, securityPolicy);
  }

  public void display() {
    System.out.println("Switch - Name:" + name + ", IP: " + ip + ", Security Policy: " + securityPolicy);
  }

  public void update(String newName) {
    name = newName;
  }
}

public class Main {
  public static void main(String args[]) {
    NetworkDevice switchPrototype = new Switch("Switch X", "193.89.1.1", "");
    switchPrototype.display();

    NetworkDevice cloneSwitchPrototype = switchPrototype.clone();
    System.out.println(switchPrototype.hashCode());
    System.out.println(cloneSwitchPrototype.hashCode());

    System.out.println("Original Object :");
    switchPrototype.display();

    System.out.println("Clone Object");
    cloneSwitchPrototype.display();

    switchPrototype.update("Switch Y");

    System.out.println("Original Object :");
    switchPrototype.display();

    System.out.println("Clone Object");
    cloneSwitchPrototype.display();

  }
}
