/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ab.clasesvendingmachine;

/**
 *
 * @author fco-j
 */
public class MiTarjeta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Tarjeta1 robameFuerte = new Tarjeta1("0123456789098765", "AEC", "Contigo",
                "PIPO", "666", 420.69);
        
        Tarjeta1 trampita = new Tarjeta1("01234567890987654", "Agustín", "Nomerobas",
                "Cojones", "0", -420.69);
        
        System.out.println(robameFuerte);
        System.out.println(trampita);
        
    }
    
}
