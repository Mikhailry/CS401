package lab7;

public class Palindrome {

    public static boolean palEval (String expression){

        char ch; //holds character processed
        int length; //expression length
        char fromStack; //character from stack
        char fromQueue; //character from queue
        boolean isPalindrome; //true if considered as palindrome

        //stack and queue to hold characters from expression
        StackInterface<Character> stack;
        QueueInterface<Character> queue;

        length=expression.length();
        stack = new LinkedStack<Character>();
        queue = new LinkedQueue<Character>();

        //pass the expression characters to the queue and stack
        for(int i=0; i<length; i++){
            ch = expression.charAt(i);
            if (Character.isLetter(ch)){
                ch = Character.toLowerCase(ch);
                stack.push(ch);
                queue.enqueue(ch);
            }//end of if
        }//end of for loop

        //evaluate whether expression is palindrome
        isPalindrome = true;
        while(isPalindrome && !stack.isEmpty()){
            fromStack=stack.top();
            stack.pop();

            fromQueue=queue.dequeue();
            if (fromStack!=fromQueue){
                isPalindrome=false;
            }//end of if
        }//end of while loop

        return isPalindrome;
    }//end of palEval method

}//end of class
