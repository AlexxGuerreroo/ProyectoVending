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

        tarjetta = true;//La comprobación que determina si es pagado con tarjeta
        //o en metálico (en este caso es con tarjeta)
        this.tarjeta = tarjeta;//La tarjeta con la cual se pagará
        this.producto = producto;//El producto a pagar
        this.introducido = producto.getPrecio();//El precio del producto a pagar
        this.cambio = 0;//Ya que se paga lo justo en tarjeta, no hay cambio
        this.deposito = deposito;//El depósito de dinero de la máquina
        fechaPago = LocalDate.now();//Recoge la fecha del pago
        horaPago = LocalTime.now();//Recoge la hora del pago

        this.tarjeta.setValido();//Comprueba si la tarjeta es válida
        if (this.tarjeta.pago(producto.getPrecio())
                && (this.producto.getCantidad() > 0)) {
            //Si la tarjeta puede realizar el pago y hay al menos un producto
            //del escogido, se podrá pagar:
            this.deposito.setDineroTarjeta(this.deposito.getDineroTarjeta()
                    + this.producto.getPrecio());//Cogerá el dinero de la tarjeta
            
            //Restará uno a la cantidad de productos
            this.producto.setCantidad(this.producto.getCantidad() - 1);
            
            fallo = false;//Y será realizado el pago con éxito

        } else {//Si una de las dos condiciones falla, saltará error
            if (this.producto.getCantidad() < 1) {
                //Si no hay stock del producto a pagar...
                System.out.println("El producto se halla agotado");

            }

            fallo = true;//Cancelará la operación

        }

    }

    //Constructor parametrizado para cuando se paga en metálico.
    public Pago(Deposito deposito, double introducido, Articulo producto) {

        tarjetta = false;//La comprobación que determina si es pagado con tarjeta
        //o en metálico (en este caso es en metálico)
        this.introducido = introducido;//El dinero introducido
        this.producto = producto;//El producto a pagar
        this.deposito = deposito;//El depósito de dinero de la máquina
        double c;//Una variable auxiliar que ayudará respecto a realizar cambio
        cambioM = new Deposito();//Un "depósito" que devolverá el cambio en monedas
        fechaPago = LocalDate.now();//Recoge la fecha del pago
        horaPago = LocalTime.now();//Recoge la hora del pago

        if (this.producto.getCantidad() > 0) {//Si el producto no está agotado

            cambio = introducido - producto.getPrecio();//Se calcula el cambio
            c = cambio * 100;//Se multiplica por 100 (se verá su utilidad más adelante

            //Algoritmo para decidir cuantas monedas se dan en el cambio.
            cambioM.setM2e((int) c / 200);//Se divide por 200 para obtener 
            //las monedas de 2€ y se le resta al depósito
            this.deposito.setM2e(this.deposito.getM2e() - cambioM.getM2e());
            c -= cambioM.getM2e() * 200;//Y se resta al auxiliar
            cambioM.setM1e((int) c / 100);//Se divide por 100 para obtener 
            //las monedas de 1€ y se le resta al depósito
            this.deposito.setM1e(this.deposito.getM1e() - cambioM.getM1e());
            c -= cambioM.getM1e() * 100;//Y se resta al auxiliar
            cambioM.setM50c((int) c / 50);//Se divide por 50 para obtener 
            //las monedas de 1€ y se le resta al depósito
            this.deposito.setM50c(this.deposito.getM50c() - cambioM.getM50c());
            c -= cambioM.getM50c() * 50;//Y se resta al auxiliar
            cambioM.setM20c((int) c / 20);//Se divide por 50 para obtener 
            //las monedas de 1€ y se le resta al depósito
            this.deposito.setM20c(this.deposito.getM20c() - cambioM.getM20c());
            c -= cambioM.getM20c() * 20;//Y se resta al auxiliar
            cambioM.setM10c((int) c / 10);//Se divide por 50 para obtener 
            //las monedas de 1€ y se le resta al depósito
            this.deposito.setM10c(this.deposito.getM10c() - cambioM.getM10c());
            c -= cambioM.getM10c() * 10;//Y se resta al auxiliar
            cambio = c;//Por último se le asigna el valor restante al cambio

            if (this.deposito.coinCheck()) {//Se comprueba si el depósito tiene
                //la cantidad de monedas necesarias para el cambio.

                this.producto.setCantidad(this.producto.getCantidad() - 1);

                fallo = false;

            } else {//De no ser así, se revierten las operaciones previas y se
                //cancela el pago

                System.out.println("No hay cambio suficiente. Lo sentimos");

                this.deposito.setM2e(this.deposito.getM2e() + cambioM.getM2e());
                this.deposito.setM1e(this.deposito.getM1e() + cambioM.getM1e());
                this.deposito.setM50c(this.deposito.getM50c() + cambioM.getM50c());
                this.deposito.setM20c(this.deposito.getM20c() + cambioM.getM20c());
                this.deposito.setM10c(this.deposito.getM10c() + cambioM.getM10c());

                fallo = true;

            }

        } else {//Si no hay stock del producto solicitado...

            System.out.println("ERROR. No hay cantidad suficiente de productos");
            fallo = true;

        }

    }

    @Override
    public String toString() {//Se muestra como si se tratase de un recibo

        if (fallo) {//Si el pago falla, será mostrado este mensaje:

            return "OPERACIÓN CANCELADA";

        } else if (tarjetta) {//Si se ha pagado con tarjeta, se muestra este 
            //tipo de recibo:

            return "Factura{\nPagado con tarjeta "
                    + "\nProducto comprado: " + producto
                    + "\nDinero introducido: " + introducido
                    + "\nFecha:  " + fechaPago + "\n}";

        } else {//Si se ha pagado en metálico, se muestra este 
            //tipo de recibo:

            return "Factura{ \nPagado en metálico "
                    + "\nProducto comprado: " + producto
                    + "\nDinero introducido: " + introducido
                    + "\nCambio : " + '(' + cambioM + "\n" + cambio + ')'
                    + "\nFecha: " + fechaPago + "\nHora: " + horaPago + "\n}";

        }
    }

}
