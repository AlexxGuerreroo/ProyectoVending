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
    public static final int NUM_BANDEJAS = 8;//Para su array correspondiente
    public static final int NUM_TARJETAS = 3;//Para su array correspondiente
    //Se declara un array que contendrá un nº de artículos determinado por la
    //variable NUM_BANDEJAS:
    private Articulo[] bandejas = new Articulo[NUM_BANDEJAS];
    private Articulo a1;//ANTICUADO, pronto será sustituido por el array bandejas
    private Articulo a2;//ANTICUADO, pronto será sustituido por el array bandejas
    private Articulo a3;//ANTICUADO, pronto será sustituido por el array bandejas
    private Articulo a4;//ANTICUADO, pronto será sustituido por el array bandejas
    private Articulo a5;//ANTICUADO, pronto será sustituido por el array bandejas
    private Articulo a6;//ANTICUADO, pronto será sustituido por el array bandejas
    private Articulo a7;//ANTICUADO, pronto será sustituido por el array bandejas
    private Articulo a8;//ANTICUADO, pronto será sustituido por el array bandejas
    private Deposito deposito;//El depósito que guarda el dinero de la máquina
    private final String CODE_ADMIN;//El código de administrador.
    private Pago pago;//La clase pago, que servirá para realizar dicha función
    //Se declara un array que contendrá un nº de tarjetas determinado por la
    //variable NUM_TARJETAS:
    private Tarjeta[] tarjetas = new Tarjeta[NUM_TARJETAS];
    private Tarjeta t1;//ANTICUADO, pronto será sustituido por el array tarjetas
    private Tarjeta t2;//ANTICUADO, pronto será sustituido por el array tarjetas
    private Tarjeta t3;//ANTICUADO, pronto será sustituido por el array tarjetas

    public Maquina(Articulo a1, Articulo a2, Articulo a3, Articulo a4,
            Articulo a5, Articulo a6, Articulo a7, Articulo a8,
            Deposito deposito) {
        //Constructor que pronto será quitado                

        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
        this.a5 = a5;
        this.a6 = a6;
        this.a7 = a7;
        this.a8 = a8;
        this.deposito = deposito;

        //Establecemos el código UUID al azar:
        ID_MAQUINA = UUID.randomUUID();

        //Usamos un método para generar el código de Admin
        CODE_ADMIN = this.generarCodigo();

        //Y lo mostramos en consola
        System.out.println("Código de Administrador: " + CODE_ADMIN);

    }

    public Maquina(Articulo[] art, Deposito deposito) {
        //Constructor usando arrays

        for (int i = 0; i < NUM_BANDEJAS; i++) {

            bandejas[i] = art[i];

        }

        this.deposito = deposito;

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

        /**
         * *****MÉTODO A CONTINUACIÓN ANTICUADO, PRONTO SERÁ SUSTITUIDO******
         */
        if (a1.getCodigo().equals(code)) {

            elegirPago(a1);

        } else if (a2.getCodigo().equals(code)) {

            elegirPago(a2);

        } else if (a3.getCodigo().equals(code)) {

            elegirPago(a3);

        } else if (a4.getCodigo().equals(code)) {

            elegirPago(a4);

        } else if (a5.getCodigo().equals(code)) {

            elegirPago(a5);

        } else if (a6.getCodigo().equals(code)) {

            elegirPago(a6);

        } else if (a7.getCodigo().equals(code)) {

            elegirPago(a7);

        } else if (a8.getCodigo().equals(code)) {

            elegirPago(a8);

        } else {//Si no coincide con ninguno, mandamos un mensaje de error.

            System.out.println("El código introducido no coincide con ningún"
                    + " producto.");

        }
        
        /*******************************************************************/

    }

    public void elegirPago(Articulo art) {
        //Declaramos e inicializamos las variables que vamos a necesitar.
        Scanner entry = new Scanner(System.in);
        boolean repeat;

        do {

            try {

                System.out.println("¿Desea pagar con tarjeta? (S para afirmar)");

                if (entry.next().equalsIgnoreCase("S")) {
                    String numero;
                    String cvv;
                    int mes, ano;

                    System.out.println("Introduzca el número de su tarjeta");
                    numero = entry.next();
                    System.out.println("Introduzca el CVV");
                    cvv = entry.next();
                    System.out.println("Introduzca el mes de caducidad");
                    mes = entry.nextInt();
                    System.out.println("Introduzca el año de caducidad");
                    ano = entry.nextInt();

                    Tarjeta t = new Tarjeta(numero, cvv, mes, ano);

                    pago = new Pago(t, deposito, art);

                    switch (t.getContador() % 3) {
                        //Dependiendo del contador, se pasarán los atributos de
                        //t a una de las posiciones de tarjetas:

                        case 1://Si el resto da uno (como cuando es la primera
                            //tarjeta creada)
                            this.tarjetas[0].copiar(t);
                            break;

                        case 2://Si el resto da uno (como cuando es la segunda
                            //tarjeta creada)
                            this.tarjetas[1].copiar(t);
                            break;

                        case 0://Si el resto da uno (como cuando es la tercera
                            //tarjeta creada)
                            this.tarjetas[2].copiar(t);
                            break;

                    }

                } else {

                    System.out.println("Introduce la cantidad a pagar: ");
                    double pag = entry.nextDouble();

                    pago = new Pago(deposito, pag, art);

                }

                repeat = false;
                System.out.println(pago);

            } catch (InputMismatchException ime) {

                System.out.println("ERROR. INTRODUCE UN NÚMERO.");
                repeat = true;

            }

        } while (repeat);

    }

    public void insertarCodigo() {
        //Este método pide un código por pantalla/interfaz, comprobando primero
        //si es de administador y si lo es, pasa a los controles de admin.
        //Si no, pasa al método elegirProducto.

        //Declaramos e inicializamos el Scanner.
        Scanner entry = new Scanner(System.in);

        //Declaramos e inicializamos las variables que vamos a necesitar.
        String codigo;

        //Creámos el método que pedirá por scanner introducir un código, que la
        //propia máquina comprobará si se trata del código del administrador
        //o del artículo que se desea pedir.
        System.out.println("Introduce el código del producto");

        codigo = entry.next();

        if (this.adminCheck(codigo)) {

            System.out.println("(Aquí irá el administrador)");

        } else {

            System.out.println("Buscando producto... ");

            try {//Pausa el programa por 1 segundo.

                TimeUnit.SECONDS.sleep(1);

            } catch (InterruptedException ie) {

                Thread.currentThread().interrupt();

            }

            //Llamamos la método.
            elegirProducto(codigo);

        }

    }

    /**
     * *************GETTERS Y SETTERS QUE PRONTO SE IRÁN******************
     */
    public Articulo getA1() {

        return a1;

    }

    public void setA1(Articulo a1) {

        this.a1 = a1;

    }

    public Articulo getA2() {

        return a2;

    }

    public void setA2(Articulo a2) {

        this.a2 = a2;

    }

    public Articulo getA3() {

        return a3;

    }

    public void setA3(Articulo a3) {

        this.a3 = a3;

    }

    public Articulo getA4() {

        return a4;

    }

    public void setA4(Articulo a4) {

        this.a4 = a4;

    }

    public Articulo getA5() {

        return a5;

    }

    public void setA5(Articulo a5) {

        this.a5 = a5;

    }

    public Articulo getA6() {

        return a6;

    }

    public void setA6(Articulo a6) {

        this.a6 = a6;

    }

    public Articulo getA7() {

        return a7;

    }

    public void setA7(Articulo a7) {

        this.a7 = a7;

    }

    public Articulo getA8() {

        return a8;

    }

    public void setA8(Articulo a8) {

        this.a8 = a8;

    }

    public Tarjeta getT1() {

        return t1;

    }

    public Tarjeta getT2() {

        return t2;

    }

    public Tarjeta getT3() {

        return t3;

    }
    
    /*********************************************************************/

    //Estos getters y setters se podrán usar en modo Admin:
    public Deposito getDeposito() {

        return deposito;

    }

    public void setDeposito(Deposito deposito) {

        this.deposito = deposito;

    }

    public Articulo[] getBandejas() {

        return bandejas;

    }

    public void setBandejas(Articulo[] bandejas) {

        this.bandejas = bandejas;

    }

    public Tarjeta[] getTarjetas() {

        return tarjetas;

    }

    public UUID getID_MAQUINA() {

        return ID_MAQUINA;

    }

}
