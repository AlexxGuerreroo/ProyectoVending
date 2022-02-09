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
        int select, posicionBandeja;
        String codigoBandeja;//El código para buscar la bandeja.
        String mensaje; //Para las opciones relacionadas con tarjetas.
        boolean repetir, found;//el boolean found servirá al
        //cambiar atributos de las bandejas.

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
                        + "7: Cambiar Stock de una Bandeja \n 8: Cambiar Precio de un Producto"
                        + "\n 9: Consultar Tarjetas" + "\n 10: Recargar Tarjeta" + " \n 0: Volver",
                        "MODO ADMINISTRADOR",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"1", "2", "3", "4",
                            "5", "6", "7", "8", "9", "10", "0"}, 0);
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

                        int m10c,
                         m20c,
                         m50c,
                         m1e,
                         m2e;

                        m10c = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántas monedas de 10cent quiere añadir?"));

                        m20c = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántas monedas de 20cent quiere añadir?"));

                        m50c = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántas monedas de 50cent quiere añadir?"));

                        m1e = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántas monedas de 1€ quiere añadir?"));

                        m2e = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántas monedas de 2€ quiere añadir?"));

                        this.recargarDeposito(m10c, m20c, m50c, m1e, m2e);
                        repetir = true;
                        break;

                    //Seleccionando este método, volvemos a introducir el número del
                    //artículo y elegimos el nuevo valor que le queremos dar.
                    case 4:

                        String newCode;
                        posicionBandeja = 0;
                        found = false;
                        boolean duplicate = false;

                        codigoBandeja = JOptionPane.showInputDialog("Indique el código del artículo:");

                        for (int i = 0; i < maquina.NUM_BANDEJAS; i++) {

                            if (codigoBandeja.equals(maquina.getBandejas()[i].getCodigo())) {

                                posicionBandeja = i;
                                found = true;
                                break;

                            }

                        }

                        if (found) {
                            newCode = JOptionPane.showInputDialog("Indique "
                                    + "el nuevo código del producto:");

                            for (int i = 0; i < maquina.NUM_BANDEJAS; i++) {

                                if (newCode.equals(maquina.getBandejas()[i].getCodigo())) {

                                    duplicate = true;
                                    break;

                                }

                            }
                            if (!duplicate) {

                                this.cambiarCodigo(posicionBandeja, newCode);

                            } else if (newCode.length() != 3) {

                                JOptionPane.showMessageDialog(null, "ERROR, El código ya"
                                        + " tiene que ser de 3 dígitos.", "Error de Longitud",
                                        JOptionPane.ERROR_MESSAGE);

                            } else {

                                JOptionPane.showMessageDialog(null, "ERROR, El código ya"
                                        + " ha sido asignado.", "Error de Duplicación",
                                        JOptionPane.ERROR_MESSAGE);

                            }

                        } else {

                            JOptionPane.showMessageDialog(null, "ERROR, No hay bandeja"
                                    + " con el código introducido.", "Bandeja no encontrada",
                                    JOptionPane.ERROR_MESSAGE);

                        }

                        repetir = true;
                        break;

                    //Similar al caso anterior, tras seleccionar el número del articulo,
                    //elegimos un nuevo nombre para sustituirlo (el precio del artículo
                    //será el mismo que el existente anteriormente).    
                    case 5:

                        posicionBandeja = 0;
                        found = false;
                        String newN;

                        codigoBandeja = JOptionPane.showInputDialog("Indique el código del artículo:");

                        for (int i = 0; i < maquina.NUM_BANDEJAS; i++) {

                            if (codigoBandeja.equals(maquina.getBandejas()[i].getCodigo())) {

                                posicionBandeja = i;
                                found = true;
                                break;

                            }

                        }

                        if (found) {

                            newN = JOptionPane.showInputDialog("Indique el nuevo producto:");

                            this.cambiarProducto(posicionBandeja, newN);

                        } else {

                            JOptionPane.showMessageDialog(null, "ERROR, No hay bandeja"
                                    + " con el código introducido.", "Bandeja no encontrada",
                                    JOptionPane.ERROR_MESSAGE);

                        }

                        repetir = true;
                        break;

                    //Cambiar el stock del artículo (como máximo la máquina aceptará 
                    //un stock 15 artículos por bandeja).    
                    case 6:

                        posicionBandeja = 0;
                        found = false;
                        int newCantidad;

                        codigoBandeja = JOptionPane.showInputDialog("Indique el código del artículo:");

                        for (int i = 0; i < maquina.NUM_BANDEJAS; i++) {

                            if (codigoBandeja.equals(maquina.getBandejas()[i].getCodigo())) {

                                posicionBandeja = i;
                                found = true;
                                break;

                            }

                        }

                        if (found) {

                            newCantidad = Integer.parseInt(JOptionPane.showInputDialog("Indique la nueva cantidad:"));

                            this.cambiarStock(posicionBandeja, newCantidad);

                        } else {

                            JOptionPane.showMessageDialog(null, "ERROR, No hay bandeja"
                                    + " con el código introducido.", "Bandeja no encontrada",
                                    JOptionPane.ERROR_MESSAGE);

                        }

                        repetir = true;
                        break;

                    //Seleccionando el artículo, podremos modificar su precio por uno nuevo.
                    case 7:

                        posicionBandeja = 0;
                        found = false;
                        double newPrecio;

                        codigoBandeja = JOptionPane.showInputDialog("Indique el código del artículo:");

                        for (int i = 0; i < maquina.NUM_BANDEJAS; i++) {

                            if (codigoBandeja.equals(maquina.getBandejas()[i].getCodigo())) {

                                posicionBandeja = i;
                                found = true;
                                break;

                            }

                        }

                        if (found) {

                            newPrecio = Double.parseDouble(JOptionPane.showInputDialog("Indique el nuevo precio:"));

                            this.cambiarPrecio(posicionBandeja, newPrecio);

                        } else {

                            JOptionPane.showMessageDialog(null, "ERROR, No hay bandeja"
                                    + " con el código introducido.", "Bandeja no encontrada",
                                    JOptionPane.ERROR_MESSAGE);

                        }

                        repetir = true;
                        break;

                    case 8:

                        mensaje = "";

                        for (int i = 0; i < maquina.NUM_TARJETAS; i++) {

                            mensaje = mensaje + maquina.getTarjetas()[i] + "\n";

                        }

                        JOptionPane.showMessageDialog(null, mensaje, "Tarjetas",
                                JOptionPane.INFORMATION_MESSAGE);

                        repetir = true;
                        break;

                    case 9:

                        int selectTarjeta;
                        double recarga;

                        mensaje = "¿Qué tarjeta quiere recargar? \n";

                        for (int i = 0; i < maquina.NUM_TARJETAS; i++) {

                            mensaje = mensaje + "Tarjeta " + (i + 1)
                                    + maquina.getTarjetas()[i] + "\n";

                        }

                        selectTarjeta = JOptionPane.showOptionDialog(null, mensaje,
                                "Selección de tarjeta",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                                new Object[]{"1", "2", "3"}, 0);

                        recarga = Double.parseDouble(JOptionPane.showInputDialog("¿Cuánto quiere añadir"));

                        this.recargarTarjeta(selectTarjeta, recarga);
                        repetir = true;
                        break;

                    //Default que nos dejará salir del modo administrador y darnos 
                    //acceso nuevamente al panel inicial.
                    default:
                        System.out.println("Saliendo del modo admin...");
                        repetir = false;
                        break;

                }

            } catch (NumberFormatException nfe) {//El tipo de excepción que se activa es distinto al del Scanner

                JOptionPane.showMessageDialog(null, "ERROR, Caracter no numérico"
                        + " introducido indebidamente.", "Error de Formato Introducido",
                        JOptionPane.ERROR_MESSAGE);
                repetir = true;

            } catch (NullPointerException npe) {//El tipo de excepción que se activa es distinto al del Scanner

                JOptionPane.showMessageDialog(null, "Volviendo al inicio...",
                        "Paso nulo",
                        JOptionPane.INFORMATION_MESSAGE);
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

    //Método que nos muestra los datos de las tarjetas.
    public void consultarTarjetas() {

        String mensaje = "";

        //Método con arrays:
        for (int i = 0; i < maquina.NUM_TARJETAS; i++) {

            mensaje = mensaje + "Tarjeta " + (i + 1) + maquina.getTarjetas()[i]
                    + "\n";

        }

        JOptionPane.showMessageDialog(null, mensaje, "Tarjetas", JOptionPane.INFORMATION_MESSAGE);

    }

    //Recaudación del depósito (dejándo a 0 todo el depósito), en ella quedará constancia la fecha en la que 
    //se ha realizado la recaudación.
    public void recaudarDelDeposito() {

        maquina.getDeposito().recaudarDeposito();

        JOptionPane.showMessageDialog(null, "Recaudado dinero del depósito",
                "Recaudación", JOptionPane.INFORMATION_MESSAGE);

        maquina.getDeposito().setFechaUltRecaudacion(LocalDate.now());

    }

    //Recarga del depósito, en ella quedará constancia de la fecha en la que se
    //ha realizado la recarga.
    public void recargarDeposito(int m10c, int m20c, int m50c, int m1e, int m2e) {

        maquina.getDeposito().recargarM(m10c, m20c, m50c, m1e, m2e);

        JOptionPane.showMessageDialog(null, "Recargado dinero del depósito",
                "Recarga Depósito", JOptionPane.INFORMATION_MESSAGE);

        maquina.getDeposito().setFechaUltRecarga(LocalDate.now());

    }

    public void recargarTarjeta(int posicion, double recarga) {

        JOptionPane.showMessageDialog(null, "Recargado dinero de la tarjeta",
                "Recarga Tarjeta", JOptionPane.INFORMATION_MESSAGE);

        maquina.getTarjetas()[posicion].setSaldo(
                maquina.getTarjetas()[posicion].getSaldo() + recarga);

    }

    //Método para cambiar el código del producto según la posición de las bandejas.
    public void cambiarCodigo(int posicion, String newCode) {

        maquina.getBandejas()[posicion].setCodigo(newCode);

        JOptionPane.showMessageDialog(null, "Realizado cambio con éxito",
                "Cambio de Código", JOptionPane.INFORMATION_MESSAGE);

    }

    //Método para cambiar de posición el producto de las bandejas.
    public void cambiarProducto(int posicion, String newProducto) {

        maquina.getBandejas()[posicion].setNombre(newProducto);

        JOptionPane.showMessageDialog(null, "Realizado cambio con éxito",
                "Cambio de Producto", JOptionPane.INFORMATION_MESSAGE);

    }

    //Método para ajustar el stock del artículo seleccionado en la máquina.
    public void cambiarStock(int posicion, int nuevaCantidad) {

        maquina.getBandejas()[posicion].setCantidad(nuevaCantidad);

        JOptionPane.showMessageDialog(null, "Realizado cambio con éxito",
                "Cambio de Cantidad", JOptionPane.INFORMATION_MESSAGE);

    }

    //Método para cambiar el precio del artiículo seleccionado en la máquina.
    public void cambiarPrecio(int posicion, double nuevoPrecio) {

        maquina.getBandejas()[posicion].setPrecio(nuevoPrecio);

        JOptionPane.showMessageDialog(null, "Realizado cambio con éxito",
                "Cambio de Precio", JOptionPane.INFORMATION_MESSAGE);

    }

}
