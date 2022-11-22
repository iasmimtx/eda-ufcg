
import java.util.Scanner;

public class quickSort {
    public static void sort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }
        else{
            int indexPivot = particiona(array, leftIndex, rightIndex);
            sort(array, leftIndex, indexPivot-1);
            sort(array, indexPivot+1, rightIndex);
        }
    }

    public static int particiona(int[] array, int leftIndex, int rightIndex) {
        
        int pivot = array[leftIndex];
        int i = leftIndex;

        for (int j = i+1; j <= rightIndex; j++) {
            if (array[j] <= pivot ) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, leftIndex, i);
        System.out.println((transforma(array)));
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;

    }

    private static String transforma(int[] array) {
        String saida = "";
        for (int i = 0; i < array.length; i++) {
            saida += array[i] + " ";
        }
        return saida.trim();
    }
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int[] numeros = new int[entrada.length];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Integer.parseInt(entrada[i]);
        }
        sort(numeros, 0, numeros.length-1);
       
    }
}
