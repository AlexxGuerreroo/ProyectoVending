/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ab.clasesvendingmachine;

/**
 *
 * @author Francisco José MG (Xele)
 */
//Incluimos estos repertorios:
import java.lang.Character;
import java.time.*;
import java.util.*;

public class Tarjeta {

    //Declaramos las variables dentro de la clase 
    private String numTarjeta;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String banco;
    private String cvv;
    private double saldo;//Con cada pago, se reducirá esta cantidad
    private boolean valido;
    private LocalDate caducidad;
    private static int contador = 0;

    //Por último, estas dos clases determinan la cantidad mínima y máxima que 
    //puede haber de saldo:
    public static final double MIN = 1.50;//Mínima cantidad de dinero al crear
    //la tarjeta
    public static final double MAX = 3000;//Máxima cantidad de dinero al crear
    //la tarjeta
    
    public Tarjeta(String numTarjeta, String nombre, String apellido1,
            String apellido2, String banco, String cvv, double saldo, int mes,
            int ano) {//Constructor para el método copiar:

        //Comprobamos que el número de la tarjeta y el nº secreto son válidos               
        if (validezNum(numTarjeta)){//En caso afirmativo, ponemos los datos
            
            this.numTarjeta = numTarjeta;
            
        }else{//Si no, se pondrán datos por defecto
            
            System.out.println("Nº de tarjeta introducido no es válido");
            this.numTarjeta = "0123456789012345";
            
        }
        
        if (validezCVV(cvv)) {//En caso afirmativo, ponemos los datos
            
            this.cvv = cvv;
            
        } else {//Si no, se pondrán datos por defecto
            
            System.out.println("Nº secreto introducido no es válido");
            this.cvv = "012";
        }

        //Pasamos el nombre y apellidos
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;

        //Pasamos el nombre de la entidad bancaria
        this.banco = banco;

        //Se pasa el valor parametrizado del saldo:

            this.saldo = saldo;

        

        //Pasamos la fecha de caducidad y comprobamos si la fecha está cumplida
        this.caducidad = LocalDate.of(ano, mes, 1);
        if (this.caducado()) {
            //Si ya ha pasado la fecha de caducidad, se reestablece por defecto:
            this.caducidad = LocalDate.of(2077, 9, 13);
        }

        //Se crea la tarjeta siempre sin ser validada, pudiéndose 
        //activar con un método aparte
        valido = false;

    }
    
    
    
    public Tarjeta(String numTarjeta, String cvv, int mes, int ano) {
        //Constructor parametrizado:
        Random tombola = new Random();

        if(this.validezNum(numTarjeta)){
            
            this.numTarjeta = numTarjeta;
            
        }else{
            
            this.numTarjeta = "0123456789012345";
            
        }
        
        if(this.validezCVV(cvv)){
            
            this.cvv = cvv;
        
        }else{
            
            this.cvv = "012";
            
        }
        
        this.caducidad = LocalDate.of(ano, mes, 1);
        nombre = "User";//Valor por defecto
        apellido1 = "";//Valor por defecto
        apellido2 = "";//Valor por defecto
        banco = "PrepH";//Valor por defecto
        saldo = tombola.nextInt(3000) + 1;//Se genera el saldo al azar
        valido = false;//Se establece como anulada.

        //Aumentamos en 1 el contador:
        contador++;

    }

    public Tarjeta() {//Constructor por defecto
        //Introducimos valores por defecto:
        numTarjeta = "0123456789012345";
        cvv = "012";
        nombre = "AlexElCapo";
        apellido1 = "Contigo";
        apellido2 = "PIPO";
        banco = "Firewatch";
        saldo = 803.19;
        caducidad = LocalDate.of(2077, 9, 13);
        valido = false; //Siempre empieza anulada

        //Aumentamos en 1 el contador:
        contador++;

        /*PD: Los valores del nombre, apellidos y la fecha son relacionados a un
        meme (este: https://www.youtube.com/watch?v=huie2_3Pekg ) */
    }
        
    public boolean validezNum(String nT) {

        boolean v = true;
        char d;

        //Comprueba si el número de tarjeta (nT) y el CVV tienen la longitud 
        //exacta:
        if (nT.length() == 16) {

            for (int i = 0; i < 16; i++) {//Comprueba que cada parte del string
                //es un nº

                d = nT.charAt(i);
                if (!(Character.isDigit(d))) {
                    //Si hay un caracter no numérico, salta el mensaje de error
                    System.out.println("El nº de tarjeta es inválido "
                            + "(no es numérico)");
                    v = false;

                }

            }            

        } else {//Si el número de tarjeta no es de 16 
            //cifras...

            System.out.println("El nº de tarjeta es inválido (fallo de longitud");
            v = false;

        }

        return v;

    }
    
    public boolean validezCVV(String cvv) {

        boolean v = true;
        char d;

        //Comprueba si el número de tarjeta (nT) y el CVV tienen la longitud 
        //exacta:
        if (cvv.length() == 3) {

            for (int j = 0; j < 3; j++) {//Comprueba que cada parte del string
                //es un nº

                d = cvv.charAt(j);
                if (!(Character.isDigit(d))) {
                    //Si hay un caracter no numérico, salta el mensaje de error
                    System.out.println("El CVV es inválido (no es numérico)");
                    v = false;

                }

            }

        } else {//si el CVV no es de 3 cifras...

            System.out.println("El CVV es inválido (fallo de longitud)");
            v = false;

        }

        return v;

    }

    public boolean caducado() {//Comprueba si la tarjeta ha caducado

        LocalDate ahora = LocalDate.now();
        boolean caduco;
        if (!(ahora.isBefore(caducidad))) {//Si el día actual no es antes de
            //la fecha de caducidad, se indica que la tarjeta ha caducado:

            caduco = true;
            System.out.println("Esta tarjeta ya está caducada");
            this.valido = false;

        } else {//Si el día actual es antes de la fecha de caducidad:

            caduco = false;

        }

        return caduco;

    }

    public LocalDate getCaducidad() {

        return caducidad;

    }

    public double getMin() {

        return MIN;

    }

    public double getMax() {

        return MAX;

    }

    public String getNumTarjeta() {

        return numTarjeta;

    }

    public String getNombre() {

        return nombre;

    }

    public String getApellido1() {

        return apellido1;

    }

    public String getApellido2() {

        return apellido2;

    }

    public String getCvv() {

        return cvv;

    }

    public void setCvv(String cvv) {

        this.cvv = cvv;

    }

    public double getSaldo() {

        return saldo;

    }

    public void setSaldo(double saldo) {

        this.saldo = saldo;

    }

    public String getBanco() {

        return banco;

    }

    public static int getContador() {

        return contador;

    }

    public boolean isValido() {

        return valido;

    }

    public void setValido() {

        if (saldo < 0 || this.caducado()) {
            this.valido = false;
        } else if (validezNum(numTarjeta) && validezCVV(cvv)) {
            this.valido = true;
        }

    }

    public void anular() {

        this.valido = false;

    }

    public boolean pago(double coste) {
        Scanner entry = new Scanner(System.in);
        String cvv;
        int aux;
        boolean pago;
        
        this.setValido();
        
        if (this.valido && coste < saldo) {

            aux = (int) ((this.saldo * 100) - (coste * 100));
            this.setSaldo(aux / 100.00);
            System.out.println("Operación realizada con éxito");
            pago = true;

        } else if (!this.valido) {

            System.out.println("ERROR. TARJETA NO ACTIVADA.\n PAGO ANULADO");
            pago = false;

        } else {

            System.out.println("ERROR. SALDO INSUFICIENTE.\n PAGO ANULADO");
            pago = false;

        }

        return pago;

    }

    public static Tarjeta copiar(Tarjeta c) {

        Tarjeta aux = new Tarjeta(c.getNumTarjeta(), c.getNombre(), 
                c.getApellido1(), c.getApellido2(), c.getBanco(), c.getCvv(),
                c.getSaldo(), c.getCaducidad().getMonthValue(),
                c.getCaducidad().getYear());

                return aux;
    }

    @Override
    public String toString() {
        return "Tarjeta{\n" + "\n\tNumTarjeta = " + numTarjeta + "\tCVV: " + cvv
                + "\n\tCaduca en " + caducidad.getMonthValue() + '/'
                + caducidad.getYear() + "\n}";
    }

}
