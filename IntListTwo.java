
/**
 * Represents a doubly linked list of integers.
 * This class provides methods to manipulate the list, such as adding elements, 
 * converting the list to a string, and checking for a valid path.
 * 
 * @author Or Saban 
 */

public class IntListTwo
{
    IntNodeTwo _head, _tail;
    //    שימו לב שלא להגדיר את התכונות האלו כפרטיות! //        
    public IntListTwo()
    {
        _head = null;
        _tail = null;
    }
    //   כאן ייכנסו השיטות שתכתבו בשאלות הבאות //         
    /**
     * Adds a new node with the given number to the end of a doubly linked list.
     * Time complexity = O(1) constant time for inserting at the end. 
     * The space complexity = O(1) for each new element added to the list because only
     * a constant amount of additional space is required for the new node.
     * @param num The number to be added to the end of the list
     */
    public void addToEnd(int num){
        IntNodeTwo nodeNum = new IntNodeTwo(num); //make num an nodeTwo object.
        // If the list is empty, set both _head and _tail to the new node
        if(_tail == null){
            _tail = nodeNum; 
            _head = nodeNum;
        }
        else{
            // Update the next and prev pointers for the current tail and the new node
            nodeNum.setPrev(_tail);
            _tail.setNext(nodeNum);
            _tail = nodeNum;
            // Update _tail to the new node
        }
    }

    /**
     *  returns the list as string from the start to the end,if empty returns "".
     *  Time complexity - O(n), where n is the number 
     *  of elements in the linked list.
     *  Space complexity - O(1) because the method uses a constant amount 
     *  of additional space regardless of the size of the input.
     *  
     */
    public String toString() {
        // Initialize the string representation with an opening curly brace
        String buildValuesToString = "{";
        IntNodeTwo curr = _head;
        while(curr != null){
            // Traverse the list until the tail is reached
            buildValuesToString += curr.getNum();
            if(curr != _tail){
                buildValuesToString +=", ";
                // If the current node is not the tail, add a comma and space
            }
            curr = curr.getNext();
        }
        buildValuesToString += "}";
        // Add a closing curly brace to the string representation
        return buildValuesToString;
    }

    /**
     * Returns a reversed string representation of the linked list enclosed in curly braces,when empty return "".
     * Calls the private helper method toStringReverse to perform the reversal.
     *
     * @return Reversed string representation of the linked list.
     */

    public String toStringReverse(){
        return "{" + toStringReverse("",_head) + "}";    
    }

    /**
     * Private helper method to recursively build the reversed string representation of the linked list.
     *
     * @param reverseStr The string being constructed in reverse order.
     * @param curr The current node being processed.
     * @return Reversed string representation of the linked list.
     */
    private String toStringReverse(String reverseStr,IntNodeTwo curr){
        if(curr == null){ 
            // Base case: If the current node is null, return an empty string.(reach end)
            return "";
        }
        // Recursively call the method with the next node and append the current node's value when back.
        reverseStr += toStringReverse(reverseStr,curr.getNext()) + curr.getNum();
        // If the current node is not the head, append a comma to the reverseStr.
        if(curr != _head){ // Add coma and space if curr is not the last value. 
            reverseStr +=", ";      
        }
        return reverseStr;
    }

    /**
     * Checks if there is a valid path in the two-way linked list.
     * A valid path is defined as a series of links in the list, starting at the top of the list
     * and moving forward to end at another link in the list. Each link's value represents the number
     * of steps that can be taken to the left or right.
     *
     * @return true if there is a valid path, false otherwise.
     */
    public boolean isWay(){
        return isWay(_head,0);
    }

    /**
     * Private helper method to recursively check for a valid path in the two-way linked list.
     * @param countStep The count of steps.
     * @param curr           The current node being processed.
     * @return true if a valid path is found, false otherwise.
     */
    public boolean isWay(IntNodeTwo curr, int countStep){
        // Base case: if the current node is null, return false.
        if(curr == null){ //if current is null return false.
            return false;
        } 
        // Base case: if at the tail with the right count of steps, return true.
        if(curr == _tail && countStep == 0){ 
            return true; 
        }
        // Initialize leftPath and rightPath.
        boolean leftPath = false;
        boolean rightPath = false;
        // If countStep is 0 and the current node's value is not 0, explore both left and right paths.
        if(countStep == 0 && curr.getNum() != 0){ 
            int temp = curr.getNum();  // Temporary hold the current value to avoid infinite recursion.
            curr.setNum(0); // Change the value to 0 because in the list only positive numbers.
            leftPath = isWay(curr.getPrev() ,-temp + 1); // Recursive call for the left path.
            rightPath = isWay(curr.getNext(),temp - 1); // Recursive call for the right path.
            curr.setNum(temp);  // Restore the original value.
        }
        // If countStep is negative, continue the left path till 0.
        if(countStep < 0){
            leftPath = isWay(curr.getPrev() ,countStep + 1); 
        } 
        // If countStep is positive, continue the right path till 0.
        if(countStep > 0){ 
            rightPath = isWay(curr.getNext(),countStep - 1);   
        }
        return leftPath || rightPath; // Return true if either leftPath or rightPath is true.
    }

}
