
/**
 * Represents a node in a doubly linked list.
 * @author (Or Saban)
 */
public class IntNodeTwo {
    private int _num; // The integer value stored in the node
    private IntNodeTwo _next, _prev; // References to the next and previous nodes

    /**
     * Constructs a new IntNodeTwo with the given integer value.
     * 
     * @param n The integer value to be stored in the node
     */
    public IntNodeTwo(int n) {
        _num = n;
        _next = null;
        _prev = null;
    }

    /**
     * Constructs a new IntNodeTwo with the given integer value,
     * next node, and previous node.
     * 
     * @param num The integer value to be stored in the node
     * @param n The next node in the list
     * @param p The previous node in the list
     */
    public IntNodeTwo(int num, IntNodeTwo n, IntNodeTwo p) {
        _num = num;
        _next = n;
        _prev = p;
    }

    /**
     * Returns the integer value stored in the node.
     * 
     * @return The integer value of the node
     */
    public int getNum() {
        return _num; 
    }

    /**
     * Returns the reference to the next node.
     * 
     * @return The reference to the next node
     */
    public IntNodeTwo getNext() {
        return _next; 
    }

    /**
     * Returns the reference to the previous node.
     * 
     * @return The reference to the previous node
     */
    public IntNodeTwo getPrev() { 
        return _prev; 
    }

    /**
     * Sets the integer value of the node.
     * 
     * @param n The new integer value to be set
     */
    public void setNum(int n) {
        _num = n;
    }

    /**
     * Sets the reference to the next node.
     * 
     * @param node The new next node
     */
    public void setNext(IntNodeTwo node) {
        _next = node; 
    }

    /**
     * Sets the reference to the previous node.
     * 
     * @param node The new previous node
     */
    public void setPrev(IntNodeTwo node) { 
        _prev = node; 
    }
}


