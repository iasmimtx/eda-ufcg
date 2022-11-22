import java.util.Scanner;
import java.util.Stack;

public class ElementAtPilha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] elementos = arrInt(sc);
        Stack pilha = new Stack<Integer>();
        for (int i = 0; i < elementos.length; i++) {
            pilha.add(elementos[i]);
        }
        int index = sc.nextInt();

        Stack auxPilha = new Stack<>();
        while (!pilha.isEmpty()) {
            auxPilha.push(pilha.pop());
        }
        Stack newPilha = new Stack<>();
        int cont = 0;
        if (index  < elementos.length) {
            while (cont != index) {
                newPilha.push(auxPilha.pop());
                cont++;
            }
            if (cont == index) {
                System.out.println(auxPilha.peek());
            }
        } else {
            System.out.println("indice invalido");
        }
    }

    private static int[] arrInt(Scanner sc) {
        String[] entrada = sc.nextLine().split(" ");
        int[] saida = new int[entrada.length];
        for (int i = 0; i < entrada.length; i++) {
            saida[i] = Integer.parseInt(entrada[i]);
        }
        return saida;
    }
}
