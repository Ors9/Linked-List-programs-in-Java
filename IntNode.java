/**
 * Represents a node in a singly linked list of integers.
 * This class provides methods to get and set the value of the node,
 * as well as to get and set the reference to the next node.
 * 
 * @author Or Saban
 *
 */
public class IntNode {
    private int _value; // The integer value stored in the node
    private IntNode _next; // Reference to the next node

    /**
     * Constructs a new IntNode with the given value and next node.
     * 
     * @param val The integer value to be stored in the node
     * @param n The next node in the list
     */
    public IntNode(int val, IntNode n) {
        _value = val;
        _next = n;
    }

    /**
     * Constructs a new IntNode with the given value and no next node.
     * 
     * @param val The integer value to be stored in the node
     */
    public IntNode(int val) {
        _value = val;
        _next = null;
    }

    /**
     * Returns the integer value stored in the node.
     * 
     * @return The integer value of the node
     */
    public int getValue() {
        return _value;
    }

    /**
     * Returns the reference to the next node.
     * 
     * @return The reference to the next node
     */
    public IntNode getNext() {
        return _next;
    }

    /**
     * Sets the integer value of the node.
     * 
     * @param v The new integer value to be set
     */
    public void setValue(int v) {
        _value = v;
    }

    /**
     * Sets the reference to the next node.
     * 
     * @param node The new next node
     */
    public void setNext(IntNode node) {
        _next = node;
    }
}
