package SinglyLinkedList;

/**
 * Node.java
 * Class for creating nodes inside of the singly linked list.
 * @author Gael Emiliano Casillas Avina (gcasillasa1900@alumno.ipn.mx)
 */
public class Node {
    private int data;
    private Node next;
    
    /**
     * @param data Required integer for the node.
     */
    public Node(int data){
        this.data = data;
        this.next = null;
    }

    /**
     * @return Returns storaged data.
     */
    public int getData() {
        return data;
    }

    /**
     * @param data Changes storaged data.
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * @return Returns next node.
     */
    public Node getNext() {
        return next;
    }

    /**
     * @param next Changes storaged node.
     */
    public void setNext(Node next) {
        this.next = next;
    }
    
    
}
