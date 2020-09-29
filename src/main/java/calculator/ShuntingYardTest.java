package calculator;

import calculator.postfix.ShuntingYard;

public class ShuntingYardTest {
    public static void main(String[] args) {
        ShuntingYard shuntingYard = new ShuntingYard();
        String[] input = "( 1 + 2 ) * ( 3 / 4 ) - ( 5 + 6 )".split(" ");
        String[] output = shuntingYard.infixToRPN(input);

        // Build output RPN string minus the commas
        for (String token : output) {
            System.out.print(token + " ");
        }

        // Feed the RPN string to RPNtoDouble to give result
        Double result = shuntingYard.getResult(output);
        System.out.println(result);
    }
}
