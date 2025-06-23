package SmartCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShuntingYard {
       //указываем приоритет
       private static int getPrecedence(String op) {
	      if ( op.equals("+") || op.equals("-") ) return 1;
	      if ( op.equals("*") || op.equals("/") ) return 2;
	      return -1;
       }

       public static List<String> parse(String expression) {
	      List<String> output = new ArrayList<>();
	      Stack<String> stack = new Stack<>();


	      for (String token : tokenize(expression)) {
		     if (token.matches("-?\\d+(\\.\\d+)?")) { // Если это число
			    output.add(token);
		     } else if (token.equals("(")) { // Левая скобка
			    stack.push(token);
		     } else if (token.equals(")")) { // Правая скобка
			    while (!stack.isEmpty() && !stack.peek().equals("(")) {
				   output.add(stack.pop());
			    }
			    stack.pop(); // Удаляем "("
		     } else { // Оператор
			    while (!stack.isEmpty() && getPrecedence(stack.peek()) >= getPrecedence(token)) {
				   output.add(stack.pop());
			    }
			    stack.push(token);
		     }
	      }

	      while (!stack.isEmpty()) {
		     output.add(stack.pop());
	      }

	      return output;
       }

       private static List<String> tokenize(String expression) {
	      List<String> tokens = new ArrayList<>();
	      StringBuilder numberBuffer = new StringBuilder();

	      for (char ch : expression.toCharArray()) {
		     if ( Character.isDigit(ch) || ch == '.' ) {
			    numberBuffer.append(ch); // собираем число
		     } else {
			    if ( numberBuffer.length() > 0 ) {
				   tokens.add(numberBuffer.toString());
				   numberBuffer.setLength(0);
			    }

			    if ( "+-*/()".indexOf(ch) != -1 ) {
				   tokens.add(Character.toString(ch)); // оператор или скобка
			    }
		     }
	      }

	      if ( numberBuffer.length() > 0 ) {
		     tokens.add(numberBuffer.toString());
	      }

	      return tokens;
       }
}
