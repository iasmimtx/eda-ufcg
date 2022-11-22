import java.util.Scanner;

public class Trim_linkedGangorra {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        int[] sequencia = arrayInteiros(sc);
        int extremos = sc.nextInt();

        Linkedl lista = new Linkedl();

        for(int e : sequencia) {
            lista.addLast(e);
        }

        removeExtremos(lista, extremos);

        System.out.println(lista);

        sc.close();
    }
    private static void removeExtremos(Linkedl lista, int extremos) {
        for (int i = 0; i < extremos; i++) {
            lista.removeFirst();
            lista.removeLast();
        }
    }
    private static int[] arrayInteiros(Scanner sc) {
        String[] entrada = sc.nextLine().split(" ");
        int[] saida = new int[entrada.length];

        for (int i = 0; i < saida.length; i++) {
            saida[i] = Integer.parseInt(entrada[i]);
        }
        return saida;
    }

}
class Linkedl {

    private Nodd head;
    private Nodd tail;
    private int size;

    public Linkedl() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

    //adicionando em ultimo
    public void addLast(int n) {
        Nodd newNode = new Nodd(n);

        if(isEmpty()) {     //se for o primeiro
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }

        this.size++;
    }

    //remove primeiro elemento
    public int removeFirst() {
        if(isEmpty()) {
            throw new RuntimeException("Lista vazia!");
        }

        int value = this.head.value;    //será removido //inicio

        if(this.head.next == null) {    //só um elemento
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }

        size--;
        return value;
    }

    //remove ultimo elemento
    public int removeLast() {
        if(isEmpty()) {
            throw new RuntimeException("Lista vazia!");
        }

        int value = this.tail.value;    //fim

        if(this.tail.next == null) {
            this.tail = null;
            this.head = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }

        size--;
        return value;
    }

    //representação
    public String toString() {
        return null;
    }


}

/* ---------- CLASSE DO NODE ---------- */

class Nodd {
    int value;
    Nodd next;
    Nodd prev;

    public Nodd(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}