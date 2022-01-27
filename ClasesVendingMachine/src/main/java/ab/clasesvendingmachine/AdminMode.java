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

        System.out.println(maquina.getA1());
        System.out.println(maquina.getA2());
        System.out.println(maquina.getA3());
        System.out.println(maquina.getA4());
        System.out.println(maquina.getA5());
        System.out.println(maquina.getA6());
        System.out.println(maquina.getA7());
        System.out.println(maquina.getA8());

    }

    public void consultarDeposito() {
        //Muestra los datos del depósito de la máquina:

        System.out.println(maquina.getDeposito());

    }

    public void recaudarDelDeposito() {
        //Vacía el depósito para recaudar beneficios y establece la fecha de la 
        //acción acordemente:

        maquina.getDeposito().vaciarDeposito();

        maquina.getDeposito().setFechaUltRecaudacion(LocalDate.now());

    }

    public void recargarDeposito(int m10c, int m20c, int m50c, int m1e, int m2e,
            int b5e, int b10e, int b20e) {
        //Recarga el depósito para tener cambio y establece la fecha de la acción
        //acordemente:

        maquina.getDeposito().recargar(m10c, m20c, m50c, m1e, m2e, b5e, b10e,
                 b20e);

        maquina.getDeposito().setFechaUltRecarga(LocalDate.now());

    }

    public void cambiarCodigo(String code, String newCode) {

        if (maquina.getA1().getCodigo().equals(code)) {

            maquina.getA1().setCodigo(newCode);

        } else if (maquina.getA2().getCodigo().equals(code)) {

            maquina.getA2().setCodigo(newCode);

        } else if (maquina.getA3().getCodigo().equals(code)) {

            maquina.getA3().setCodigo(newCode);

        } else if (maquina.getA4().getCodigo().equals(code)) {

            maquina.getA4().setCodigo(newCode);

        } else if (maquina.getA5().getCodigo().equals(code)) {

            maquina.getA5().setCodigo(newCode);

        } else if (maquina.getA6().getCodigo().equals(code)) {

            maquina.getA6().setCodigo(newCode);

        } else if (maquina.getA7().getCodigo().equals(code)) {

            maquina.getA7().setCodigo(newCode);

        } else if (maquina.getA8().getCodigo().equals(code)) {

            maquina.getA8().setCodigo(newCode);

        } else {//Si no coincide con ninguno, mandamos un mensaje de error.

            System.out.println("El código introducido no coincide con ningún"
                    + " producto.");

        }

    }

    public void cambiarProducto(String code, String newProducto) {

        if (maquina.getA1().getCodigo().equals(code)) {

            maquina.getA1().setNombre(newProducto);

        } else if (maquina.getA2().getCodigo().equals(code)) {

            maquina.getA2().setNombre(newProducto);

        } else if (maquina.getA3().getCodigo().equals(code)) {

            maquina.getA3().setNombre(newProducto);

        } else if (maquina.getA4().getCodigo().equals(code)) {

            maquina.getA4().setNombre(newProducto);

        } else if (maquina.getA5().getCodigo().equals(code)) {

            maquina.getA5().setNombre(newProducto);

        } else if (maquina.getA6().getCodigo().equals(code)) {

            maquina.getA6().setNombre(newProducto);

        } else if (maquina.getA7().getCodigo().equals(code)) {

            maquina.getA7().setNombre(newProducto);

        } else if (maquina.getA8().getCodigo().equals(code)) {

            maquina.getA8().setNombre(newProducto);

        } else {//Si no coincide con ninguno, mandamos un mensaje de error.

            System.out.println("El código introducido no coincide con ningún"
                    + " producto.");

        }

    }

    public void cambiarStock(String code, int nuevaCantidad) {

        if (maquina.getA1().getCodigo().equals(code)) {

            maquina.getA1().setCantidad(nuevaCantidad);

        } else if (maquina.getA2().getCodigo().equals(code)) {

            maquina.getA2().setCantidad(nuevaCantidad);

        } else if (maquina.getA3().getCodigo().equals(code)) {

            maquina.getA3().setCantidad(nuevaCantidad);

        } else if (maquina.getA4().getCodigo().equals(code)) {

            maquina.getA4().setCantidad(nuevaCantidad);

        } else if (maquina.getA5().getCodigo().equals(code)) {

            maquina.getA5().setCantidad(nuevaCantidad);

        } else if (maquina.getA6().getCodigo().equals(code)) {

            maquina.getA6().setCantidad(nuevaCantidad);

        } else if (maquina.getA7().getCodigo().equals(code)) {

            maquina.getA7().setCantidad(nuevaCantidad);

        } else if (maquina.getA8().getCodigo().equals(code)) {

            maquina.getA8().setCantidad(nuevaCantidad);

        } else {//Si no coincide con ninguno, mandamos un mensaje de error.

            System.out.println("El código introducido no coincide con ningún"
                    + " producto.");

        }

    }

}
