/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import java.util.function.DoubleUnaryOperator;

/**
 * Clase que agrupa un conjunto de funciones matemáticas y sus derivadas.
 * Proporciona métodos para obtener funciones {@link DoubleUnaryOperator}
 * a partir de un índice, así como un listado de nombres descriptivos para
 * su uso en interfaces gráficas (por ejemplo, en un JComboBox).
 * 
 * 
 * @author KARITO
 */
public class Funciones {

    
    /**
     * Retorna la función matemática correspondiente a la opción indicada.
     *
     * @param opcion índice de la función deseada:
     *
     *   → f(x) = 4x³ - 6x² + 7x - 2.3
     *   → f(x) = x³ - 2x² + 4x - 8
     *   → f(x) = cos(x) - x
     *   → f(x) = eˣ - 3x
     *   → f(x) = x² - 2
     * 
     * @return un {@code DoubleUnaryOperator} que implementa la función.
     * @throws IllegalArgumentException si el índice no corresponde a ninguna función.
     */
    public static DoubleUnaryOperator getFuncion(int opcion) {
        switch (opcion) {
            case 0: // f(x) = 4x^3 - 6x^2 + 7x - 2.3
                return (x) -> 4 * Math.pow(x, 3) - 6 * Math.pow(x, 2) + 7 * x - 2.3;
            case 1: // f(x) = x^3 - 2x^2 + 4x - 8
                return (x) -> Math.pow(x, 3) - 2 * Math.pow(x, 2) + 4 * x - 8;
            case 2: // f(x) = cos(x) - x
                return (x) -> Math.cos(x) - x;
            case 3: // f(x) = e^x - 3x
                return (x) -> Math.exp(x) - 3 * x;
            case 4: // f(x) = x^2 - 20
                return (x) -> Math.pow(x, 2) - 2;
            default:
                throw new IllegalArgumentException("Función no definida");
        }
    }

     /**
     * Retorna la derivada de la función correspondiente a la opción indicada.
     * 
     * @param opcion índice de la función cuya derivada se desea
     * @return un {@code DoubleUnaryOperator} que implementa la derivada de la función.
     * @throws IllegalArgumentException si el índice no corresponde a ninguna derivada definida.
     */
    public static DoubleUnaryOperator getDerivada(int opcion) {
        switch (opcion) {
            case 0: // 4x^3 - 6x^2 + 7x - 2.3
                return (x) -> 12 * Math.pow(x, 2) - 12 * x + 7;
            case 1: //  x^3 - 2x^2 + 4x - 8
                return (x) -> 3 * Math.pow(x, 2) - 4 * x + 4;
            case 2: // cos(x) - x
                return (x) -> -Math.sin(x) - 1;
            case 3: // e^x - 3x
                return (x) -> Math.exp(x) - 3;
            case 4: // x^2 - 2
                return (x) -> 2 * x;
            default:
                throw new IllegalArgumentException("Derivada no definida");
        }
    }
    /**
     * Retorna la lista de nombres de las funciones para su uso en componentes
     * de interfaz gráfica, como menús desplegables.
     * 
     * @return un arreglo de {@code String} con la representación en texto de cada función.
     */
    public static String[] getNombres() {
        return new String[]{
            "f(x) = 4x^3 - 6x^2 + 7x - 2.3",
            "f(x) = x^3 - 2x^2 + 4x - 8",
            "f(x) = cos(x) - x",
            "f(x) = e^x - 3x",
            "f(x) = x^2 - 2"
        };
    
}
}