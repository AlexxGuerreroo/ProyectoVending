/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ab.clasesvendingmachine;

public class Pago {

    private boolean tarjeta;
    private Deposito Deposito;
    private double introducido;
    private double cambio;
    private Fecha fechaPago;
    private Articulo producto;
    private Deposito cambioM;

    //Contructor parametrizado para cuando se paga con tarjeta.
    public Pago(boolean tarjeta, Deposito Deposito, Articulo producto) {

        this.tarjeta = tarjeta;
        this.producto = producto;
        this.introducido = producto.getPrecio();
        this.cambio = 0;
        this.Deposito = Deposito;
        fechaPago = new Fecha();

    }

    //Constructor parametrizado para cuando se paga en metálico.
    public Pago(Deposito Deposito, double introducido, Articulo producto) {

        tarjeta = false;
        this.introducido = introducido;
        this.producto = producto;
        this.Deposito = Deposito;
        cambio = introducido - producto.getPrecio();
        double c = cambio * 100;
        cambioM = new Deposito();

        //Algoritmo para decidir cuantas monedas se dan en el cambio.
        cambioM.setM2e((int) c / 200);
        c -= cambioM.getM2e() * 200;
        cambioM.setM1e((int) c / 100);
        c -= cambioM.getM1e() * 100;
        cambioM.setM50c((int) c / 50);
        c -= cambioM.getM50c() * 50;
        cambioM.setM20c((int) c / 20);
        c -= cambioM.getM20c() * 20;
        cambioM.setM10c((int) c / 10);
        c -= cambioM.getM10c() * 10;
        cambio = c;

    }

    public boolean isTarjeta() {
        return tarjeta;
    }

    public Deposito getDeposito() {
        return Deposito;
    }

    public double getIntroducido() {
        return introducido;
    }

    public double getCambio() {
        return cambio;
    }

    public Fecha getFechaPago() {
        return fechaPago;
    }

    public Articulo getProducto() {
        return producto;
    }

    public Deposito getCambioM() {
        return cambioM;
    }

    @Override
    public String toString() {
        return "Factura{\n" + "Pagado con tarjeta " + tarjeta + "\nProducto comprado " + producto
                + "\nDinero introducido: " + introducido + "\nEl cambio es de "
                + cambio + "\nFecha:  " + fechaPago + "\n}";
    }

}
