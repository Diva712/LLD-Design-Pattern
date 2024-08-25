package CreationalDesignPattern.SingletonDesignPattern;

public class Main {
  public static void main(String[] args) {

    Singleton instance = Singleton.getInstance();
    Singleton otherInstance = Singleton.getInstance();
    System.out.println(instance.hashCode());
    System.out.println(otherInstance.hashCode());

    instance.doSomething();

  }

}

// this is lazy initialization beacuse when we want object than only created
// this method is not a thread safe

// so for thread safty we make method as a synchorinzed , but it will create
// expensivae
// in each time when we create a singleton object

// we did eager instiallization
class Singleton {

  private static Singleton instance;

  private Singleton() {
    System.out.println("This is singleton object !!");
  };

  public static synchronized Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }

  public void doSomething() {
    System.out.println("I am from do Somthing Method of Singleton class !!");
  }
}

// eager initialization , this is thread safe becoz
// JVM executed a static initializer when the class is loaded
class Eager {
  private static Eager instance = new Eager();

  private Eager() {
  };

  public static Eager getInstance() {
    return instance;
  }
}

// other approach
// double locking suystem
// using only synchronized block for object creation portion!!
class Singleton2 {
  public static Singleton2 instance;

  private Singleton2() {

  };

  public static Singleton2 getInstance() {
    if (instance == null) {

      synchronized (Singleton2.class) {
        if (instance == null) {
          instance = new Singleton2();
        }
      }
    }
    return instance;
  }
}

// other method for creating a singleton object is inner class
