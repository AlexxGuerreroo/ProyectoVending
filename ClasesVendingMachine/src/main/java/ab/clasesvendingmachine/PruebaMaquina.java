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
        
        Bandeja[] rng = new Bandeja[8];
        
        rng[0] = new Bandeja();
        rng[1] = new Bandeja();
        rng[2] = new Bandeja();
        rng[3] = new Bandeja();
        rng[4] = new Bandeja();
        rng[5] = new Bandeja();
        rng[6] = new Bandeja();
        rng[7] = new Bandeja();
        
        Deposito beta = new Deposito();
        
        Maquina alfa = new Maquina(rng, beta);
        
        alfa.insertarCodigo("777");
        
    }
    
}
