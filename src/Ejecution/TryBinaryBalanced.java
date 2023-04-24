package Ejecution;

import BalancedBinaryTree.BalancedBinaryTree;
import BalancedBinaryTree.NodeBBT;
import java.util.Random;

/**
 * TryBinaryBalanced.java
 * Class for trying balanced binary tree.
 * @author Gael Emiliano Casillas Avina (casillas.avina.gael.emiliano@gmail.com)
 * @since 04/17/2023
 */
public class TryBinaryBalanced {
    /**
     * Function for executing main class.
     * @param args Arguments for running main.
     */
    public static void main(String args[]){
        BalancedBinaryTree tree = new BalancedBinaryTree();
        Random rand = new Random();
        NodeBBT auxN;
        
        for(int i = 0; i < 15; ++i){
            int aux = rand.nextInt(1, 2000001);
            tree.inertNode(aux);
        }
        
        tree.printPrefix();
    }
}
