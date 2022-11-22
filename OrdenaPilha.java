import java.util.Scanner;
import java.util.Stack;

public class OrdenaPilha {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tamanho = sc.nextInt();
        Stack pilha = new Stack();

        //adicinando na pilha os valores inseridos na entrada(input)
        for (int i = 0; i < tamanho; i++) {
            pilha.push(sc.nextInt());
        }
        pilha = ordenaPilhaa(pilha);
        System.out.println("-");
        while (!pilha.isEmpty()) {
            System.out.println(pilha.pop());
        }
    }

    private static Stack ordenaPilhaa(Stack<Integer> pilha) {
        Stack<Integer> pilhaInvertida = new Stack();

        while (!(pilha.isEmpty())) {
            int maior = getMaior(pilha);
            pilhaInvertida.push(maior);
        }
        return pilhaInvertida;
    }

    private static int getMaior(Stack<Integer> pilha) {
        Stack<Integer> pilhaAux = new Stack();

        int maior = pilha.peek();
        while (!(pilha.isEmpty())) {
            int value = pilha.pop();
            pilhaAux.push(value);

            if (value > maior) {
                maior = value;
            }
        }

        while (!(pilhaAux.isEmpty())) {
            int value = pilhaAux.pop();
            pilha.push(value);
        }

        while (!pilha.isEmpty()) {
            int value = pilha.pop();
            if (value == maior) break;
            pilhaAux.push(value);
        }
        while (!pilhaAux.isEmpty()) {
            pilha.push(pilhaAux.pop());
        }
        return maior;
    }
}
