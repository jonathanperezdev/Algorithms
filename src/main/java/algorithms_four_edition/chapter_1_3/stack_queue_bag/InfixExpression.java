package algorithms_four_edition.chapter_1_3.stack_queue_bag;

import java.util.Stack;

class InfixExpression {
    private static String getInfixExpression(String input) {
        String expression = "";
        String[] letters = input.split("\\s");

        Stack<String> infixExpression = new Stack<>();
        int i = letters.length -1;
        while( i > 0){
            if(letters[i].equals(")")){
                if(letters[i-1].equals(")")){
                    infixExpression.add(letters[i]);
                    i = i-1;
                }else{
                    for (int j =0; j <= 3; j ++){
                        infixExpression.add(letters[i]);
                        i = i-1;
                    }
                    infixExpression.add("(");
                }
            }else {
                for (int j = 0; j <= 4; j ++){
                    infixExpression.add(letters[i]);
                    i = i-1;
                }
                infixExpression.add("(");
                infixExpression.add("(");
            }
        }

        while(!infixExpression.isEmpty()) {
            expression = expression + infixExpression.pop();
        }
        return expression;
    }

    public static void main (String args[]) {
        System.out.println(getInfixExpression("1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )"));
        System.out.println(getInfixExpression("1 + 80 ) * 3 - 4 ) * 5 - 6 ) ) )"));
    }
}
