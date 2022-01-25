/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ab.clasesvendingmachine;

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

    //Constructor parametrizado del depósito de dinero (monedas, billetes y transacciones).
    public Deposito(int m10c, int m20c, int m50c, int m1e, int m2e, int b5e, int b10e, int b20e, double dineroTarjeta) {
        this.m10c = m10c;
        this.m20c = m20c;
        this.m50c = m50c;
        this.m1e = m1e;
        this.m2e = m2e;
        this.b5e = b5e;
        this.b10e = b10e;
        this.b20e = b20e;
        this.dineroTarjeta = dineroTarjeta;
    }

    public Deposito(int m10c, int m20c, int m50c, int m1e, int m2e, int b5e, int b10e, int b20e) {
        
        this.m10c = m10c;
        this.m20c = m20c;
        this.m50c = m50c;
        this.m1e = m1e;
        this.m2e = m2e;
        this.b5e = b5e;
        this.b10e = b10e;
        this.b20e = b20e;
        dineroTarjeta = 0;
        
    }
    
    

    public Deposito() {

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

    public int getM10c() {
        return m10c;
    }

    public void setM10c(int m10c) {
        this.m10c = m10c;
    }

    public int getM20c() {
        return m20c;
    }

    public void setM20c(int m20c) {
        this.m20c = m20c;
    }

    public int getM50c() {
        return m50c;
    }

    public void setM50c(int m50c) {
        this.m50c = m50c;
    }

    public int getM1e() {
        return m1e;
    }

    public void setM1e(int m1e) {
        this.m1e = m1e;
    }

    public int getM2e() {
        return m2e;
    }

    public void setM2e(int m2e) {
        this.m2e = m2e;
    }

    public int getB5e() {
        return b5e;
    }

    public void setB5e(int b5e) {
        this.b5e = b5e;
    }

    public int getB10e() {
        return b10e;
    }

    public void setB10e(int b10e) {
        this.b10e = b10e;
    }

    public int getB20e() {
        return b20e;
    }

    public void setB20e(int b20e) {
        this.b20e = b20e;
    }

    public double getDineroTarjeta() {
        return dineroTarjeta;
    }

    public void setDineroTarjeta(double dineroTarjeta) {
        this.dineroTarjeta = dineroTarjeta;
    }
    
    public boolean coinCheck(){
        //El método comprueba si el depósito sea siempre pasitivo, existiendo 
        //el cambio en monedas y así poder realizar el pago.
        
        if(this.m10c >= 0 && this.m20c >= 0 && this.m50c >= 0 && this.m1e >= 0
       && this.m2e >= 0 && this.b5e >= 0 && this.b10e >= 0 && this.b20e >= 0){
        
            return true;
        
        }else{
            
            return false;
        
        }
        
    }

    @Override
    public String toString() {

        return "Depósito{\n" + "Monedas: \n -10cents: " + m10c + "\n -20cents: "
                + m20c + "\n -50cents: " + m50c + "\n -1€: " + m1e + "\n -2€: "
                + m2e + "\nBilletes: \n -5€: " + b5e + "\n -10€: " + b10e
                + "\n -20€: " + b20e + "\n introducido por crédito/débito: "
                + dineroTarjeta + "\n}";
    }

}
