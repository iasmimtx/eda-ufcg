import java.util.Arrays;
import java.util.Scanner;

public class UltimoPivo {
    

    public static void particiona(int[] array, int leftIndex, int rightIndex) {
        
        int pivot = array[rightIndex];
        int i = rightIndex;
        
        for (int j = rightIndex - 1; j > -1; j--) {
            if (array[j] > pivot) {
                i--;
                swap(array, i, j);
                System.out.println(Arrays.toString(array));
            }
        }
        swap(array, i, rightIndex);
        System.out.println(Arrays.toString(array));
       
    }

    private static void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int[] numeros = new int[entrada.length];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Integer.parseInt(entrada[i]);
        }
       particiona(numeros, 0, numeros.length-1);
       System.out.println(Arrays.toString(numeros));
       
    }
}

/*9 5 1 8 2 6
[9, 5, 1, 2, 8, 6]
[2, 5, 1, 9, 8, 6]
[2, 5, 1, 6, 8, 9]
[2, 5, 1, 6, 8, 9] */