/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ab.clasesvendingmachine;
import java.util.*;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author pikac
 */
public class Maquina {

    private Articulo a1;
    private Articulo a2;
    private Articulo a3;
    private Articulo a4;
    private Articulo a5;
    private Articulo a6;
    private Articulo a7;
    private Articulo a8;
    private Deposito deposito;
    private String codeAdmin;
    private Pago pago;
    private Tarjeta t1;
    private Tarjeta t2;
    private Tarjeta t3;
    
    
    public Maquina(Articulo a1, Articulo a2, Articulo a3, Articulo a4,
            Articulo a5, Articulo a6, Articulo a7, Articulo a8,
            Deposito deposito) {
                        
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
        this.a5 = a5;
        this.a6 = a6;
        this.a7 = a7;
        this.a8 = a8;
        this.deposito = deposito;
        
        codeAdmin = this.generarCodigo();
        
        System.out.println("Código de Administrador: " + codeAdmin);
        
    }
    
    public String generarCodigo(){
        
        Random tecla = new Random();        
        int aux;
        String codex = "";
        
        //
        aux = tecla.nextInt(15) + 33;                
        codex += (char) aux;
        
        aux = tecla.nextInt(10) + 48;                
        codex += (char) aux;
        //
        aux = tecla.nextInt(26) + 97;                
        codex += (char) aux;
        
        aux = tecla.nextInt(26) + 65;                
        codex += (char) aux;
        //
        aux = tecla.nextInt(26) + 97;                
        codex += (char) aux;
        
        aux = tecla.nextInt(26) + 65;                
        codex += (char) aux;
        
        aux = tecla.nextInt(10) + 48;                
        codex += (char) aux;
        
        aux = tecla.nextInt(15) + 33;                
        codex += (char) aux;
        
        return codex;
        
    }

    public Maquina(Articulo a1, Articulo a2, Articulo a3, Articulo a4, 
            Articulo a5, Articulo a6, Articulo a7, Articulo a8, 
            Deposito deposito, String code) {
        
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
        this.a5 = a5;
        this.a6 = a6;
        this.a7 = a7;
        this.a8 = a8;
        this.deposito = deposito;
        this.codeAdmin = code;
        
    }
    
    //Crearemos un método para comprobar que el código introducido coincide con
    //el del administrados.
    
    public boolean adminCheck (String code) {
        boolean admin = false;
        
        if(code.equals(codeAdmin)){
            admin = true;
        }
        return admin;
    }
    
    //Crearemos un método para comprobar que el código introducido coincide con
    //el de la bandeja.

        
    public void elegirProducto(String code) {
        //Este método cogerá el artículo seleccionado y comenzará el pago;
        
        if(a1.getCodigo().equals(code)){
            
            elegirPago(a1);
            
        }else if(a2.getCodigo().equals(code)){
            
            elegirPago(a2);
            
        }else if(a3.getCodigo().equals(code)){
            
            elegirPago(a3);
            
        }else if(a4.getCodigo().equals(code)){
            
            elegirPago(a4);
            
        }else if(a5.getCodigo().equals(code)){
            
            elegirPago(a5);
            
        }else if(a6.getCodigo().equals(code)){
            
            elegirPago(a6);
            
        }else if(a7.getCodigo().equals(code)){
            
            elegirPago(a7);
            
        }else if(a8.getCodigo().equals(code)){
            
            elegirPago(a8);
            
        }else{
            
            System.out.println("El código introducido no coincide con ningún"
                    + " producto.");
            
        }
        
        
    }
    
    public void elegirPago (Articulo art) {
        //Declaramos e inicializamos las variables que vamos a necesitar.
        Scanner entry = new Scanner(System.in);
        boolean repeat;
        
        do{
        
            try{

                System.out.println("¿Desea pagar con tarjeta? (S para afirmar)");

                if (entry.next().equalsIgnoreCase("S")){
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
                    
                    switch(t.getContador() % 3){
                        //Dependiendo del contador, se pasarán los atributos de
                        //t a t1, t2 o t3:
                        
                        case 1://Si el resto da uno (como cuando es la primera
                            //tarjeta creada)
                            this.t1.copiar(t);
                            break;
                        
                        case 2://Si el resto da uno (como cuando es la segunda
                            //tarjeta creada)
                            this.t2.copiar(t);
                            break;
                            
                        case 0://Si el resto da uno (como cuando es la tercera
                            //tarjeta creada)
                            this.t3.copiar(t);
                            break;
                        
                    }

                }else{

                    System.out.println("Introduce la cantidad a pagar: ");
                    double pag = entry.nextDouble();

                    pago = new Pago(deposito, pag, art);

                }        

                repeat = false;
                System.out.println(pago);

            }catch(InputMismatchException ime){

                System.out.println("ERROR. INTRODUCE UN NÚMERO.");
                repeat = true;

            }
            
        }while(repeat);
        
    }
    
    public void insertarCodigo(){
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
        
        if(this.adminCheck(codigo)){
            
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
    
    //Esto se podrá usar en modo Admin:

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

    public Deposito getDeposito() {
        
        return deposito;
        
    }

    public void setDeposito(Deposito deposito) {
        
        this.deposito = deposito;
        
    }

    public Tarjeta getT1() {
        
        return t1;
        
    }

    public void setT1(Tarjeta t1) {
        
        this.t1 = t1;
        
    }

    public Tarjeta getT2() {
        
        return t2;
        
    }

    public void setT2(Tarjeta t2) {
        
        this.t2 = t2;
        
    }

    public Tarjeta getT3() {
        
        return t3;
        
    }

    public void setT3(Tarjeta t3) {
        
        this.t3 = t3;
        
    }

    
    
}
