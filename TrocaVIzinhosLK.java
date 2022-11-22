import java.util.Scanner;

public class TrocaVIzinhosLK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = arrInteiros(sc);
        Linkedlisti lista = new Linkedlisti();
        for (int i = 0; i < numeros.length; i++) {
            lista.addLast(numeros[i]);
        }
        int index = sc.nextInt();
        lista.troca(index);
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

class Linkedlisti {

    Nod head, tail;
    int size;

    public Linkedlisti() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

    public void addLast(int v) {
        Nod newNode = new Nod(v);

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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        if (size == 0) {
            sb.append("vazia");
        }
        Nod aux = this.head;
        while (aux != null) {
            sb.append(aux.value).append(" ");
            aux = aux.next;
        }
        return sb.toString().trim();
    }

    public void troca(int index) {
        Nod aux = this.head;
        while (aux != null && index > 0) {
            aux = aux.next;
            index--;
        }
        // referencia do 3
        Nod auxNext = aux.next;
        // 13 -> 4
        aux.next = aux.next.next;
        // 4 -> 13
        if (auxNext.next == null) {
            this.tail = aux;
        } else {
            auxNext.next.prev = aux;
        }

        //3 <- 13
        Nod auxPrev = aux.prev;
        aux.prev = auxNext;
        // 3 -> 13
        auxNext.next = aux;
        auxNext.prev = auxPrev;
        if (auxPrev == null) {
            this.head = auxNext;
        } else {
            auxPrev.next = auxNext;
        }
    }
}

class Nod {
    Nod prev;
    int value;
    Nod next;
    public Nod(int v) {
        this.value = v;
        this.next = null;
        this.prev = null;
    }
}
