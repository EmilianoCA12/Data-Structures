package BalancedBinaryTree;

/**
 * NodeBBT.java
 * Class for creating the node of a Balanced Binary Tree.
 * @author Gael Emiliano Casillas Avina (casillas.avina.gael.emiliano@gmail.com)
 * @since 04/24/2023
 */
public class NodeBBT {
    
    private int value;
    private int bf;
    private int counter;
    private NodeBBT leftNode;
    private NodeBBT rightNode;
    
    /**
     * Constructor of a node for Balanced Binary Tree.
     * @param value Value of a node.
     */
    public NodeBBT(int value){
        this.value = value;
        this.bf = 0;
        this.counter = 1;
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
     * Function for getting the balance factor.
     * @return Returns the balance factor.
     */
    public int getBf(){
        return bf;
    }
    
    /**
     * Function for setting the balance factor.
     * @param bf New balance factor.
     */
    public void setBf(int bf){
        this.bf = bf;
    }
    
    /**
     * Obtains the left node.
     * @return Returns left node.
     */
    public NodeBBT getLeftNode() {
        return leftNode;
    }
    
    /**
     * Funciton for setting left node.
     * @param leftNode New left node.
     */
    public void setLeftNode(NodeBBT leftNode){
        this.leftNode = leftNode;
    }

    /**
     * Obtains the right node.
     * @return Returns right node.
     */
    public NodeBBT getRightNode() {
        return rightNode;
    }
    
    /**
     * Funciton for setting left node.
     * @param rightNode New right node.
     */
    public void setRightNode(NodeBBT rightNode){
        this.rightNode = rightNode;
    }
    
    /**
     * Function for getting the amount of repeated nodes.
     * @return Returns the counter of repeated nodes.
     */
    public int getCounter(){
        return this.counter;
    }
    
    /**
     * Function for setting new amount of repeated nodes.
     * @param counter New amount of repeated nodes.
     */
    public void setCounter(int counter){
        this.counter = counter;
    }
}
