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
        int select, p;
        boolean repeat;
        
        do{

            try {

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
                System.out.println("Cualquier otro numero: Salir");
                System.out.println("*********************************");

                select = entry.nextInt();

                switch (select) {

                    case 1:

                        this.consultarBandejas();
                        repeat = true;
                        break;

                    case 2:

                        this.consultarDeposito();
                        repeat = true;
                        break;

                    case 3:

                        this.recaudarDelDeposito();
                        repeat = true;
                        break;

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
                        
                        repeat = true;
                        break;

                    case 5:

                        String newC;

                        System.out.println("Indique la posición del artículo en el array:");
                        p = entry.nextInt();

                        System.out.println("Indique el nuevo código del producto:");
                        newC = entry.next();

                        this.cambiarCodigo(p, newC);

                        repeat = true;
                        break;

                    case 6:

                        String newN;

                        System.out.println("Indique la posición del artículo en el array:");
                        p = entry.nextInt();

                        System.out.println("Indique el nuevo producto:");
                        newN = entry.next();

                        this.cambiarProducto(p, newN);

                        repeat = true;
                        break;

                    case 7:

                        int newCantidad;
                        repeat = true;

                        System.out.println("Indique la posición del artículo en el array:");
                        p = entry.nextInt();

                        System.out.println("Indique la nueva cantidad:");
                        newCantidad = entry.nextInt();

                        this.cambiarStock(p, newCantidad);

                        break;

                    case 8:

                        int newPrecio;

                        System.out.println("Indique la posición del artículo en el array:");
                        p = entry.nextInt();

                        System.out.println("Indique el nuevo precio:");
                        newPrecio = entry.nextInt();

                        this.cambiarPrecio(p, newPrecio);

                        repeat = true;
                        break;

                    default:
                        System.out.println("Saliendo del modo admin...");
                        repeat = false;
                        break;

                }

            } catch (InputMismatchException ime) {

                System.out.println("ERROR, Caracter no numérico introducido indebidamente.");
                entry.nextLine();
                repeat = false;

            }
            
        }while(repeat);

    }

    public void consultarBandejas() {
        //Muestra todos los artículos (bandejas) de la máquina:

        for (int i = 0; i < maquina.NUM_BANDEJAS; i++) {
            //Método con arrays:

            System.out.println(maquina.getBandejas()[i]);

        }

    }

    public void consultarDeposito() {
        //Muestra los datos del depósito de la máquina:

        System.out.println(maquina.getDeposito());

    }

    public void recaudarDelDeposito() {
        //Vacía el depósito para recaudar beneficios y establece la fecha de la 
        //acción acordemente:

        maquina.getDeposito().vaciarDeposito();

        maquina.getDeposito().setFechaUltRecaudacion(LocalDate.now());

    }

    public void recargarDeposito(int m10c, int m20c, int m50c, int m1e, int m2e,
            int b5e, int b10e, int b20e) {
        //Recarga el depósito para tener cambio y establece la fecha de la acción
        //acordemente:

        maquina.getDeposito().recargar(m10c, m20c, m50c, m1e, m2e, b5e, b10e,
                b20e);

        maquina.getDeposito().setFechaUltRecarga(LocalDate.now());

    }

    public void cambiarCodigo(int posicion, String newCode) {
        //Método que ajusta el código del artículo correspondiente a su posición
        //en el array bandejas

        maquina.getBandejas()[posicion].setCodigo(newCode);

    }

    public void cambiarProducto(int posicion, String newProducto) {
        //Método que ajusta el producto del artículo correspondiente a su posición
        //en el array bandejas

        maquina.getBandejas()[posicion].setNombre(newProducto);

    }

    public void cambiarStock(int posicion, int nuevaCantidad) {
        //Método que ajusta el stock del artículo correspondiente a su posición
        //en el array bandejas

        maquina.getBandejas()[posicion].setCantidad(nuevaCantidad);

    }

    public void cambiarPrecio(int posicion, int nuevoPrecio) {
        //Método que ajusta el precio del artículo correspondiente a su posición
        //en el array bandejas

        maquina.getBandejas()[posicion].setPrecio(nuevoPrecio);

    }

}
