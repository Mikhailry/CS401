package lab3;

public class BubbleSort {

    public void bubbleSort(int inputArray[]) {

        for (int i = 0; i < inputArray.length - 1; i++) {
            for (int j = 1; j < inputArray.length; j++) {

                if (inputArray[j-1] > inputArray[j]) {
                    // swap elements
                    int temp = inputArray[j-1];
                    inputArray[j-1] = inputArray[j];
                    inputArray[j] = temp;
                }//end of if

            }//end of inner loop
        }//end of outer loop

    }//end of bubble sort method



    //Print array method
    public void printArray(int inputArray[])
    {
        int n = inputArray.length;
        for (int i=0; i<n; ++i)
            System.out.print(inputArray[i] + " ");
        System.out.println();
    }



}//end of class
