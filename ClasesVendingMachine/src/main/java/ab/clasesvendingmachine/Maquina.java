/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ab.clasesvendingmachine;

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
    private String code;

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
        code = "ACM1PT";
        
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
        this.code = code;
        
    }
        
    public void elegirProducto(int code) {
        //Este método cogerá el artículo seleccionado y comenzará el pago;

    }
    
    public void insertarCodigo(){
        //Este método pide un código por pantalla/interfaz, comprobando primero
        //si es de administador y si lo es, pasa a los controles de admin.
        //Si no, pasa al método elegirProducto.
        
        
        
    }

    
    
}
