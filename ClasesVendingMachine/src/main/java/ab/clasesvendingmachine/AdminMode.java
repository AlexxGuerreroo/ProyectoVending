/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ab.clasesvendingmachine;

import java.time.LocalDate;

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
    
    public void optionSelect(){
        //Este método indicará los métodos para poder seleccionarse:
        
        
        
    }
            
    public void consultarBandejas(){
        //Muestra todos los artículos (bandejas) de la máquina:
        
        System.out.println(maquina.getA1());
        System.out.println(maquina.getA2());
        System.out.println(maquina.getA3());
        System.out.println(maquina.getA4());
        System.out.println(maquina.getA5());
        System.out.println(maquina.getA6());
        System.out.println(maquina.getA7());
        System.out.println(maquina.getA8());
        
    }
    
    public void consultarDeposito(){
        //Muestra los datos del depósito de la máquina:
        
        System.out.println(maquina.getDeposito());
        
    }
    
    public void recaudarDelDeposito(){
        //Vacía el depósito para recaudar beneficios y establece la fecha de la 
        //acción acordemente:
        
        maquina.getDeposito().vaciarDeposito();
        
        maquina.getDeposito().setFechaUltRecaudacion(LocalDate.now());
        
    }
    
    public void recargarDeposito(int m10c, int m20c, int m50c, int m1e, int m2e, 
            int b5e, int b10e, int b20e){
        //Recarga el depósito para tener cambio y establece la fecha de la acción
        //acordemente:
        
        maquina.getDeposito().recargar(m10c, m20c, m50c, m1e, m2e, b5e, b10e
                , b20e);
        
        maquina.getDeposito().setFechaUltRecarga(LocalDate.now());
        
    }
    
}
