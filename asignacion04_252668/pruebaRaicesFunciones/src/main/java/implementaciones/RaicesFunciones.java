/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

/**
 * Clase que implementa métodos numéricos para encontrar raíces de funciones,
 * incluyendo el método de Bisección y el de Regla Falsa.
 * <p>
 * Cada método permite calcular una raíz aproximada de una función continua
 * en un intervalo dado, siempre que exista un cambio de signo en los extremos.
 * </p>
 *
 * @author KARITO
 */
public class RaicesFunciones {

    /**
     * Número de iteraciones realizadas en el último cálculo.
     */
    private int iteraciones;

    /**
     * Devuelve el número de iteraciones realizadas en el último cálculo.
     *
     * @return cantidad de iteraciones
     */
    public int getIteraciones() {
        return iteraciones;
    }

    private final List<PasoIteracion> pasos = new ArrayList<>();

    public List<PasoIteracion> getPasos() {
        return pasos;
    }


    /**
     * Método de Bisección para encontrar una raíz de la función {@code f}.
     * <p>
     * Divide el intervalo en mitades y selecciona el subintervalo donde ocurre
     * el cambio de signo, repitiendo el proceso hasta que el error sea menor
     * al permitido.
     * </p>
     *
     * @param f     función a evaluar (implementada como {@link DoubleUnaryOperator})
     * @param xi    valor inicial del intervalo
     * @param xf    valor final del intervalo
     * @param eamax error máximo permitido (en porcentaje)
     * @return raíz aproximada de la función
     */
    public double biseccion(DoubleUnaryOperator f, double xi, double xf, double eamax) {
        iteraciones = 0;
        double xr = 0, ea = 100;

        while (ea > eamax) {
            double xrPrev = xr;
            xr = (xi + xf) / 2.0;
            double fxr = f.applyAsDouble(xr);
            double fxi = f.applyAsDouble(xi);

            if (fxr * fxi < 0) {
                xf = xr;
            } else {
                xi = xr;
            }

            iteraciones++;
            if (iteraciones > 1) {
                ea = Math.abs((xr - xrPrev) / xr) * 100;
            }
             pasos.add(new PasoIteracion(iteraciones, xi, xf, xr, fxr, ea));
        }
        return xr;
    }

    /**
     * Método de la Regla Falsa para encontrar una raíz de la función {@code f}.
     * <p>
     * Calcula el punto de intersección de la recta secante al intervalo y selecciona
     * el subintervalo donde ocurre el cambio de signo, repitiendo el proceso hasta
     * que el error sea menor al permitido.
     * </p>
     *
     * @param f     función a evaluar (implementada como {@link DoubleUnaryOperator})
     * @param xi    valor inicial del intervalo
     * @param xf    valor final del intervalo
     * @param eamax error máximo permitido (en porcentaje)
     * @return raíz aproximada de la función
     */
    public double reglaFalsa(DoubleUnaryOperator f, double xi, double xf, double eamax) {
        iteraciones = 0;
        double xr = 0, ea = 100;

        while (ea > eamax) {
            double xrPrev = xr;
            double fxi = f.applyAsDouble(xi);
            double fxf = f.applyAsDouble(xf);

            xr = xf - (fxf * (xi - xf)) / (fxi - fxf);
            double fxr = f.applyAsDouble(xr);

            if (fxi * fxr < 0) {
                xf = xr;
            } else {
                xi = xr;
            }

            iteraciones++;
            if (iteraciones > 1) {
                ea = Math.abs((xr - xrPrev) / xr) * 100;
            }
             pasos.add(new PasoIteracion(iteraciones, xi, xf, xr, fxr, ea));
        }
        return xr;
    }
}
