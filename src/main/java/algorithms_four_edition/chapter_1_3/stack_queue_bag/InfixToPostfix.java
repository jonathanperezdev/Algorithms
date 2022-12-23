package algorithms_four_edition.chapter_1_3.stack_queue_bag;

import java.util.LinkedList;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

//Exercise 1.3.10
public class InfixToPostfix {
    //Infix numbers are read right to left, so, after read a number, I just put it in output (postfixExpression)
    // operators right to left (Stack), so if I found any operator I added it to the Stack
    private static String getInfixToPostfix(String input) {
        String[] elements = input.split("");

        Stack<String> operators = new Stack<>();
        String postfixExpression = "";

        for (String element : elements) {
            if ("*+/-^".contains(element)) {
                while (!operators.isEmpty() && prec(element) <= prec(operators.peek())) {
                    postfixExpression += operators.pop();
                }
                operators.push(element);
            }else if (element.equals("(")) {
                operators.push(element);
            }else if (element.equals(")")) {
                while (!operators.isEmpty() &&  !operators.peek().equals("("))
                    postfixExpression += operators.pop();

                operators.pop();
            //Is a number
            }else {
                postfixExpression += element;
            }
        }

        while (!operators.isEmpty()) {
            postfixExpression = postfixExpression + operators.pop();
        }
        return postfixExpression;
    }

    static int prec(String operator){
        switch (operator) {
            case "+":
            case "-":
                return 1;

            case "*":
            case "/":
                return 2;

            case "^":
                return 3;
        }
        return -1;
    }

    private static String getAll(Stack<String> operators, LinkedList<String> operands) {
        String result = "";
        while (!operands.isEmpty()) {
            result = result + operands.poll();
        }

        while (!operators.isEmpty()) {
            result = result + operators.pop();
        }

        return result;
    }

    public static void main(String args[]) {
        assertEquals("ABC*+",getInfixToPostfix("A+B*C"));
        assertEquals("AB+CD+*",getInfixToPostfix("(A+B)*(C+D)"));
        assertEquals("12+42/*", getInfixToPostfix("((1+2)*(4/2))"));
        assertEquals("abcdef^/*g*h*+", getInfixToPostfix("a+((b*c(d/e^f)*g)*h)"));
        assertEquals("abcdef^/*g*l/h*+", getInfixToPostfix("a+((b*c(d/e^f)*g/l)*h)"));
    }
}

