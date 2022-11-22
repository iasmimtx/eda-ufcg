import java.util.Arrays;
import java.util.Scanner;

public class SelectionPassoAPasso {
    static void selectionSort(int numArray[]) {
        if (numArray.length <= 1) {
            System.out.println(Arrays.toString(numArray));
            return;
        }
        for (int i = 0; i < numArray.length - 1; i++) {
            int indexMenor = i;
            Boolean alterou = false;
            for (int j = i + 1; j < numArray.length; j++) {
                if (numArray[j] < numArray[indexMenor]) {
                    indexMenor = j;
                    alterou = true;
                }
            }

            swap(numArray, i, indexMenor);
            if (alterou) {
                System.out.println(Arrays.toString(numArray));
            }
        }
    }

    private static void swap(int[] numeros, int j, int i) {
        int temp = numeros[i];
        numeros[i] = numeros[j];
        numeros[j] = temp;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int[] numeros = new int[entrada.length];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Integer.parseInt(entrada[i]);
        }
        selectionSort(numeros);
    }
}
