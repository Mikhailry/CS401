package lab7;

public class BinarySearch {

    public boolean binarySearch (Employee [] arrayTarget, int target, int first, int last){

        // Precondition: first and last are legal indices of array
        // If target is contained in array return true
        // otherwise return false.

//        int n=arrayTarget.length;
//        int first = arrayTarget[0].getiD();
//        int last=arrayTarget[n-1].getiD();

        int midpoint = (first + last) / 2;
        if (first > last)
            return false;
        else
        if (target == arrayTarget[midpoint].getiD())
            return true;
        else
        if (target > arrayTarget[midpoint].getiD()) { // target too high
            return binarySearch(arrayTarget, target, midpoint + 1, last);
        } else {// target too low
            return binarySearch(arrayTarget, target, first, midpoint - 1);
        }

    }//end of binarySearch method

}
