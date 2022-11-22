import java.util.Arrays;
import java.util.Scanner;

//Implemente um programa em Java que posiciona o último elemento de uma sequência
//de forma a ordená-la. A sequência de entrada sempre está ordenada de forma crescente
// (exceto pelo último número).
public class InsereUltimo {
    public static void main(String[] args) {

        // Tratamento da entrada, tranformando um arr de str em int através do for.
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int[] numeros = new int[entrada.length];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Integer.parseInt(entrada[i]);
        }

        // Inserção ordenada a partir do indice 1.
        for (int i = 1; i < numeros.length; i++) {
            int j = i;
            while (j > 0 && numeros[j] < numeros[j - 1]) {
                swap(numeros, j, j - 1);
                j -= 1;
            }
        }
        System.out.println(Arrays.toString(numeros));
    }

    private static void swap(int[] numeros, int j, int i) {
        int temp = numeros[i];
        numeros[i] = numeros[j];
        numeros[j] = temp;
    }
}
