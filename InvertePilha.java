import java.util.Scanner;

public class InvertePilha {
    private int topo;
    private int capacidade;
    private int[] pilha;


    public InvertePilha(int capacidade) {
        this.capacidade = capacidade;
        this.topo = -1;
        this.pilha = new int[capacidade];
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    // capacidade- 1 pois a pilha começa do zero
    public boolean isFull() {
        return this.topo == this.capacidade - 1;
    }

    // adiciona no final da pilha o valor de n.
    public void push(int n) {
        if (this.isFull()) {
            throw new RuntimeException("Pilha Cheia!");
        }
        pilha[++this.topo] = n; // this.topo += 1 pilha[topo] = n;
    }

    // remove e retrona o último elemento da pilha
    public int pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("Pilha Vazia!");
        }
        int valor = pilha[this.topo--]; // int valor = pilha[this.topo] topo -= 1 return valor;
        return valor;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tamanho = sc.nextInt();
        InvertePilha pilha = new InvertePilha(tamanho);
        //adicinando na pilha os valores inseridos na entrada(input)
        for (int i = 0; i < tamanho; i++) {
            pilha.push(sc.nextInt());
        }
        int valor = getMax(pilha, tamanho);
        System.out.println(valor);
    }

    private static int getMax(InvertePilha pilha, int limiteIndex) {
        int[] arrAux = new int[limiteIndex + 1];

        // add no array os valores do topo até o indice desejado.
        int cont = 0;
        while (cont <= limiteIndex) {
            arrAux[cont] = pilha.pop();
            cont++;
        }

        // verificando no array qual o maior valor.
        int maior = arrAux[0];
        for (int i = 0; i < arrAux.length; i++) {
            if (arrAux[i] > maior) {
                maior = arrAux[i];
            }
        }
        // adicionando os valores do array (elementos removidos) de volta a pilha.
        for (int j = arrAux.length - 1; j >= 0; j--) {
            pilha.push(arrAux[j]);
        }
        return maior;
    }
}
