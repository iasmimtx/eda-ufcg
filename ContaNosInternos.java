import java.util.Scanner;

public class ContaNosInternos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] valores = arrInteiros(sc);
        MyBST arvore = new MyBST();
        for (int valor : valores) {
            arvore.addRecursive(valor);
        }
        System.out.println(arvore.contaNo());
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

class MyBST {
    private Nodeh raiz;

    public boolean isEmpty() {
        return raiz == null;
    }

    public void addRecursive(int elemento) {
        if (isEmpty()) {
            this.raiz = new Nodeh(elemento);
        } else {
            addRecursive(this.raiz, elemento);
        }
    }

    private void addRecursive(Nodeh node, int elemento) {
        if (elemento < node.value) {
            if (node.left == null) {
                Nodeh newNode = new Nodeh(elemento);
                node.left = newNode;
                newNode.parent = node;
                return;
            }
            addRecursive(node.left, elemento);
        } else {
            if (node.right == null) {
                Nodeh newNo = new Nodeh(elemento);
                node.right = newNo;
                newNo.parent = node;
                return;
            }
            addRecursive(node.right, elemento);
        }
    }

    public int contaNo() {
        return contaNo(raiz);
    }

    private int contaNo(Nodeh node) {
        int resul = 0;
        if (node != null && !node.isLeaf()) {
            resul = 1 + contaNo(node.left) + contaNo(node.right);
        }
        return resul;
    }
}

class Nodeh {

    int value;
    Nodeh left, right, parent;

    public Nodeh(int v) {
        this.value = v;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }


}
