package logic;

import java.util.Stack;

public class PostfixConvertor {

  public static int _left(char c) {
    if (c == '+' || c == '-')
      return 10;
    else if (c == '*' || c == '/')
      return 30;
    else
      return -1;
  }

  public static int _right(char c) {
    if (c == '+' || c == '-')
      return 8;
    else if (c == '*' || c == '/')
      return 20;
    else
      return -1;
  }

  public static boolean doPop(char left, char right) {
    return (_left(left) > _right(right));
  }

  public static String toPostFix(String infix) {
    String postfix = "";
    Stack<Character> ops = new Stack<Character>();
    for (int i = 0; i < infix.length(); i++) {
      char c = infix.charAt(i);
      if ((c >= '0' && c <= '9') || c == '.') {
        postfix += c;
      } else {
        postfix += "\\";
        if (ops.empty()) {
          ops.push(c);
        } else {
          try {
            char l = ops.peek();
            System.out.print("L : " + l + " R : " + c + "\n");
            while (doPop(l, c)) {
              System.out.print("L : " + l + " R : " + c + "\n");
              postfix += l;
              ops.pop();
              l = ops.peek();
            }
            ops.push(c);
          } catch (Exception e) {
            ops.push(c);
          }
        }
      }
    }
    postfix += "\\";
    while (!ops.empty()) {
      postfix += ops.peek();
      ops.pop();
    }
    return postfix;
  }
}
