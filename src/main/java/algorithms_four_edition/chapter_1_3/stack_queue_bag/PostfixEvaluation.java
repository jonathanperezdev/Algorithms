package algorithms_four_edition.chapter_1_3.stack_queue_bag;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class PostfixEvaluation {
    private static Double evaluatePostfix(String input) {
        String[] elements = input.split("\\s+");

        Stack<Double> stack = new Stack<>();

        Double value1;
        Double value2;
        for (String element : elements){
            if(NumberUtils.isParsable(element)){
                stack.push(Double.valueOf(element));
            }else {

                value1 = stack.pop();
                value2 = stack.pop();
                switch (element) {
                    case "+":
                        stack.push(value1 + value2);
                        break;
                    case "-":
                        stack.push(value1 - value2);
                        break;
                    case "*":
                        stack.push(value1 * value2);
                        break;
                    case "/":
                        stack.push(value1 / value2);
                        break;
                    case "^":
                        stack.push(Math.pow(value1,value2));
                        break;
                }
            }
        }

        return stack.pop();
    }

    public static void main(String args[]) {
        assertEquals(Double.valueOf(2),evaluatePostfix("10 50 + 20 -"));
        assertEquals(Double.valueOf(0),evaluatePostfix("5 10 + 30 40 + *"));
        assertEquals(Double.valueOf("20.88888888888889"),evaluatePostfix("10 23 12 3 6 2 ^ / * 16 * 89 / 45 * +"));
    }
}
