package programacioniii.metodosordenamiento;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class MetodosOrdenamiento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> listaOriginal = new ArrayList<>();

        boolean primeraEjecucion = true;

        while (true) {
            if (!primeraEjecucion) {
                System.out.println("¿Desea ingresar una nueva lista? (Si/No)");
                String nuevaLista = scanner.nextLine().trim();
                if (nuevaLista.equalsIgnoreCase("No")) {
                    break;
                }
            }
            System.out.println("Ingrese los elementos de la lista separados por comas:");
            String input = scanner.nextLine();
            String[] elementos = input.split(",");
            listaOriginal.clear(); // Limpiar la lista anterior si existe
            for (String elemento : elementos) {
                listaOriginal.add(elemento.trim()); // Eliminar espacios en blanco alrededor de cada elemento
            }
            primeraEjecucion = false;

            // Crear instancias de los algoritmos de ordenamiento
            BubbleSort bubbleSort = new BubbleSort();
            BucketSort bucketSort = new BucketSort();
            CountingSort countingSort = new CountingSort();
            InsertionSort insertionSort = new InsertionSort();
            MergeSort mergeSort = new MergeSort();
            QuickSort quickSort = new QuickSort();
            RadixSort radixSort = new RadixSort();
            SelectionSort selectionSort = new SelectionSort();

            boolean salir = false;

            while (!salir) {
                // Mostrar menú de opciones
                System.out.println("Seleccione un método de ordenamiento:");
                System.out.println("1. Ordenamiento burbuja");
                System.out.println("2. Ordenamiento por bucket");
                System.out.println("3. Ordenamiento por conteo");
                System.out.println("4. Ordenamiento por inserción");
                System.out.println("5. Ordenamiento por combinación");
                System.out.println("6. Ordenamiento rápido");
                System.out.println("7. Ordenamiento por radix");
                System.out.println("8. Ordenamiento por selección");
                System.out.println("0. Salir");

                // Leer la opción seleccionada por el usuario
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea después de leer el entero

                switch (opcion) {
                    case 1:
                        // Ordenar utilizando Bubble Sort
                        List<String> listaOrdenadaBubble = bubbleSort.ordenar(listaOriginal);
                        System.out.println("Lista ordenada método burbuja: " + listaOrdenadaBubble);
                        break;
                    case 2:
                        // Ordenar utilizando Bucket Sort
                        List<String> listaOrdenadaBucket = bucketSort.ordenar(listaOriginal);
                        System.out.println("Lista ordenada método bucket: " + listaOrdenadaBucket);
                        break;
                    case 3:
                        // Ordenar utilizando Counting Sort
                        List<String> listaOrdenadaCounting = countingSort.ordenar(listaOriginal);
                        System.out.println("Lista ordenada método conteo: " + listaOrdenadaCounting);
                        break;
                    case 4:
                        // Ordenar utilizando Insertion Sort
                        List<String> listaOrdenadaInsertion = insertionSort.ordenar(listaOriginal);
                        System.out.println("Lista ordenada método inserción: " + listaOrdenadaInsertion);
                        break;
                    case 5:
                        // Ordenar utilizando Merge Sort
                        List<String> listaOrdenadaMerge = mergeSort.ordenar(listaOriginal);
                        System.out.println("Lista ordenada método combinación: " + listaOrdenadaMerge);
                        break;
                    case 6:
                        // Ordenar utilizando Quick Sort
                        List<String> listaOrdenadaQuick = quickSort.ordenar(listaOriginal);
                        System.out.println("Lista ordenada método rápido: " + listaOrdenadaQuick);
                        break;
                    case 7:
                        // Ordenar utilizando Radix Sort
                        List<String> listaOrdenadaRadix = radixSort.ordenar(listaOriginal);
                        System.out.println("Lista ordenada método radix: " + listaOrdenadaRadix);
                        break;
                    case 8:
                        // Ordenar utilizando Selection Sort
                        List<String> listaOrdenadaSelection = selectionSort.ordenar(listaOriginal);
                        System.out.println("Lista ordenada método selección: " + listaOrdenadaSelection);
                        break;
                    case 0:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                }

                if (!salir) {
                    System.out.println("¿Desea continuar con la misma lista? (Si/No)");
                    String continuar = scanner.nextLine().trim();
                    if (!continuar.equalsIgnoreCase("Si")) {
                        break;
                    }
                }
            }
        }

        System.out.println("¡Hasta luego!");
        scanner.close();
    }
}

