import java.util.Scanner;

public class InvertePilhaIndex {

    private int topo;
    private int capacidade;
    private int[] pilha;

    public InvertePilhaIndex(int capacidade) {
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
        int tamanhoPilha = sc.nextInt();
        InvertePilhaIndex pilha = new InvertePilhaIndex(tamanhoPilha);
        for (int i = 0; i < tamanhoPilha; i++) {
            pilha.push(sc.nextInt());
        }
        int indice = sc.nextInt();
        invertePilha(tamanhoPilha, pilha, indice);
        while (!pilha.isEmpty()) {
            System.out.println(pilha.pop());
        }
    }

    private static void invertePilha(int tamanhoPilha, InvertePilhaIndex pilha, int indice) {
        System.out.println("-");
        int[] arrAux = new int[indice + 1];

        // adiciona no array os valores da pilha até o indice.
        int cont = 0;
        while (cont <= indice) {
            arrAux[cont] = pilha.pop();
            cont++;
        }

        // adiciona de volta na pilha os valores do arrAux já invertidos.
        for (int i = 0; i < arrAux.length; i++) {
            pilha.push(arrAux[i]);
        }
    }
}
