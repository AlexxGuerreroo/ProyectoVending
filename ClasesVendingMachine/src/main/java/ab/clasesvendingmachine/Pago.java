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
    private Deposito Deposito;
    private double introducido;
    private double cambio;
    private LocalDate fechaPago;
    private LocalTime horaPago;
    private Articulo producto;
    private Deposito cambioM;
    private boolean fallo;

    //Contructor parametrizado para cuando se paga con tarjeta.
    public Pago(Tarjeta tarjeta, Deposito Deposito, Articulo producto) {

        tarjetta = true;
        this.tarjeta = tarjeta;
        this.producto = producto;
        this.introducido = producto.getPrecio();
        this.cambio = 0;
        this.Deposito = Deposito;
        fechaPago = LocalDate.now();
        horaPago = LocalTime.now();
        
        if(this.tarjeta.getSaldo() >= producto.getPrecio() 
                && this.producto.getCantidad() > 0 && this.tarjeta.isValido()){
            
            this.tarjeta.setSaldo(this.tarjeta.getSaldo() - producto.getPrecio());
            this.Deposito.setDineroTarjeta(this.Deposito.getDineroTarjeta() + 
                producto.getPrecio());
            this.producto.setCantidad(this.producto.getCantidad() - 1);
            fallo = false;
            
        }else if (this.tarjeta.getSaldo() < producto.getPrecio() 
                || !this.tarjeta.isValido()){
            
            System.out.println("ERROR. No hay saldo suficiente en la tarjeta");
            fallo = true;
            
        }else{
            
            System.out.println("ERROR. No hay cantidad suficiente de productos");
            fallo = true;
            
        }

    }

    //Constructor parametrizado para cuando se paga en metálico.
    public Pago(Deposito Deposito, double introducido, Articulo producto) {

        tarjetta = false;
        this.introducido = introducido;
        this.producto = producto;
        this.Deposito = Deposito;
        double c;
        cambioM = new Deposito();
        fechaPago = LocalDate.now();
        horaPago = LocalTime.now();
        
        if(this.producto.getCantidad() > 0){
              
            cambio = introducido - producto.getPrecio();
            c = cambio * 100;
            this.producto.setCantidad(this.producto.getCantidad() - 1);
            
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
        
        fallo = false;
            
        }else{
            
            System.out.println("ERROR. No hay cantidad suficiente de productos");
            fallo = true;
            
        }
        
    }

    @Override
    public String toString() {
        
        if (fallo){
            return "OPERACIÓN CANCELADA";
        }else if(tarjetta){
            return "Factura{\nPagado con tarjeta " 
                    + "\nProducto comprado: " + producto
                    + "\nDinero introducido: " + introducido 
                    + "\nFecha:  " + fechaPago + "\n}";
        }else{
            
            return "Factura{ \nPagado en metálico "
                    + "\nProducto comprado: " + producto
                    + "\nDinero introducido: " + introducido 
                    + "\nCambio : " + cambio  + '(' + cambioM + ')'
                    + "\nFecha: " + fechaPago + "\nHora: " + horaPago + "\n}";
            
        }
    }

}
