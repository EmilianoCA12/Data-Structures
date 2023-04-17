package BinaryTree;

/**
 * NodeBBT.java
 * Class for creating nodes inside of the binary tree.
 * @author Gael Emiliano Casillas Avina (casillas.avina.gael.emiliano@gmail.com)
 * @since 04/17/2023
 */
public class NodeBBT {
    
    private int value;
    private NodeBBT leftNode;
    private NodeBBT rightNode;
    private int contador;
    
    /**
     * Constructor of a node.
     * @param value Value of a node.
     */
    public NodeBBT(int value){
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
    public NodeBBT getLeftNode() {
        return leftNode;
    }

    /**
     * Obtains the right node.
     * @return Returns right node.
     */
    public NodeBBT getRightNode() {
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
                this.leftNode = new NodeBBT(value);
            }else{
                this.leftNode.insertNode(value);
            }
        }else{
            if(this.rightNode == null){
                this.rightNode = new NodeBBT(value);
            }else{
                this.rightNode.insertNode(value);
            }
        }   
    }
}
