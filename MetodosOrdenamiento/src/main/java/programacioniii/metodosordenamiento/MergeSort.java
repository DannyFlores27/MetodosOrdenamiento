
package programacioniii.metodosordenamiento;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
     /**
     * Método público para ordenar una lista de cadenas de texto utilizando el algoritmo de ordenamiento Merge Sort.
     *
     * @param lista La lista de cadenas de texto a ordenar.
     * @return Una nueva lista de cadenas de texto ordenada.
     */
    public List<String> ordenar(List<String> lista) {
        // Si la lista tiene menos de 2 elementos, está ordenada
        if (lista.size() <= 1) {
            return lista;
        }

        // Dividimos la lista en dos mitades aproximadamente iguales
        int mitad = lista.size() / 2;
        List<String> izquierda = ordenar(lista.subList(0, mitad));
        List<String> derecha = ordenar(lista.subList(mitad, lista.size()));

        // Combinamos las dos mitades ordenadas
        return merge(izquierda, derecha);
    }

    // Método para combinar dos listas ordenadas en una sola lista ordenada
    private List<String> merge(List<String> izquierda, List<String> derecha) {
        List<String> listaOrdenada = new ArrayList<>();
        int i = 0, j = 0;

        // Combinamos las dos listas comparando los elementos y colocándolos en orden
        while (i < izquierda.size() && j < derecha.size()) {
            if (izquierda.get(i).compareTo(derecha.get(j)) <= 0) {
                listaOrdenada.add(izquierda.get(i));
                i++;
            } else {
                listaOrdenada.add(derecha.get(j));
                j++;
            }
        }

        // Agregamos los elementos restantes de la lista izquierda, si los hay
        while (i < izquierda.size()) {
            listaOrdenada.add(izquierda.get(i));
            i++;
        }

        // Agregamos los elementos restantes de la lista derecha, si los hay
        while (j < derecha.size()) {
            listaOrdenada.add(derecha.get(j));
            j++;
        }

        // Devolvemos la lista ordenada
        return listaOrdenada;
    }
}
