import java.util.Scanner;

public class InfixToPostfix {

    static char[] infixExpression = getUserInput();
    static char[] stack = new char[stackLength()];
    static char[] postfixExpression = new char[infixExpression.length];
    static int top = -1;
    static int topForStack = -1;

    static void main() {
        System.out.println("Postfix Expression: " + convertToPostfix());
    }

    static String convertToPostfix() {

        for(int i=0; i<infixExpression.length; i++) {
            if(Character.isDigit(infixExpression[i]) || Character.isLetter(infixExpression[i]))
                push(infixExpression[i]);
            else {
                checkPrecedence(infixExpression[i]);
            }
        }

        for(int i=topForStack; i>=0; i--) {
            push(stack[topForStack]);
            popForOperator();
        }

        return new String(postfixExpression);
    }

    static void checkPrecedence(char currentOperator) {
        if(topForStack > -1) {
            for(int i=topForStack; i>=0; i--) {
                if(checkPreced(stack[i], currentOperator)) {
                    push(stack[i]);
                    popForOperator();
                }
            }
            pushToStack(currentOperator);
        } else
            pushToStack(currentOperator);
    }

    static boolean checkPreced(char leftOperator, char rightOperator) {
        int left = getValueForPrecedence(leftOperator);
        int right = getValueForPrecedence(rightOperator);

        if (leftOperator == '^' && rightOperator == '^') return false;

        return left >= right;
    }

    static int getValueForPrecedence(char ch) {
        if(ch == '^')   return 3;
        else if(ch == '*' || ch == '/') return 2;
        else return 1;
    }

    static char popForOperator() {
        return stack[topForStack--];
    }

    static char push(char ch) {
        postfixExpression[++top] = ch;
        return ch;
    }

    static char pushToStack(char ch) {
        stack[++topForStack] = ch;
        return ch;
    }

    static char[] getUserInput() {

        Scanner input = new Scanner(System.in);

        displayInfo();
        System.out.print("\nEnter your expression here(5+4/7*5+6): ");
        String userInput = input.nextLine();

        char[] infixExpression = userInput.replaceAll("\\s", "").toCharArray();

        return infixExpression;
    }

    static void displayInfo() {
        System.out.println("WELCOME TO POSTFIX CONVERSION!");
        System.out.println("==============================");

    }

    static int stackLength() {
        int counter = 0;

        for(int i=0; i<infixExpression.length; i++) {
            if(!Character.isLetter(infixExpression[i]) && !Character.isDigit(infixExpression[i]))
                counter++;
        }

        return counter;
    }
}
