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
        
        Bandeja random = new Bandeja();
        
        System.out.println(random);
        
        Bandeja noRandom = new Bandeja("Kit Kat", 1.60, 10, "236");
        
        System.out.println(noRandom);
        
    }
    
}
