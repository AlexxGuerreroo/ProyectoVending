/*
Requisitos de la práctica:
2. Funciones del usuario.
    Selección del producto.
    Pago en efectivo y recolección de las monedas.
    Pago con tarjeta y consultar la tarjeta.
    Actualización de las cantidades.
    Actualización del stock.
 */

 /*
Diseño de la clase Máquina.
    1. Número de serie único que no cambia nada (usando la clase UUID)
    2. Tamaño (número de bandejas).
    3. Dirección donde está ubicada la misma.
    4. Tarjetas de crédito (cvv, número de tarjeta y fecha de vencimiento)
    5. Código aleatorio del administrador.
 */
package ab.clasesvendingmachine;

import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

/**
 *
 * @author pikac
 */
public class Maquina {
    //Declaramos las variables de esta clase:

    /*  ESTA CLASE ESTÁ EN MEDIO DE UNA TRANCISIÓN DE ATRIBUTOS APILADOS A ARRAYS
    DE ATRIBUTOS
     */
    private final UUID ID_MAQUINA;
    private AdminMode control;
    public static final int NUM_BANDEJAS = 8;//Para su array correspondiente
    public static final int NUM_TARJETAS = 3;//Para su array correspondiente
    //Se declara un array que contendrá un nº de artículos determinado por la
    //variable NUM_BANDEJAS:
    private Bandeja[] bandejas = new Bandeja[NUM_BANDEJAS];
    private Deposito deposito;//El depósito que guarda el dinero de la máquina
    private final String CODE_ADMIN;//El código de administrador.
    private Pago pago;//La clase pago, que servirá para realizar dicha función
    //Se declara un array que contendrá un nº de tarjetas determinado por la
    //variable NUM_TARJETAS:
    private Tarjeta[] tarjetas = new Tarjeta[NUM_TARJETAS];

    public Maquina(Bandeja[] art, Deposito deposito, Tarjeta [] tarjetas) {
        //Constructor usando arrays

        for (int i = 0; i < NUM_BANDEJAS; i++) {

            bandejas[i] = art[i];

        }

        this.deposito = deposito;

        //Establecemos el código UUID al azar:
        ID_MAQUINA = UUID.randomUUID();

        //Usamos un método para generar el código de Admin
        CODE_ADMIN = this.generarCodigo();
        
        this.tarjetas = tarjetas;

        //Y lo mostramos en consola
        System.out.println("Código de Administrador: " + CODE_ADMIN);

    }

    public Maquina() {
        //Constructor por defecto:        

        for (int i = 0; i < NUM_BANDEJAS; i++) {

            //Este bucle generará artículos por defecto:
            bandejas[i] = new Bandeja();

        }

        //Establecemos un depósito vacío (lo rellenaremos en el modo admin
        deposito = new Deposito();

        //Establecemos el código UUID al azar:
        ID_MAQUINA = UUID.randomUUID();

        //Usamos un método para generar el código de Admin
        CODE_ADMIN = this.generarCodigo();

        //Y lo mostramos en consola
        System.out.println("Código de Administrador: " + CODE_ADMIN);

    }

    public String generarCodigo() {
        //Este método genera al azar el código de Admin de la máquina con un 
        //algoritmo que asegura que no se repite tipo de caracter o símbolo:

        Random tecla = new Random();
        int aux;
        String codex = "";

        //Primer símbolo al azar
        aux = tecla.nextInt(15) + 33;
        codex += (char) aux;

        //Primera cifra numérica al azar
        aux = tecla.nextInt(10) + 48;
        codex += (char) aux;

        //Primera letra minúscula al azar
        aux = tecla.nextInt(26) + 97;
        codex += (char) aux;

        //Primera letra mayúscula al azar
        aux = tecla.nextInt(26) + 65;
        codex += (char) aux;

        //Segunda letra minúscula al azar
        aux = tecla.nextInt(26) + 97;
        codex += (char) aux;

        //Segunda letra mayúscula al azar
        aux = tecla.nextInt(26) + 65;
        codex += (char) aux;

        //Segunda cifra numérica al azar
        aux = tecla.nextInt(10) + 48;
        codex += (char) aux;

        //Segundo símbolo al azar
        aux = tecla.nextInt(15) + 33;
        codex += (char) aux;

        return codex;

    }

    public boolean adminCheck(String code) {
        //Método para comprobar que el código introducido coincide con
        //el del administrador. 
        boolean admin = false;

        if (code.equals(CODE_ADMIN)) {
            admin = true;
        }
        return admin;
    }

    public void elegirProducto(String code) {
        //Este método cogerá el artículo seleccionado y comenzará el pago;
        boolean coincidencia = false;

        for (int i = 0; i < NUM_BANDEJAS; i++) {
            //Comprobará usando arrays hasta

            if (bandejas[i].getCodigo().equals(code)) {

                elegirPago(bandejas[i]);
                coincidencia = true;
                break;

            }

        }

        if (!coincidencia) {
            //Si no coincide con ninguno, mandamos un mensaje de error:

            System.out.println("El código introducido no coincide con ningún"
                    + " producto.");

        }

    }

    public void elegirPago(Bandeja art) {
        //Declaramos e inicializamos las variables que vamos a necesitar.
        int select;

        try {

            select = JOptionPane.showOptionDialog(null, "¿Cómo desea pagar?",
                    "Método de pago", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, new Object[]{"Tarjeta", "Efectivo", "Volver"}, "Volver");

            if (select == 0) {
                String numero;
                String cvv;
                int mes, ano;
                
                String mensaje = "¿Con qué tarjeta quieres pagar? \n";

            //Método con arrays:
            for (int i = 0; i < NUM_TARJETAS; i++) {

                mensaje = mensaje + getTarjetas()[i] + "\n";

            }

            JOptionPane.showMessageDialog(null, mensaje, "Tarjetas"
                    , JOptionPane.INFORMATION_MESSAGE);
            
            select = JOptionPane.showOptionDialog(null, mensaje,
                        "Selección de tarjeta",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
                        new Object[]{"1", "2", "3"}, 0);

                pago = new Pago(tarjetas[select], deposito, art);                

            } else if (select == 1) {
               
                pago = new Pago(deposito, art);

            }

            JOptionPane.showMessageDialog(null, pago, "Factura",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException nfe) {

            JOptionPane.showMessageDialog(null, "LO INTRODUCIDO NO ES VÁLIDO", "Error de Input",
                    JOptionPane.ERROR_MESSAGE);

        }

    }

    public void insertarCodigo(String codigo) {
        //Este método recoge un código del JButton, comprobando primero
        //si es de administador y, si lo es, pasa a los controles de admin.
        //Si no, pasa al método elegirProducto.

        if (!CODE_ADMIN.equals(codigo)) {
            
            System.out.println("Buscando producto... ");
            
            try {//Pausa el programa por 1 segundo.
                
                TimeUnit.SECONDS.sleep(1);
                
            } catch (InterruptedException ie) {
                
                Thread.currentThread().interrupt();
                
            }
            
            //Llamamos la método.
            elegirProducto(codigo);
            
        } else {
            
            control = new AdminMode(this);
            
        }

    }

    //Estos getters y setters se podrán usar en modo Admin:
    public Deposito getDeposito() {

        return deposito;

    }

    public void setDeposito(Deposito deposito) {

        this.deposito = deposito;

    }

    public Bandeja[] getBandejas() {

        return bandejas;

    }

    public void setBandejas(Bandeja[] bandejas) {

        this.bandejas = bandejas;

    }

    public Tarjeta[] getTarjetas() {

        return tarjetas;

    }

    public UUID getID_MAQUINA() {

        return ID_MAQUINA;

    }

    public String getCODE_ADMIN() {

        return CODE_ADMIN;

    }

}
