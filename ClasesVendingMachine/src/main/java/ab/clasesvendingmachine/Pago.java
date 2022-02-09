/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ab.clasesvendingmachine;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class Pago {

    private boolean conTarjeta;
    private Tarjeta tarjeta;
    private Deposito deposito;
    private double introducido;
    private double cambio;
    private LocalDate fechaPago;
    private LocalTime horaPago;
    private Bandeja producto;
    private Deposito cambioM;
    private boolean fallo;

    public Pago() {//Este constructor vacío se creará en situación de fallo.
        
        fallo = true;
        
    }    
    
    //Contructor parametrizado para cuando se paga con tarjeta.
    public Pago(Tarjeta tarjeta, Deposito deposito, Bandeja producto) {

        conTarjeta = true;//La comprobación que determina si es pagado con tarjeta
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

            //Cogerá el dinero de la tarjeta y lo sumará
            this.deposito.addDineroTarjeta(this.producto.getPrecio());

            //Restará uno a la cantidad de productos
            this.producto.setCantidad(this.producto.getCantidad() - 1);

            fallo = false;//Y será realizado el pago con éxito

        } else {//Si una de las dos condiciones falla, saltará error            

            fallo = true;//Cancelará la operación

        }

    }

    public Pago(Deposito deposito, Bandeja producto) {

        conTarjeta = false;//La comprobación que determina si es pagado con tarjeta
        //o en metálico (en este caso es en metálico)
        introducido = 0;
        int precio = (int) (producto.getPrecio() * 10);
        this.producto = producto;//El producto a pagar.
        this.deposito = deposito;//El depósito de dinero de la máquina.
        double aux;//Una variable auxiliar que ayudará respecto a realizar cambio.
        cambioM = new Deposito();//Un "depósito" que devolverá el cambio en monedas.
        cambioM.vaciarDeposito();//Vaciamos el depósito del cambio.
        Deposito insertar = new Deposito();//Un "Depósito" auxiliar que añadirá 
        //al depósito de la máquina la cantidad introducida de monedas y billetes.
        insertar.vaciarDeposito();//Vaciamos el depósito donde que se insertará el dinero.
        fechaPago = LocalDate.now();//Recoge la fecha del pago.
        horaPago = LocalTime.now();//Recoge la hora del pago.

        if (this.producto.getCantidad() > 0) {//Si el producto no está agotado

            /**
             * ******************Para introducir el pago**********************
             */
            
            //Realizamos un bucle para pedir qué monedar se va a introducir.
            //Se efectuará el bucle hasta que se finalice el pago.
            while (introducido < precio) {
                    
                //Array que almacena las opciones de monedas que se van a poder introducir.
                String[] options = {"10 céntimos", "20 céntimos", "50 céntimos",
                    "1€", "2€", "5€", "10€", "20€"};
                
                //Pedimos en una ventana el tipo de moneda que se va a introducir
                //y lo recoge en un String llamado entry
                String entry = (String) JOptionPane.showInputDialog(null, "¿Qué moneda desea introducir?"
                        + "\n(Queda por pagar: " + ((double)(precio - introducido) / 10)
                        + "0€)", "Pasarela de Pago", JOptionPane.QUESTION_MESSAGE,
                         null, options, options[0]);                                

                switch (entry) {
                    //Según el valor de entry, se añade a un depósito la moneda/billete
                    //introducido.

                    case "10 céntimos":
                        insertar.addM10c(1);
                        introducido += 1;
                        break;

                    case "20 céntimos":
                        insertar.addM20c(1);
                        introducido += 2;
                        break;

                    case "50 céntimos":
                        insertar.addM50c(1);
                        introducido += 5;
                        break;

                    case "1€":
                        insertar.addM1e(1);
                        introducido += 10;
                        break;

                    case "2€":
                        insertar.addM2e(1);
                        introducido += 20;
                        break;

                    case "5€":
                        insertar.addB5e(1);
                        introducido += 50;
                        break;

                    case "10€":
                        insertar.addB10e(1);
                        introducido += 100;
                        break;

                    case "20€":
                        insertar.addB20e(1);
                        introducido += 200;
                        break;
                        
                    case "null"://Si se da a volver, se anula el pago.
                        fallo = true;
                        break;

                }
                
                if(fallo) break;//Al darle a volver, se rompe el bucle.

            }

            //Y por último, añadimos todo al depósito:
            this.deposito.recargar(insertar.getM10c(), insertar.getM20c(),
                    insertar.getM50c(), insertar.getM1e(), insertar.getM2e(),
                    insertar.getB5e(), insertar.getB10e(), insertar.getB20e());

            /*
             * ********************Para aportar el cambio*********************
             */
            
            cambio = introducido - precio;//Se calcula el cambio

            aux = cambio;//Se multiplica por 100 (se verá su utilidad más adelante)

            //Algoritmo para decidir cuantas monedas se dan en el cambio:
            cambioM.addM2e((int) aux / 20);//Se divide por 200 para obtener 
            //las monedas de 2€ y se resta al auxiliar           
            aux -= cambioM.getM2e() * 20;

            cambioM.addM1e((int) aux / 10);//Se divide por 100 para obtener 
            //las monedas de 1€ y se resta al auxiliar           
            aux -= cambioM.getM1e() * 10;

            cambioM.addM50c((int) aux / 5);//Se divide por 50 para obtener 
            //las monedas de 50 céntimos y se resta al auxiliar          
            aux -= cambioM.getM50c() * 5;

            cambioM.addM20c((int) aux / 2);//Se divide por 20 para obtener 
            //las monedas de 20 céntimos y se resta al auxiliar          
            aux -= cambioM.getM20c() * 2;

            cambioM.addM10c((int) aux);//Se divide por 10 para obtener 
            //las monedas de 10 céntimos

            if (this.deposito.coinCheck(cambioM)) {//Se comprueba si el depósito tiene
                //la cantidad de monedas necesarias para el cambio.

                this.deposito.quitarM2e(cambioM.getM2e());
                this.deposito.quitarM1e(cambioM.getM1e());
                this.deposito.quitarM50c(cambioM.getM50c());
                this.deposito.quitarM20c(cambioM.getM20c());
                this.deposito.quitarM10c(cambioM.getM10c());
                this.producto.setCantidad(this.producto.getCantidad() - 1);

                fallo = false;

            } else {  //En el caso de que no haya cambio suficiente nos aparecerá
                //un error que nos impida seguir con el pago del artículo.

                JOptionPane.showMessageDialog(null, "Lo sentimos, la máquina no "
                        + "dispone de cambbio suficiente.\t Tendrá que pagar la cantidad justa",
                        "Pago Insuficiente", JOptionPane.ERROR_MESSAGE);

                //Y quitamos todo lo que hemos añadido en la operación:
                this.deposito.quitarM2e(insertar.getM2e());
                this.deposito.quitarM1e(insertar.getM1e());
                this.deposito.quitarM50c(insertar.getM50c());
                this.deposito.quitarM20c(insertar.getM20c());
                this.deposito.quitarM10c(insertar.getM10c());

                fallo = true;

            }

        }

    }

    @Override   //toString que muestra los racibos al efectuar el pago.
    public String toString() {

        if (fallo) {//Si el pago falla, se mostrará este mensaje.

            return "OPERACIÓN CANCELADA";

        } else if (conTarjeta) {//Si se paga con tarjeta, se muestra este recibo.

            return "Factura{\nPagado con tarjeta "
                    + "\nProducto comprado: " + producto.forFactura()
                    + "\nDinero introducido: " + introducido
                    + "€\nFecha:  " + fechaPago + "\n}";

        } else {//Si se paga en metálico, se muestra este recibo. 

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            
            return "Factura{ \nPagado en metálico "
                    + "\nProducto comprado: " + producto.forFactura()
                    + "\nDinero introducido: " + (introducido/10)
                    + "€\nCambio : \n" + '(' + cambioM.mostrarCambio() + "\n"
                    + ')' + "\nFecha: " + fechaPago + "\nHora: "
                    + horaPago.format(formatter) + "\n}";

        }
    }
}