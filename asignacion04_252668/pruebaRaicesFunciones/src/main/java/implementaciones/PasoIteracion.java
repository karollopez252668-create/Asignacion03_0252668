/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

/**
 * Clase que representa un paso de iteración en los métodos numéricos
 * para encontrar raíces de funciones.
 * <p>
 * Cada instancia almacena los valores del intervalo, la raíz aproximada,
 * el valor de la función en esa raíz y el error aproximado para una iteración.
 * </p>
 * 
 * @author KARITO
 */
public class PasoIteracion {

    /** Número de iteración actual */
    private final int iteracion;

    /** Valor inferior del intervalo (Xi) */
    private final double xi;

    /** Valor superior del intervalo (Xf) */
    private final double xf;

    /** Raíz aproximada calculada en esta iteración */
    private final double xr;

    /** Valor de la función en la raíz aproximada (f(xr)) */
    private final double fxr;

    /** Error aproximado calculado en esta iteración */
    private final double error;

    /**
     * Constructor para crear un registro de una iteración.
     *
     * @param iteracion número de iteración
     * @param xi valor inicial del intervalo
     * @param xf valor final del intervalo
     * @param xr raíz aproximada calculada
     * @param fxr valor de la función en xr
     * @param error error aproximado de la iteración
     */
    public PasoIteracion(int iteracion, double xi, double xf, double xr, double fxr, double error) {
        this.iteracion = iteracion;
        this.xi = xi;
        this.xf = xf;
        this.xr = xr;
        this.fxr = fxr;
        this.error = error;
    }

    /**
     * Devuelve el número de iteración.
     * 
     * @return número de iteración
     */
    public int getIteracion() { return iteracion; }

    /**
     * Devuelve el valor inicial del intervalo (Xi).
     * 
     * @return valor de Xi
     */
    public double getXi() { return xi; }

    /**
     * Devuelve el valor final del intervalo (Xf).
     * 
     * @return valor de Xf
     */
    public double getXf() { return xf; }

    /**
     * Devuelve la raíz aproximada calculada en esta iteración.
     * 
     * @return raíz aproximada (Xr)
     */
    public double getXr() { return xr; }

    /**
     * Devuelve el valor de la función evaluada en la raíz aproximada.
     * 
     * @return f(Xr)
     */
    public double getFxr() { return fxr; }

    /**
     * Devuelve el error aproximado calculado en esta iteración.
     * 
     * @return error aproximado
     */
    public double getError() { return error; }
}
