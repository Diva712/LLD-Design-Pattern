interface BreathingImplementer {
  void breath();
}

class TreeBreath implements BreathingImplementer {

  public void breath() {
    System.out.println("Breath through Leaves , Inhale CO2  and Exhale O2 in Photosynthesis !!");
  }
}

class WaterBreath implements BreathingImplementer {
  public void breath() {
    System.out.println("Breath through Grills , Inhale O2 from water and Exhale CO2 !!");
  }
}

class LandBreath implements BreathingImplementer {
  @Override
  public void breath() {
    System.out.println("Breath through Nose , Inhale Oxygen and Exhale CO2");
  }
}

abstract class LivingThings {

  BreathingImplementer breathingImplementer;

  LivingThings(BreathingImplementer breathingImplementer) {
    this.breathingImplementer = breathingImplementer;
  }

  abstract void breathProcess();
}

class Fish extends LivingThings {
  Fish(BreathingImplementer breathingImplementer) {
    super(breathingImplementer);
  }

  @Override
  void breathProcess() {
    // TODO Auto-generated method stub
    breathingImplementer.breath();

  }
}

class Dog extends LivingThings {
  Dog(BreathingImplementer breathingImplementer) {
    super(breathingImplementer);
  }

  @Override
  void breathProcess() {
    breathingImplementer.breath();
  }
}

class Tree extends LivingThings {
  Tree(BreathingImplementer breathingImplementer) {
    super(breathingImplementer);
  }

  @Override
  void breathProcess() {
    breathingImplementer.breath();
  }
}

public class Main {
  public static void main(String[] args) {
    LivingThings Fish = new Fish(new WaterBreath());
    Fish.breathProcess();

    LivingThings Dog = new Dog(new LandBreath());
    Dog.breathProcess();
  }
}
