package logic;

import java.util.Stack;

public class PostfixEvaluation {

  public static double evaluate(String postfix) {
    Stack<Double> literals = new Stack<Double>();
    String t = "";
    for (int i = 0; i < postfix.length(); i++) {
      char c = postfix.charAt(i);

      if (c == '+' || c == '-' || c == '*' || c == '/') {
        double l, r, temp;
        switch (c) {
          case '+':
            r = literals.peek();
            literals.pop();
            l = literals.peek();
            literals.pop();
            temp = l + r;
            literals.push(temp);
            break;
          case '-':
            r = literals.peek();
            literals.pop();
            l = literals.peek();
            literals.pop();
            temp = l - r;
            literals.push(temp);
            break;
          case '*':
            r = literals.peek();
            literals.pop();
            l = literals.peek();
            literals.pop();
            temp = l * r;
            literals.push(temp);
            break;
          case '/':
            r = literals.peek();
            literals.pop();
            l = literals.peek();
            literals.pop();
            temp = l / r;
            literals.push(temp);
            break;
          default:
            break;
        }
        continue;
      }

      while (c != '\\') {
        t += c;
        i++;
        c = postfix.charAt(i);
      }
      literals.push(Double.parseDouble(t));
      t = "";
    }
    return literals.peek();
  }

}
