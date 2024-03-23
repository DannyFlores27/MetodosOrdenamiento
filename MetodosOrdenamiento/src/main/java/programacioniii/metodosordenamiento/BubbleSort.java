
package programacioniii.metodosordenamiento;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {
     /**
     * Método público para ordenar una lista de cadenas de texto utilizando el algoritmo de ordenamiento Bubble Sort.
     *
     * @param lista La lista de cadenas de texto a ordenar.
     * @return Una nueva lista de cadenas de texto ordenada.
     */
    public List<String> ordenar(List<String> listaCadenas) {
        // Copiamos la lista original para no modificarla directamente
        List<String> listaOrdenada = new ArrayList<>();

        listaOrdenada.addAll(listaCadenas); // Copiamos los elementos de la lista original

        int n = listaOrdenada.size();

        // Iteramos sobre la lista para aplicar el algoritmo de Bubble Sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Comparamos dos cadenas adyacentes y las intercambiamos si están en el orden incorrecto
                if (listaOrdenada.get(j).compareTo(listaOrdenada.get(j + 1)) > 0) {
                    String temp = listaOrdenada.get(j);
                    listaOrdenada.set(j, listaOrdenada.get(j + 1));
                    listaOrdenada.set(j + 1, temp);
                }
            }
        }

        return listaOrdenada;
    }
}
