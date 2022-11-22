import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = arrInteiros(sc);
        Linkedl lista = new Linkedl();
        for (int i = 0; i < numeros.length; i++) {
            lista.addLast(numeros[i]);
        }
        int extremo = sc.nextInt();

        int cont = 1;
        while (cont <= extremo) {
            lista.removeFirst();
            lista.removeLast();
            cont++;
        }
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

public class LinkedList {

    No head, tail;
    int size;
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public boolean isEmpty() {
        return this.head == null && this.tail == null;
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
//    public void addFirst(int v) {
//        No newNode = new No(v);
//        if (isEmpty()) {
//            this.tail = newNode;
//            this.head = newNode;
//        } else {
//            newNode.next = head;
//            head.prev = newNode;
//            this.head = newNode;
//        }
//        size++;
//    }

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
        size -= 1;
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
        size -= 1;
        return inicio;
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

class Node {

    No prev;
    int value;
    No next;

    public Node(int v) {
        this.value = v;
        this.next = null;
        this.prev = null;
    }
}

