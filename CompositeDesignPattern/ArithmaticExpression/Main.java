
interface ArithmaticExpression {
  int evaluate();
}

class Number implements ArithmaticExpression {
  int value;

  Number(int value) {
    this.value = value;
  }

  public int evaluate() {
    return value;
  }
}

class Expression implements ArithmaticExpression {

  ArithmaticExpression leftExpression;
  ArithmaticExpression rightExpression;
  String operation;

  Expression(ArithmaticExpression leftExpression, ArithmaticExpression rightExpression, String operation) {
    this.leftExpression = leftExpression;
    this.rightExpression = rightExpression;
    this.operation = operation;
  }

  public int evaluate() {
    int ans = 0;

    switch (operation) {
      case "ADD":
        ans = leftExpression.evaluate() + rightExpression.evaluate();
        break;

      case "SUBTRACT":
        ans = leftExpression.evaluate() - rightExpression.evaluate();
        break;

      case "MULTIPLY":
        ans = leftExpression.evaluate() * rightExpression.evaluate();
        break;

      case "DIVIDE":
        ans = leftExpression.evaluate() / rightExpression.evaluate();
        break;

      default:
        throw new UnsupportedOperationException("Unknown operation: " + operation);
    }

    return ans;
  }
}

public class Main {

  public static void main(String[] args) {
    ArithmaticExpression val1 = new Number(2);
    ArithmaticExpression val2 = new Number(3);
    ArithmaticExpression val3 = new Number(5);

    ArithmaticExpression AddExpression = new Expression(val2, val3, "ADD");
    ArithmaticExpression MultiplyExpression = new Expression(val1, AddExpression, "MULTIPLY");

    int ans = MultiplyExpression.evaluate();

    System.out.println("Answer for (2*(3+5)) is " + ans);

  }
}
