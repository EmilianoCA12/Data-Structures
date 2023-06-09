package Ejecution;

import BinaryTree.*;
import java.util.Random;

/**
 * TryBinary.java
 * Class for trying binary tree.
 * @author Gael Emiliano Casillas Avina (casillas.avina.gael.emiliano@gmail.com)
 * @since 04/17/2023
 */
public class TryBinary {
    /**
     * Function for executing main class.
     * @param args Arguments for running main.
     */
    public static void main(String args[]){
        
        BinaryTree tree = new BinaryTree();
        Random rand = new Random();
        NodeBT auxN;
        
        for(int i = 0; i < 1000000; ++i){
            int aux = rand.nextInt(1, 2000001);
            tree.insertNode(aux);
        }
        
        for(int i = 0; i < 50; ++i){
            
            long begin = System.nanoTime();
            
            int aux = rand.nextInt(1, 2000001);
            
            auxN = tree.executeSearch(aux);
            
            long end = System.nanoTime();
            
            if(auxN == null){
                System.out.println("Resultado: Inexistente -- Tiempo: " + (end - begin));
            }else{
                System.out.println("Resultado: " + auxN + " -- Tiempo: " + (end - begin));
            }
        }
        
        System.out.println("Valor minimo: " + tree.executeMin());
        System.out.println("Valor maximo: " + tree.executeMax());
    }
}
