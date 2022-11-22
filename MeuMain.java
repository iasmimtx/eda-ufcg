import java.util.Scanner;

public class MeuMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = arrInteiros(sc);
        int remover = sc.nextInt();
        FiltraLinkedList lista = new FiltraLinkedList();
        for (int i = 0; i < numeros.length; i++) {
            lista.addLast(numeros[i]);
        }
        lista.remove(remover);
        System.out.println(lista);
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

class FiltraLinkedList {

    private No head;
    private No tail;
    private int size;

    public FiltraLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public void addLast(int v) {
        No newNode = new No(v);

        if (isEmpty()) {
            this.head = newNode;
            this.tail = this.head;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.size++;
    }

    public int removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("Fila vazia!");
        }
        int fim = tail.value;
        if (this.head.next == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        size--;
        return fim;
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Fila vazia!");
        }
        int inicio = head.value;
        if (this.head.next == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }
        size--;
        return inicio;
    }

    public void remove(int valor) {
        No aux = this.head;
        for (int i = 0; i < this.size; i++) {
            if (aux.value == valor) {
                if (i == 0) removeFirst();
                else if (i == size - 1) removeLast();
                else {
                    aux.prev.next = aux.next;
                    aux.next.prev = aux.prev;
                    size--;
                }
                i--;
            }
            aux = aux.next;
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        if (size == 0) {
            sb.append("vazia");
        }
        No aux = this.head;
        while (aux != null) {
            sb.append(aux.value).append(" ");
            aux = aux.next;
        }
        return sb.toString().trim();
    }
}

class No {
    No prev;
    int value;
    No next;

    public No(int v) {
        this.value = v;
        this.next = null;
        this.prev = null;
    }
}

