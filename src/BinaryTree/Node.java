package BinaryTree;

/**
 * Node.java
 * Class for creating nodes inside of the binary tree.
 * @author Gael Emiliano Casillas Avina (casillas.avina.gael.emiliano@gmail.com)
 * @since 04/16/2023
 */
public class Node {
    
    private int value;
    private Node leftNode;
    private Node rightNode;
    private int contador;
    
    /**
     * Constructor of a node.
     * @param value Value of a node.
     */
    public Node(int value){
        this.value = value;
        this.contador = 1;
        this.leftNode = null;
        this.rightNode = null;
    }

    /**
     * Function to get the value of the node.
     * @return Returns the value of the node.
     */
    public int getValue() {
        return value;
    }

    /**
     * Function for setting the value of the node.
     * @param value New value of the node.
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Obtains the left node.
     * @return Returns left node.
     */
    public Node getLeftNode() {
        return leftNode;
    }

    /**
     * Obtains the right node.
     * @return Returns right node.
     */
    public Node getRightNode() {
        return rightNode;
    }
    
    /**
     * Inserts a new node inside the tree.
     * @param value The new value to add
     */
    public void insertNode(int value){
        if(value == this.value){
            this.contador++;
            return;
        }
        if(value < this.value){
            if(this.leftNode == null){
                this.leftNode = new Node(value);
            }else{
                this.leftNode.insertNode(value);
            }
        }else{
            if(this.rightNode == null){
                this.rightNode = new Node(value);
            }else{
                this.rightNode.insertNode(value);
            }
        }   
    }
}
