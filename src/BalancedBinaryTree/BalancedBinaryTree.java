package BalancedBinaryTree;

/**
 * BalancedBinaryTree.java
 * Class for creatingb a Balanced Binary Tree.
 * @author Gael Emiliano Casillas Avina (casillas.avina.gael.emiliano@gmail.com)
 * @since 04/24/2023
 */
public class BalancedBinaryTree {
    
    private NodeBBT initial;
    
    /**
     * Constructor for the balanced binary tree.
     */
    public BalancedBinaryTree(){
        this.initial = null;
    }
    
    /**
     * Call of the recursive function.
     * @param value Value of search node.
     * @return Returns found node.
     */
    public NodeBBT executeSearch(int value){
        return this.searchNode(value, this.initial);
    }
    
    /**
     * Function for creating the recursive algorithm to search a node.
     * @param value Value of search node.
     * @param search Node for the recursion.
     * @return Returns if it found the node.
     */
    private NodeBBT searchNode(int value, NodeBBT search){
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
     * Function for doing a left rotation.
     * @param node Original pivot node.
     * @return Returns the reference of the new pivot node.
     */
    private NodeBBT leftRotation(NodeBBT node){
        NodeBBT aux = node.getLeftNode();
        node.setLeftNode(aux.getRightNode());
        aux.setRightNode(node);
        node.setBf(Math.max(obtainBf(node.getLeftNode()), obtainBf(node.getRightNode())) + 1);
        aux.setBf(Math.max(obtainBf(aux.getLeftNode()), obtainBf(aux.getRightNode())) + 1);
        return aux;
    }
    
    /**
     * Function for doing a right rotation.
     * @param node Original pivot node.
     * @return Returns the reference of the new pivot node.
     */
    private NodeBBT rightRotation(NodeBBT node){
        NodeBBT aux = node.getRightNode();
        node.setRightNode(aux.getLeftNode());
        aux.setLeftNode(node);
        node.setBf(Math.max(obtainBf(node.getLeftNode()), obtainBf(node.getRightNode())) + 1);
        aux.setBf(Math.max(obtainBf(aux.getLeftNode()), obtainBf(aux.getRightNode())) + 1);
        return aux;
    }
    
    /**
     * Function for doing a double left rotation.
     * @param node Original pivot node.
     * @return Returns the reference of the new pivot node.
     */
    private NodeBBT doubleLeftRotation(NodeBBT node){
        NodeBBT aux;
        node.setLeftNode(this.rightRotation(node.getLeftNode()));
        aux = this.leftRotation(node);
        return aux;
    }
    
    /**
     * Function for doing a double right rotation.
     * @param node Original pivot node.
     * @return Returns the reference of the new pivot node.
     */
    private NodeBBT doubleRightRotation(NodeBBT node){
        NodeBBT aux;
        node.setRightNode(this.leftRotation(node.getRightNode()));
        aux = this.rightRotation(node);
        return aux;
    }
    
    /**
     * Function for executing the insert algorithm.
     * @param value Value to insert inside the balanced binary tree.
     */
    public void inertNode(int value){
        NodeBBT aux = this.executeSearch(value);
        if(aux != null){
            aux.setCounter(aux.getCounter() + 1);
        }else{
            NodeBBT newNode = new NodeBBT(value);
            if(initial == null){
                initial = newNode;
            }else{
                initial = this.insertBBT(newNode, initial);
            }
        }
    }
    
    /**
     * Funciton for inserting new elements inside the balanced binary tree with recursion.
     * @param newNode Node to insert.
     * @param subTree Subtree of the node.
     * @return Returns the new pivto node.
     */
    private NodeBBT insertBBT(NodeBBT newNode, NodeBBT subTree){
        NodeBBT newFather = subTree;
        if(newNode.getValue() < subTree.getValue()){
            if(subTree.getLeftNode() == null){
                subTree.setLeftNode(newNode);
            }else{
                subTree.setLeftNode(this.insertBBT(newNode, subTree.getLeftNode()));
                if(obtainBf(subTree.getLeftNode()) - obtainBf(subTree.getRightNode()) == 2){
                    if(newNode.getValue() < subTree.getLeftNode().getValue()){
                        newFather = this.leftRotation(subTree);
                    }else{
                        newFather = this.doubleLeftRotation(subTree);
                    }
                }
            }
        }else if(newNode.getValue() > subTree.getValue()){
            if(subTree.getRightNode() == null){
                subTree.setRightNode(newNode);
            }else{
                subTree.setRightNode(this.insertBBT(newNode, subTree.getRightNode()));
                if(obtainBf(subTree.getRightNode()) - obtainBf(subTree.getLeftNode()) == 2){
                    if(newNode.getValue() > subTree.getRightNode().getValue()){
                        newFather = this.rightRotation(subTree);
                    }else{
                        newFather = this.doubleRightRotation(subTree);
                    }
                }
            }
        }
        
        if((subTree.getLeftNode() == null) && (subTree.getRightNode() != null)){
            subTree.setBf(subTree.getRightNode().getBf() + 1);
        }else if((subTree.getRightNode() == null) && (subTree.getLeftNode() != null)){
            subTree.setBf(subTree.getLeftNode().getBf() + 1);
        }else{
            subTree.setBf(Math.max(obtainBf(subTree.getLeftNode()), obtainBf(subTree.getRightNode())) + 1);
        }
        
        return newFather;
    }
    
    /**
     * Function for printing values using prefix.
     */
    public void printPrefix(){
        this.prefix(this.initial);
    }
    
    /**
     * Function for printing the tree in prefix way using recursion.
     * @param begin Node for recursion.
     */
    private void prefix(NodeBBT begin){
        if(begin == null){
            return;
        }else{
            System.out.print(begin.getValue() + "->");
            this.prefix(begin.getLeftNode());
            this.prefix(begin.getRightNode());
        }
    }
    
    /**
     * 
     */
    private int obtainBf(NodeBBT node){
        if(node == null){
            return -1;
        }else{
            return node.getBf();
        }
    }
}
