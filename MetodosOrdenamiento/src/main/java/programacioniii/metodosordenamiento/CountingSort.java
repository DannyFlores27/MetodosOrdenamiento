
package programacioniii.metodosordenamiento;

import java.util.ArrayList;
import java.util.List;

public class CountingSort {
     /**
     * Método público para ordenar una lista de cadenas de texto utilizando el algoritmo de ordenamiento Counting Sort.
     *
     * @param lista La lista de cadenas de texto a ordenar.
     * @return Una nueva lista de cadenas de texto ordenada.
     */
    public List<String> ordenar(List<String> lista) {
        // Encontrar la longitud máxima de las cadenas en la lista
        int maxLongitud = encontrarMaxLongitud(lista);
        
        // Crear un arreglo de conteo para almacenar la frecuencia de cada caracter
        int[][] conteo = new int[lista.size()][256]; // 256 es el número de caracteres ASCII posibles
        
        // Contar la frecuencia de cada caracter en cada posición de la cadena
        for (int i = 0; i < lista.size(); i++) {
            String cadena = lista.get(i);
            for (int j = 0; j < cadena.length(); j++) {
                char caracter = cadena.charAt(j);
                conteo[i][caracter]++;
            }
        }
        
        // Construir la lista ordenada utilizando el arreglo de conteo
        List<String> listaOrdenada = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 256; j++) {
                for (int k = 0; k < conteo[i][j]; k++) {
                    sb.append((char)j);
                }
            }
            listaOrdenada.add(sb.toString());
        }
        
        return listaOrdenada;
    }
    
    // Método para encontrar la longitud máxima de las cadenas en la lista
    private static int encontrarMaxLongitud(List<String> lista) {
        int maxLongitud = 0;
        for (String cadena : lista) {
            maxLongitud = Math.max(maxLongitud, cadena.length());
        }
        return maxLongitud;
    }
}
