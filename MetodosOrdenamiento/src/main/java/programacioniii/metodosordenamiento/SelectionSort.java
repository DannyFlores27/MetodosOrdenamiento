
package programacioniii.metodosordenamiento;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {
     /**
     * Método público para ordenar una lista de cadenas de texto utilizando el algoritmo de ordenamiento Selection Sort.
     * @param listaCadenas La lista de cadenas de texto a ordenar.
     * @return Una nueva lista de cadenas de texto ordenada.
     */
    public List<String> ordenar(List<String> listaCadenas) {
        // Copiamos la lista original para no modificarla directamente
        List<String> listaOrdenada = new ArrayList<>();

        listaOrdenada.addAll(listaCadenas); // Copiamos los elementos de la lista original

        int n = listaOrdenada.size();

        // Iteramos sobre la lista
        for (int i = 0; i < n - 1; i++) {
            // Encontramos el índice del mínimo elemento en el subarray no ordenado
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (listaOrdenada.get(j).compareTo(listaOrdenada.get(indiceMinimo)) < 0) {
                    indiceMinimo = j;
                }
            }

            // Intercambiamos el mínimo elemento con el primer elemento del subarray no ordenado
            if (indiceMinimo != i) {
                String temp = listaOrdenada.get(i);
                listaOrdenada.set(i, listaOrdenada.get(indiceMinimo));
                listaOrdenada.set(indiceMinimo, temp);
            }
        }

        return listaOrdenada;
    }
}
