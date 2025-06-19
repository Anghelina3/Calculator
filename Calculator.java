package SmartCalculator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Calculator {
       public double calculate(String expression){
          List<String> posfix = ShuntingYard.parse(expression);
          return evaluatePostfix(posfix);
       }


       public double evaluatePostfix(List<String> posfix){
              Deque<Double> stack = new ArrayDeque<>();

              for(String token : posfix){
                     if(isNumeric(token)){
                            stack.push(Double.parseDouble(token));
                     }
                     else {
                            double right = stack.pop();
                            double left = stack.pop();
                            double result = switch (token){
                                   case "+" -> left + right;
                                   case "-" -> left - right;
                                   case "*" -> left * right;
                                   case "/" -> left / right;
                                   default -> throw new IllegalArgumentException("Invalid expression");
                            };
                           stack.push(result);
                     }
              }
              return stack.pop();

       }

       public boolean isNumeric(String str){
              return str.matches("-?\\d+(\\.\\d+)?");
       }


       public static void main(String[] args) {
              Calculator calculator = new Calculator();
              double res = calculator.calculate("(1 + 2.2/2) + 2*5 - 2");
              System.out.println(res);
       }
}
