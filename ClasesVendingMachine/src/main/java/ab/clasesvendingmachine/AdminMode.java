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
import javax.swing.JOptionPane;

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
            try {

                /* System.out.println("ESTÁ EN MODO ADMINISTRADOR");
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
            System.out.println("*********************************"); */
                //Seleccionamos las opciones mediante un número introducido por Scanner
                select = JOptionPane.showOptionDialog(null, "Elige una opción: \n \n 1: Consultar Bandejas \n "
                        + "2: Consultar Dinero \n 3: Recaudar Dinero \n 4: Recargar Dinero \n "
                        + "5: Cambiar Código de una Bandeja \n 6: Cambiar Producto de una Bandeja \n "
                        + "7: Cambiar Stock de una Bandeja \n 8: Cambiar Precio de un Producto \n 0: Volver",
                        "MODO ADMINISTRADOR",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"1", "2", "3", "4",
                            "5", "6", "7", "8", "0"}, 8);
                System.out.println(select);

                //Bucle switch que mediante el valor introducido por scanner 
                //anteriormente, nos dará acceso a a cada uno de los métodos
                switch (select) {

                    case 0:

                        this.consultarBandejas();
                        repetir = true;
                        break;

                    case 1:

                        this.consultarDeposito();
                        repetir = true;
                        break;

                    case 2:

                        this.recaudarDelDeposito();
                        repetir = true;
                        break;

                    //Un sout nos preguntará por el número de monedas que queremos
                    //recargar en la máquina.        
                    case 3:

                        int a,
                         b,
                         c,
                         d,
                         e,
                         f,
                         g,
                         h;

                        a = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántas monedas de 10cent quiere añadir?"));

                        b = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántas monedas de 20cent quiere añadir?"));

                        c = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántas monedas de 50cent quiere añadir?"));

                        d = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántas monedas de 1€ quiere añadir?"));

                        e = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántas monedas de 2€ quiere añadir?"));

                        f = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos billetes de 5€ quiere añadir?"));

                        g = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos billetes de 10€ quiere añadir?"));

                        h = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos billetes de 20€ quiere añadir?"));

                        this.recargarDeposito(a, b, c, d, e, f, g, h);
                        repetir = true;
                        break;

                    //Seleccionando este método, volvemos a introducir el número del
                    //artículo y elegimos el nuevo valor que le queremos dar.
                    case 4:

                        String newC;

                        p = Integer.parseInt(JOptionPane.showInputDialog("Indique la posición del artículo en el array:"));

                        newC = JOptionPane.showInputDialog("Indique el nuevo código del producto:");

                        this.cambiarCodigo(p, newC);
                        repetir = true;
                        break;

                    //Similar al caso anterior, tras seleccionar el número del articulo,
                    //elegimos un nuevo nombre para sustituirlo (el precio del artículo
                    //será el mismo que el existente anteriormente).    
                    case 5:

                        String newN;

                        p = Integer.parseInt(JOptionPane.showInputDialog("Indique la posición del artículo en el array:"));

                        newN = JOptionPane.showInputDialog("Indique el nuevo código del producto:");

                        this.cambiarCodigo(p, newN);
                        repetir = true;
                        break;

                    //Cambiar el stock del artículo (como máximo la máquina aceptará 
                    //un stock 15 artículos por bandeja).    
                    case 6:

                        int newCantidad;

                        p = Integer.parseInt(JOptionPane.showInputDialog("Indique la posición del artículo en el array:"));

                        newCantidad = Integer.parseInt(JOptionPane.showInputDialog("Indique la nueva cantidad:"));

                        this.cambiarStock(p, newCantidad);
                        repetir = true;
                        break;

                    //Seleccionando el artículo, podremos modificar su precio por uno nuevo.
                    case 7:

                        int newPrecio;

                        p = Integer.parseInt(JOptionPane.showInputDialog("Indique la posición del artículo en el array:"));

                        newPrecio = Integer.parseInt(JOptionPane.showInputDialog("Indique el nuevo precio:"));

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

            } catch (NumberFormatException nfe) {

                JOptionPane.showMessageDialog(null, "ERROR, Caracter no numérico"
                        + " introducido indebidamente.", "Error de Formato Introducido",
                        JOptionPane.ERROR_MESSAGE);
                entry.nextLine();
                repetir = true;

            }

        } while (repetir);

    }

    //Método que nos muestra todos los artículos de la bandeja de la máquina.
    public void consultarBandejas() {

        String mensaje = "";
        
        //Método con arrays:
        for (int i = 0; i < maquina.NUM_BANDEJAS; i++) {

            mensaje = mensaje + maquina.getBandejas()[i] + "\n";

        }

        JOptionPane.showMessageDialog(null, mensaje, "Bandejas", JOptionPane.INFORMATION_MESSAGE);
        
    }

    //Método que nos muestra los datos del depósito de la máquina.
    public void consultarDeposito() {

        String mensaje = maquina.getDeposito().toString();        
        
        JOptionPane.showMessageDialog(null, mensaje, "Depósito", JOptionPane.INFORMATION_MESSAGE);
        
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
