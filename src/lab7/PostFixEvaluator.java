package lab7;

import java.util.Scanner;

public class PostFixEvaluator {

    public static int evaluate(String expression) {

        //create a stack
        StackInterface<Integer> stack = new LinkedStack();

        // Scan all characters one by one
        for(int i=0;i<expression.length();i++)
        {
            char c=expression.charAt(i);

            // If the scanned character is an operand (number here),
            // push it to the stack.
            if(Character.isDigit(c))
                stack.push(c - '0');

                //  If the scanned character is an operator, pop two
                // elements from stack apply the operator
            else
            {
                int val1 = stack.top();
                stack.pop();
                int val2 = stack.top();
                stack.pop();

                switch(c)
                {
                    case '+':
                        stack.push(val2+val1);
                        break;

                    case '-':
                        stack.push(val2- val1);
                        break;

                    case '/':
                        stack.push(val2/val1);
                        break;

                    case '*':
                        stack.push(val2*val1);
                        break;
                }
            }
        }
        int result=stack.top();
        stack.pop();
        return result;
    }//end of evaluate method

} //end of class
