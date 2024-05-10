
/**
 *  Represents a singly linked list of integers.
 * This class provides methods to manipulate the list, such as adding elements, 
 * converting the list to a string, and performing operations on sublists.
 * 
 *
 * @author Or Saban 
 */
public class IntList
{
    private IntNode _head;
    public IntList( ) {
        _head = null;
    }

    public void addToEnd(int num) {
        // adds num at the end of the list
        IntNode node = new IntNode(num);
        if (_head == null)
            _head = node;
        else {
            IntNode ptr = _head;
            while (ptr.getNext( ) != null)
                ptr = ptr.getNext( );
            ptr.setNext(node);
        }
    }

    public String toString()
    {
        String s = "";
        IntNode temp = _head;
        while (temp != null)
        {
            s = s+ temp.getValue() + " --> ";
            temp = temp.getNext();
        }
        s+= " null";
        return s;
    } 
    //    כאן ייכנסו השיטות שתכתבו בשאלות הבאות //           

    /**
     * Finds if there exists a subList whose elements sum up to a specific number.
     * Sliding window algorithm is employed for efficient exploration of subLists.
     * Time complexity - O(n) where n is the number of elements in the linked list
     * , as each node is visited at most twice.
     * Space complexity - O(1) the space complexity is constant.
     * 
     * @param num The target sum to check for
     * @return True if there exists a subList, false otherwise
     */
    public boolean subListSum(int num){
        IntNode end = _head;
        IntNode start = _head;
        int sum = 0;
        while(end != null){ //sliding windows algoritem.
            if(sum < num){ //if sum samller make bigger
                sum += end.getValue();
                end = end.getNext();
            }
            else if(sum == num){ //found out
                return true;    
            }
            else { //sum > num make smalleer.
                sum -= start.getValue();
                start = start.getNext();
            }
        }
        while(start != null || sum > num){
            if(sum == num){
                return true;
            }
            sum -= start.getValue();
            start = start.getNext();    
            //try to minimize sum more.
        }
        return false;
    }

    /**
     * Finds the node that divides the list to maximize the difference between
     * the averages of the two parts.
     * Algorithm Description:
     * 1. Calculate the total sum and length of the entire list.
     * 2. Iterate through the list, maintaining two parts and calculating averages for each division point.
     * 3. Track the node that maximizes the absolute difference between the averages.
     * 4. Return the node that optimally divides the list.

     * Time Complexity: O(n)
     * - The algorithm iterates through the entire linked list once.
     * - The loop runs in linear time with respect to the number of nodes in the list.

     * Space Complexity: O(1)
     * - The algorithm uses a constant amount of space for variables, regardless of the input size.
     *
     * @return The node that optimally divides the list, or null if the list is empty or has only one element.
     */
    public IntNode averageNode(){
        if(_head == null || _head.getNext() == null){
            // If the list is empty or has only one element, there is no valid division.
            return null;   
        }
        int length1 = 0; // Length of the first part
        int length2 = 0; // Length of the second part
        double sum1 = 0; // Sum of values in the first part
        double sum2 = 0; // Sum of values in the second part
        double avarage1 = 0; // Average of values in the first part
        double avarage2 = 0; // Average of values in the second part
        IntNode curr = _head; // Initialize current node to the head
        while(curr != null){ // Calculate the sum and length for the entire list
            length1++; // Grow the length based on each iterate
            sum1 += curr.getValue(); 
            curr = curr.getNext(); // Move to the next node
        }
        avarage1 = sum1/length1;  // Calculate the average for the entire list
        double maxDifference = -1;
        IntNode theDiviner = new IntNode(999); // Initialize the optimal divider node
        curr = _head; // Reset current node to the head
        double currDifference = -1;
        while(curr.getNext() != null){
            // Iterate through the list to find the optimal division point
            length2++; // Grow the length based on each iterate
            length1--; // Decrease the length based on each iterate
            sum1 -= curr.getValue(); // Update sum.
            avarage1 = (double)(sum1/length1); // Recalculate the avarage
            sum2 += curr.getValue(); // Update sum.
            avarage2 = (double)(sum2/length2); //Recalculate the avarage.
            // Calculate the absolute difference between averages and,
            currDifference = Math.abs(avarage1 - avarage2);
            // Update the divider if the difference is greater than the current max.
            if(maxDifference <= currDifference){
                maxDifference = currDifference;
                theDiviner = curr;
            }
            curr = curr.getNext(); // Move to the next node
        }
        return theDiviner;
    }

}
