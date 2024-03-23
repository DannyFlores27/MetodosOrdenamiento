
package programacioniii.metodosordenamiento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RadixSort {
    /**
     * Método público para ordenar una lista de cadenas de texto utilizando el algoritmo de ordenamiento Radix Sort.
     *
     * @param lista La lista de cadenas de texto a ordenar.
     * @return Una nueva lista de cadenas de texto ordenada.
     */
    public static List<String> ordenar(List<String> lista) {
        int n = lista.size();
        int longitudMaxima = encontrarLongitudMaxima(lista);

        // Hacer mutable la lista dada
        lista = new ArrayList<>(lista);

        // Realiza el conteo de cada dígito. Se ejecuta ordenarConteo() para cada dígito.
        for (int exp = 0; exp < longitudMaxima; exp++) {
            ordenarConteo(lista, n, exp);
        }

        return lista;
    }

    // Función para realizar el conteo de los elementos según el valor de un dígito específico
    private static void ordenarConteo(List<String> lista, int n, int exp) {
        List<String> salida = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            salida.add(null);
        }
        Map<Character, List<String>> conteo = new HashMap<>();

        // Almacena el conteo de ocurrencias en conteo[]
        for (String elemento : lista) {
            char caracter = obtenerCaracter(elemento, exp);
            if (!conteo.containsKey(caracter)) {
                conteo.put(caracter, new ArrayList<>());
            }
            conteo.get(caracter).add(elemento);
        }

        // Construye la lista de salida
        int index = 0;
        for (char c = 0; c < 256; c++) {
            if (conteo.containsKey(c)) {
                for (String elemento : conteo.get(c)) {
                    salida.set(index++, elemento);
                }
            }
        }

        // Copia la lista de salida a la lista original para que esté ordenada
        for (int i = 0; i < n; i++) {
            lista.set(i, salida.get(i));
        }
    }

    // Función para obtener el carácter en la posición específica de la cadena
    private static char obtenerCaracter(String cadena, int posicion) {
        if (posicion >= cadena.length() || posicion < 0) {
            return (char) ('0' - 1); // Devuelve un carácter menor que '0' en el conjunto de caracteres ASCII
        }
        return cadena.charAt(cadena.length() - posicion - 1);
    }

    // Función para encontrar la longitud máxima en la lista de cadenas
    private static int encontrarLongitudMaxima(List<String> lista) {
        int longitudMaxima = 0;
        for (String cadena : lista) {
            longitudMaxima = Math.max(longitudMaxima, cadena.length());
        }
        return longitudMaxima;
    }
}
