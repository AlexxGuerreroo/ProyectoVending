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
import java.util.*;

public class PruebaMaquina {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner entry = new Scanner(System.in);
        String code;
        
        Bandeja[] rng = new Bandeja[8];
        Tarjeta[] cards = new Tarjeta[3];
        
        rng[0] = new Bandeja();
        rng[1] = new Bandeja();
        rng[2] = new Bandeja();
        rng[3] = new Bandeja();
        rng[4] = new Bandeja();
        rng[5] = new Bandeja();
        rng[6] = new Bandeja();
        rng[7] = new Bandeja();
        
        cards[0] = new Tarjeta(9);
        cards[1] = new Tarjeta(6);
        cards[2] = new Tarjeta(76);
        
        Deposito beta = new Deposito();
        
        Maquina alfa = new Maquina(rng, beta, cards);
        
        System.out.println("¿Qué código desea introducir?");
        code = entry.next();
        
        alfa.insertarCodigo(code);
        
    }
    
}
