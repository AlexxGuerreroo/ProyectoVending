/*
Requisitos de la práctica:
1. Funciones del administrador.
    Consultar y cambiar el código de las bandejas.
    Consultar y cambiar el producto contenido en las bandejas.
    Consultar y cambiar el stock de las bandejas usando el código de las mismas
    cantidad máxima 15 artículos).
    Consultar el efectivo que hay en la máquina.
    Recaudar el dinero de la máquina (debe quedar registrado la fecha de recaudación).
    Recargar efectivo para que la máquina siempre tenga dinero (debe quedar registado la fecha de recargo).
    Consultar el dinero recaudado mediante tarjetas de créditos.
 */
package ab.clasesvendingmachine;

import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author pikac
 */
public class AdminMode {

    private final Maquina maquina;

    public AdminMode(Maquina maquina) {

        this.maquina = maquina;

        optionSelect();

    }

    public void optionSelect() {
        //Este método indicará los métodos para poder seleccionarse:

        Scanner entry = new Scanner(System.in);
        
        //Declaramos variables que vamos a necesitar.
        int select, p;
        boolean repetir;
        
        do {                    
            
        //Método que nos indicará las opciones que podemos elegir dentro del modo 
        //administrador.
        try{

            System.out.println("ESTÁ EN MODO ADMINISTRADOR");
            System.out.println("Elige una opción:");
            System.out.println("*********************************");
            System.out.println("1: Consultar Bandejas");
            System.out.println("2: Consultar Dinero");
            System.out.println("3: Recaudar Dinero");
            System.out.println("4: Recargar Dinero");
            System.out.println("5: Cambiar Código de una Bandeja");
            System.out.println("6: Cambiar Producto de una Bandeja");
            System.out.println("7: Cambiar Stock de una Bandeja");
            System.out.println("8: Cambiar Precio de un Producto");
            System.out.println("*********************************");
        
        //Seleccionamos las opciones mediante un número introducido por Scanner
            select = entry.nextInt();

            //Bucle switch que mediante el valor introducido por scanner 
            //anteriormente, nos dará acceso a a cada uno de los métodos
            switch(select){

                case 1:

                    this.consultarBandejas();
                    repetir = true;
                    break;

                case 2:

                    this.consultarDeposito();
                    repetir = true;
                    break;

                case 3:

                    this.recaudarDelDeposito();
                    repetir = true;
                    break;
                    
                //Un sout nos preguntará por el número de monedas que queremos
                //recargar en la máquina.        
                case 4: 

                    int a, b, c, d, e, f, g, h;

                    System.out.println("¿Cuántas monedas de 10cent quiere añadir?");
                    a = entry.nextInt();

                    System.out.println("¿Cuántas monedas de 20cent quiere añadir?");
                    b = entry.nextInt();

                    System.out.println("¿Cuántas monedas de 50cent quiere añadir?");
                    c = entry.nextInt();

                    System.out.println("¿Cuántas monedas de 1€ quiere añadir?");
                    d = entry.nextInt();

                    System.out.println("¿Cuántas monedas de 2€ quiere añadir?");
                    e = entry.nextInt();

                    System.out.println("¿Cuántos billetes de 5€ quiere añadir?");
                    f = entry.nextInt();

                    System.out.println("¿Cuántos billetes de 10€ quiere añadir?");
                    g = entry.nextInt();

                    System.out.println("¿Cuántos billetes de 20€ quiere añadir?");
                    h = entry.nextInt();

                    this.recargarDeposito(a, b, c, d, e, f, g, h);
                    repetir = true;
                    break;
                
                //Seleccionando este método, volvemos a introducir el número del
                //artículo y elegimos el nuevo valor que le queremos dar.
                case 5:

                    String newC;

                    System.out.println("Indique la posición del artículo en el array:");
                    p = entry.nextInt();

                    System.out.println("Indique el nuevo código del producto:");
                    newC = entry.next();

                    this.cambiarCodigo(p, newC);
                    repetir = true;
                    break;
                
                //Similar al caso anterior, tras seleccionar el número del articulo,
                //elegimos un nuevo nombre para sustituirlo (el precio del artículo
                //será el mismo que el existente anteriormente).    
                case 6:

                    String newN;

                    System.out.println("Indique la posición del artículo en el array:");
                    p = entry.nextInt();

                    System.out.println("Indique el nuevo producto:");
                    newN = entry.next();

                    this.cambiarCodigo(p, newN);
                    repetir = true;
                    break;
                
                //Cambiar el stock del artículo (como máximo la máquina aceptará 
                //un stock 15 artículos por bandeja).    
                case 7:

                    int newCantidad;

                    System.out.println("Indique la posición del artículo en el array:");
                    p = entry.nextInt();

                    System.out.println("Indique la nueva cantidad:");
                    newCantidad = entry.nextInt();

                    this.cambiarStock(p, newCantidad);
                    repetir = true;
                    break;
                
                //Seleccionando el artículo, podremos modificar su precio por uno nuevo.
                case 8:

                    int newPrecio;

                    System.out.println("Indique la posición del artículo en el array:");
                    p = entry.nextInt();

                    System.out.println("Indique el nuevo precio:");
                    newPrecio = entry.nextInt();

                    this.cambiarPrecio(p, newPrecio);
                    repetir = true;
                    break;
                
                //Default que nos dejará salir del modo administrador y darnos 
                //acceso nuevamente al panel inicial.
                default:
                    System.out.println("Saliendo del modo admin...");
                    repetir = false;
                    break;

            }
            
        }catch(InputMismatchException ime){
            
            System.out.println("ERROR, Caracter no numérico introducido indebidamente.");
            entry.nextLine();
            repetir = true;
            
        }
        
        }while (repetir);

    } 

    //Método que nos muestra todos los artículos de la bandeja de la máquina.
    public void consultarBandejas() {

        //Método con arrays:
        for(int i = 0; i < maquina.NUM_BANDEJAS; i++){
            
            
            System.out.println(maquina.getBandejas()[i]);
            
        }       

    }
    //Método que nos muestra los datos del depósito de la máquina.
    public void consultarDeposito() {
        

        System.out.println(maquina.getDeposito());

    }
    
    //Recaudación del depósito (dejándo a 0 todo el depósito), en ella quedará constancia la fecha en la que 
    //se ha realizado la recaudación.
    public void recaudarDelDeposito() {
        

        maquina.getDeposito().vaciarDeposito();

        maquina.getDeposito().setFechaUltRecaudacion(LocalDate.now());

    }
    
    //Recarga del depósito, en ella quedará constancia de la fecha en la que se
    //ha realizado la recarga.
    public void recargarDeposito(int m10c, int m20c, int m50c, int m1e, int m2e,
            int b5e, int b10e, int b20e) {
        

        maquina.getDeposito().recargar(m10c, m20c, m50c, m1e, m2e, b5e, b10e,
                 b20e);

        maquina.getDeposito().setFechaUltRecarga(LocalDate.now());

    }
    
    //Método para cambiar el código del producto según la posición de las bandejas.
    public void cambiarCodigo(int posicion, String newCode) {
        

        maquina.getBandejas()[posicion].setCodigo(newCode);

    }
    
    //Método para cambiar de posición el producto de las bandejas.
    public void cambiarProducto(int posicion, String newProducto) {
        
        
        maquina.getBandejas()[posicion].setNombre(newProducto);        

    }
    
    //Método para ajustar el stock del artículo seleccionado en la máquina.
    public void cambiarStock(int posicion, int nuevaCantidad) {
        
        
        maquina.getBandejas()[posicion].setCantidad(nuevaCantidad);

    }
    
    //Método para cambiar el precio del artiículo seleccionado en la máquina.
    public void cambiarPrecio(int posicion, int nuevoPrecio) {
        
        
        maquina.getBandejas()[posicion].setPrecio(nuevoPrecio);
        
    }
        
}
