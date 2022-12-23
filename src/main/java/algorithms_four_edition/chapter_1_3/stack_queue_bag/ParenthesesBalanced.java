package algorithms_four_edition.chapter_1_3.stack_queue_bag;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// Exercise 1.3.4
class ParenthesesBalanced {
    //The string should be read left to right, the last open parentheses should be compared with the first parentheses who close,
    //so Stack helps to store open parentheses and get the last one added
    Stack<String> stack = new Stack<>();

    public boolean isBalanced(String s) {
        String[] parenthesis = s.split("");

        for (String p : parenthesis) {
            if ("([{".contains(p)) {
                stack.add(p);
            } else {
                if (p.equals(")") && !stack.pop().equals("("))
                    return false;
                if (p.equals("]") && !stack.pop().equals("["))
                    return false;
                if (p.equals("}") && !stack.pop().equals("{"))
                    return false;
            }
        }

        return true;
    }
}

class ParenthesesBalancedTest {
    static ParenthesesBalanced pa = new ParenthesesBalanced();

    public static void main(String[] args) {
        test1();
        test2();
    }

    @Test
    public static void test1() {
        assertTrue(pa.isBalanced("[()]{}{[()()]()}"));
    }

    @Test
    public static void test2() {
        assertFalse(pa.isBalanced("[(])"));
    }
}
