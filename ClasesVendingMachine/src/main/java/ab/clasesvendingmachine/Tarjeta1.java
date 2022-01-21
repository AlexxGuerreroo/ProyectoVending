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
public class Tarjeta1 {

    private String numTarjeta;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String cvv;
    private double saldo;
    private boolean valido = true;

    public Tarjeta1(String numTarjeta, String nombre, String apellido1, 
            String apellido2, String cvv, double saldo) {
        
        if(numTarjeta.length() == 16){
            
            this.numTarjeta = numTarjeta;
        }else{
            System.out.println("Nº de tarjeta introducido incorrecto");
            this.numTarjeta = "0000000000000000";
            valido = false;
        }
        
            this.nombre = nombre;
            this.apellido1 = apellido1;
            this.apellido2 = apellido2;
            
        if(cvv.length() == 3){
            this.cvv = cvv;
        }else{
            System.out.println("Nº secreto introducido incorrecto");
            this.cvv = "000";
            valido = false;
        }
        
        this.saldo = saldo;
        if (saldo < 0){
            
            valido = false;
            
        }
            
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getCvv() {
        return cvv;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isValido() {
        return valido;
    }
    
    

    @Override
    public String toString() {
        return "Tarjeta{" + "numTarjeta=" + numTarjeta + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", cvv=" + cvv + ", saldo=" + saldo + ", valido=" + valido + '}';
    }

}
