import java.nio.file.StandardWatchEventKinds;
import java.util.Scanner;

public class MaxPilhaIndex {
    private int topo;
    private int capacidade;
    private int[] pilha;

    public MaxPilhaIndex(int capacidade) {
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

    // retorna o valor do topo da pilha, ou seja, o ultimo valor adicionado.
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha Vazia!");
        }
        return pilha[topo];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] valores = arrInteiros(sc);
        MaxPilhaIndex pilha = new MaxPilhaIndex(valores.length);
        //adicinando na pilha os valores inseridos na entrada(input)
        for (int i = 0; i < valores.length; i++) {
            pilha.push(valores[i]);
        }
        int limiteIndex = sc.nextInt();
        int valor = getMax(pilha, limiteIndex);
        System.out.println(valor);
    }

    private static int getMax(MaxPilhaIndex pilha, int limiteIndex) {
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

    private static int[] arrInteiros(Scanner sc) {
        String[] entrada = sc.nextLine().split(" ");
        int[] saida = new int[entrada.length];
        for (int i = 0; i < entrada.length; i++) {
            saida[i] = Integer.parseInt(entrada[i]);
        }
        return saida;
    }





}






