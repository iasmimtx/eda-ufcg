import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortRecursivo {

    public static void insertSortRecursv(int numeros[], int numLen) {
        if (numLen <= 1)
            return;
        insertSortRecursv(numeros, numLen - 1);
        int ult = numeros[numLen - 1];
        int j = numLen - 2;
        while (j >= 0 && numeros[j] > ult) {
            numeros[j + 1] = numeros[j];
            j--;
        }
        numeros[j + 1] = ult;
        System.out.println(Arrays.toString(numeros));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int[] numeros = new int[entrada.length];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Integer.parseInt(entrada[i]);
        }

        insertSortRecursv(numeros, numeros.length);

    }
}
