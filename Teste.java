import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Teste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tamanho = sc.nextInt();
        Stack pilha = new Stack();
        for(int i = 0; i < tamanho; i++){
            pilha.push(sc.nextInt());
        }
        int valor = getMax(pilha);
        System.out.println(valor);
    }

    private static int getMax(Stack pilha) {
        Stack auxPilha = new Stack();
        int maior = (int) pilha.peek();
        while(!pilha.isEmpty()){
            if(pilha.size() == 1){
                break;
            }
            auxPilha.push(pilha.pop());
            if(maior < (int) pilha.peek()){
                maior = (int) pilha.peek();
            }
        }
        return maior;
    }
}

