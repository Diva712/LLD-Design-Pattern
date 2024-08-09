
abstract class BasePizza {
  abstract int cost();
}

class MagarhitaPizaa extends BasePizza {
  public int cost() {
    return 120;
  }
}

class VedDelightPizza extends BasePizza {
  public int cost() {
    return 150;
  }
}

class FarmHousePizza extends BasePizza {
  public int cost() {
    return 170;
  }
}

abstract class ToppingDecorator extends BasePizza {
}

class ExtraCheeseTopping extends ToppingDecorator {
  BasePizza pizza;

  ExtraCheeseTopping(BasePizza pizza) {
    this.pizza = pizza;
  }

  public int cost() {
    return pizza.cost() + 30;
  }
}

class MashroomTopping extends ToppingDecorator {
  BasePizza pizza;

  MashroomTopping(BasePizza pizza) {
    this.pizza = pizza;
  }

  public int cost() {
    return pizza.cost() + 50;
  }
}

class Jzelepino extends ToppingDecorator {
  BasePizza pizza;

  Jzelepino(BasePizza pizza) {
    this.pizza = pizza;
  }

  public int cost() {
    return pizza.cost() + 50;
  }
}

public class Main {

  public static void main(String[] args) {
    System.out.println("Here is Pizza Coner !!");

    BasePizza pizza = new MagarhitaPizaa();
    System.out.println("The cost of Magarhita Pizza is : " + pizza.cost());

    BasePizza pizza2 = new Jzelepino(new ExtraCheeseTopping(new FarmHousePizza()));
    System.out.println("The cost of Pizza with Jzelepino , Extra Cheese and Fram House Pizze is :" + pizza2.cost());

    BasePizza pizza3 = new MashroomTopping(new ExtraCheeseTopping(new VedDelightPizza()));
    System.out.println("The cost of Pizza with Mashroom , Extra Cheese and VegDelight is : " + pizza3.cost());
  }

}