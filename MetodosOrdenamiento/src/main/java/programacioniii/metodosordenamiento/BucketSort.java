
package programacioniii.metodosordenamiento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    /**
     * Método público para ordenar una lista de cadenas de texto utilizando el algoritmo de ordenamiento Bucket sort.
     *
     * @param lista La lista de cadenas de texto a ordenar.
     * @return Una nueva lista de cadenas de texto ordenada.
     */
    public static List<String> ordenar(List<String> lista) {
        // Verificar si la lista está vacía o tiene un solo elemento
        if (lista == null || lista.size() <= 1) {
            return lista;
        }

        // Crear un arreglo de cubetas
        ArrayList<ArrayList<String>> cubetas = new ArrayList<>(128); // Usaremos 128 cubetas para todo el rango ASCII

        // Inicializar cada cubeta
        for (int i = 0; i < 128; i++) {
            cubetas.add(new ArrayList<>());
        }

        // Colocar cada elemento en su cubeta correspondiente
        for (String cadena : lista) {
            if (esNumero(cadena)) {
                // Si es un número, lo colocamos en la cubeta correspondiente al primer dígito
                int digit = Integer.parseInt(cadena.substring(0, 1));
                cubetas.get(digit).add(cadena);
            } else {
                // Si es una palabra, lo colocamos en la cubeta correspondiente al primer carácter
                int charValue = (int) cadena.charAt(0);
                cubetas.get(charValue).add(cadena);
            }
        }

        // Ordenar cada cubeta
        for (ArrayList<String> cubeta : cubetas) {
            Collections.sort(cubeta);
        }

        // Concatenar las cubetas ordenadas
        List<String> resultado = new ArrayList<>();
        for (ArrayList<String> cubeta : cubetas) {
            resultado.addAll(cubeta);
        }

        return resultado;
    }

    // Método auxiliar para verificar si una cadena es un número
    private static boolean esNumero(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
