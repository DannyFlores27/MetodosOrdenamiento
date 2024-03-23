
package programacioniii.metodosordenamiento;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {
        /**
     * Método público para ordenar una lista de cadenas de texto utilizando el algoritmo de ordenamiento insertionSort.
     *
     * @param lista La lista de cadenas de texto a ordenar.
     * @return Una nueva lista de cadenas de texto ordenada.
     */
    public List<String> ordenar(List<String> lista) {
        // Copiamos la lista original para evitar modificar la lista original
        List<String> listaOrdenada = new ArrayList<>(lista);

        // Comenzamos desde el segundo elemento hasta el último
        for (int i = 1; i < listaOrdenada.size(); i++) {
            // Almacenamos temporalmente el elemento actual que vamos a insertar
            String elementoActual = listaOrdenada.get(i);
            int j = i - 1;

            // Movemos los elementos mayores que el elemento actual una posición hacia la derecha
            while (j >= 0 && listaOrdenada.get(j).compareTo(elementoActual) > 0) {
                listaOrdenada.set(j + 1, listaOrdenada.get(j));
                j--;
            }

            // Insertamos el elemento actual en su posición correcta
            listaOrdenada.set(j + 1, elementoActual);
        }

        // Devolvemos la lista ordenada
        return listaOrdenada;
    }
}
