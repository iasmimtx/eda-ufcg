import java.util.Arrays;
import java.util.Scanner;

public class SelectionSortRecursivo {
    public static void selectionPassoaPasso(int numeros[]) {        
        for (int  i =  0 ; i < numeros.length -  1 ; i++){  
            int  indice = i;  
            for  ( int  j = i +  1 ; j < numeros.length; j++){  
                if  (numeros[j] < numeros[indice]){  
                    indice = j;  
                } 
            }  
            swap(numeros, indice, i);
            System.out.println(Arrays.toString(numeros));
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
        
        selectionPassoaPasso(numeros);

    }
}
