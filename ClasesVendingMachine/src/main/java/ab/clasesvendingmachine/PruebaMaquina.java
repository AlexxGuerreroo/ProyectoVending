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
public class PruebaMaquina {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Articulo[] rng = new Articulo[8];
        
        rng[0] = new Articulo();
        rng[1] = new Articulo();
        rng[2] = new Articulo();
        rng[3] = new Articulo();
        rng[4] = new Articulo();
        rng[5] = new Articulo();
        rng[6] = new Articulo();
        rng[7] = new Articulo();
        
        Deposito beta = new Deposito();
        
        Maquina alfa = new Maquina(rng, beta);
        
        alfa.insertarCodigo("777");
        
    }
    
}
