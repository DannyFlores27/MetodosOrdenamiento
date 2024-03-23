
package programacioniii.metodosordenamiento;

import java.util.ArrayList;
import java.util.List;

public class HeapSort {
        /**
     * Método público para ordenar una lista de cadenas de texto utilizando el algoritmo de ordenamiento Heap Sort.
     *
     * @param lista La lista de cadenas de texto a ordenar.
     * @return Una nueva lista de cadenas de texto ordenada.
     */
    public List<String> ordenar(List<String> lista) {
        // Verificación de la validez de la lista
        if (lista == null || lista.isEmpty()) {
            return lista;
        }

        // Convertir la lista en un arreglo para facilitar el procesamiento
        String[] arreglo = lista.toArray(new String[0]);

        // Construir un montículo máximo (Heapify)
        construirMonticuloMaximo(arreglo);

        // Extraer elementos del montículo uno por uno
        for (int i = arreglo.length - 1; i >= 0; i--) {
            // Corregir el error: la variable j no está definida
            // Se utiliza la variable i en lugar de j
            intercambiarHeapSort(arreglo, i, 0); // Mover el elemento máximo actual a la posición correcta
            heapify(arreglo, i, 0); // Restaurar la propiedad de montículo en el subárbol
        }

        // Convertir el arreglo ordenado de nuevo a una lista y retornarla
        List<String> listaOrdenada = new ArrayList<>();
        for (String elemento : arreglo) {
            listaOrdenada.add(elemento);
        }
        return listaOrdenada;
    }

    // Método para construir un montículo máximo a partir de un arreglo dado
    private void construirMonticuloMaximo(String[] arreglo) {
        int n = arreglo.length;
        // Comenzar desde el último nodo que tiene hijos
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arreglo, n, i);
        }
    }

    // Método para mantener la propiedad de montículo en un subárbol dado un nodo
    private void heapify(String[] arreglo, int n, int indicePadre) {
        int indiceMaximo = indicePadre;
        int indiceIzquierdo = 2 * indicePadre + 1;
        int indiceDerecho = 2 * indicePadre + 2;

        // Comparar el nodo actual con su hijo izquierdo
        if (indiceIzquierdo < n && arreglo[indiceIzquierdo].compareTo(arreglo[indiceMaximo]) > 0) {
            indiceMaximo = indiceIzquierdo;
        }

        // Comparar el nodo actual con su hijo derecho
        if (indiceDerecho < n && arreglo[indiceDerecho].compareTo(arreglo[indiceMaximo]) > 0) {
            indiceMaximo = indiceDerecho;
        }

        // Si el nodo actual no es el máximo, intercambiarlo con el máximo y hacer heapify en el subárbol afectado
        if (indiceMaximo != indicePadre) {
            intercambiarHeapSort(arreglo, indicePadre, indiceMaximo);
            heapify(arreglo, n, indiceMaximo);
        }
    }

    // Método para intercambiar dos elementos en un arreglo
    private void intercambiarHeapSort(String[] arreglo, int i, int j) {
        String temp = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temp;
    }
}
