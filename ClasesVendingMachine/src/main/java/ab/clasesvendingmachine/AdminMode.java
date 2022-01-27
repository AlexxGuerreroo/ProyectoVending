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

    }

    public void consultarBandejas() {
        //Muestra todos los artículos (bandejas) de la máquina:
        
        for(int i = 0; i < maquina.NUM_BANDEJAS; i++){
            //Método con arrays:
            
            System.out.println(maquina.getBandejas()[i]);
            
        }       

    }

    public void consultarDeposito() {//POR MODIFICAR CUANDO SE IMPLEMENTE ARRAYS
        //Muestra los datos del depósito de la máquina:

        System.out.println(maquina.getDeposito());

    }

    public void recaudarDelDeposito() {//POR MODIFICAR CUANDO SE IMPLEMENTE ARRAYS
        //Vacía el depósito para recaudar beneficios y establece la fecha de la 
        //acción acordemente:

        maquina.getDeposito().vaciarDeposito();

        maquina.getDeposito().setFechaUltRecaudacion(LocalDate.now());

    }

    public void recargarDeposito(int m10c, int m20c, int m50c, int m1e, int m2e,
            int b5e, int b10e, int b20e) {//POR MODIFICAR CUANDO SE IMPLEMENTE ARRAYS
        //Recarga el depósito para tener cambio y establece la fecha de la acción
        //acordemente:

        maquina.getDeposito().recargar(m10c, m20c, m50c, m1e, m2e, b5e, b10e,
                 b20e);

        maquina.getDeposito().setFechaUltRecarga(LocalDate.now());

    }
    
    public void cambiarCodigo(int posicion, String newCode) {
        //Método que ajusta el código del artículo correspondiente a su posición
        //en el array bandejas

        maquina.getBandejas()[posicion].setCodigo(newCode);

    }
    
    public void cambiarProducto(int posicion, String newProducto) {
        //Método que ajusta el producto del artículo correspondiente a su posición
        //en el array bandejas
        
        
        maquina.getBandejas()[posicion].setNombre(newProducto);        

    }
    
    public void cambiarStock(int posicion, int nuevaCantidad) {
        //Método que ajusta el stock del artículo correspondiente a su posición
        //en el array bandejas
        
        maquina.getBandejas()[posicion].setCantidad(nuevaCantidad);
        
    }
        
}
