import java.util.Scanner;

public class RemoveIndexLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = arrInteiros(sc);
        LinkedLists lista = new LinkedLists();

        for (int i = 0; i < numeros.length; i++) {
            lista.addLast(numeros[i]);
        }
        int index = sc.nextInt();
        lista.remove(index);
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
class LinkedLists {

    Noo head, tail;
    int size;

    public LinkedLists() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

    public void addLast(int v) {
        Noo newNode = new Noo(v);

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


    public int removeFim() {
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

    public int removeInicio() {

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
        Noo aux = this.head;
        while (aux != null) {
            sb.append(aux.value).append(" ");
            aux = aux.next;
        }
        return sb.toString().trim();
    }

    public int remove(int index) {
        if(index == 0) return removeInicio();
        if(index == size - 1) return removeFim();
        Noo aux = this.head;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }

        aux.next.prev = aux.prev;
        aux.prev.next = aux.next;
        size -= 1;
        return aux.value;
    }
}


class Noo {

    Noo prev;
    int value;
    Noo next;

    public Noo(int v) {
        this.value = v;
        this.next = null;
        this.prev = null;
    }
}
