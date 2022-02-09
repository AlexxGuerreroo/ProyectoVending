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
import org.apache.commons.lang3.RandomStringUtils;

public class Tarjeta {

    //Declaramos las variables dentro de la clase .
    private String numTarjeta;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String banco;
    private String cvv;
    private double saldo;//Con cada pago, se reducirá esta cantidad.
    private boolean valido;
    private YearMonth caducidad;

    //Por último, estas dos clases determinan la cantidad mínima y máxima que 
    //puede haber de saldo:
    public static final double MIN = 1.50;//Mínima cantidad de dinero al crear
    //la tarjeta.
    public static final double MAX = 3000;//Máxima cantidad de dinero al crear
    //la tarjeta.
    
    public Tarjeta(String numTarjeta, String cvv, double saldo, int mes,
            int ano) {//Constructor para el método copiar:

        //Comprobamos que el número de la tarjeta y el nº secreto son válidos 
        //En caso afirmativo, ponemos los datos
        if (validezNum(numTarjeta)){
            
            this.numTarjeta = numTarjeta;
            
        }else{//Si no, se pondrán datos por defecto.
            
            System.out.println("Nº de tarjeta introducido no es válido");
            this.numTarjeta = "0123456789012345";
            
        }
        
        //En caso afirmativo, ponemos los datos
        if (validezCVV(cvv)) {
            
            this.cvv = cvv;
            
        } else {    //Si no, se pondrán datos por defecto
            
            System.out.println("Nº secreto introducido no es válido");
            this.cvv = "012";
        }

        //Asignamos estos valores por defecto:
        nombre = "User";
        apellido1 = "";
        apellido2 = "";
        banco = "PrepH";

        //Se pasa el valor parametrizado del saldo:
        this.saldo = saldo;
        
        //Pasamos la fecha de caducidad y comprobamos si la fecha está cumplida.
        this.caducidad = YearMonth.of(ano, mes);
        if (this.caducado()) {
            
            this.caducidad = YearMonth.of(2077, 9);
         //Si ya ha pasado la fecha de caducidad, se reestablece por defecto:
        }

        //Se crea una tarjeta por defecto que no será validada, pero pudiéndose 
        //activar posteriormente con un método.
        valido = false;

    }
    
    
    
    public Tarjeta(String numTarjeta, String cvv, int mes, int ano) {
        
        //Constructor parametrizado:
        Random ruleta = new Random();

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
        
        this.caducidad = YearMonth.of(ano, mes);
        
        //Valores creados por defecto.
        nombre = "User";
        apellido1 = "";
        apellido2 = "";
        banco = "PrepH";
        saldo = ruleta.nextInt(3000) + 1;//El saldo es generado al azar.
        valido = false;//Por defecto se crea anulada.

    }

    public Tarjeta() {//Constructor por defecto.
        //Introducimos valores por defecto:
        numTarjeta = RandomStringUtils.randomNumeric(16).toUpperCase();
        cvv = RandomStringUtils.randomNumeric(3).toUpperCase();
        nombre = "User";
        apellido1 = "";
        apellido2 = "";
        banco = "BBVA";
        saldo = 803.19;
        caducidad = YearMonth.of(2077, 9);
        valido = false; //Por defecto se crea anulada.

        /*PD: Los valores del nombre, apellidos y la fecha son relacionados a un
        meme (este: https://www.youtube.com/watch?v=huie2_3Pekg ) */
    }
        
    public boolean validezNum(String nT) {

        boolean v = true;
        char d;

        //Comprueba si el número de tarjeta (nT) tienen la longitud exacta:
        if (nT.length() == 16) {

            for (int i = 0; i < 16; i++) {//Comprueba que cada parte del string
                //es un número.

                d = nT.charAt(i);
                if (!(Character.isDigit(d))) {
                    
                    //Si hay un caracter no numérico, salta el mensaje de error
                    System.out.println("El nº de tarjeta es inválido "
                            + "(no es numérico)");
                    v = false;

                }

            }            

        } else {//Si el número de tarjeta no es de 16 cifras salta el error.

            System.out.println("El nº de tarjeta es inválido (fallo de longitud");
            v = false;

        }

        return v;

    }
    
    public boolean validezCVV(String cvv) {

        boolean v = true;
        char d;

        //Comprueba CVV tienen la longitud exacta:
        if (cvv.length() == 3) {

            for (int j = 0; j < 3; j++) {//Comprueba que cada parte del string
                //es un número.

                d = cvv.charAt(j);
                if (!(Character.isDigit(d))) {
                    
                    //Si hay un caracter no numérico, salta el mensaje de error
                    System.out.println("El CVV es inválido (no es numérico)");
                    v = false;

                }

            }

        } else {//si el CVV no es de 3 cifras salta el error.

            System.out.println("El CVV es inválido (fallo de longitud)");
            v = false;

        }

        return v;

    }
    
    //Método para comprobar la validez de la tarjeta.
    public boolean caducado() {

        YearMonth ahora = YearMonth.now();
        boolean caduco;
        if (!(ahora.isBefore(caducidad))) {
            //Si el día actual no es antior a la fecha de caducidad, se indica
            //que la tarjeta ha caducado.

            caduco = true;
            System.out.println("Esta tarjeta ya está caducada");
            this.valido = false;

        } else {
            //Si el día actual es anterior a la fecha de caducidad, devolverá 
            //un valor falso.
            caduco = false;

        }

        return caduco;

    }

    public YearMonth getCaducidad() {

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
    
    //Método para efectuar el pago en el caso de que fuesen válidos todos los 
    //valores, o en su defecto devolver un error.
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
    
    //Método copiar.
    public static Tarjeta copiar(Tarjeta c) {

        Tarjeta aux = new Tarjeta(c.getNumTarjeta(), c.getCvv(),
                c.getSaldo(), c.getCaducidad().getMonthValue(),
                c.getCaducidad().getYear());

                return aux;
    }

    @Override
    public String toString() {
        return "Tarjeta{\n" + "\n\tNumTarjeta = " + numTarjeta + "\nCVV: " + cvv
                + "\t Saldo: " + saldo
                + "\n\tCaduca en " + caducidad.getMonthValue() + '/'
                + caducidad.getYear() + "\n}";
    }

}
