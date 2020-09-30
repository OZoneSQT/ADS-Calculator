package calculator.postfix;

public class PostFixPrinter {
    private PostFixShuntingYard postFixShuntingYard = new PostFixShuntingYard();
    private PostFixCalculator postFixCalculator = new PostFixCalculator();

    public PostFixPrinter() {
    }

    public void printPostFixExpression(String expression) {
        String[] input = expression.split(" ");
        String[] output = postFixShuntingYard.infixToPostFix(input);

        for (String token : output) {
            System.out.print(token + " ");
        }

        Double result = postFixCalculator.getResult(output);

        System.out.println("\n Result = " + result);
    }

    /*
    Methods for testing, issue with line-shift
     */
    public void testPrintPostFixExpression(String expression) {
        String[] input = expression.split(" ");
        String[] output = postFixShuntingYard.infixToPostFix(input);

        for (String token : output) {
            System.out.print(token + " ");
        }
    }

}
