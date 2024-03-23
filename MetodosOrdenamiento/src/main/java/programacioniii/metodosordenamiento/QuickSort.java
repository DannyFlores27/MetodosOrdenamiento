
package programacioniii.metodosordenamiento;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
     /**
     * Método público para ordenar una lista de cadenas de texto utilizando el algoritmo de ordenamiento Quick Sort.
     *
     * @param lista La lista de cadenas de texto a ordenar.
     * @return Una nueva lista de cadenas de texto ordenada.
     */
    public List<String> ordenar(List<String> lista) {
        // Verificación de la validez de la lista
        if (lista == null || lista.isEmpty()) {
            return lista;
        }
  
        // Hacer una copia de la lista original para evitar la mutación
        List<String> listaCopia = new ArrayList<>(lista);
  
        // Llamada al método de ordenamiento recursivo
        quickSortRecursive(listaCopia, 0, listaCopia.size() - 1);
        return listaCopia;
    }
  
    // Método privado para realizar la ordenación recursiva
    private void quickSortRecursive(List<String> lista, int inicio, int fin) {
        if (inicio < fin) {
            // Determinar el índice del pivote y organizar la lista alrededor del pivote
            int indicePivote = particion(lista, inicio, fin);
  
            // Ordenar recursivamente los elementos antes y después del pivote
            quickSortRecursive(lista, inicio, indicePivote - 1);
            quickSortRecursive(lista, indicePivote + 1, fin);
        }
    }
  
    // Método para particionar la lista y devolver el índice del pivote
    private int particion(List<String> lista, int inicio, int fin) {
        String pivote = lista.get(fin);
        int i = inicio - 1;
  
        for (int j = inicio; j < fin; j++) {
            // Si el elemento actual es menor o igual que el pivote, se intercambia con el elemento en i+1
            if (lista.get(j).compareTo(pivote) <= 0) {
                i++;
                intercambiarQuick(lista, i, j);
            }
        }
        // Colocar el pivote en su posición correcta intercambiándolo con el elemento en i+1
        intercambiarQuick(lista, i + 1, fin);
        return i + 1;
    }
  
    // Método para intercambiar dos elementos en la lista
    private void intercambiarQuick(List<String> lista, int i, int j) {
        String temp = lista.get(i);
        lista.set(i, lista.get(j));
        lista.set(j, temp);
    }

    /**
     * Método público para ordenar una lista de cadenas de texto utilizando el algoritmo de ordenamiento Heap Sort.
     *
     * @param lista La lista de cadenas de texto a ordenar.
     * @return Una nueva lista de cadenas de texto ordenada.
     */
    public List<String> heapSort(List<String> lista) {
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
