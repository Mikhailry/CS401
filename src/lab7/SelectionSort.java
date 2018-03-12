package lab7;

public class SelectionSort {

    public void sort(Employee [] inputArray){
        int n=inputArray.length;

        for (int i=0; i<n-1; i++){
            int minIndex = i;

            for (int j=i+1; j<n; j++){
                if (inputArray[j].compareTo(inputArray[minIndex]) < 0) {
                    minIndex = j;
                }

            }// end of inner for loop

            // Swapping
            Employee temp = inputArray[minIndex];
            inputArray[minIndex] = inputArray[i];
            inputArray[i] = temp;

        }//end of outer for loop

    } //end of sort method

    // Print array method
    public void printArray(Employee inputArray[]) {
        int n = inputArray.length;
        for (int i=0; i<n; ++i)
            System.out.print(inputArray[i]+" ");
        System.out.println();
    } //end of print array method


} //end of class
