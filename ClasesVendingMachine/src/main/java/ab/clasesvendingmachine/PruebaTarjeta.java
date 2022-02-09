/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ab.clasesvendingmachine;

/**
 *
 * @author fco-j
 */
public class PruebaTarjeta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Tarjeta t1 = new Tarjeta();
        Tarjeta t2 = new Tarjeta("0486578623384976", "864", 532.69, 8,
                2034);

        Tarjeta t3 = new Tarjeta();

        System.out.println("T1: \n" + t1 + "\n");

        t3.copiar(t2);

        System.out.println("T3: \n" + t3 + "\n");
                
        t2.setValido();
        
        System.out.println("T2: \n" + t2 + "\n");

        t2.pago(600);        

        t2.anular();

        t2.pago(200);

        t3.setValido();

        t3.pago(200);

        System.out.println("T3: \n" + t3 + "\n");

    }

}
