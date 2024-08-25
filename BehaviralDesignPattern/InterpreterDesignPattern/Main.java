package BehaviralDesignPattern.InterpreterDesignPattern;

import java.util.HashMap;
import java.util.Map;

class Context {
  Map<String, Integer> mpp = new HashMap<>();

  void put(String str, int value) {

    mpp.put(str, value);
  }

  int interpret(String str) {
    return mpp.get(str);
  }
}

interface AbstractExpression {
  int interpret(Context context);
}

class TerminalExpression implements AbstractExpression {
  String stringValue;

  TerminalExpression(String stringValue) {
    this.stringValue = stringValue;
  }

  public int interpret(Context context) {
    return context.interpret(stringValue);
  }
}

class MultiplyExpression implements AbstractExpression {
  AbstractExpression leftExpression;
  AbstractExpression rightExpression;

  MultiplyExpression(AbstractExpression leftExpression, AbstractExpression rightExpression) {
    this.leftExpression = leftExpression;
    this.rightExpression = rightExpression;
  }

  public int interpret(Context context) {
    return leftExpression.interpret(context) * rightExpression.interpret(context);
  }
}

class SumExpression implements AbstractExpression {

  AbstractExpression leftExpression;
  AbstractExpression rightExpression;

  SumExpression(AbstractExpression leftExpression, AbstractExpression rightExpression) {
    this.leftExpression = leftExpression;
    this.rightExpression = rightExpression;
  }

  public int interpret(Context context) {
    return leftExpression.interpret(context) + rightExpression.interpret(context);
  }
}

public class Main {

  public static void main(String[] args) {

    Context context = new Context();
    context.put("a", 4);
    context.put("b", 5);
    AbstractExpression expression = new MultiplyExpression(new TerminalExpression("a"), new TerminalExpression("b"));
    int answer = expression.interpret(context);
    // a*b
    System.out.println("a*b is : " + answer);

    AbstractExpression expression2 = new SumExpression(new TerminalExpression("a"), new TerminalExpression("b"));
    int answer2 = expression2.interpret(context);

    System.out.println("a+b is : " + answer2);

    AbstractExpression expression3 = new SumExpression(
        new MultiplyExpression(new TerminalExpression("a"), new TerminalExpression("b")),
        new MultiplyExpression(new TerminalExpression("a"), new TerminalExpression("b")));

    int answer3 = expression3.interpret(context);
    System.out.println("((a*b) + (a*b)) is : " + answer3);
  }

}
