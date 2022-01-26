/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ab.clasesvendingmachine;

/**
 *
 * @author pikac
 */
public class MiArticulo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Articulo random = new Articulo();
        
        System.out.println(random);
        
        Articulo noRandom = new Articulo("Kit Kat", 1.60, 10, "236");
        
        System.out.println(noRandom);
        
    }
    
}
