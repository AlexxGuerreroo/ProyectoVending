/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ab.clasesvendingmachine;
import java.util.*;
/**
 *
 * @author pikac
 */
public class Articulo {
    
    private String nombre; //Nombre del artículo
    private double precio; //Precio del artículo
    private int cantidad; //Cantidad del artículo
    private int codigo; //Código del artículo

    public Articulo(String nombre, double precio, int cantidad, int codigo) {
        Random generate = new Random(); 
        //Constructor que pedirá los datos como parámetros
        try{
            this.nombre = nombre; //El parámetro nombre será asignado al artículo
            this.precio = precio; //El parámetro precio será asignado al artículo
            if(this.precio<0.30 || this.precio>5){
                //Si el precio está fuera del rango (entre 0,30€ y 5€), saldrá error
                //y se generará el precio al azar
                System.out.println("El precio introducido se halla fuera de los límites");
                this.precio = (double) (generate.nextInt(50) + 3) / 10;
            
            }
            this.cantidad = cantidad; //El parámetro cantidad será asignado al artículo
            if(this.cantidad<0 || this.cantidad>15){
                //Si la cantidad está fuera del rango (entre 0 y 15), saldrá error
                //y se generará la cantidad al azar
                System.out.println("La cantidad introducida se halla fuera de los límites");
                this.cantidad = generate.nextInt(16);
            }
        
            this.codigo = codigo; //El parámetro código será asignado al artículo
            if(this.codigo<1 || this.codigo>999){
                //Si el código está fuera del rango (entre 1 y 999), saldrá error
                //y se generará el código al azar
                System.out.println("El código introducido se halla fuera de los límites");
                this.codigo = generate.nextInt(999) + 1;
            }
        }catch(InputMismatchException ime){
            //Si en los datos numéricos se introducen otro tipo de caracteres,
            //salta este error.
            System.out.println("Error. Los datos numéricos introducidos no son válidos");
            System.out.println("Se generarán los datos numéricos al azar");
            this.nombre = nombre; //El parámetro nombre será asignado al artículo
            this.codigo = generate.nextInt(999) + 1; //Se generará el código al azar 
            //(entre 1 y 999)       
            this.precio = (double) (generate.nextInt(50) + 3) / 10; 
            //Se generará el precio al azar (desde 0,30€ hasta 5€ sin centésimas)
            this.cantidad = generate.nextInt(16); 
            //Se generará la cantidad al azar (entre 0 y 15)
        }
    }
    
    public Articulo(){ 
        //Constructor que generará los datos del artículo al azar:
        Random generate = new Random(); //Se crea un random para ello
        int x = generate.nextInt(4); //Será usado para elegir entre 4 nombres
        //predeterminados
        codigo = generate.nextInt(999) + 1; //Se generará el código al azar 
        //(entre 1 y 999)       
        precio = (double) (generate.nextInt(50) + 3) / 10; 
        //Se generará el precio al azar (desde 0,30€ hasta 5€ sin centésimas)
        cantidad = generate.nextInt(16); 
        //Se generará la cantidad al azar (entre 0 y 15)
        
        switch(x){ // Asignará como nombre una de estas cuatro opciones
            
            case 0: //Primera opción
                nombre = "Milka Hacendado";
                break;
            
            case 1: //Segunda opción
                nombre = "Oreo Hacendado";
                break;
            
            case 2: //Tercera opción
                nombre = "Chips Ahoy Hacendado";
                break;
            
            case 3: //Cuarta opción
                nombre = "Nestlé Hacendado";
                break;
                        
        }
                        
    }

    public String getNombre() { //Devolverá el nombre asignado a la clase
        return nombre;
    }

    public void setNombre(String nombre) {
        //Se asignará a la clase el nombre que le sea introducido
        this.nombre = nombre;
    }

    public double getPrecio() { //Devolverá el precio asignado a la clase
        return precio;
    }

    public void setPrecio(double precio) {
               
        if(precio<0.30 || precio>5){
            //Si el precio está fuera del rango (entre 0,30€ y 5€), saldrá error
            System.out.println("El precio introducido se halla fuera de los límites");
            
        }else{
            //Si no, se asignará a la clase el precio que le sea introducido
            this.precio = precio;
        }
        
    }

    public int getCantidad() { //Devolverá la cantidad asignada a la clase
        return cantidad;
    }

    public void setCantidad(int cantidad) {
                
        if(cantidad<0 || cantidad>15){
            //Si la cantidad está fuera del rango (entre 0 y 15), saldrá error
            System.out.println("La cantidad introducida se halla fuera de los límites");
            
        }else{
            //Si no, se asignará a la clase la cantidad que le sea introducida
            this.cantidad = cantidad;
        }
    }

    public int getCodigo() { //Devolverá el código asignado a la clase
        return codigo;
    }

    public void setCodigo(int codigo) {
        
        if(codigo<1 || codigo>999){
            //Si el código está fuera del rango (entre 1 y 999), saldrá error
            System.out.println("El código introducido se halla fuera de los límites");
               
        }else{
            //Si no, se asignará a la clase el código que le sea introducido
            this.codigo = codigo;
        }
    }

    @Override
    public String toString() { //Devuelve los datos de la clase como String
        return "Articulo" + "\n" + '{' + "\n Nombre = " + nombre +
                "\n Precio = " + precio + "0€" + "\n Cantidad = " +
                cantidad + "\n Código = " + codigo + "\n" + '}';
    }
    
    
    
}
