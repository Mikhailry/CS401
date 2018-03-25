package lab8;

public class CS401ArrayImpl<E> implements CS401CollectionInterface<E>
{
   private E[] elements;
   private int num_elements;
   private int capacity;

   @SuppressWarnings("unchecked")
   public CS401ArrayImpl(int size)
   {
      elements = (E[]) new Object[size];
      num_elements = 0;
      capacity = size;
   }

   @SuppressWarnings("unchecked")
   public CS401ArrayImpl()
   {
      /**
       * Call the c'tor that takes the 'size' parameter.  **/
      this(5);
   }

   /**
    * Methods inherited from CS401CollectionInterface
    */
   public boolean is_full()
   {
      if (num_elements == capacity)
          return true;
      return false;
   }

   public boolean is_empty()
   {
      if (num_elements == 0)
          return true;
      return false;
   }

   public int size() { return num_elements; }

   public boolean add(E e)  {
      add(Where.BACK, e);  // Add at the end
      return true;
   }

   /*
    * Remove element at index i.  If the element exists in the collection,
    * return that element back to the user.  If the index is out of bounds,
    * return null.
    */
   public E remove(int i) {
       /*
       * Remember to compact the array so there are no spaces in between
       * if an element from the middle is removed or an element at the
       * beginning of the array is removed.
       */

       E rtnObj; //object to return
       int temp; //temp variable

       if(i < num_elements){

           rtnObj = elements[i];
           elements[i] = null;

           temp = i;
           while(temp < num_elements){
               elements[temp] = elements[temp+1];
               elements[temp+1] = null;
               temp++;
           }
           num_elements--;
           return rtnObj;
       }

      return null;
   } //end of remove method

   /*
    * Return true if e is in the collection class, false otherwise.
    */
   public boolean contains(E e) {

       boolean result = false;
       int i=0;

       while (i<=num_elements || elements[i].equals(e)){

           if (elements[i].equals(e)){
               result = true;
           } else {
               i++;
           }

       }//end of while loop

       return result;
   }

   /**
    * ---- Methods defined by this class
    * ----------------------------------------------------------
    * Methods that are added by this class and not in the
    * CS401CollectionInterface
    */

   /**
    * Add element in middle.
    * Preconditions: where == MIDDLE
    *                index <= num_elements - 1
    */
   public boolean add(Where where, int index, E e) {

      /*
       * If there is no space to add the new element, grow the array. */
      if (is_full())  {
          grow();
      } // end of if

      if (where == Where.MIDDLE) {
          System.out.println("Inserting element at index: " + index);
          for (int i=num_elements-1; i>index; i--){
              E temp = elements[i];
              elements[i] = elements[i-1];
              elements[i-1] = temp;
          }
      elements[index] = e;

          num_elements++;
      }// end of if

      return true;
   }

   /**
    * Add element in front or at the end, as dictated by where.
    * Preconditions: where != MIDDLE
    */
   public boolean add(Where where, E e) {

      /*
       * If there is no space to add the new element, grow the array. */
      if (is_full())  {
          grow();
      }

      if (where == Where.BACK)  {
          System.out.println("Inserting element at index " + num_elements);
          elements[num_elements] = e;
          num_elements++;
      }
      else if (where == Where.FRONT)  {
          System.out.println("Inserting element at index 0");
          System.out.println("Compacting storage");
          /*
           * Add code here.
           * You will add the new element at index 0, and shift all the
           * elements down by one. */

          for (int i=num_elements-1; i>0; i--){

              E temp = elements[i];
              elements[i] = elements[i-1];
              elements[i-1] = temp;

          }//end  of for loop
          elements[0] = e;

      }//end of else if
      return true;
   }

   /*
    * Gets the element at index i (0 <= i <= num_elements-1)
    */
   public E get(int i)  {

      if (i < 0 && i > num_elements)
          return null;

      return(elements[i]);
   }

   /**
    * ----------- Private methods
    */
   /*
    * Grows elements array to hold more elements.  Copies old (existing)
    * elements in the new array.
    *
    * Postcondition: (a) elements must contain the contents of the old array
    *                (b) elements must now have twice as much capacity as
    *                    before
    */
   @SuppressWarnings("unchecked")
   private boolean grow()  {

      /*
       * Add code here
       * Expand capacity (double it) and copy old array contents to the
       * new one.
       */

       E[] elementsExt = (E[]) new Object[capacity*2];
       for (int i=0; i<num_elements; i++ ){
           elementsExt[i] = elements [i];
       }//end of for loop
       elements = elementsExt;
       capacity = elements.length;

      System.out.println("Capacity reached.  Increasing storage...");
      System.out.println("New capacity is " + capacity + " elements");

      return true;
   }

   //prints all the elements of the ArrayList
   public void printAL(){

       for (int i=0; i<num_elements; i++){
           System.out.print(elements[i]);
       }// end of for loop

   }//end of printAL method
}
