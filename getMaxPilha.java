import java.util.Scanner;
import java.util.Stack;

public class getMaxPilha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] valores = arrInteiros(sc);
        Stack pilha = new Stack();
        //adicinando na pilha os valores inseridos na entrada(input)
        for (int i = 0; i < valores.length; i++) {
            pilha.push(valores[i]);
        }
        int valor = getMax(pilha);
        System.out.println(valor);
    }

    private static int getMax(Stack pilha) {
        Stack auxPilha = new Stack();
        int maior = (int) pilha.peek();
        while (!pilha.isEmpty()) {
            if (pilha.size() == 1) {
                break;
            }
            auxPilha.push(pilha.pop());
            if (maior < (int) pilha.peek()) {
                maior = (int) pilha.peek();
            }
        }
        return maior;
    }
    private static int[] arrInteiros(Scanner sc) {
        String[] entrada = sc.nextLine().split(" ");
        int[] saida = new int[entrada.length];
        for (int i = 0; i < entrada.length; i++) {
            saida[i] = Integer.parseInt(entrada[i]);
        }
        return saida;
    }
}
