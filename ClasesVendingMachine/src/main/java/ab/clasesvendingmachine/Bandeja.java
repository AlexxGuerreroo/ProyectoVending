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
public class Bandeja {

    private String nombre; //Nombre del artículo
    private double precio; //Precio del artículo
    private int cantidad; //Cantidad del artículo
    private String codigo; //Código del artículo
    public static final int MAX = 15;

    public Bandeja(String nombre, double precio, int cantidad, String codigo) {
        Random generate = new Random();
        
        //Constructor que pedirá los datos como parámetros.
        try {
            //El parámetro nombre será asignado al artículo.
            this.nombre = nombre;
            
            //El parámetro precio será asignado al artículo.
            this.precio = precio;
            
            //Si el precio está fuera del rango (entre 0,30€ y 5€), saldrá error
            //y se generará el precio al azar.
            if (this.precio < 0.30 || this.precio > 5) {
                            
                System.out.println("El precio introducido se halla fuera de los límites ");
                this.precio = (double) (generate.nextInt(50) + 3) / 10;

            }
            
            //El parámetro cantidad será asignado al artículo.
            this.cantidad = cantidad;
            
            //Si la cantidad está fuera del rango (entre 0 y 15), saldrá error
            //y se generará la cantidad al azar.
            if (this.cantidad < 0 || this.cantidad > MAX) {
                
                System.out.println("La cantidad introducida se halla fuera de los límites ");
                this.cantidad = generate.nextInt(16);
            }
            //El parámetro código será asignado al artículo. 
            this.codigo = codigo;

            if (this.codigo.length() != 3) {
                
                //Si el código está fuera del rango (entre 0 y 999), saldrá error
                //y se generará el código al azar.
                System.out.println("Error al introducir el código, en su defecto"
                        + "se creará uno nuevo por defecto ");
                
                //Esto generará 3 número al azar entre el 0 y el 9.
                this.codigo = "" + generate.nextInt(10) + generate.nextInt(10)
                        + generate.nextInt(10);
            }
            
        } catch (InputMismatchException ime) {
            
            //Si en los datos numéricos se introducen otro tipo de caracteres,
            //salta este error.
            System.out.println("Error. Valores introducidos no válidos "
                    + "\nSe generarán los datos numéricos al azar");
            
            //El parámetro nombre será asignado al artículo.
            this.nombre = nombre;
            
            //Se generará el código al azar (entre 1 y 999).    
            this.codigo = "" + generate.nextInt(10) + generate.nextInt(10)
                    + generate.nextInt(10); 
            
            //Se generará el precio al azar (desde 0,30€ hasta 5€ sin centésimas).
            this.precio = (double) (generate.nextInt(50) + 3) / 10;
            
            //Se generará la cantidad al azar (entre 0 y 15).
            this.cantidad = generate.nextInt(16);
        }
    }

    public Bandeja() {
        
        //Declaramos e inicializamos el constructor que generará los datos
        //del artículo al azar.
        Random generate = new Random();
        
        //ELegirá cuatro nombres predeterminados al azar.
        int x = generate.nextInt(4); 
        
        //Se generará el código al azar (entre 0 y 999).       
        codigo = "" + generate.nextInt(10) + generate.nextInt(10)
                + generate.nextInt(10); 
        
        //Se generará el precio al azar (desde 0,30€ hasta 5€ sin centésimas)
        precio = (double) (generate.nextInt(50) + 3) / 10;
        //Se generará la cantidad al azar (entre 0 y 15)
        cantidad = generate.nextInt(16);
        
        //Asignará como nombre una de las cuatro opciones.
        switch (x) {
            
            //Primera opción.
            case 0:
                nombre = "Milka";
                break;

            //Segunda opción .
            case 1: //Segunda opción
                nombre = "Oreo";
                break;
                
            //Tercera opción.
            case 2: //Tercera opción
                nombre = "Chips Ahoy";
                break;
                
            //Cuarta opción.
            case 3: //Cuarta opción
                nombre = "Nestlé";
                break;

        }

    }
    
    //Devolverá el nombre asignado a la clase.
    public String getNombre() { 
        return nombre;
    }
    
    //Se asignará a la clase el nombre que le sea introducido.
    public void setNombre(String nombre) {
        
        this.nombre = nombre;
    }
    //Devolverá el precio asignado a la clase.
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {

        if (precio < 0.30 || precio > 5) {
            //Si el precio está fuera del rango (entre 0,30€ y 5€), saldrá error.
            System.out.println("El precio introducido se halla fuera de los límites");

        } else {
            //Si no, se asignará a la clase el precio que le sea introducido.
            this.precio = precio;
        }

    }
    
    //Devolverá la cantidad asignada a la clase.
    public int getCantidad() { 
        return cantidad;
    }

    public void setCantidad(int cantidad) {

        if (cantidad < 0 || cantidad > MAX) {
            //Si la cantidad está fuera del rango (entre 0 y 15), saldrá error
            System.out.println("La cantidad introducida se halla fuera de los límites");

        } else {
            //Si no, se asignará a la clase la cantidad que le sea introducida.
            this.cantidad = cantidad;
        }
    }
    
    //Devolverá el código asignado a la clase.
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {

        if (codigo.length() != 3) {
            //Si el código está fuera del rango (entre 1 y 999), saldrá error
            System.out.println("El código introducido se halla fuera de los límites");

        } else {
            //Si no, se asignará a la clase el código que le sea introducido
            this.codigo = codigo;
        }
    }
    
    public String forFactura() { //Devuelve como String los datos necesarios de 
        //la clase para la factura 
        return "Articulo " + codigo + ": " + '{' + "Nombre = " + nombre
                + "; Precio = " + precio + "0€" + '}';
    }

    //Método toString que devuelve los datos de la clase.
    @Override
    public String toString() { //Devuelve los datos de la clase como String
        return "Articulo " + codigo + ": " + '{' + "Nombre = " + nombre
                + "; Precio = " + precio + "0€" + "; Cantidad = "
                + cantidad + '}';
    }

}
