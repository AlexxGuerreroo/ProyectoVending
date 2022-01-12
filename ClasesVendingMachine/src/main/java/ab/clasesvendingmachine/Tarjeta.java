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
public class Tarjeta {

    private String numTarjeta;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String cvv;
    private double saldo;

    public Tarjeta(String numTarjeta, String nombre, String apellido1, String apellido2, String cvv, double saldo) {
        this.numTarjeta = numTarjeta;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.cvv = cvv;
        this.saldo = saldo;
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

    @Override
    public String toString() {
        return "Tarjeta{" + "numTarjeta=" + numTarjeta + ", nombre=" + nombre
                + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
                + ", cvv=" + cvv + ", saldo=" + saldo + '}';
    }

}
