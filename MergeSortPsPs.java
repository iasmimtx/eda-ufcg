import java.util.Arrays;
import java.util.Scanner;

public class MergeSortPsPs {

    private static void merge(int[] array, int left, int rigth) {
        int[] helper = new int[array.length]; 
		for (int i = 0; i < array.length; i++) {
	        helper[i] = array[i];
	    }
        int meio = (left + rigth) / 2;
        int i = left;
        int j = meio + 1;
        int k = left;
        while (i <= meio && j <= rigth) {
           if(helper[i]  <= helper[j]) {
            array[k] = helper[i];
            i++;
            
           } else {
            array[k] = helper[j];
            j++;
            
           }
           k++;
           
        }
        while (i <= meio) {
            array[k] = helper[i];
            i++;
            k++;
         
        }

        while (j <= rigth) {
            array[k] = helper[j];
            j++;
            k++;
            
        }
    }
    public static void sort(int[]array, int left, int right) {
        printArray(array, left, right);
        if (left >= right){
            return;
        } else { 
            int meio = (left + right) / 2;
            sort(array, left, meio);
            sort(array, meio + 1, right);
            merge(array, left, right);
            
            if(right - left < array.length-1) {
                printArray(array, left, right);
            }
        }
    }
    public static void printArray(int[] array, int ini, int fim) {
        System.out.println(Arrays.toString(Arrays.copyOfRange(array, ini, fim + 1)));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int[] numeros = new int[entrada.length];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Integer.parseInt(entrada[i]);
        }
        sort(numeros, 0, numeros.length-1);
        System.out.println(Arrays.toString(numeros));
    }
}
