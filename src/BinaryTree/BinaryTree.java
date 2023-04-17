package BinaryTree;

/**
 * BinaryTree.java
 * Class for creating nodes inside of the binary tree.
 * @author Gael Emiliano Casillas Avina (casillas.avina.gael.emiliano@gmail.com)
 * @since 04/17/2023
 */
public class BinaryTree {
    
    private NodeBT initial;
    
    /**
     * Constructor for the binary tree.
     */
    public BinaryTree(){
        this.initial = null;
    }
    
    /**
     * Function for adding a new node inside the tree.
     * @param value Value of the new node.
     */
    public void insertNode(int value){
        if(this.initial == null){
            this.initial = new NodeBT(value);
        }else{
            this.initial.insertNode(value);
        }
    }
    
    /**
     * Function for printing values using prefix.
     */
    public void printPrefix(){
        this.prefix(this.initial);
    }
    
    private void prefix(NodeBT begin){
        if(begin == null){
            return;
        }else{
            System.out.print(begin.getValue() + "->");
            this.prefix(begin.getLeftNode());
            this.prefix(begin.getRightNode());
        }
    }
    
    /**
     * Call of the recursive function.
     * @param value Value of search node.
     * @return Returns found node.
     */
    public NodeBT executeSearch(int value){
        return this.searchNode(value, this.initial);
    }
    
    /**
     * Function for creating the recursive algorithm to search a node.
     * @param value Value of search node.
     * @param search Node for the recursion.
     * @return Returns if it found the node.
     */
    public NodeBT searchNode(int value, NodeBT search){
        if(search == null) return null;
        if(search.getValue() == value){
            return search;
        }else if(value < search.getValue()){
            return this.searchNode(value, search.getLeftNode());
        }else{
            return this.searchNode(value, search.getRightNode());
        }
    }
    
    /**
     * Function for getting minimum value in the binary tree.
     * @return Returns the minimum value.
     */
    public int executeMin(){
        return searchMin(this.initial);
    }
    
    /**
     * Function for creating the recursive algorithm to find the minimum value.
     * @param search Node for the recursion.
     * @return Returns the minimum number.
     */
    public int searchMin(NodeBT search){
        if(search.getLeftNode() == null){
            return search.getValue();
        }else{
            return this.searchMin(search.getLeftNode());
        }
    }
    
    /**
     * Function for getting maximum value in the binary tree.
     * @return Returns the maximum value.
     */
    public int executeMax(){
        return searchMax(this.initial);
    }
    
    /**
     * Function for creating the recursive algorithm to find the maximum value.
     * @param search Node for the recursion.
     * @return Returns the maximum number.
     */
    public int searchMax(NodeBT search){
        if(search.getRightNode() == null){
            return search.getValue();
        }else{
            return this.searchMax(search.getRightNode());
        }
    }
}
