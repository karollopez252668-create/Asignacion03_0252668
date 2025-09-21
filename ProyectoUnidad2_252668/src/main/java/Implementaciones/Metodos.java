/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import java.util.function.DoubleUnaryOperator;
import javax.swing.table.DefaultTableModel;


/**
 * Clase que implementa los principales métodos numéricos para encontrar raíces
 * de ecuaciones no lineales: Bisección, Regla Falsa, Newton-Raphson y Secante.
 * 
 * <p>Cada método llena una tabla de iteraciones usando un
 * {@link DefaultTableModel} para su posterior visualización en una interfaz gráfica.</p>
 * 
 * <p>Condiciones de parada:</p>
 * <ul>
 *   <li>Cuando el error es menor que la tolerancia especificada.</li>
 *   <li>O cuando se alcanza el número máximo de iteraciones.</li>
 * </ul>
 * 
 * @author KARITO
 */
public class Metodos {
    
    
    /**
     * Método de Bisección para encontrar raíces de la función.
     * 
     * @param f función a evaluar representada como {@link DoubleUnaryOperator}.
     * @param xi extremo izquierdo del intervalo inicial.
     * @param xf extremo derecho del intervalo inicial.
     * @param tol tolerancia deseada para el error.
     * @param maxIter número máximo de iteraciones permitidas.
     * @param modelo modelo de tabla donde se agregarán los resultados de cada iteración
     *               en el formato: [iteración, xi, xf, xr, f(xr), error].
     */
    public static void biseccion(DoubleUnaryOperator f, double xi, double xf, double tol, int maxIter, DefaultTableModel modelo) {
        double xr = 0, error = 1;
        int iter = 1;

        while (iter <= maxIter && error > tol) {
            xr = (xi + xf) / 2.0;
            double fxi = f.applyAsDouble(xi);
            double fxr = f.applyAsDouble(xr);

            if (iter == 1) error = Math.abs(xf - xi);
            else error = Math.abs((xf - xi) / 2.0);

            modelo.addRow(new Object[]{iter, xi, xf, xr, fxr, error});

            if (fxi * fxr < 0) {
                xf = xr;
            } else {
                xi = xr;
            }

            if (error < tol) break;
            iter++;
        }
    }

    
    /**
     * Método de Regla Falsa (o Posición Falsa) para encontrar raíces.
     * 
     * @param f función a evaluar.
     * @param xi extremo izquierdo del intervalo inicial.
     * @param xf extremo derecho del intervalo inicial.
     * @param tol tolerancia deseada para el error.
     * @param maxIter número máximo de iteraciones.
     * @param modelo modelo de tabla donde se agregarán los resultados de cada iteración
     *               en el formato: [iteración, xi, xf, xr, f(xr), error].
     */
    public static void reglaFalsa(DoubleUnaryOperator f, double xi, double xf, double tol, int maxIter, DefaultTableModel modelo) {
        double xr = 0, error = 1;
        int iter = 1;

        while (iter <= maxIter && error > tol) {
            double fxi = f.applyAsDouble(xi);
            double fxf = f.applyAsDouble(xf);

            xr = xf - (fxf * (xi - xf)) / (fxi - fxf);
            double fxr = f.applyAsDouble(xr);

            if (iter == 1) error = Math.abs(xr - xi);
            else error = Math.abs(xr - xi);

            modelo.addRow(new Object[]{iter, xi, xf, xr, fxr, error});

            if (fxi * fxr < 0) {
                xf = xr;
            } else {
                xi = xr;
            }

            if (error < tol) break;
            iter++;
        }
    }

     /**
     * Método de Newton-Raphson para encontrar raíces.
     * 
     * @param f función a evaluar.
     * @param df derivada de la función, también como {@link DoubleUnaryOperator}.
     * @param x0 valor inicial (aproximación inicial de la raíz).
     * @param tol tolerancia para el error.
     * @param maxIter número máximo de iteraciones.
     * @param modelo modelo de tabla donde se agregarán los resultados de cada iteración
     *               en el formato: [iteración, x, "-", x1, f(x), error].
     */
    public static void newtonRaphson(DoubleUnaryOperator f, DoubleUnaryOperator df, double x0, double tol, int maxIter, DefaultTableModel modelo) {
        double x = x0, error = 1;
        int iter = 1;

        while (iter <= maxIter && error > tol) {
            double fx = f.applyAsDouble(x);
            double dfx = df.applyAsDouble(x);
            double x1 = x - fx / dfx;
            error = Math.abs(x1 - x);

            modelo.addRow(new Object[]{iter, x, "-", x1, fx, error});

            if (error < tol) break;
            x = x1;
            iter++;
        }
    }

    
    /**
     * Método de Secante para encontrar raíces sin necesidad de derivada.
     * 
     * @param f función a evaluar.
     * @param x0 primer valor inicial.
     * @param x1 segundo valor inicial.
     * @param tol tolerancia para el error.
     * @param maxIter número máximo de iteraciones.
     * @param modelo modelo de tabla donde se agregarán los resultados de cada iteración
     *               en el formato: [iteración, xi, xf, xr, f(xr), error].
     */
    public static void secante(DoubleUnaryOperator f, double x0, double x1, double tol, int maxIter, DefaultTableModel modelo) {
        double xi = x0, xf = x1, xr = 0, error = 1;
        int iter = 1;

        while (iter <= maxIter && error > tol) {
            double fxi = f.applyAsDouble(xi);
            double fxf = f.applyAsDouble(xf);

            xr = xf - (fxf * (xi - xf)) / (fxi - fxf);
            double fxr = f.applyAsDouble(xr);

            error = Math.abs(xr - xf);

            modelo.addRow(new Object[]{iter, xi, xf, xr, fxr, error});

            xi = xf;
            xf = xr;

            if (error < tol) break;
            iter++;
        }
    }
}

