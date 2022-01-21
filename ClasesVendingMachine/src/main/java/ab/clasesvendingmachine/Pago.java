/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ab.clasesvendingmachine;

// Clase para tratar fechas (sÃ³lo dÃ­a, mes y aÃ±o)
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
// Enumerado para los meses del aÃ±o (Enero, ...)
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.time.LocalTime;

public class Pago {

    private boolean tarjetta;
    private Tarjeta tarjeta;
    private Deposito deposito;
    private double introducido;
    private double cambio;
    private LocalDate fechaPago;
    private LocalTime horaPago;
    private Articulo producto;
    private Deposito cambioM;
    private boolean fallo;

    //Contructor parametrizado para cuando se paga con tarjeta.
    public Pago(Tarjeta tarjeta, Deposito deposito, Articulo producto) {

        tarjetta = true;
        this.tarjeta = tarjeta;
        this.producto = producto;
        this.introducido = producto.getPrecio();
        this.cambio = 0;
        this.deposito = deposito;
        fechaPago = LocalDate.now();
        horaPago = LocalTime.now();

        this.tarjeta.setValido();
        if (this.tarjeta.pago(producto.getPrecio())
                && (this.producto.getCantidad() > 0)) {

            this.deposito.setDineroTarjeta(this.deposito.getDineroTarjeta()
                    + this.producto.getPrecio());
            this.producto.setCantidad(this.producto.getCantidad() - 1);
            fallo = false;

        } else {
            if (this.producto.getCantidad() < 1) {

                System.out.println("El producto se halla agotado");

            }
            
            fallo = true;
            
        }

    }

    //Constructor parametrizado para cuando se paga en metálico.
    public Pago(Deposito deposito, double introducido, Articulo producto) {

        tarjetta = false;
        this.introducido = introducido;
        this.producto = producto;
        this.deposito = deposito;
        double c;
        cambioM = new Deposito();
        fechaPago = LocalDate.now();
        horaPago = LocalTime.now();

        if (this.producto.getCantidad() > 0) {

            cambio = introducido - producto.getPrecio();
            c = cambio * 100;

            //Algoritmo para decidir cuantas monedas se dan en el cambio.
            cambioM.setM2e((int) c / 200);
            this.deposito.setM2e(this.deposito.getM2e() - cambioM.getM2e());
            c -= cambioM.getM2e() * 200;
            cambioM.setM1e((int) c / 100);
            this.deposito.setM1e(this.deposito.getM1e() - cambioM.getM1e());
            c -= cambioM.getM1e() * 100;
            cambioM.setM50c((int) c / 50);
            this.deposito.setM50c(this.deposito.getM50c() - cambioM.getM50c());
            c -= cambioM.getM50c() * 50;
            cambioM.setM20c((int) c / 20);
            this.deposito.setM20c(this.deposito.getM20c() - cambioM.getM20c());
            c -= cambioM.getM20c() * 20;
            cambioM.setM10c((int) c / 10);
            this.deposito.setM10c(this.deposito.getM10c() - cambioM.getM10c());
            c -= cambioM.getM10c() * 10;
            cambio = c;
            
            if(this.deposito.coinCheck()){
            
                this.producto.setCantidad(this.producto.getCantidad() - 1);

                fallo = false;
            
            }else{
                
                System.out.println("No hay cambio suficiente. Lo sentimos");
                
                this.deposito.setM2e(this.deposito.getM2e() + cambioM.getM2e());
                this.deposito.setM1e(this.deposito.getM1e() + cambioM.getM1e());
                this.deposito.setM50c(this.deposito.getM50c() + cambioM.getM50c());
                this.deposito.setM20c(this.deposito.getM20c() + cambioM.getM20c());
                this.deposito.setM10c(this.deposito.getM10c() + cambioM.getM10c());
                
                fallo = true;
                
            }

        } else {

            System.out.println("ERROR. No hay cantidad suficiente de productos");
            fallo = true;

        }

    }

    @Override
    public String toString() {

        if (fallo) {
            
            return "OPERACIÓN CANCELADA";
            
        } else if (tarjetta) {
            
            return "Factura{\nPagado con tarjeta "
                    + "\nProducto comprado: " + producto
                    + "\nDinero introducido: " + introducido
                    + "\nFecha:  " + fechaPago + "\n}";
            
        } else {

            return "Factura{ \nPagado en metálico "
                    + "\nProducto comprado: " + producto
                    + "\nDinero introducido: " + introducido
                    + "\nCambio : " + cambio + '(' + cambioM + ')'
                    + "\nFecha: " + fechaPago + "\nHora: " + horaPago + "\n}";

        }
    }

}
