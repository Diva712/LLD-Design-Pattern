
interface WeightMachine {

  int getWeightInPound();
}

class WeightMachineForBaby implements WeightMachine {

  public int getWeightInPound() {
    return 74;
  }
}

interface WeightAdapter {
  double getWeight();
}

class WeightInKg implements WeightAdapter {

  WeightMachineForBaby weightMachineForBaby;

  WeightInKg(WeightMachineForBaby weightMachine) {
    this.weightMachineForBaby = weightMachine;
  }

  public double getWeight() {
    return weightMachineForBaby.getWeightInPound() * 0.4;
  }
}

public class Main {
  public static void main(String[] args) {

    WeightAdapter weightAdapter = new WeightInKg(new WeightMachineForBaby());
    double weightInKG = weightAdapter.getWeight();
    String formattedWeight = String.format("%.2f", weightInKG);
    System.out.println("Weight in KG is : " + formattedWeight);
  }

}
