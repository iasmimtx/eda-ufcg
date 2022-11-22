import java.util.Arrays;
import java.util.Scanner;
//Implemente um programa em Java que posiciona o primeiro elemento de uma sequência de forma a ordená-la.
// A sequência de entrada sempre está ordenada de forma crescente (exceto pelo primeiro número).
public class InserePrimeiro {
    
    public static void main(String[] args) {
    // Tratamento da entrada, tranformando um arr de str em int através do for.
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int[] numeros = new int[entrada.length];
        for(int i = 0; i < numeros.length; i++) {
            numeros[i] = Integer.parseInt(entrada[i]);
        }
        
        for (int i = 0; i < numeros.length - 1 ; i++) {   
            if (numeros[i] > numeros[i + 1]) {
                swap(numeros, i, i + 1);
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
  
    

