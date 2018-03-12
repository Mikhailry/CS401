package lab7;

public class InfixToPostfix {

    //return precedence of operator
    static int precedence(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    } //end of precedence

    static String infixToPostfix(String exp)
    {
        // initializing empty String for result
        String result  = new String("");

        //create a stack
        StackInterface<Character> stackChar = new LinkedStack();

        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);

            // If the scanned character is an operand, add it to output.
            if (Character.isLetterOrDigit(c)) {
                result += c;
            }

            // If the scanned character is an '(', push it to the stack.
            else if (c == '(') {
                stackChar.push(c);
            }

            //  If the scanned character is an ')', pop and output from the stack
            // until an '(' is encountered.
            else if (c == ')') {

                while (!stackChar.isEmpty() && stackChar.top() != '(') {
                    result += stackChar.top();
                    stackChar.pop();
                }

                if (!stackChar.isEmpty() && stackChar.top() != '(') {
                    return "Invalid Expression"; // invalid expression
                } else {
                    stackChar.pop();
                }
            }
            else // an operator is encountered
            {
                while (!stackChar.isEmpty() && precedence(c) <= precedence(stackChar.top())) {
                    result += stackChar.top();
                    stackChar.pop();
                }
                stackChar.push(c);
            }

        }

        // pop all the operators from the stack
        while (!stackChar.isEmpty()) {
            result += stackChar.top();
            stackChar.pop();
        }

        return result;
    }


}
