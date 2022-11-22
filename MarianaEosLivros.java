import java.util.Scanner;

public class MarianaEosLivros {
    public static void insertSort(String array[], int numLen) {
        if (numLen <= 1) {
            
            String nomes = String.join(", ", array);

            System.out.println(nomes.trim());
            //System.out.println(Arrays.toString(array));
            return;
        }
           
        insertSort(array, numLen - 1);
        String ult = array[numLen - 1];
        int j = numLen - 2;
        while (j >= 0 && array[j].compareTo(ult) > 0) {
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = ult;
        String nomes = String.join(", ", array);
        System.out.println(nomes.trim());
      
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(",");
        insertSort(entrada, entrada.length);
    }
}

