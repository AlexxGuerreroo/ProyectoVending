/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ab.clasesvendingmachine;

import java.time.LocalDate;
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
            
            //Cogerá el dinero de la tarjeta y lo sumará
            this.deposito.addDineroTarjeta(this.producto.getPrecio());            

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
        double aux;//Una variable auxiliar que ayudará respecto a realizar cambio
        cambioM = new Deposito();//Un "depósito" que devolverá el cambio en monedas
        Deposito insertar = new Deposito();//Un "Depósito" auxiliar que añadirá 
        //al depósito de la máquina la cantidad introducida de monedas y billetes.
        fechaPago = LocalDate.now();//Recoge la fecha del pago
        horaPago = LocalTime.now();//Recoge la hora del pago

        if (this.producto.getCantidad() > 0) {//Si el producto no está agotado

            
            /**
             * ******************Para introducir el pago**********************
             */
                        
            aux = introducido * 100;
            insertar.addB20e((int) aux / 2000);//Se divide por 2000 para obtener 
            //los billetes de 20€ para meter en el depósito
            aux -= insertar.getB20e() * 2000;//Y se resta al auxiliar   

            insertar.addB10e((int) aux / 1000);//Se divide por 1000 para obtener 
            //los billetes de 10€ para meter en el depósito
            aux -= insertar.getB10e() * 1000;//Y se resta al auxiliar 

            insertar.addB5e((int) aux / 500);//Se divide por 500 para obtener 
            //los billetes de 5€ para meter en el depósito
            aux -= insertar.getB5e() * 500;//Y se resta al auxiliar 

            insertar.addM2e((int) aux / 200);//Se divide por 200 para obtener 
            //las monedas de 2€ para meter en el depósito
            aux -= insertar.getM2e() * 200;//Y se resta al auxiliar

            insertar.addM1e((int) aux / 100);//Se divide por 100 para obtener 
            //las monedas de 2€ para meter en el depósito
            aux -= insertar.getM1e() * 100;//Y se resta al auxiliar

            insertar.addM50c((int) aux / 50);//Se divide por 50 para obtener 
            //las monedas de 2€ para meter en el depósito
            aux -= insertar.getM50c() * 50;//Y se resta al auxiliar

            cambioM.addM20c((int) aux / 20);//Se divide por 20 para obtener 
            //las monedas de 2€ para meter en el depósito
            aux -= insertar.getM20c() * 20;//Y se resta al auxiliar

            cambioM.addM10c((int) aux / 10);//Se divide por 10 para obtener 
            //las monedas de 2€ para meter en el depósito

            //Y por último, añadimos todo al depósito:
            this.deposito.recargar(insertar.getM10c(), insertar.getM20c(),
                    insertar.getM50c(), insertar.getM1e(), insertar.getM2e(),
                    insertar.getB5e(), insertar.getB10e(), insertar.getB20e());

            
            
            /**
             * ********************Para aportar el cambio*********************
             */
                        
            cambio = introducido - producto.getPrecio();//Se calcula el cambio
            aux = cambio * 100;//Se multiplica por 100 (se verá su utilidad más adelante

            //Algoritmo para decidir cuantas monedas se dan en el cambio:
            cambioM.addM2e((int) aux / 200);//Se divide por 200 para obtener 
            //las monedas de 2€ y se le resta al depósito
            this.deposito.quitarM2e(cambioM.getM2e());
            aux -= cambioM.getM2e() * 200;//Y se resta al auxiliar

            cambioM.addM1e((int) aux / 100);//Se divide por 100 para obtener 
            //las monedas de 1€ y se le resta al depósito
            this.deposito.quitarM1e(cambioM.getM1e());
            aux -= cambioM.getM1e() * 100;//Y se resta al auxiliar

            cambioM.addM50c((int) aux / 50);//Se divide por 50 para obtener 
            //las monedas de 1€ y se le resta al depósito
            this.deposito.quitarM50c(cambioM.getM50c());
            aux -= cambioM.getM50c() * 50;//Y se resta al auxiliar

            cambioM.addM20c((int) aux / 20);//Se divide por 50 para obtener 
            //las monedas de 1€ y se le resta al depósito
            this.deposito.quitarM20c(cambioM.getM20c());
            aux -= cambioM.getM20c() * 20;//Y se resta al auxiliar

            cambioM.addM10c((int) aux / 10);//Se divide por 50 para obtener 
            //las monedas de 1€ y se le resta al depósito
            this.deposito.quitarM10c(cambioM.getM10c());
            aux -= cambioM.getM10c() * 10;//Y se resta al auxiliar

            cambio = aux;//Por último se le asigna el valor restante al cambio

            if (this.deposito.coinCheck()) {//Se comprueba si el depósito tiene
                //la cantidad de monedas necesarias para el cambio.

                this.producto.setCantidad(this.producto.getCantidad() - 1);

                fallo = false;

            } else {  //En el caso de que no haya cambio suficiente nos aparecerá
                //un error que nos impida seguir con el pago del artículo.

                System.out.println("No hay cambio suficiente. Lo sentimos");
                System.out.println("Tendrá que pagar la cantidad suficiente");

                /*
                this.deposito.addM2e(this.deposito.getM2e() + cambioM.getM2e());
                this.deposito.setM1e(this.deposito.getM1e() + cambioM.getM1e());
                this.deposito.setM50c(this.deposito.getM50c() + cambioM.getM50c());
                this.deposito.setM20c(this.deposito.getM20c() + cambioM.getM20c());
                this.deposito.setM10c(this.deposito.getM10c() + cambioM.getM10c());
                 */
                this.deposito.addM2e(cambioM.getM2e());
                this.deposito.addM1e(cambioM.getM1e());
                this.deposito.addM50c(cambioM.getM50c());
                this.deposito.addM20c(cambioM.getM20c());
                this.deposito.addM10c(cambioM.getM10c());

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
