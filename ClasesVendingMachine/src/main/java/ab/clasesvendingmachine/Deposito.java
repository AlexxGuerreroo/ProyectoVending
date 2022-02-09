/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ab.clasesvendingmachine;

import java.time.LocalDate;

/**
 *
 * @author alexx
 */
public class Deposito {

    //Guardamos los valores de las monedas y billetes en estos atributos.
    private int m10c;  //Monedas de 10 centimos.
    private int m20c;   //Monedas de 20 centimos.
    private int m50c;   //Monedas de 50 centimos.
    private int m1e;    //Monedas de 1 euros.
    private int m2e;   //Monedas de 2 euros.  
    private int b5e;    //Billetes de 5 euros.
    private int b10e;   //Billetes de 10 euros.
    private int b20e;   //Billetes de 20 euros.
    private double dineroTarjeta; //Dinero recibido de una tarjeta (débito o crédito).
    private LocalDate fechaUltRecaudacion;
    private LocalDate fechaUltRecarga;

    
    public Deposito(int m10c, int m20c, int m50c, int m1e, int m2e, int b5e,
            int b10e, int b20e, double dineroTarjeta) {
    //Constructor parametrizado del depósito de dinero (monedas, billetes y transacciones).

        this.m10c = m10c;
        this.m20c = m20c;
        this.m50c = m50c;
        this.m1e = m1e;
        this.m2e = m2e;
        this.b5e = b5e;
        this.b10e = b10e;
        this.b20e = b20e;
        this.dineroTarjeta = dineroTarjeta;

        //Se le aportarán a las fechas un valor por defecto: 1/1/2022 :
        fechaUltRecaudacion = LocalDate.of(2022, 1, 1);
        fechaUltRecarga = LocalDate.of(2022, 1, 1);

    }

    public Deposito(int m10c, int m20c, int m50c, int m1e, int m2e, int b5e,
             int b10e, int b20e) {
    //Constructor parametrizado del depósito de dinero (monedas y billetes)

    //Por motivos de claridad, se ha decidido crear las variables para las 
    //monedas y billetes por separado, en lugar de incluirlo todo en un array.
        this.m10c = m10c;
        this.m20c = m20c;
        this.m50c = m50c;
        this.m1e = m1e;
        this.m2e = m2e;
        this.b5e = b5e;
        this.b10e = b10e;
        this.b20e = b20e;
        dineroTarjeta = 0;

        //Se le aportarán a las fechas el valor por defecto: 1/1/2022 :
        fechaUltRecaudacion = LocalDate.of(2022, 1, 1);
        fechaUltRecarga = LocalDate.of(2022, 1, 1);

    }

    public Deposito() {

        m10c = 15;
        m20c = 15;
        m50c = 15;
        m1e = 15;
        m2e = 15;
        b5e = 0;
        b10e = 0;
        b20e = 0;
        dineroTarjeta = 0;

    }

    public void vaciarDeposito() {

        m10c = 0;
        m20c = 0;
        m50c = 0;
        m1e = 0;
        m2e = 0;
        b5e = 0;
        b10e = 0;
        b20e = 0;
        dineroTarjeta = 0;

    }
    
    public void recaudarDeposito() {

        m10c = 10;
        m20c = 10;
        m50c = 10;
        m1e = 10;
        m2e = 10;
        b5e = 10;
        b10e = 10;
        b20e = 10;
        dineroTarjeta = 0;

    }

    public int getM10c() {

        return m10c;

    }

    public void addM10c(int m10c) {

        this.m10c += m10c;

    }

    public int getM20c() {

        return m20c;

    }

    public void addM20c(int m20c) {

        this.m20c += m20c;

    }

    public int getM50c() {

        return m50c;

    }

    public void addM50c(int m50c) {

        this.m50c += m50c;

    }

    public int getM1e() {

        return m1e;

    }

    public void addM1e(int m1e) {

        this.m1e += m1e;

    }

    public int getM2e() {

        return m2e;

    }

    public void addM2e(int m2e) {

        this.m2e += m2e;

    }

    public int getB5e() {

        return b5e;

    }

    public void addB5e(int b5e) {

        this.b5e += b5e;

    }

    public int getB10e() {

        return b10e;

    }

    public void addB10e(int b10e) {

        this.b10e += b10e;

    }

    public int getB20e() {

        return b20e;

    }

    public void addB20e(int b20e) {

        this.b20e += b20e;

    }

    public double getDineroTarjeta() {
        return dineroTarjeta;
    }

    public void recargar(int m10c, int m20c, int m50c, int m1e, int m2e,
            int b5e, int b10e, int b20e) {
        //Este método servirá para llamar a todos los add, en vez de llamarlos 
        //uno a uno 

        this.addM10c(m10c);
        this.addM20c(m20c);
        this.addM50c(m50c);
        this.addM1e(m1e);
        this.addM2e(m2e);
        this.addB5e(b5e);
        this.addB10e(b10e);
        this.addB20e(b20e);
        

    }
    
    public void recargarM(int m10c, int m20c, int m50c, int m1e, int m2e) {
        //Este método servirá para llamar a todos los add, en vez de llamarlos 
        //uno a uno 

        this.addM10c(m10c);
        this.addM20c(m20c);
        this.addM50c(m50c);
        this.addM1e(m1e);
        this.addM2e(m2e);

    }

    public boolean coinCheck(Deposito d) {
        //El método comprueba si el depósito posee más monedas que el del 
        //parámetro (el cambio), para así poder realizar el pago:

        if (this.m10c >= d.getM10c() && this.m20c >= d.getM20c()
                && this.m50c >= d.getM50c() && this.m1e >= d.getM1e()
                && this.m2e >= d.getM2e()) {

            return true;

        } else {

            return false;

        }

    }

    public void quitarM10c(int m10c) {

        this.m10c -= m10c;

    }

    public void quitarM20c(int m20c) {

        this.m20c -= m20c;

    }

    public void quitarM50c(int m50c) {

        this.m50c -= m50c;

    }

    public void quitarM1e(int m1e) {

        this.m1e -= m1e;

    }

    public void quitarM2e(int m2e) {

        this.m2e -= m2e;

    }

    public void setB5e(int b5e) {

        this.b5e = b5e;

    }

    public void setB10e(int b10e) {

        this.b10e = b10e;

    }

    public void setB20e(int b20e) {

        this.b20e = b20e;

    }

    public void addDineroTarjeta(double dineroTarjeta) {

        this.dineroTarjeta += dineroTarjeta;

    }

    public void quitarDineroTarjeta(double dineroTarjeta) {

        this.dineroTarjeta -= dineroTarjeta;

    }

    public void setFechaUltRecaudacion(LocalDate fechaUltRecaudacion) {

        this.fechaUltRecaudacion = fechaUltRecaudacion;

    }

    public void setFechaUltRecarga(LocalDate fechaUltRecarga) {

        this.fechaUltRecarga = fechaUltRecarga;

    }
    
    public String mostrarCambio(){
        //Devolverá solo las monedas, de forma parecida al toString();
                
        return "\n" + "Monedas: \n -10cents: " + m10c + "\n -20cents: "
                + m20c + "\n -50cents: " + m50c + "\n -1€: " + m1e + "\n -2€: "
                + m2e;
        
    }

    @Override
    public String toString() {

        return "Depósito{\n" + "Monedas: \n -10cents: " + m10c + "\n -20cents: "
                + m20c + "\n -50cents: " + m50c + "\n -1€: " + m1e + "\n -2€: "
                + m2e + "\nBilletes: \n -5€: " + b5e + "\n -10€: " + b10e
                + "\n -20€: " + b20e + "\n Introducido por crédito/débito: "
                + dineroTarjeta + "\nÚltima recarga: " + fechaUltRecarga
                + "\nÚltima recaudación: " + fechaUltRecaudacion + "\n}";
    }

}
